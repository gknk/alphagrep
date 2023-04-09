package alphagrep;

/**
 * Response class represents the properties of a Response object. It has setter
 * methods to populate the Response fields. Also has getter methods to get the
 * properties of an Response object
 * 
 * @author Gopal Krushna Nayak *
 */
public class Response {
	private String responseType;
	private String orderId;
	private String symbol;
	private String side;
	private Double price;
	private int quantity;
	private String accountId;
	private String errorCode;
	private String responseTimeStamp;
	private String exchangeOrderId;
	private String childResponseType;
	private String duration;
	private String exchangeTimeStamp;

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getExchangeOrderId() {
		return exchangeOrderId;
	}

	public void setExchangeOrderId(String exchangeOrderId) {
		this.exchangeOrderId = exchangeOrderId;
	}

	public String getChildResponseType() {
		return childResponseType;
	}

	public void setChildResponseType(String childResponseType) {
		this.childResponseType = childResponseType;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getExchangeTimeStamp() {
		return exchangeTimeStamp;
	}

	public void setExchangeTimeStamp(String exchangeTimeStamp) {
		this.exchangeTimeStamp = exchangeTimeStamp;
	}

	public String getResponseTimeStamp() {
		return responseTimeStamp;
	}

	public void setResponseTimeStamp(String responseTimeStamp) {
		this.responseTimeStamp = responseTimeStamp;
	}

	/**
	 * Overrides toString() method to returns a response string the way we want to
	 * represent to the end users.
	 * 
	 * @param No parameter.
	 * @return String Containing the response message.
	 */
	@Override
	public String toString() {
		String responseString = "ResponseType:%s|OrderID:%s|Symbol:%s|Side:%s|Price:%s|Quantity:%s|AccountID:%s|ErrorCode:%s|responseTimeStamp:%s|Exchange_Order_Id:%s|ChildResponseType:%s|Duration:%s|exchTS:%s";
		String response = String.format(responseString, this.responseType, this.orderId, this.symbol, this.side,
				this.price, this.quantity, this.accountId, this.errorCode, this.responseTimeStamp, this.exchangeOrderId,
				this.childResponseType, this.duration, this.exchangeTimeStamp);
		return response;
	}
}
