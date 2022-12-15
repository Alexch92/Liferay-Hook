 package it.sincon.sigeo.dto;
 
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Objects;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class AuthorityDTO
 {
   private String denominazione = null;
   
   private String id = null;
   
   private List<PermissionDTO> permessi = new ArrayList<>();
   
   public AuthorityDTO denominazione(String denominazione) {
     this.denominazione = denominazione;
     return this;
   }
 
 
 
 
   
   public String getDenominazione() {
     return this.denominazione;
   }
   
   public void setDenominazione(String denominazione) {
     this.denominazione = denominazione;
   }
   
   public AuthorityDTO id(String id) {
     this.id = id;
     return this;
   }
 
 
 
 
   
   public String getId() {
     return this.id;
   }
   
   public void setId(String id) {
     this.id = id;
   }
   
   public AuthorityDTO permessi(List<PermissionDTO> permessi) {
     this.permessi = permessi;
     return this;
   }
   
   public AuthorityDTO addPermessiItem(PermissionDTO permessiItem) {
     if (this.permessi == null) {
       this.permessi = new ArrayList<>();
     }
     this.permessi.add(permessiItem);
     return this;
   }
 
 
 
 
   
   public List<PermissionDTO> getPermessi() {
     return this.permessi;
   }
   
   public void setPermessi(List<PermissionDTO> permessi) {
     this.permessi = permessi;
   }
 
 
   
   public boolean equals(Object o) {
     if (this == o) {
       return true;
     }
     if (o == null || getClass() != o.getClass()) {
       return false;
     }
     AuthorityDTO authorityDTO = (AuthorityDTO)o;
     return (Objects.equals(this.denominazione, authorityDTO.denominazione) && 
       Objects.equals(this.id, authorityDTO.id) && 
       Objects.equals(this.permessi, authorityDTO.permessi));
   }
 
   
   public int hashCode() {
     return Objects.hash(new Object[] { this.denominazione, this.id, this.permessi });
   }
 
 
   
   public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("class AuthorityDTO {\n");
     
     sb.append("    denominazione: ").append(toIndentedString(this.denominazione)).append("\n");
     sb.append("    id: ").append(toIndentedString(this.id)).append("\n");
     sb.append("    permessi: ").append(toIndentedString(this.permessi)).append("\n");
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

