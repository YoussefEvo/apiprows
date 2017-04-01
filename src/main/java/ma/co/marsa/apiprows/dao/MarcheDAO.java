package ma.co.marsa.apiprows.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ma.co.marsa.apiprows.dao.interfaces.IMarcheDAO;
import ma.co.marsa.apiprows.dto.BonReceptionDTO;
import ma.co.marsa.apiprows.dto.BordereauPrixDTO;
import ma.co.marsa.apiprows.dto.MarcheDTO;
import ma.co.marsa.apiprows.dto.ParamWsApiproDTO;

@Repository
public class MarcheDAO implements IMarcheDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<MarcheDTO> findAllMarches(String siteCode) throws Exception {
		StringBuilder req = new StringBuilder();
		req.append("SELECT  marche.agreement_key, marche.supplier_key, fournisseur.supplier_name")
				.append(" , marche.agreement_name, marche.description, marche.start_date, marche.end_date")
				.append(" , marche.agreement_code_key, marche.account_key, marche.milestone_amount_currency")
				.append(" , marche.currency_key")
				.append(" FROM dbo.agreement marche inner join dbo.supplier fournisseur")
				.append(" on marche.supplier_key = fournisseur.supplier_key")
				.append(" where  marche.site_key = ?");
		Object[] params = new Object[]{siteCode.replace("\"", "")};
		List<MarcheDTO> marches = jdbcTemplate.query(req.toString(), params,
		        new RowMapper<MarcheDTO>() {
		            public MarcheDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	MarcheDTO marche = new MarcheDTO();
		            	marche.setNumMarche(rs.getString("agreement_key"));
		            	marche.setTypeMarche(rs.getString("agreement_code_key"));
		            	marche.setLibMarche(rs.getString("agreement_name"));
		            	marche.setCodFournisseur(rs.getString("supplier_key"));
		            	marche.setLibFournisseur(rs.getString("supplier_name"));
		            	marche.setDescription(rs.getString("description"));
		            	marche.setBudget(rs.getString("account_key"));
		            	marche.setMontant(rs.getDouble("milestone_amount_currency"));
		            	marche.setDevise(rs.getString("currency_key"));
		            	marche.setDateDemarage(rs.getDate("start_date"));
		            	marche.setDateFin(rs.getDate("end_date"));
		                return marche;
		            }
		        });
		return marches;
	}

	@Override
	public List<BordereauPrixDTO> findBordereauPrixByNumMarche(String numMarche) throws Exception {
		StringBuilder req = new StringBuilder();
		req.append("SELECT  agreement_key, sp_name, unit_price, agreed_quantity, unit")
				.append(" FROM dbo.agr_sp_combination ")
				.append(" where  agreement_key = ");
		Object[] params = new Object[]{numMarche.replace("\"", "")};
		List<BordereauPrixDTO> BordereauPrixs = jdbcTemplate.query(req.toString(), params,
		        new RowMapper<BordereauPrixDTO>() {
		            public BordereauPrixDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	BordereauPrixDTO bordereauPrix = new BordereauPrixDTO();
		            	bordereauPrix.setNumMarche(rs.getString("agreement_key"));
		            	bordereauPrix.setDesigniation(rs.getString("sp_name"));
		            	bordereauPrix.setUnite(rs.getString("unit"));
		            	bordereauPrix.setQte(rs.getDouble("agreed_quantity"));
		            	bordereauPrix.setPrixUnitaire(rs.getDouble("unit_price"));
		                return bordereauPrix;
		            }
		        });
		return BordereauPrixs;
	}
	
	@Override
	public List<BonReceptionDTO> getlistBonReceptionMarche(ParamWsApiproDTO paramWsApipro) throws Exception {
		StringBuilder req = new StringBuilder();
		req.append("SELECT  agreement_key, po_key, delivery_key, mo_key, wo_key")
				.append(", trans_date, sp_name, unit, quantity, unit_price")
				.append(", transaction_amount, currency_key")
				.append(" FROM dbo.transactions ")
				.append(" where agreement_key = ? and trans_date between ? and ?  ");
		Object[] params = new Object[]{paramWsApipro.getCodeMarche(), paramWsApipro.getDateDebutStr(), paramWsApipro.getDateFinStr()};
		List<BonReceptionDTO> bonReceptions = jdbcTemplate.query(req.toString(), params,
		        new RowMapper<BonReceptionDTO>() {
		            public BonReceptionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	BonReceptionDTO bonReception = new BonReceptionDTO();
		            	bonReception.setNumMarche(rs.getString("agreement_key"));
		            	bonReception.setNumBonCommande(rs.getString("po_key"));
		            	bonReception.setNumBonReception(rs.getString("delivery_key"));
		            	bonReception.setMo(rs.getString("mo_key"));
		            	bonReception.setOt(rs.getString("wo_key"));
		            	bonReception.setDateReception(rs.getDate("trans_date"));
		            	bonReception.setDesigniationBonReception(rs.getString("sp_name"));
		            	bonReception.setUnite(rs.getString("unit"));
		            	bonReception.setQte(rs.getDouble("quantity"));
		            	bonReception.setPrixUnitaire(rs.getDouble("unit_price"));
		            	bonReception.setMontant(rs.getDouble("transaction_amount"));
		            	bonReception.setDevise(rs.getString("currency_key"));
		                return bonReception;
		            }
		        });
		return bonReceptions;
	}
	
	
}
