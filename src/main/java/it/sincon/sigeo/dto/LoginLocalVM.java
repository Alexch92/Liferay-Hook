 package it.sincon.sigeo.dto;
 
 import java.util.Objects;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class LoginLocalVM
 {
   private Boolean rememberMe = null;
 
   
   private String username = null;
   
   public LoginLocalVM rememberMe(Boolean rememberMe) {
     this.rememberMe = rememberMe;
     return this;
   }
 
 
 
 
 
   
   public Boolean isRememberMe() {
     return this.rememberMe;
   }
   
   public void setRememberMe(Boolean rememberMe) {
     this.rememberMe = rememberMe;
   }
   
   public LoginLocalVM username(String username) {
     this.username = username;
     return this;
   }
 
 
 
 
 
   
   public String getUsername() {
     return this.username;
   }
   
   public void setUsername(String username) {
     this.username = username;
   }
 
 
   
   public boolean equals(Object o) {
     if (this == o) {
       return true;
     }
     if (o == null || getClass() != o.getClass()) {
       return false;
     }
     LoginLocalVM loginLocalVM = (LoginLocalVM)o;
     return (Objects.equals(this.rememberMe, loginLocalVM.rememberMe) && 
       Objects.equals(this.username, loginLocalVM.username));
   }
 
   
   public int hashCode() {
     return Objects.hash(new Object[] { this.rememberMe, this.username });
   }
 
 
   
   public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("class LoginLocalVM {\n");
     
     sb.append("    rememberMe: ").append(toIndentedString(this.rememberMe)).append("\n");
     sb.append("    username: ").append(toIndentedString(this.username)).append("\n");
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

