package kodlamaio.northwind.core.utilities.results;

public class Result { //Super type, like abstract. can be nude.
	private boolean success;
	private String message;

	//CONSTRUCTORS
	public Result(boolean success) {
		this.success = success;
	}

	public Result(boolean success, String message) {
		this(success); //We call single parameters constroctur For dont repeat myself.
		this.message = message;
	}
	
	//GETTERS
	public boolean isSuccess() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}
}
