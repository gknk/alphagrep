package alphagrep;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class contains some utility methods.
 * 
 * @author Gopal Krushna Nayak
 * 
 */
public class Utility {

	/**
	 * This method returns maximum quantity a security can be traded. We are
	 * fetching this information from a predefined map. Here the filter is based on
	 * the symbol of the security.
	 * 
	 * @param symbol A string containing the symbol.
	 * @return Integer A int containing the maximum quantity for the respective
	 *         symbol.
	 */
	public static int getMaxQuantity(String symbol) {
		return getSymbolQuantityMap().get(symbol);
	}

	/**
	 * This method returns a predefined map contains symbol as key and maximum
	 * quantity as values.
	 * 
	 * @param No parameter.
	 * @return Map<Integer, Integer> A map containing symbol and it's maximum
	 *         quantity.
	 */
	private static Map<String, Integer> getSymbolQuantityMap() {
		Map<String, Integer> maxPrice = new HashMap<>();
		maxPrice.put("xyz", 1000);
		maxPrice.put("ABC_XYZ!", 1500);
		maxPrice.put("def", 2000);
		maxPrice.put("klm", 2500);
		maxPrice.put("IFEU_BRNFMZ0022!", 1500);
		return maxPrice;
	}

	/**
	 * This method returns maximum price a security can be traded. We are fetching
	 * this information from a predefined map. Here the filter is based on the
	 * symbol of the security.
	 * 
	 * @param symbol A string containing the symbol.
	 * @return Double A double containing the maximum price for the respective
	 *         symbol.
	 */
	public static double getMaxPrice(String symbol) {
		return getSymbolPriceMap().get(symbol);
	}

	/**
	 * This method returns a predefined map contains symbol as key and maximum price
	 * as values.
	 * 
	 * @param No parameter.
	 * @return Map<Integer, Integer> A map containing symbol and it's maximum price.
	 */
	private static Map<String, Double> getSymbolPriceMap() {
		Map<String, Double> maxPrice = new HashMap<>();
		maxPrice.put("xyz", 158.0);
		maxPrice.put("ABC_XYZ!", 158.0);
		maxPrice.put("def", 158.0);
		maxPrice.put("klm", 158.0);
		maxPrice.put("IFEU_BRNFMZ0022!", 250.0);
		return maxPrice;
	}
}
