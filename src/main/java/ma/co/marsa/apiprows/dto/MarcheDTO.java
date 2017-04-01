package ma.co.marsa.apiprows.dto;

import java.io.Serializable;
import java.util.Date;


public class MarcheDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idMarche;
	private String codFournisseur;
	private String typeMarche;
	private Date dateDemarage;
	private Date dateFin;
	private String description;
	private String budget;
	private String devise;
	private Double montant;
	private String libFournisseur;
	private String libMarche;
	private String numMarche;
	private String userCreat;
	private String userModif;
	private Date datCreat;
	private Date datModif;
	private Integer indSupp;

	public MarcheDTO() {
	}

	public Integer getIdMarche() {
		return idMarche;
	}

	public void setIdMarche(Integer idMarche) {
		this.idMarche = idMarche;
	}

	public String getCodFournisseur() {
		return codFournisseur;
	}

	public void setCodFournisseur(String codFournisseur) {
		this.codFournisseur = codFournisseur;
	}

	public Date getDateDemarage() {
		return dateDemarage;
	}

	public void setDateDemarage(Date dateDemarage) {
		this.dateDemarage = dateDemarage;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLibFournisseur() {
		return libFournisseur;
	}

	public void setLibFournisseur(String libFournisseur) {
		this.libFournisseur = libFournisseur;
	}

	public String getLibMarche() {
		return libMarche;
	}

	public void setLibMarche(String libMarche) {
		this.libMarche = libMarche;
	}

	public String getNumMarche() {
		return numMarche;
	}

	public void setNumMarche(String numMarche) {
		this.numMarche = numMarche;
	}

	public String getUserCreat() {
		return userCreat;
	}

	public void setUserCreat(String userCreat) {
		this.userCreat = userCreat;
	}

	public String getUserModif() {
		return userModif;
	}

	public void setUserModif(String userModif) {
		this.userModif = userModif;
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

	public Integer getIndSupp() {
		return indSupp;
	}

	public void setIndSupp(Integer indSupp) {
		this.indSupp = indSupp;
	}

	public String getTypeMarche() {
		return typeMarche;
	}

	public void setTypeMarche(String typeMarche) {
		this.typeMarche = typeMarche;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
}