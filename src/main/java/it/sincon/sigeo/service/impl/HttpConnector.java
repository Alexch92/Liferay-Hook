 package it.sincon.sigeo.service.impl;
 
 import com.liferay.portal.kernel.util.StreamUtil;
 import flexjson.JSONDeserializer;
 import flexjson.JSONSerializer;
import it.sincon.sigeo.factorytransformer.InstantFactory;
import it.sincon.sigeo.factorytransformer.InstantTransformer;

import java.io.ByteArrayOutputStream;
 import java.io.IOException;
 import java.io.OutputStream;
 import java.net.HttpURLConnection;
 import java.net.URL;
import java.time.Instant;
import java.util.Map;
 
 
 
 
 
 
 
 
 public class HttpConnector
 {
public static <T> T callService(Object request, Class<T> classType, String token, Map<String, Class<?>> mappingUse, String method, String apiUrls, int httpCode) {
     T result = null;
 
     
     try {
       String urlComplete = "http://localhost:8080" + apiUrls;
       URL url = new URL(urlComplete);
       HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
       urlConnection.setRequestProperty("Connection", "Close");
       urlConnection.setRequestMethod(method);
       urlConnection.setConnectTimeout(10000);
       urlConnection.setReadTimeout(180000);
       System.out.println("token: " + token);
       if (token != null) {
         urlConnection.setRequestProperty("Authorization", "Bearer " + token);
       }
       if (request != null) {
         urlConnection.setRequestProperty("Content-Type", "application/json");
         urlConnection.setDoOutput(true);
         JSONSerializer serializer = new JSONSerializer();
         serializer = serializer.exclude(new String[] { "*.class" });
         serializer.transform(new InstantTransformer(), Instant.class);
         String content = serializer.deepSerialize(request);
         System.out.println("request: "+content);
         OutputStream os = urlConnection.getOutputStream();
         os.write(content.getBytes("UTF-8"));
         os.flush();
       }
       int responseCode=urlConnection.getResponseCode();
       System.out.println("response code:" +responseCode);
       if (responseCode == httpCode) {
         ByteArrayOutputStream res = new ByteArrayOutputStream();
         StreamUtil.transfer(urlConnection.getInputStream(), res);
         System.out.println("result: "+new String(res.toByteArray()));
         JSONDeserializer<T> deserializer = new JSONDeserializer<T>();
         deserializer=deserializer.use(Instant.class, new InstantFactory());
         for (Map.Entry<String, Class<?>> use : mappingUse.entrySet())
           deserializer = deserializer.use(use.getKey(), use.getValue()); 
         result = (T)deserializer.deserialize(new String(res.toByteArray()), classType);
       } 
       System.out.println(result);
       urlConnection.disconnect();
 
     
     }
     catch (IOException e) {
       e.printStackTrace();
     } 
 
     
     return result;
   }
 }


