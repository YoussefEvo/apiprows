package ma.co.marsa.apiprows.dto;

import java.util.Date;

import ma.co.marsa.apiprows.utils.Constantes;
import ma.co.marsa.apiprows.utils.Utilitaires;

public class ParamWsApiproDTO {
	
	private String codeMarche;
	private String libFourbisseur;
	private String CodeSite;
	
	private Date dateEtablissement;
	private Date dateDebut;
	private Date dateFin;
	
	public String getCodeMarche() {
		return codeMarche;
	}
	public void setCodeMarche(String codeMarche) {
		this.codeMarche = codeMarche;
	}
	public String getLibFourbisseur() {
		return libFourbisseur;
	}
	public void setLibFourbisseur(String libFourbisseur) {
		this.libFourbisseur = libFourbisseur;
	}
	public String getCodeSite() {
		return CodeSite;
	}
	public void setCodeSite(String codeSite) {
		CodeSite = codeSite;
	}
	public Date getDateEtablissement() {
		return dateEtablissement;
	}
	public void setDateEtablissement(Date dateEtablissement) {
		this.dateEtablissement = dateEtablissement;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	public String getDateDebutStr() {
		return Utilitaires.getString(dateDebut, Constantes.DATE_PATTERN_DASH_YYYY);
	}
	
	public String getDateFinStr() {
		return Utilitaires.getString(dateFin, Constantes.DATE_PATTERN_DASH_YYYY);
	}
	
	

	
}
