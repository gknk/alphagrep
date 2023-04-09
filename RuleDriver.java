package alphagrep;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the entry point of this project.
 * 
 * @author Gopal Krushna Nayak
 * 
 */
public class RuleDriver {

	/**
	 * Calls the getOrders() method present in the Parser class to parse the input
	 * string. Creates the object of RuleManager class. Calls the executeRules()
	 * methods present in the RuleManager class. Collects the possible responses for
	 * the input order. Calls the compareResults() method present in the
	 * CompareResults class to compare the expected and actual responses.
	 * 
	 */
	public static void main(String[] args) {
		List<Order> orders = Parser.getOrders(Constants.INPUT_FILE);
		for (Order order : orders) {
			String request = order.toString();
			List<String> responses = new ArrayList<>();
			RuleManager ruleManager = new RuleManager(order);
			responses = ruleManager.executeRules();
			CompareResults.compareResults(request, responses);
		}
	}
}
