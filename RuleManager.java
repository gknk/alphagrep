package alphagrep;

import java.util.ArrayList;
import java.util.List;

/**
 * RuleManager consolidates all the rules. Collects the responses. Returns the
 * responses as a list of string
 * 
 * @author Gopal Krushna Nayak
 * 
 */
public class RuleManager {
	Order order;

	public RuleManager(Order order) {
		this.order = order;
	}

	/**
	 * This method consolidate all the rules mentioned the derived class. Returns a
	 * list of rules.
	 * 
	 * @param No parameter.
	 * @return List<BaseRule> A list of Rule objects
	 */
	private List<BaseRule> getRules() {
		List<BaseRule> list = new ArrayList<>();
		list.add(new PriceRule(order));
		list.add(new QuantityRule(order));
		list.add(new SymbolRule(order));
		// Keep on adding all the derived rule classes
		return list;
	}

	/**
	 * This method iterates through all the rules. Execute the rules. Gets the
	 * Response object. Generates the response string. Adds the response string to a
	 * list and finally returns the list.
	 * 
	 * @param No parameter.
	 * @return List<String> A list of string containing the response messages
	 */
	public List<String> executeRules() {
		List<String> responseString = new ArrayList<>();
		List<BaseRule> rules = getRules();
		List<Response> responses = new ArrayList<Response>();
		for (BaseRule rule : rules) {
			responses.addAll(rule.executeRule());
		}
		for (Response response : responses) {
			responseString.add(response.toString());
		}
		return responseString;
	}
}
