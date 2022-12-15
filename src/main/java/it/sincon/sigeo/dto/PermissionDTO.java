 package it.sincon.sigeo.dto;
 
 import it.sincon.sigeo.enums.ACLRestrictions;
 import java.util.Objects;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class PermissionDTO
 {
   private FunzioneDTO funzione = null;
 
   
   private Long id = null;
 
 
 
 
 
   
   private ACLRestrictions restriction = null;
   
   public PermissionDTO funzione(FunzioneDTO funzione) {
     this.funzione = funzione;
     return this;
   }
 
 
 
 
 
   
   public FunzioneDTO getFunzione() {
     return this.funzione;
   }
   
   public void setFunzione(FunzioneDTO funzione) {
     this.funzione = funzione;
   }
   
   public PermissionDTO id(Long id) {
     this.id = id;
     return this;
   }
 
 
 
 
 
   
   public Long getId() {
     return this.id;
   }
   
   public void setId(Long id) {
     this.id = id;
   }
   
   public PermissionDTO restriction(ACLRestrictions restriction) {
     this.restriction = restriction;
     return this;
   }
 
 
 
 
 
   
   public ACLRestrictions getRestriction() {
     return this.restriction;
   }
   
   public void setRestriction(ACLRestrictions restriction) {
     this.restriction = restriction;
   }
 
 
   
   public boolean equals(Object o) {
     if (this == o) {
       return true;
     }
     if (o == null || getClass() != o.getClass()) {
       return false;
     }
     PermissionDTO permissionDTO = (PermissionDTO)o;
     return (Objects.equals(this.funzione, permissionDTO.funzione) && 
       Objects.equals(this.id, permissionDTO.id) && 
       Objects.equals(this.restriction, permissionDTO.restriction));
   }
 
   
   public int hashCode() {
     return Objects.hash(new Object[] { this.funzione, this.id, this.restriction });
   }
 
 
   
   public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("class PermissionDTO {\n");
     
     sb.append("    funzione: ").append(toIndentedString(this.funzione)).append("\n");
     sb.append("    id: ").append(toIndentedString(this.id)).append("\n");
     sb.append("    restriction: ").append(toIndentedString(this.restriction)).append("\n");
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


