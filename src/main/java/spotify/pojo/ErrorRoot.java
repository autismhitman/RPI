package spotify.pojo;

import java.util.Map;

public class ErrorRoot {
	
	private Error error;
	
	public ErrorRoot() {
		super();
	}

	public ErrorRoot(Error error) {
		super();
		this.error = error;
	}

	public Error getError() {
		return error;
	}

	public ErrorRoot setError(Error error) {
		this.error = error;
		return this;
	}

	 
	
	

}
