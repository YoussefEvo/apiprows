package ma.co.marsa.apiprows.services.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import ma.co.marsa.apiprows.dto.BonReceptionDTO;
import ma.co.marsa.apiprows.dto.BordereauPrixDTO;
import ma.co.marsa.apiprows.dto.MarcheDTO;
import ma.co.marsa.apiprows.dto.ParamWsApiproDTO;

/**
 * 
 * @author ZGUIOUAR
 *
 */
public interface IMarcheService {
	
	/**
	 * DESCRIPTION : Methode qui permet de récupérer la liste des marchés
	 * DATE DERNIERE MODIF : 01 fev. 2017
	 * PROJET : APIPROWS
	 * AUTEUR : ZGUIOUAR
	 * 
	 * @param siteCode
	 * @return
	 * @throws Exception
	 */
	List<MarcheDTO> findAllMarches(String siteCode) throws Exception;
	
	/**
	 * DESCRIPTION : BPU Bordereau Prix Unitaires 
	 * DATE DERNIERE MODIF : 07 Fév. 2017
	 * PROJET : APIPROWS
	 * AUTEUR : ZGUIOUAR
	 * 
	 * @param numMarche
	 * @return 
	 * @throws Exception
	 */
	List<BordereauPrixDTO> findBordereauPrixByNumMarche(String numMarche) throws Exception;
	
	/**
	 * DESCRIPTION : Methode qui permet de récupérer la liste des bons de réception par 
	 * 				 numéro du marché , date debut & date fin	 
	 * DATE DERNIERE MODIF : 01 fév. 2017
	 * PROJET : APIPROWS
	 * AUTEUR : ZGUIOUAR
	 * 
	 * @param paramWsApipro
	 * @return
	 * @return
	 */
	List<BonReceptionDTO> getlistBonReceptionMarche(ParamWsApiproDTO paramWsApipro) throws Exception;
	
}
