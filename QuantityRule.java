package alphagrep;

import java.util.ArrayList;
import java.util.List;

/**
 * QuantityRule class extends BaseRule class. It contains all the rules related
 * to the quantity fields.
 * 
 * @author Gopal Krushna Nayak
 * 
 */
public class QuantityRule extends BaseRule {

	public QuantityRule(Order order) {
		super(order);
	}

	/**
	 * This method contains all the quantity related checks. Assumption here is, the
	 * method returns a success response if all the checks pass. Returns an error
	 * response if one of the check fails. If one of the check fails, it ignores the
	 * rest of the checks.
	 * 
	 * @param No parameter.
	 * @return List<Response> A list of Response object
	 */
	@Override
	public List<Response> executeRule() {

		// Reads the max price from an utility class.
		int maxQuantity = Utility.getMaxQuantity(order.getSymbol());
		List<String> list = new ArrayList<>();

		/*
		 * Here for every check, I have assigned a different error code.
		 * I am assuming that the exchange will send different error code for each check.
		 * For price related checks say the error code starts with 201.
		 * Here error codes are hard coded. Nut you can read these info from a constant file.
		 */
		// Negative quantity check
		if (order.getQuantity() <= 0) {
			this.order.setResponseType("REJECT");
			this.order.setErrorCode("301");
			this.order.setResponseTimeStamp(String.valueOf(System.currentTimeMillis()));
			return this.getErrorResponse();
		}
		// Max quantity check
		if (order.getQuantity() > maxQuantity) {
			this.order.setResponseType("REJECT");
			this.order.setErrorCode("302");
			this.order.setResponseTimeStamp(String.valueOf(System.currentTimeMillis()));
			return this.getErrorResponse();
		}
		//if all the check passes, then return the success response
		this.order.setResponseTimeStamp(String.valueOf(System.currentTimeMillis()));
		list.add(Constants.NEW_ORDER_CONFIRM);
		return this.getSuccessResponse(list);
	}
}
