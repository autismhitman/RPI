package spotify.enums;

public enum Routes {
	
	USERS("/users/"),
	PLAYLIST("/playlists/"),
	BASEPATH("/v1"),
    ACCOUNTPATH("/api/token");
	
	private String description;
	
	Routes(String description){
		this.description= description;
	}
	
	public String toString() {
		
		return description;
	}
}
