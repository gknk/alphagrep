package alphagrep;

/**
 * Order class represents the properties of an Order object. It has setter
 * methods to populate the Order fields. Also has getter methods to get the
 * properties of an Order object
 * 
 * @author Gopal Krushna Nayak
 * 
 */
public class Order {
	private String orderId;
	private String requestType;
	private String responseType;
	private String token;
	private String symbol;
	private String side;
	private double price;
	private int quantity;
	private int quantityFilled;
	private int disclosedQuantity;
	private String timeStamp;
	private String duration;
	private String orderType;
	private String account;
	private int exchangeId;
	private int numCopies;
	private String responseTimeStamp;
	private String exchangeOrderId;
	private String childResponseType;
	private String exchTimeStamp;
	private String errorCode;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantityFilled() {
		return quantityFilled;
	}

	public void setQuantityFilled(int quantityFilled) {
		this.quantityFilled = quantityFilled;
	}

	public int getDisclosedQuantity() {
		return disclosedQuantity;
	}

	public void setDisclosedQuantity(int disclosedQuantity) {
		this.disclosedQuantity = disclosedQuantity;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(int exchangeId) {
		this.exchangeId = exchangeId;
	}

	public int getNumCopies() {
		return numCopies;
	}

	public void setNumCopies(int numCopies) {
		this.numCopies = numCopies;
	}

	public String getResponseTimeStamp() {
		return responseTimeStamp;
	}

	public void setResponseTimeStamp(String responseTimeStamp) {
		this.responseTimeStamp = responseTimeStamp;
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

	public String getExchTimeStamp() {
		return exchTimeStamp;
	}

	public void setExchTimeStamp(String exchTimeStamp) {
		this.exchTimeStamp = exchTimeStamp;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Overrides toString() method to returns a order string.
	 * 
	 * @param No parameter.
	 * @return String Containing the order string.
	 */
	@Override
	public String toString() {
		String orderString = "RequestType:%s|OrderID:%s|Token:%s|Symbol:%s|Side:%s|Price:%s|Quantity:%s|QuantityFilled:%s|DisclosedQnty:%s|TimeStamp:%s|Duration:%s|OrderType:%s|Account:%s|Exchange:%s|NumCopies:%s";
		String order = String.format(orderString, this.getRequestType(), this.getOrderId(), this.getToken(),
				this.getSymbol(), this.getSide(), this.getPrice(), this.getQuantity(), this.getQuantityFilled(),
				this.getDisclosedQuantity(), this.getTimeStamp(), this.getDuration(), this.getOrderType(),
				this.getAccount(), this.getExchangeId(), this.getNumCopies());
		return order;
	}
}