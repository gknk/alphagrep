package alphagrep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Parser class reads the orders from a file, process those and creates Order
 * objects
 * 
 * @author Gopal Krushna Nayak
 * 
 */
public class Parser {

	/**
	 * Reads the order string from the file, process the order string and returns a
	 * list of Order objects.
	 * 
	 * @param fileName A string containing the name of the file
	 * @return List<Order> A list of Order objects
	 */
	public static List<Order> getOrders(String fileName) {
		List<Order> orders = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				Order order = parseOrder(line);
				orders.add(order);
			}
			br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return orders;
	}

	/**
	 * Reads each order as a string. Splits the string with a delimeter ("|").
	 * Iterates through all the string tokens and splits the token with a delimeter
	 * (":). Populate all the fields of Order objects with the setter methods.
	 * 
	 * @param orderString A string containing the order string
	 * @return Order An Order object
	 */
	private static Order parseOrder(String orderString) {
		Order order = new Order();
		String[] tokens = orderString.split("\\|");
		for (String token : tokens) {
			String[] fields = token.split(":");
			switch (fields[0]) {
			case "RequestType":
				order.setRequestType(fields[1]);
				break;
			case "OrderID":
				order.setOrderId(fields[1]);
				break;
			case "Token":
				order.setToken(fields[1]);
				break;
			case "Symbol":
				order.setSymbol(fields[1]);
				break;
			case "Side":
				order.setSide(fields[1]);
				break;
			case "Price":
				order.setPrice(Double.parseDouble(fields[1]));
				break;
			case "Quantity":
				order.setQuantity(Integer.parseInt(fields[1]));
				break;
			case "QuantityFilled":
				order.setQuantityFilled(Integer.parseInt(fields[1]));
				break;
			case "DisclosedQnty":
				order.setDisclosedQuantity(Integer.parseInt(fields[1]));
				break;
			case "TimeStamp:":
				order.setTimeStamp(fields[1]);
				break;
			case "Duration":
				order.setDuration(fields[1]);
				break;
			case "OrderType":
				order.setOrderType(fields[1]);
				break;
			case "Account":
				order.setAccount(fields[1]);
				break;
			case "Exchange":
				order.setExchangeId(Integer.parseInt(fields[1]));
				break;
			case "NumCopies":
				order.setNumCopies(Integer.parseInt(fields[1]));
				break;
			default:
				// Throw some custom Exception or you may ignore this field
			}
		}
		return order;
	}
}