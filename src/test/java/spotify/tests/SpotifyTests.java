package spotify.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;
import spotify.PlaylistApiCalls;
import spotify.enums.StatusCodes;
import spotify.pojo.ErrorRoot;
import spotify.pojo.Playlist; 

@Epic("Spotify outh 2.0")
public class SpotifyTests {
	
	 String expired_access_token= "BQAPoUeYvNif4HptqEjv9J2wU5pddHBByuFsTwd8rXppCkveCdQ2Yf_jNwdbJSkN9_t2rE-uF1gG27xoeP44NlNXtai_AIxQauDxiZ72HF1Wv_8Ts6Op2SfS-XwHUGBWVG44dpz8KZHcv_wvfE5pYZlY_iae2CylfbarOLTuUPEr6pCRO7G4CPhwik7V7xnjOF7CCL-Qa_3R0SBJZFU2t7cpp3JcP5YsGVbU-VxzO7Q5LItLzPlX-_sA1FuturCajTFfo-54Z4R25xPLA5kCLc1okIP5idh9c970nPsJ4pk0McrYAOK-";
	 String playlistId= "6Dh8aFgOklofUsrTLg0SAV";
	
	@Story("Create a playlist story")
	@Link("https://example.org")
	@Link(name="allure", type ="mylink")
	@TmsLink("123")
	@Issue("#123")
        @Description("This test case checks that user should Be Able To Create Playlist ")
	@Test(description="Create playlist validation test")
	public void shouldBeAbleToCreatePlaylist() {
		
		Playlist requestedPlaylist = new Playlist()
				         .setName("Raaga Music")
				         .setDescription("new playlist desc")
				         .setPublic(false);
				       
		Response response =	PlaylistApiCalls.post(requestedPlaylist);
		 
		assertThat(response.statusCode(),equalTo(StatusCodes.CODE_201.getCode()));//201		
		Playlist responsePlaylist=response.as(Playlist.class);
		 
		assertThat(responsePlaylist.getName() ,equalTo(requestedPlaylist.getName()));
		 
		assertThat(responsePlaylist.getDescription() ,equalTo(requestedPlaylist.getDescription()));
		 
		assertThat(responsePlaylist.getPublic() ,equalTo(requestedPlaylist.getPublic()));
		   
	}	
	
	@Story("Create a playlist story")
	@Test(description="Fetch playlist validation test")
	public void shouldBeAbleTofetchPlaylist() {
		   Response response = PlaylistApiCalls.get(playlistId);
		   assertThat(response.statusCode(),equalTo(StatusCodes.CODE_200.getCode()));	//200				
		   Playlist responsePlaylist =response.as(Playlist.class);
		   System.out.println("PL ID is :"+responsePlaylist.getId());
	   
	}
	
	@Story("Create a playlist story")
	@Test (description="Update playlist validation test")
	public void shouldBeAbleToupdatePlaylist() {
		
		 Playlist requestedPlaylist = new Playlist()
		         .setName("Raaga New Music")
		         .setDescription("playlist desc")
		         .setPublic(false);
		 
		 Response response = PlaylistApiCalls.put(playlistId, requestedPlaylist);
		 assertThat(response.statusCode(),equalTo(StatusCodes.CODE_200.getCode()));//200
	 	   
	}	

	@Test(description="Negative validation test without name")
	public void shouldNotBeAbleToCreatePlaylistWithoutName() {
		
		Playlist requestedPlaylist = new Playlist()
		         .setDescription("new playlist desc")
		         .setPublic(false);
		
		Response response = PlaylistApiCalls.post(requestedPlaylist);
		assertThat(response.statusCode(),equalTo(StatusCodes.CODE_400.getCode()));//400
				       
		ErrorRoot error =response.as(ErrorRoot.class);		
		 assertThat(error.getError().getStatus(),equalTo(StatusCodes.CODE_400.getCode()));
		 assertThat(error.getError().getMessage(),equalTo(StatusCodes.CODE_400.getMsg()));  
	}
	
	@Story("Expired token story")
    @Test(description="Negative validation test with expired token")
	public void shouldNotBeAbleToCreatePlaylistWithExpiredToken() {
		
		 Playlist requestedPlaylist = new Playlist()
		         .setName("Raaga New Music")
		         .setDescription("playlist desc")
		         .setPublic(false);
				       
		Response response = PlaylistApiCalls.post(expired_access_token ,requestedPlaylist);
		
		 ErrorRoot er = response.as(ErrorRoot.class);
		
		 
		 assertThat(er.getError().getStatus(),equalTo(StatusCodes.CODE_401.getCode()));//401
		 assertThat(er.getError().getMessage(),equalTo(StatusCodes.CODE_401.getMsg()));  
	}	

}
//working fine
























