package alphagrep;

import java.util.ArrayList;
import java.util.List;

/**
 * SymbolRule class extends BaseRule class. It contains all the rules related to
 * the symbol fields.
 * 
 * @author Gopal Krushna Nayak
 * 
 */
public class SymbolRule extends BaseRule {

	/*
	 * Constructor of the class
	 */
	public SymbolRule(Order order) {
		super(order);
	}

	/**
	 * This method contains all the symbol related checks. Assumption here is, the
	 * method returns a success response if all the checks pass. Returns an error
	 * response if one of the check fails. If one of the check fails, it ignores the
	 * rest of the checks.
	 * 
	 * @param No parameter.
	 * @return List<Response> A list of Response objects
	 */
	@Override
	public List<Response> executeRule() {
		List<Response> list = new ArrayList<>();
		// If the symbol is xyz then generate new_order_confirm and trade_confirm
		if (order.getSymbol().equals("IFEU_BRNFMZ0022!")) {
			List<String> successMsgs = new ArrayList<>();
			successMsgs.add(Constants.NEW_ORDER_CONFIRM);
			successMsgs.add(Constants.TRADE_CONFIRM);
			this.order.setResponseTimeStamp(String.valueOf(System.currentTimeMillis()));
			return this.getSuccessResponse(successMsgs);
		}
		return list;
	}
}
