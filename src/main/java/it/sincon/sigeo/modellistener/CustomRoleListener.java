 package it.sincon.sigeo.modellistener;
 
 import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.Role;

import java.util.HashMap;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;

import it.sincon.sigeo.dto.AuthorityDTO;
import it.sincon.sigeo.dto.JWTTokenDTO;
import it.sincon.sigeo.dto.LoginLocalVM;
import it.sincon.sigeo.service.impl.HttpConnector;
 
 
 
 
 @Component(immediate = true, service = {ModelListener.class})
 public class CustomRoleListener
   extends BaseModelListener<Role>
 {
   public void onAfterCreate(Role model) throws ModelListenerException {
     if (model.getType() == 1) {
       AuthorityDTO roleSigeo = new AuthorityDTO();
       roleSigeo.setId("ROLE_" + model.getTitle(new Locale("it", "IT")).replaceAll("[^A-Za-z0-9]", "_").toUpperCase()+"_"+model.getRoleId());
       roleSigeo.setDenominazione(model.getDescription(new Locale("it", "IT")));
       LoginLocalVM loginLocale = (new LoginLocalVM()).username("admin");
       JWTTokenDTO token = (JWTTokenDTO)HttpConnector.callService(loginLocale, JWTTokenDTO.class, null, new HashMap<>(), "POST", "/api/session/local", 200);
       AuthorityDTO savedAuthority = (AuthorityDTO)HttpConnector.callService(roleSigeo, AuthorityDTO.class, token.getIdToken(), new HashMap<>(), "POST", "/api/authorities", 201);
       if (savedAuthority == null) throw new ModelListenerException(); 
     } 
   }
 }


