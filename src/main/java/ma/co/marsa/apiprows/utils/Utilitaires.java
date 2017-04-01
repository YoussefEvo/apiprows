package ma.co.marsa.apiprows.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Classe qui permet le traitement utilitaire 
 * CRÉE LE : 17 janv. 2017 
 * PROJET : APIPROWS
 * AUTEUR : ZGUIOUAR
 * 
 * @author ZGUIOUAR
 *
 */
public class Utilitaires {

	private final static Logger LOGGER = Logger.getLogger(Utilitaires.class);
	
	/**
	 * DESCRIPTION : Methode qui permet de convertir une chaine à un entier
	 * DATE DERNIERE MODIF : 17 janv. 2017
	 * PROJET : APIPROWS
	 * AUTEUR : ZGUIOUAR
	 * 
	 * @param value
	 * @return
	 */
	public static Integer getInteger(final String value) {
		if (StringUtils.isNotEmpty(value)) {
			return (Integer) ConvertUtils.convert(value, Integer.class);
		}
		return 0;
	}
	
	/**
	 * 
	 * DESCRIPTION : 
	 * DATE DERNIERE MODIF :  06 janv. 2017 
	 * PROJET : APIPROWS
	 * AUTEUR : ZGUIOUAR
	 * 
	 * @param value
	 * @param pattern
	 * @return
	 */
	public static String getString(final Date value, String pattern) {
		if (StringUtils.isNotBlank(pattern)) {
			pattern = Constantes.DATE_PATTERN_DASH_YYYY;
		}
		if (value == null) {
			return null;
		}
		return dateToString(value, pattern);
	}
	
	/**
	 * 
	 * DESCRIPTION : 
	 * DATE DERNIERE MODIF :  06 janv. 2017 
	 * PROJET : Gestion Decomptes
	 * AUTEUR : ZGUIOUAR
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static final String dateToString(final Date date, final String pattern) {
		try {
			if (date != null) {
				SimpleDateFormat simpleDate = new SimpleDateFormat(pattern,
						Locale.FRANCE);
				return simpleDate.format(date);
			}
		} catch (Exception ex) {
			LOGGER.error(ex);
		}
		return null;
	}
	
	/**
	 * DESCRIPTION : Gestion des erreurs  
	 * DATE DERNIERE MODIF : 19 janv. 2017
	 * PROJET : APIPROWS
	 * AUTEUR : ZGUIOUAR
	 * 
	 * @param value
	 * @return
	 */
	public static MultiValueMap<String, String> handleError(final Exception e){
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add(Constantes.ERROR_RESPONSE_STATUS_CODE, HttpStatus.INTERNAL_SERVER_ERROR.toString());
		map.add(Constantes.ERROR_RESPONSE_MESSAGE, e.getClass().getName() + ": " + e.getMessage());
		map.add(Constantes.ERROR_RESPONSE_METHODE, e.getStackTrace()[0].getClassName() + "." + e.getStackTrace()[0].getMethodName());
		return map;
	}

}
