package spotify;

import static io.restassured.RestAssured.given;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;
import spotify.utils.ConfigLoader;
public class TokenManager {
	
	private static String access_token;
	private static Instant expiry_time;
	
	public synchronized static String getToken() {
		
		try {
			if(access_token==null || Instant.now().isAfter(expiry_time)) {
				 System.out.println("Renewing token !!!");
				 Response response = renewToken(); 
				 access_token =response.path("access_token");
				 int expiryDurationinSeconds= response.path("expires_in");
				 expiry_time = Instant.now().plusSeconds(expiryDurationinSeconds-300);
			}
			else {
				System.out.println("Token is good to use");
				
			}
		}catch(Exception e) {
			
			throw new RuntimeException("Token renew failed");
		}
		return access_token;
		
	}
	
	private static Response renewToken() {
		
		 Map<String, String> hmap = new HashMap<>();
		 hmap.put("grant_type", ConfigLoader.getInstance().getGrantType());
		 hmap.put("refresh_token", ConfigLoader.getInstance().getRefreshToken());
		// System.out.println(ConfigLoader.getGrantType());
		// System.out.println(ConfigLoader.getRefreshToken());
		 
		Response response= RestResource.postAccount(hmap);
		
		if(response.statusCode()!=200) {
			throw new RuntimeException("Abort!! Renew token failed");
		}
		else 
			return response;
	}

}
