package ma.co.marsa.apiprows.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.co.marsa.apiprows.dto.BonReceptionDTO;
import ma.co.marsa.apiprows.dto.BordereauPrixDTO;
import ma.co.marsa.apiprows.dto.MarcheDTO;
import ma.co.marsa.apiprows.dto.ParamWsApiproDTO;
import ma.co.marsa.apiprows.services.interfaces.IMarcheService;
import ma.co.marsa.apiprows.utils.Utilitaires;

@RestController
public class MarcheRestController {
	
	private final static Logger LOGGER = Logger.getLogger(MarcheRestController.class);

	@Autowired
	IMarcheService marcheService;
	
	
	/**
	 * DESCRIPTION : Methode qui permet de récupérer la liste des marchés 
	 * DATE DERNIERE MODIF : 01 fév. 2017
	 * PROJET : APIPROWS
	 * AUTEUR : ZGUIOUAR
	 * 
	 * @param value
	 * @return
	 */
	@RequestMapping(value = "/listMarche/", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<MarcheDTO>> listMarche(@RequestBody String siteCode) {
		List<MarcheDTO> listMarches = new ArrayList<>();
		try {
			listMarches= marcheService.findAllMarches(siteCode);
			if(CollectionUtils.isEmpty(listMarches)){
				return new ResponseEntity<List<MarcheDTO>>(listMarches, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			LOGGER.error(e);
			return new ResponseEntity<List<MarcheDTO>>(null, Utilitaires.handleError(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<MarcheDTO>>(listMarches, HttpStatus.OK);
	}
		

	/**
	 * DESCRIPTION : Methode qui permet de récupérer la liste des marchés 
	 * DATE DERNIERE MODIF : 01 fév. 2017
	 * PROJET : APIPROWS
	 * AUTEUR : ZGUIOUAR
	 * 
	 * @param value
	 * @return
	 */
	@RequestMapping(value = "/bordereauPrixMarche/", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<BordereauPrixDTO>> listBordereauPrixMarche(@RequestBody String numMarche) {
		List<BordereauPrixDTO> listBordereauPrix;
		try {
			listBordereauPrix= marcheService.findBordereauPrixByNumMarche(numMarche);
			if(CollectionUtils.isEmpty(listBordereauPrix)){
				return new ResponseEntity<List<BordereauPrixDTO>>(listBordereauPrix, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			LOGGER.error(e);
			return new ResponseEntity<List<BordereauPrixDTO>>(null, Utilitaires.handleError(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<BordereauPrixDTO>>(listBordereauPrix, HttpStatus.OK);
	}
	
	/**
	 * DESCRIPTION : Methode qui permet de récupérer la liste des bons de réception par 
	 * 				 numéro du marché , date debut & date fin	 
	 * DATE DERNIERE MODIF : 10 fév. 2017
	 * PROJET : APIPROWS
	 * AUTEUR : ZGUIOUAR
	 * 
	 * @param paramWsApipro
	 * @return
	 */
	@RequestMapping(value = "/listBonReceptionMarche/", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<BonReceptionDTO>> listBonReceptionMarche(@RequestBody ParamWsApiproDTO paramWsApipro) {
		List<BonReceptionDTO> listbonReceptions;
		try {
			listbonReceptions= marcheService.getlistBonReceptionMarche(paramWsApipro);
			if(CollectionUtils.isEmpty(listbonReceptions)){
				return new ResponseEntity<List<BonReceptionDTO>>(listbonReceptions, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			LOGGER.error(e);
			return new ResponseEntity<List<BonReceptionDTO>>(null, Utilitaires.handleError(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<BonReceptionDTO>>(listbonReceptions, HttpStatus.OK);
	}
	
	
}
