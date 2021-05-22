package kodlamaio.northwind.core.utilities.results;

public class DataResult<T> extends Result {
//We made generic bcs we has numeric data types.
	
	private T data;
	public DataResult(T data,boolean success, String message) {
		super(success, message); //Super, run constructors of base class.
		this.data=data;
	}
	
	public DataResult(T data,boolean success) {
		super(success); 
		this.data=data;
	}
	
	public T getData() {
		return this.data;
	}
}
