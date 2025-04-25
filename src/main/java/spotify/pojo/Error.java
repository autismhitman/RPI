package spotify.pojo;

public class Error {
	
	
	private int status;
	private String message;
	
	
	public Error() {
		super();
	}


	public Error(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}


	public int getStatus() {
		return status;
	}


	public Error setStatus(int status) {
		this.status = status;
		return this;
	}


	public String getMessage() {
		return message;
	}


	public Error setMessage(String message) {
		this.message = message;
		return this;
	}
	
	

}
