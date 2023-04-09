package alphagrep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CompareResults class compares the actual response with expected response.
 * 
 * @author Gopal Krushna Nayak
 * 
 */
public class CompareResults {

	/**
	 * This method reads the expected response from a golden source copy. Compares
	 * the response received against the responses in the golden source copy. Writes
	 * the mismatch string into a File.
	 * 
	 * @param request        A string containing the original request.
	 * @param actualResponse A List<String> containing the actual responses.
	 * @return No return value.
	 */
	public static void compareResults(String request, List<String> actualResponse) {
		/*
		 * Find the OrderId form the request, so that we can filter out only the
		 * relevant responses from the golden copy source. Assumption here is that the
		 * orderId is unique for every request. Also assuming that pattern of the
		 * request is fixed.
		 * Here I'm writing both the string to the output file. However we can extract
		 * the exact mismatch and write them into a file. This can easily be implemented.
		 */
		String orderId = "";
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(request);
		if (matcher.find()) {
			orderId = matcher.group(0);
		}
		// Read the responses from the golden copy source, say a file.
		List<String> expectedResponse = readFromGoldenSource(orderId);

		Map<String, String> expectedResponseMap = getMap(expectedResponse);
		Map<String, String> actualResponseMap = getMap(actualResponse);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.OUTPUT_FILE, true));
			for (String key : expectedResponseMap.keySet()) {
				if (!expectedResponseMap.get(key).equals(actualResponseMap.get(key))) {
					writer.write("Expected response:: " + expectedResponseMap.get(key));
					writer.newLine();
					writer.write("Actual response:: " + actualResponseMap.get(key));
					writer.newLine();
				}
			}
			writer.flush();
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This method reads the input string. Splits it. Forms a map where key is
	 * "ResponsType:OrderID:ErrorCode" value is the input string
	 * 
	 * @param strings A List<String> containing the responses.
	 * @return Map<String, String> A map where key is ResponsType:OrderID:ErrorCode
	 *         and value is the input string
	 */
	private static Map<String, String> getMap(List<String> strings) {
		Map<String, String> map = new HashMap<>();
		for (String str : strings) {
			String[] tokens = str.split("\\|");
			String key = "";
			String responseType = "";
			String orderID = "";
			String errorCode = "";

			for (String token : tokens) {
				String[] fields = token.split(":");
				if (fields[0].equals("ResponseType"))
					responseType = fields[1];
				if (fields[0].equals("OrderID"))
					orderID = fields[1];
				if (fields[0].equals("ErrorCode"))
					errorCode = fields[1];
			}
			key = responseType + ":" + orderID + ":" + errorCode;
			map.put(key, str);
		}
		return map;
	}

	/**
	 * This method reads the golden source file. Returns expected responses.
	 * 
	 * @param orderId A string containing the orderId.
	 * @return List<String> A list of string containing all the responses from
	 *         Golden copy source.
	 */
	private static List<String> readFromGoldenSource(String orderId) {
		List<String> lines = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(Constants.EXPECTED_RESPONSE_FILE));
			String str;
			while ((str = br.readLine()) != null) {
				if (str.contains(orderId)) {
					lines.add(str);
				}
			}
			br.close();
		} catch (IOException ex) {

		}
		return lines;
	}
}
