package it.sincon.sigeo.dto;

import flexjson.JSON;
import java.util.Objects;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class JWTTokenDTO
 {
   private Long exp = null;
   
   @JSON(name = "id_token")
   private String idToken = null;
 
   
   private String refresh = null;
   
   public JWTTokenDTO exp(Long exp) {
     this.exp = exp;
     return this;
   }
 
 
 
 
 
   
   public Long getExp() {
     return this.exp;
   }
   
   public void setExp(Long exp) {
     this.exp = exp;
   }
   
   public JWTTokenDTO idToken(String idToken) {
     this.idToken = idToken;
     return this;
   }
 
 
 
 
 
   
   public String getIdToken() {
     return this.idToken;
   }
   
   public void setIdToken(String idToken) {
     this.idToken = idToken;
   }
   
   public JWTTokenDTO refresh(String refresh) {
     this.refresh = refresh;
     return this;
   }
 
 
 
 
 
   
   public String getRefresh() {
     return this.refresh;
   }
   
   public void setRefresh(String refresh) {
     this.refresh = refresh;
   }
 
 
   
   public boolean equals(Object o) {
     if (this == o) {
       return true;
     }
     if (o == null || getClass() != o.getClass()) {
       return false;
     }
     JWTTokenDTO jwTTokenDTO = (JWTTokenDTO)o;
     return (Objects.equals(this.exp, jwTTokenDTO.exp) && 
       Objects.equals(this.idToken, jwTTokenDTO.idToken) && 
       Objects.equals(this.refresh, jwTTokenDTO.refresh));
   }
 
   
   public int hashCode() {
     return Objects.hash(new Object[] { this.exp, this.idToken, this.refresh });
   }
 
 
   
   public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("class JWTTokenDTO {\n");
     
     sb.append("    exp: ").append(toIndentedString(this.exp)).append("\n");
     sb.append("    idToken: ").append(toIndentedString(this.idToken)).append("\n");
     sb.append("    refresh: ").append(toIndentedString(this.refresh)).append("\n");
     sb.append("}");
     return sb.toString();
   }
 
 
 
 
   
   private String toIndentedString(Object o) {
     if (o == null) {
       return "null";
     }
     return o.toString().replace("\n", "\n    ");
   }
 }