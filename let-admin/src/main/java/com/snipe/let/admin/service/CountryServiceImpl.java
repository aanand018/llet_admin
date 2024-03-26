package com.snipe.let.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.snipe.let.admin.dao.CountryDAO;
import com.snipe.let.admin.dao.CountryRepository;
import com.snipe.let.admin.domain.CountryDomain;
import com.snipe.let.admin.mapper.CountryMapper;
import com.snipe.let.admin.model.CountryModel;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryDAO countryDAO;

	@Autowired
	CountryMapper countryMapper;

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String addCountry(CountryModel countryModel) throws Exception {
		CountryDomain countryDomain = new CountryDomain();
		BeanUtils.copyProperties(countryModel, countryDomain);
		List<CountryDomain> CountryDomain = countryRepository.findAll();
		if (CountryDomain.size() == 0) {
			String sql = insertCountry();

			int res = jdbcTemplate.update(sql);
			if (res == 1) {
				System.out.println("success");
			} else {
				System.out.println("failure");
			}
		}
		return countryDAO.addCountry(countryDomain);
	}

	@Override
	public List<CountryModel> getCountryList() throws Exception {
		List<CountryDomain> countryDomain = countryDAO.getCountryList();
		return countryMapper.entityList(countryDomain);
	}

	@Override
	public CountryModel getCountryListById(long countryId) throws Exception {
		CountryModel countryModel = new CountryModel();
		CountryDomain countryDomain = countryDAO.getCountryListById(countryId);
		BeanUtils.copyProperties(countryDomain, countryModel);
		return countryModel;
	}

	@Override
	public String updateCountry(CountryModel countryModel) throws Exception {
		CountryDomain countryDomain = new CountryDomain();
		BeanUtils.copyProperties(countryModel, countryDomain);
		return countryDAO.updateCountry(countryDomain);
	}

	public String deleteCountryById(long countryId) throws Exception {
		return countryDAO.deleteCountryById(countryId);
	}

	private String insertCountry() {
		String sql = "INSERT INTO `country` VALUES (1,93,'Afghanistan','AF',0),(2,355,'Albania','AL',0),(3,213,'Algeria','DZ',0),(4,1684,'American Samoa','AS',0),(5,376,'Andorra','AD',0),(6,244,'Angola','AO',0),(7,1264,'Anguilla','AI',0),(8,0,'Antarctica','AQ',0),(9,1268,'Antigua And Barbuda','AG',0),(10,54,'Argentina','AR',0),(11,374,'Armenia','AM',0),(12,297,'Aruba','AW',0),(13,61,'Australia','AU',0),(14,43,'Austria','AT',0),(15,994,'Azerbaijan','AZ',0),(16,1242,'Bahamas The','BS',0),(17,973,'Bahrain','BH',0),(18,880,'Bangladesh','BD',0),(19,1246,'Barbados','BB',0),(20,375,'Belarus','BY',0),(21,32,'Belgium','BE',0),(22,501,'Belize','BZ',0),(23,229,'Benin','BJ',0),(24,1441,'Bermuda','BM',0),(25,975,'Bhutan','BT',0),(26,591,'Bolivia','BO',0),(27,387,'Bosnia and Herzegovina','BA',0),(28,267,'Botswana','BW',0),(29,0,'Bouvet Island','BV',0),(30,55,'Brazil','BR',0),(31,246,'British Indian Ocean Territory','IO',0),(32,673,'Brunei','BN',0),(33,359,'Bulgaria','BG',0),(34,226,'Burkina Faso','BF',0),(35,257,'Burundi','BI',0),(36,855,'Cambodia','KH',0),(37,237,'Cameroon','CM',0),(38,1,'Canada','CA',0),(39,238,'Cape Verde','CV',0),(40,1345,'Cayman Islands','KY',0),(41,236,'Central African Republic','CF',0),(42,235,'Chad','TD',0),(43,56,'Chile','CL',0),(44,86,'China','CN',0),(45,61,'Christmas Island','CX',0),(46,672,'Cocos (Keeling) Islands','CC',0),(47,57,'Colombia','CO',0),(48,269,'Comoros','KM',0),(49,242,'Republic Of The Congo','CG',0),(50,242,'Democratic Republic Of The Congo','CD',0),(51,682,'Cook Islands','CK',0),(52,506,'Costa Rica','CR',0),(53,225,'Cote D\\'Ivoire (Ivory Coast)','CI',0),(54,385,'Croatia (Hrvatska)','HR',0),(55,53,'Cuba','CU',0),(56,357,'Cyprus','CY',0),(57,420,'Czech Republic','CZ',0),(58,45,'Denmark','DK',0),(59,253,'Djibouti','DJ',0),(60,1767,'Dominica','DM',0),(61,1809,'Dominican Republic','DO',0),(62,670,'East Timor','TP',0),(63,593,'Ecuador','EC',0),(64,20,'Egypt','EG',0),(65,503,'El Salvador','SV',0),(66,240,'Equatorial Guinea','GQ',0),(67,291,'Eritrea','ER',0),(68,372,'Estonia','EE',0),(69,251,'Ethiopia','ET',0),(70,61,'External Territories of Australia','XA',0),(71,500,'Falkland Islands','FK',0),(72,298,'Faroe Islands','FO',0),(73,679,'Fiji Islands','FJ',0),(74,358,'Finland','FI',0),(75,33,'France','FR',0),(76,594,'French Guiana','GF',0),(77,689,'French Polynesia','PF',0),(78,0,'French Southern Territories','TF',0),(79,241,'Gabon','GA',0),(80,220,'Gambia The','GM',0),(81,995,'Georgia','GE',0),(82,49,'Germany','DE',0),(83,233,'Ghana','GH',0),(84,350,'Gibraltar','GI',0),(85,30,'Greece','GR',0),(86,299,'Greenland','GL',0),(87,1473,'Grenada','GD',0),(88,590,'Guadeloupe','GP',0),(89,1671,'Guam','GU',0),(90,502,'Guatemala','GT',0),(91,44,'Guernsey and Alderney','XU',0),(92,224,'Guinea','GN',0),(93,245,'Guinea-Bissau','GW',0),(94,592,'Guyana','GY',0),(95,509,'Haiti','HT',0),(96,0,'Heard and McDonald Islands','HM',0),(97,504,'Honduras','HN',0),(98,852,'Hong Kong S.A.R.','HK',0),(99,36,'Hungary','HU',0),(100,354,'Iceland','IS',0),(101,91,'India','IN',0),(102,62,'Indonesia','ID',0),(103,98,'Iran','IR',0),(104,964,'Iraq','IQ',0),(105,353,'Ireland','IE',0),(106,972,'Israel','IL',0),(107,39,'Italy','IT',0),(108,1876,'Jamaica','JM',0),(109,81,'Japan','JP',0),(110,44,'Jersey','XJ',0),(111,962,'Jordan','JO',0),(112,7,'Kazakhstan','KZ',0),(113,254,'Kenya','KE',0),(114,686,'Kiribati','KI',0),(115,850,'Korea North','KP',0),(116,82,'Korea South','KR',0),(117,965,'Kuwait','KW',0),(118,996,'Kyrgyzstan','KG',0),(119,856,'Laos','LA',0),(120,371,'Latvia','LV',0),(121,961,'Lebanon','LB',0),(122,266,'Lesotho','LS',0),(123,231,'Liberia','LR',0),(124,218,'Libya','LY',0),(125,423,'Liechtenstein','LI',0),(126,370,'Lithuania','LT',0),(127,352,'Luxembourg','LU',0),(128,853,'Macau S.A.R.','MO',0),(129,389,'Macedonia','MK',0),(130,261,'Madagascar','MG',0),(131,265,'Malawi','MW',0),(132,60,'Malaysia','MY',0),(133,960,'Maldives','MV',0),(134,223,'Mali','ML',0),(135,356,'Malta','MT',0),(136,44,'Man (Isle of)','XM',0),(137,692,'Marshall Islands','MH',0),(138,596,'Martinique','MQ',0),(139,222,'Mauritania','MR',0),(140,230,'Mauritius','MU',0),(141,269,'Mayotte','YT',0),(142,52,'Mexico','MX',0),(143,691,'Micronesia','FM',0),(144,373,'Moldova','MD',0),(145,377,'Monaco','MC',0),(146,976,'Mongolia','MN',0),(147,1664,'Montserrat','MS',0),(148,212,'Morocco','MA',0),(149,258,'Mozambique','MZ',0),(150,95,'Myanmar','MM',0),(151,264,'Namibia','NA',0),(152,674,'Nauru','NR',0),(153,977,'Nepal','NP',0),(154,599,'Netherlands Antilles','AN',0),(155,31,'Netherlands The','NL',0),(156,687,'New Caledonia','NC',0),(157,64,'New Zealand','NZ',0),(158,505,'Nicaragua','NI',0),(159,227,'Niger','NE',0),(160,234,'Nigeria','NG',0),(161,683,'Niue','NU',0),(162,672,'Norfolk Island','NF',0),(163,1670,'Northern Mariana Islands','MP',0),(164,47,'Norway','NO',0),(165,968,'Oman','OM',0),(166,92,'Pakistan','PK',0),(167,680,'Palau','PW',0),(168,970,'Palestinian Territory Occupied','PS',0),(169,507,'Panama','PA',0),(170,675,'Papua new Guinea','PG',0),(171,595,'Paraguay','PY',0),(172,51,'Peru','PE',0),(173,63,'Philippines','PH',0),(174,0,'Pitcairn Island','PN',0),(175,48,'Poland','PL',0),(176,351,'Portugal','PT',0),(177,1787,'Puerto Rico','PR',0),(178,974,'Qatar','QA',0),(179,262,'Reunion','RE',0),(180,40,'Romania','RO',0),(181,70,'Russia','RU',0),(182,250,'Rwanda','RW',0),(183,290,'Saint Helena','SH',0),(184,1869,'Saint Kitts And Nevis','KN',0),(185,1758,'Saint Lucia','LC',0),(186,508,'Saint Pierre and Miquelon','PM',0),(187,1784,'Saint Vincent And The Grenadines','VC',0),(188,684,'Samoa','WS',0),(189,378,'San Marino','SM',0),(190,239,'Sao Tome and Principe','ST',0),(191,966,'Saudi Arabia','SA',0),(192,221,'Senegal','SN',0),(193,381,'Serbia','RS',0),(194,248,'Seychelles','SC',0),(195,232,'Sierra Leone','SL',0),(196,65,'Singapore','SG',0),(197,421,'Slovakia','SK',0),(198,386,'Slovenia','SI',0),(199,44,'Smaller Territories of the UK','XG',0),(200,677,'Solomon Islands','SB',0),(201,252,'Somalia','SO',0),(202,27,'South Africa','ZA',0),(203,0,'South Georgia','GS',0),(204,211,'South Sudan','SS',0),(205,34,'Spain','ES',0),(206,94,'Sri Lanka','LK',0),(207,249,'Sudan','SD',0),(208,597,'Suriname','SR',0),(209,47,'Svalbard And Jan Mayen Islands','SJ',0),(210,268,'Swaziland','SZ',0),(211,46,'Sweden','SE',0),(212,41,'Switzerland','CH',0),(213,963,'Syria','SY',0),(214,886,'Taiwan','TW',0),(215,992,'Tajikistan','TJ',0),(216,255,'Tanzania','TZ',0),(217,66,'Thailand','TH',0),(218,228,'Togo','TG',0),(219,690,'Tokelau','TK',0),(220,676,'Tonga','TO',0),(221,1868,'Trinidad And Tobago','TT',0),(222,216,'Tunisia','TN',0),(223,90,'Turkey','TR',0),(224,7370,'Turkmenistan','TM',0),(225,1649,'Turks And Caicos Islands','TC',0),(226,688,'Tuvalu','TV',0),(227,256,'Uganda','UG',0),(228,380,'Ukraine','UA',0),(229,971,'United Arab Emirates','AE',0),(230,44,'United Kingdom','GB',0),(231,1,'United States','US',0),(232,1,'United States Minor Outlying Islands','UM',0),(233,598,'Uruguay','UY',0),(234,998,'Uzbekistan','UZ',0),(235,678,'Vanuatu','VU',0),(236,39,'Vatican City State (Holy See)','VA',0),(237,58,'Venezuela','VE',0),(238,84,'Vietnam','VN',0),(239,1284,'Virgin Islands (British)','VG',0),(240,1340,'Virgin Islands (US)','VI',0),(241,681,'Wallis And Futuna Islands','WF',0),(242,212,'Western Sahara','EH',0),(243,967,'Yemen','YE',0),(244,38,'Yugoslavia','YU',0),(245,260,'Zambia','ZM',0),(246,263,'Zimbabwe','ZW',0);\r\n"
				+ "";
		return sql;

	}

}
