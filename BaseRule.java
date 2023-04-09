package alphagrep;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseRule class is an Abstract class which represents how a rule should be
 * defined
 * 
 * @author Gopal Krushna Nayak
 * 
 */
public abstract class BaseRule {
	protected Order order;

	public BaseRule(Order order) {
		this.order = order;
	}

	/**
	 * This method will be implemented by all the derived class of BaseRule class.
	 * This will return the list of possible responses for an order.
	 * 
	 * @param No parameter.
	 * @return List<Response> A list of Response objects
	 */
	public abstract List<Response> executeRule();

	/**
	 * This method returns a list of success responses based on the success
	 * messages. Iterates through all the success messages. It creates a Response
	 * object for each message and based on success message, it populate's the
	 * Response Object attributes. Finally adds all the Response object in a list
	 * and returns the list.
	 * 
	 * @param successMsgs A List<String> containing all the success messages.
	 * @return List<Response> A list of Response objects
	 */
	protected List<Response> getSuccessResponse(List<String> successMsgs) {
		List<Response> responses = new ArrayList<>();

		for (String successmsg : successMsgs) {
			if (successmsg.equals("NEW_ORDER_CONFIRM")) {
				order.setResponseType("NEW_ORDER_CONFIRM");
				order.setExchangeOrderId("13007294");
			} else {
				order.setResponseType("TRADE_CONFIRM");
				order.setExchangeOrderId("13007306");
			}
			Response response = new Response();
			response.setResponseType(order.getResponseType());
			response.setOrderId(order.getOrderId());
			response.setSymbol(order.getSymbol());
			response.setSide(order.getSide());
			response.setPrice(order.getPrice());
			response.setQuantity(order.getQuantity());
			response.setAccountId(order.getAccount());
			// Setting error code to 1 as it is a success message.
			response.setErrorCode("1");
			response.setResponseTimeStamp(order.getResponseTimeStamp());
			response.setExchangeOrderId(order.getExchangeOrderId());
			// Setting default child response type to "NULL_RESPONSE_MIDDLE". We can set it
			// to something else.
			response.setChildResponseType("NULL_RESPONSE_MIDDLE");
			response.setDuration(order.getDuration());
			response.setExchangeTimeStamp(order.getResponseTimeStamp());
			responses.add(response);
		}
		return responses;
	}

	/**
	 * This method returns a single error response. It creates a Response object.
	 * Populate's the Response Object attributes. Finally adds the Response object
	 * in a list and returns the list.
	 * 
	 * @param No parameter.
	 * @return List<Response> A list of Response objects
	 */
	protected List<Response> getErrorResponse() {
		List<Response> responses = new ArrayList<>();
		Response response = new Response();
		response.setResponseType(order.getResponseType());
		response.setOrderId(order.getOrderId());
		response.setSymbol(order.getSymbol());
		response.setSide(order.getSide());
		response.setPrice(order.getPrice());
		response.setQuantity(order.getQuantity());
		response.setAccountId(order.getAccount());
		response.setErrorCode(order.getErrorCode());
		response.setResponseTimeStamp(order.getResponseTimeStamp());
		response.setExchangeOrderId("0");
		response.setChildResponseType("CANCEL_ORDER_REJECT_MIDDLE");
		response.setDuration(order.getDuration());
		response.setExchangeTimeStamp("0");
		responses.add(response);
		return responses;
	}
}
