 package it.sincon.sigeo.modellistener;
 
 import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import it.sincon.sigeo.dto.AuthorityDTO;
import it.sincon.sigeo.dto.Filter;
import it.sincon.sigeo.dto.FilterGroup;
import it.sincon.sigeo.dto.JWTTokenDTO;
import it.sincon.sigeo.dto.LoginLocalVM;
import it.sincon.sigeo.dto.PermissionDTO;
import it.sincon.sigeo.dto.SearchResponse;
import it.sincon.sigeo.dto.UserDTO;
import it.sincon.sigeo.enums.FilterCondition;
import it.sincon.sigeo.enums.JoinOperator;
import it.sincon.sigeo.service.impl.HttpConnector;
 
 
 @Component(immediate = true, service = {ModelListener.class})
 public class CustomUserListener
   extends BaseModelListener<User>
 {
	 
	 
   public void onAfterCreate(User model) throws ModelListenerException {
     UserDTO user = new UserDTO();
     user.setActivated(Boolean.valueOf(true));
     user.setEmail(model.getEmailAddress());
     user.setLogin(model.getScreenName());
     user.setFirstName(model.getFirstName());
     user.setLastName(model.getLastName());
     user.setCodiceFiscale(""+model.getUserId());
     user.setAuthorities(new ArrayList<String>());
     LoginLocalVM loginLocale = (new LoginLocalVM()).username("admin");
     JWTTokenDTO token = HttpConnector.callService(loginLocale, JWTTokenDTO.class, null, new HashMap<>(), "POST", "/api/session/local", 200);
     model.getRoles().forEach(p -> { 
    	 if (HttpConnector.callService(null, AuthorityDTO.class, token.getIdToken(), new HashMap<String, Class<?>>(), "GET", "/api/authorities/"+"ROLE_" + p.getTitle(new Locale("it", "IT")).replaceAll("[^A-Za-z0-9]", "_").toUpperCase(), 200)!=null) {
    		 user.getAuthorities().add("ROLE_" + p.getTitle(new Locale("it", "IT")).replaceAll("[^A-Za-z0-9]", "_").toUpperCase());
    	 }
    		 
         }); 
     UserDTO savedUser = (UserDTO)HttpConnector.callService(user, UserDTO.class, token.getIdToken(), new HashMap<>(), "POST", "/api/users", 201);
     savedUser.setActivated(Boolean.valueOf(true));
     savedUser.setCodiceFiscale(""+model.getUserId());
     savedUser = HttpConnector.callService(savedUser, UserDTO.class, token.getIdToken(), new HashMap<>(), "PUT", "/api/users/" + savedUser.getId(), 200);
     if (savedUser == null) throw new ModelListenerException(); 
   }
   
  
   @SuppressWarnings("unchecked")
@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
	   if (associationClassName.equals("com.liferay.portal.kernel.model.Role")) {
		   Long userId = (Long)classPK;
		   Long roleId = (Long)associationClassPK;
		   System.out.println("userPK:"+userId);
		   System.out.println("roleId:"+roleId);
			FilterGroup filterGroup = new FilterGroup();
		   filterGroup.addFiltersItem(new Filter().field("codiceFiscale").value(""+userId).condition(FilterCondition.EQUALS)).joinOperator(JoinOperator.AND);
		   LoginLocalVM loginLocale = (new LoginLocalVM()).username("admin");
		   JWTTokenDTO token = HttpConnector.callService(loginLocale, JWTTokenDTO.class, null, new HashMap<>(), "POST", "/api/session/local", 200);
		   Map<String,Class<?>> mappingUseSearch=new HashMap<String, Class<?>>();
		   
		   SearchResponse<Map<String,Object>> searchResponse=HttpConnector.callService(filterGroup, SearchResponse.class, token.getIdToken(), mappingUseSearch, "POST", "/api/users/search", 200);
		   Map<String,Class<?>> mappingUseGet=new HashMap<String, Class<?>>();
		   mappingUseGet.put("fullauthorities.values",AuthorityDTO.class);
		   mappingUseGet.put("fullautorities.values.permessi.values", PermissionDTO.class);
		   final UserDTO userDTO = HttpConnector.callService(null, UserDTO.class, token.getIdToken(), mappingUseGet, "GET", "/api/users/"+searchResponse.getItems().get(0).get("id"), 200);
		   userDTO.setCodiceFiscale(""+userId);
		   if (userDTO.getAuthorities()==null)
			   userDTO.setAuthorities(new ArrayList<String>());
		   FilterGroup filterGroupRole = new FilterGroup();
		   filterGroupRole.addFiltersItem(new Filter().field("id").value("_"+roleId).condition(FilterCondition.ENDS_WITH)).joinOperator(JoinOperator.AND);
		   Map<String,Class<?>> mappingUseSearchRole=new HashMap<String, Class<?>>();
		   mappingUseSearchRole.put("items.value", AuthorityDTO.class);
		   mappingUseSearchRole.put("items.value.permessi.values", PermissionDTO.class);
		   SearchResponse<Map<String,Object>> risultati=HttpConnector.callService(filterGroupRole, SearchResponse.class, token.getIdToken(), mappingUseSearchRole, "POST", "/api/authorities/search", 200);
		   if (risultati.getTotalItems().intValue()==1) {
			   userDTO.getAuthorities().add(""+risultati.getItems().get(0).get("id"));
		   }
		   
		   UserDTO userDTOSaved = HttpConnector.callService(userDTO, UserDTO.class, token.getIdToken(), new HashMap<>(), "PUT", "/api/users/" + userDTO.getId(), 200);
		   if (userDTOSaved == null) throw new ModelListenerException();
	   }
	   
   }
   
   @SuppressWarnings("unchecked")
@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
	   if (associationClassName.equals("com.liferay.portal.kernel.model.Role")) {
		   Long userId = (Long)classPK;
		   Long roleId = (Long)associationClassPK;
		   System.out.println("userPK:"+userId);
		   System.out.println("roleId:"+roleId);

			FilterGroup filterGroup = new FilterGroup();
		   filterGroup.addFiltersItem(new Filter().field("codiceFiscale").value(""+userId).condition(FilterCondition.EQUALS)).joinOperator(JoinOperator.AND);
		   LoginLocalVM loginLocale = (new LoginLocalVM()).username("admin");
		   JWTTokenDTO token = HttpConnector.callService(loginLocale, JWTTokenDTO.class, null, new HashMap<>(), "POST", "/api/session/local", 200);
		   Map<String,Class<?>> mappingUseSearch=new HashMap<String, Class<?>>();
		   
		   SearchResponse<Map<String,Object>> searchResponse=HttpConnector.callService(filterGroup, SearchResponse.class, token.getIdToken(), mappingUseSearch, "POST", "/api/users/search", 200);
		   Map<String,Class<?>> mappingUseGet=new HashMap<String, Class<?>>();
		   mappingUseGet.put("fullauthorities.values",AuthorityDTO.class);
		   mappingUseGet.put("fullautorities.values.permessi.values", PermissionDTO.class);
		   final UserDTO userDTO = HttpConnector.callService(null, UserDTO.class, token.getIdToken(), mappingUseGet, "GET", "/api/users/"+searchResponse.getItems().get(0).get("id"), 200);
		   userDTO.setCodiceFiscale(""+userId);
		   FilterGroup filterGroupRole = new FilterGroup();
		   filterGroupRole.addFiltersItem(new Filter().field("id").value("_"+roleId).condition(FilterCondition.ENDS_WITH)).joinOperator(JoinOperator.AND);
		   Map<String,Class<?>> mappingUseSearchRole=new HashMap<String, Class<?>>();
		   mappingUseSearchRole.put("items.value", AuthorityDTO.class);
		   mappingUseSearchRole.put("items.value.permessi.values", PermissionDTO.class);
		   SearchResponse<Map<String,Object>> risultati=HttpConnector.callService(filterGroupRole, SearchResponse.class, token.getIdToken(), mappingUseSearchRole, "POST", "/api/authorities/search", 200);
		   if (risultati.getTotalItems().intValue()==1) {
			   userDTO.getAuthorities().remove(""+risultati.getItems().get(0).get("id"));
		   }
		   UserDTO userDTOSaved = HttpConnector.callService(userDTO, UserDTO.class, token.getIdToken(), new HashMap<>(), "PUT", "/api/users/" + userDTO.getId(), 200);
		   if (userDTOSaved == null) throw new ModelListenerException();
	   }
	}
   
 }

