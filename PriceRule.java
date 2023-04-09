package alphagrep;

import java.util.ArrayList;
import java.util.List;

/**
 * PriceRule class extends BaseRule class. It contains all the rules related to
 * the price fields.
 * 
 * @author Gopal Krushna Nayak
 * 
 */
public class PriceRule extends BaseRule {

	public PriceRule(Order order) {
		super(order);
	}

	/**
	 * This method contains all the price related checks. Assumption here is, the
	 * method returns a success response if all the checks pass. Returns an error
	 * response if one of the check fails. If one of the check fails, it ignores the
	 * rest of the checks.
	 * 
	 * @param No parameter.
	 * @return List<Response> A list of Response object
	 */
	@Override
	public List<Response> executeRule() {

		//Reads the max price from an utility class.
		double maxPrice = Utility.getMaxPrice(order.getSymbol());
		List<String> list = new ArrayList<>();
		
		/*
		 * Here for every check, I have assigned a different error code.
		 * I am assuming that the exchange will send different error code for each check.
		 * For price related checks say the error code starts with 201.
		 * Here error codes are hard coded. Nut you can read these info from a constant file.
		 */
		// Negative price check
		if (order.getPrice() < 0) {
			this.order.setResponseType("REJECT");
			this.order.setErrorCode("201");
			this.order.setResponseTimeStamp(String.valueOf(System.currentTimeMillis()));
			return this.getErrorResponse();
		}
		// If price is greater than x(say here max price) for symbol xyz then reject
		if (order.getSymbol().equals("xyz") && order.getPrice() > maxPrice) {
			this.order.setResponseType("REJECT");
			this.order.setErrorCode("202");
			this.order.setResponseTimeStamp(String.valueOf(System.currentTimeMillis()));
			return this.getErrorResponse();
		}
		// If price is 123 then generate reject
		if (order.getPrice() > 123) {
			this.order.setResponseType("REJECT");
			this.order.setErrorCode("203");
			this.order.setResponseTimeStamp(String.valueOf(System.currentTimeMillis()));
			return this.getErrorResponse();
		}
		//if all the check passes, then return the success response
		this.order.setResponseTimeStamp(String.valueOf(System.currentTimeMillis()));
		list.add(Constants.NEW_ORDER_CONFIRM);
		return this.getSuccessResponse(list);
	}
}