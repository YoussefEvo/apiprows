package ma.co.marsa.apiprows.test;

//import java.util.List;
//
//import ma.co.marsa.apiprows.dto.UserDTO;
//
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.client.RestTemplate;

public class UserRestTestClient  {

	public static final String REST_SERVICE_URI = "http://localhost:8080/apiprows";
	
	/** 
	 * DESCRIPTION : Récupérer la liste des Utilisateurs
	 * DATE DERNIERE MODIF : 17 janv. 2017
	 * PROJET : APIPROWS
	 * AUTEUR : ZGUIOUAR
	 * 
	 * @return
	 */
	private static void listAllUsers(){
		
		
		// Methode 1 bind DTO 
		
//		RestTemplate restTemplate = new RestTemplate();
//		ParameterizedTypeReference<List<UserDTO>> typeRef = new ParameterizedTypeReference<List<UserDTO>>() {};
//		UserDTO user1 = new UserDTO();
//		user1.setEmail("test@test");
//		HttpHeaders requestHeaders = new HttpHeaders();
//		requestHeaders.setContentType(new MediaType("application", "json", Charset.forName("utf-8")));
//		requestHeaders.set("Accept", "application/json");
//		HttpEntity<UserDTO> request = new HttpEntity<UserDTO>(user1, requestHeaders);
//		ResponseEntity<List<UserDTO>> response = restTemplate.exchange(REST_SERVICE_URI + "/user/", HttpMethod.POST,request, typeRef);
//		
//		Spring mvc rest :
//		@RequestMapping(value = "/user/", method = RequestMethod.POST, produces = "application/json")
//		public ResponseEntity<List<UserDTO>> listAllUsers(@RequestBody UserDTO params) {...}
		
		//Methode 2 bind MultiValueMap
		
//		RestTemplate restTemplate = new RestTemplate();
//		ParameterizedTypeReference<List<UserDTO>> typeRef = new ParameterizedTypeReference<List<UserDTO>>() {};
//		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
//		map.add("libFrn", "1");
//		map.add("codeSite", "2");
//		map.add("codeMarche", "3");
//		HttpHeaders requestHeaders = new HttpHeaders();
//		requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//		requestHeaders.set("Accept", "application/json");
//		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,requestHeaders);
//		ResponseEntity<List<UserDTO>> response = restTemplate.exchange(REST_SERVICE_URI + "/user/", HttpMethod.POST,request, typeRef);
//		
//		Spring mvc rest :
//		@RequestMapping(value = "/user/", method = RequestMethod.POST, produces = "application/json")
//		public ResponseEntity<List<UserDTO>> listAllUsers(@RequestBody MultiValueMap<String, Object> params) {
		
		// Resultat
		
//		if (HttpStatus.OK.equals(response.getStatusCode())) {
//			List<UserDTO> users = response.getBody();
//			for (UserDTO user : users) {
//				System.out.println(user.getUsername());
//			}
//		}
	}
	


    public static void main(String args[]){
		listAllUsers();
    }
}