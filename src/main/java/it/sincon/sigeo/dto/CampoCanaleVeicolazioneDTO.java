/*
 * PWA API
 * PWA API documentation
 *
 * OpenAPI spec version: 0.0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package it.sincon.sigeo.dto;

import java.util.Objects;

/**
 * CampoCanaleVeicolazioneDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-09-15T12:03:22.432+02:00")
public class CampoCanaleVeicolazioneDTO {
  
  private Boolean attivo = null;

  
  private CanaleVeicolazioneDTO canaleVeicolazioneDTO = null;

  
  private MenuListaValoriDTO elencoValori = null;

  
  private Long id = null;

  
  private Integer lunghezza = null;

  
  private String nome = null;

  
  private Boolean obbligatorio = null;

  
  private Boolean ripetibile = null;

  
  private String tipoCampo = null;

  public CampoCanaleVeicolazioneDTO attivo(Boolean attivo) {
    this.attivo = attivo;
    return this;
  }

   public Boolean getAttivo() {
	return attivo;
}

public Boolean getObbligatorio() {
	return obbligatorio;
}

public Boolean getRipetibile() {
	return ripetibile;
}

/**
   * Get attivo
   * @return attivo
  **/
  
  public Boolean isAttivo() {
    return attivo;
  }

  public void setAttivo(Boolean attivo) {
    this.attivo = attivo;
  }

  public CampoCanaleVeicolazioneDTO canaleVeicolazioneDTO(CanaleVeicolazioneDTO canaleVeicolazioneDTO) {
    this.canaleVeicolazioneDTO = canaleVeicolazioneDTO;
    return this;
  }

   /**
   * Get canaleVeicolazioneDTO
   * @return canaleVeicolazioneDTO
  **/
  
  public CanaleVeicolazioneDTO getCanaleVeicolazioneDTO() {
    return canaleVeicolazioneDTO;
  }

  public void setCanaleVeicolazioneDTO(CanaleVeicolazioneDTO canaleVeicolazioneDTO) {
    this.canaleVeicolazioneDTO = canaleVeicolazioneDTO;
  }

  public CampoCanaleVeicolazioneDTO elencoValori(MenuListaValoriDTO elencoValori) {
    this.elencoValori = elencoValori;
    return this;
  }

   /**
   * Get elencoValori
   * @return elencoValori
  **/
  
  public MenuListaValoriDTO getElencoValori() {
    return elencoValori;
  }

  public void setElencoValori(MenuListaValoriDTO elencoValori) {
    this.elencoValori = elencoValori;
  }

  public CampoCanaleVeicolazioneDTO id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CampoCanaleVeicolazioneDTO lunghezza(Integer lunghezza) {
    this.lunghezza = lunghezza;
    return this;
  }

   /**
   * Get lunghezza
   * @return lunghezza
  **/
  
  public Integer getLunghezza() {
    return lunghezza;
  }

  public void setLunghezza(Integer lunghezza) {
    this.lunghezza = lunghezza;
  }

  public CampoCanaleVeicolazioneDTO nome(String nome) {
    this.nome = nome;
    return this;
  }

   /**
   * Get nome
   * @return nome
  **/

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public CampoCanaleVeicolazioneDTO obbligatorio(Boolean obbligatorio) {
    this.obbligatorio = obbligatorio;
    return this;
  }

   /**
   * Get obbligatorio
   * @return obbligatorio
  **/
  
  public Boolean isObbligatorio() {
    return obbligatorio;
  }

  public void setObbligatorio(Boolean obbligatorio) {
    this.obbligatorio = obbligatorio;
  }

  public CampoCanaleVeicolazioneDTO ripetibile(Boolean ripetibile) {
    this.ripetibile = ripetibile;
    return this;
  }

   /**
   * Get ripetibile
   * @return ripetibile
  **/
  
  public Boolean isRipetibile() {
    return ripetibile;
  }

  public void setRipetibile(Boolean ripetibile) {
    this.ripetibile = ripetibile;
  }

  public CampoCanaleVeicolazioneDTO tipoCampo(String tipoCampo) {
    this.tipoCampo = tipoCampo;
    return this;
  }

   /**
   * Get tipoCampo
   * @return tipoCampo
  **/

  public String getTipoCampo() {
    return tipoCampo;
  }

  public void setTipoCampo(String tipoCampo) {
    this.tipoCampo = tipoCampo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CampoCanaleVeicolazioneDTO campoCanaleVeicolazioneDTO = (CampoCanaleVeicolazioneDTO) o;
    return Objects.equals(this.attivo, campoCanaleVeicolazioneDTO.attivo) &&
        Objects.equals(this.canaleVeicolazioneDTO, campoCanaleVeicolazioneDTO.canaleVeicolazioneDTO) &&
        Objects.equals(this.elencoValori, campoCanaleVeicolazioneDTO.elencoValori) &&
        Objects.equals(this.id, campoCanaleVeicolazioneDTO.id) &&
        Objects.equals(this.lunghezza, campoCanaleVeicolazioneDTO.lunghezza) &&
        Objects.equals(this.nome, campoCanaleVeicolazioneDTO.nome) &&
        Objects.equals(this.obbligatorio, campoCanaleVeicolazioneDTO.obbligatorio) &&
        Objects.equals(this.ripetibile, campoCanaleVeicolazioneDTO.ripetibile) &&
        Objects.equals(this.tipoCampo, campoCanaleVeicolazioneDTO.tipoCampo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attivo, canaleVeicolazioneDTO, elencoValori, id, lunghezza, nome, obbligatorio, ripetibile, tipoCampo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CampoCanaleVeicolazioneDTO {\n");
    
    sb.append("    attivo: ").append(toIndentedString(attivo)).append("\n");
    sb.append("    canaleVeicolazioneDTO: ").append(toIndentedString(canaleVeicolazioneDTO)).append("\n");
    sb.append("    elencoValori: ").append(toIndentedString(elencoValori)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lunghezza: ").append(toIndentedString(lunghezza)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    obbligatorio: ").append(toIndentedString(obbligatorio)).append("\n");
    sb.append("    ripetibile: ").append(toIndentedString(ripetibile)).append("\n");
    sb.append("    tipoCampo: ").append(toIndentedString(tipoCampo)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

