package spotify;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import spotify.enums.Routes;
import spotify.pojo.Playlist;
public class PlaylistApiCalls {


	
	@Step
	public static Response post(Playlist requestedPlaylist) {
		
		return RestResource.post(TokenManager.getToken(),Routes.USERS+"31rlivtmsorcvxgufquhvgcb62lq/playlists", requestedPlaylist);	

	}
	
	public static Response post(String token, Playlist requestedPlaylist) {
        
		return RestResource.post(token,Routes.USERS+"31rlivtmsorcvxgufquhvgcb62lq/playlists", requestedPlaylist);			 

	}

	public static Response get(String playlistId) {
		
		return RestResource.get(TokenManager.getToken(), Routes.PLAYLIST + playlistId);
	}

	public static Response put(String playlistId, Playlist requestedPlaylist) {

		return RestResource.put(TokenManager.getToken(),Routes.PLAYLIST + playlistId, requestedPlaylist);
				 
	}

}
