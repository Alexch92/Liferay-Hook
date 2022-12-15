package it.sincon.sigeo.factorytransformer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import flexjson.ObjectBinder;
import flexjson.ObjectFactory;

public class InstantFactory implements ObjectFactory {

	@Override
	public Object instantiate(ObjectBinder context, Object value, Type targetType, Class targetClass) {
		if (value!=null && value instanceof String) {
			try {
				return LocalDateTime.parse((String)value, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",Locale.ITALY)).atZone(ZoneId.of("Europe/Rome")).toInstant();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

}
