 package it.sincon.sigeo.dto;
 
 import java.util.Objects;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class FunzioneDTO
 {
   private String descrizione = null;
 
   
   private String id = null;
   
   public FunzioneDTO descrizione(String descrizione) {
     this.descrizione = descrizione;
     return this;
   }
 
 
 
 
 
   
   public String getDescrizione() {
     return this.descrizione;
   }
   
   public void setDescrizione(String descrizione) {
     this.descrizione = descrizione;
   }
   
   public FunzioneDTO id(String id) {
     this.id = id;
     return this;
   }
 
 
 
 
 
   
   public String getId() {
     return this.id;
   }
   
   public void setId(String id) {
     this.id = id;
   }
 
 
   
   public boolean equals(Object o) {
     if (this == o) {
       return true;
     }
     if (o == null || getClass() != o.getClass()) {
       return false;
     }
     FunzioneDTO funzioneDTO = (FunzioneDTO)o;
     return (Objects.equals(this.descrizione, funzioneDTO.descrizione) && 
       Objects.equals(this.id, funzioneDTO.id));
   }
 
   
   public int hashCode() {
     return Objects.hash(new Object[] { this.descrizione, this.id });
   }
 
 
   
   public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("class FunzioneDTO {\n");
     
     sb.append("    descrizione: ").append(toIndentedString(this.descrizione)).append("\n");
     sb.append("    id: ").append(toIndentedString(this.id)).append("\n");
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

