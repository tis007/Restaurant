package Cuisine;

@SuppressWarnings("serial")
public class OrderException extends Exception {

	public OrderException() {
	}

	public OrderException(String message) {
		super(message, new Throwable(), false, false);
	}

}
