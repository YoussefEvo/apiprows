package ma.co.marsa.apiprows.dto;

import java.io.Serializable;
import java.util.Date;



public class BonReceptionDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private Integer idBonReception;
	private String numBonCommande;
	private String numMarche;
	private String numBonReception;
	private Date datCreat;
	private Date datModif;
	private Date dateCommande;
	private Date dateReception;
	private String delais;
	private String designiationBonReception;
	private Integer indSupp;
	private String mo;
	private Double montant;
	private String ot;
	private Double prixUnitaire;
	private Double qte;
	private Double tva;
	private String unite;
	private String devise;
	public Integer getIdBonReception() {
		return idBonReception;
	}
	public void setIdBonReception(Integer idBonReception) {
		this.idBonReception = idBonReception;
	}
	public String getNumBonCommande() {
		return numBonCommande;
	}
	public void setNumBonCommande(String numBonCommande) {
		this.numBonCommande = numBonCommande;
	}
	public String getNumMarche() {
		return numMarche;
	}
	public void setNumMarche(String numMarche) {
		this.numMarche = numMarche;
	}
	public String getNumBonReception() {
		return numBonReception;
	}
	public void setNumBonReception(String numBonReception) {
		this.numBonReception = numBonReception;
	}
	public Date getDatCreat() {
		return datCreat;
	}
	public void setDatCreat(Date datCreat) {
		this.datCreat = datCreat;
	}
	public Date getDatModif() {
		return datModif;
	}
	public void setDatModif(Date datModif) {
		this.datModif = datModif;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public Date getDateReception() {
		return dateReception;
	}
	public void setDateReception(Date dateReception) {
		this.dateReception = dateReception;
	}
	public String getDelais() {
		return delais;
	}
	public void setDelais(String delais) {
		this.delais = delais;
	}
	public String getDesigniationBonReception() {
		return designiationBonReception;
	}
	public void setDesigniationBonReception(String designiationBonReception) {
		this.designiationBonReception = designiationBonReception;
	}
	public Integer getIndSupp() {
		return indSupp;
	}
	public void setIndSupp(Integer indSupp) {
		this.indSupp = indSupp;
	}
	public String getMo() {
		return mo;
	}
	public void setMo(String mo) {
		this.mo = mo;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public String getOt() {
		return ot;
	}
	public void setOt(String ot) {
		this.ot = ot;
	}
	public Double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(Double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public Double getQte() {
		return qte;
	}
	public void setQte(Double qte) {
		this.qte = qte;
	}
	public Double getTva() {
		return tva;
	}
	public void setTva(Double tva) {
		this.tva = tva;
	}
	public String getUnite() {
		return unite;
	}
	public void setUnite(String unite) {
		this.unite = unite;
	}
	public String getDevise() {
		return devise;
	}
	public void setDevise(String devise) {
		this.devise = devise;
	}
}