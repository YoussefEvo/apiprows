package ma.co.marsa.apiprows.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.co.marsa.apiprows.dao.interfaces.IMarcheDAO;
import ma.co.marsa.apiprows.dto.BonReceptionDTO;
import ma.co.marsa.apiprows.dto.BordereauPrixDTO;
import ma.co.marsa.apiprows.dto.MarcheDTO;
import ma.co.marsa.apiprows.dto.ParamWsApiproDTO;
import ma.co.marsa.apiprows.services.interfaces.IMarcheService;

@Service
@Transactional
public class MarcheService implements IMarcheService{
	
	@Autowired
    private IMarcheDAO marcheDAO;
	
	@Override
	public List<MarcheDTO> findAllMarches(String siteCode) throws Exception{
		if (StringUtils.isNotBlank(siteCode)) {
			return marcheDAO.findAllMarches(siteCode);
		}else{
			throw new Exception("Le site code est un champ obligatoire ");
		}
	}

	@Override
	public List<BordereauPrixDTO> findBordereauPrixByNumMarche(String numMarche) throws Exception {
		if (StringUtils.isNotBlank(numMarche)) {
			return marcheDAO.findBordereauPrixByNumMarche(numMarche);
		}else{
			throw new Exception("Le numéro du marché est un champ obligatoire ");
		}
	}
	
	@Override
	public List<BonReceptionDTO> getlistBonReceptionMarche(ParamWsApiproDTO paramWsApipro) throws Exception {
		if (null == paramWsApipro){
			throw new Exception("Le numéro du marché et La date debut et La date fin sont des champs obligatoire ");
		} else if (StringUtils.isNotBlank(paramWsApipro.getCodeMarche())) {
			throw new Exception("Le numéro du marché est un champ obligatoire ");
		}else if (null != paramWsApipro.getDateDebut()) {
			throw new Exception("La date debut est un champ obligatoire ");
		}else if (null != paramWsApipro.getDateFin()) {
			throw new Exception("La date fin est un champ obligatoire ");
		}else{
			return marcheDAO.getlistBonReceptionMarche(paramWsApipro);
		}
	}
}
