# alphagrep

How to run the driver class
1) Craete a project in eclipse or any other IDE
2) Create a package named alphagrep
3) Copy all these files under alphagrep folder
4) Change the input file, output file and expected response file locations to run the program. I've attached the Input file, output file and ExpectedResponsefile for reference.
5) Right click and run as a "Java Application" on the driver class. Here the driver class is "RulesDriver.java"

## **Project Design**:

***Order class***: This class contains the details of an order. It has all the order attributes. 
It has getters and setters methods that get or set the order object attributes, respectively. 
Overrides the toString method to output the order string.

***Response class***: This class contains the details of a response. It has all the response attributes.
It has getters and setters methods that get or set the response object attributes, respectively.
Overrides the toString method to output the response string.

***Parser class***: An implementation of the parser. From the file, the order string is read one line (order) at a time.
Returns a list of Order objects after processing the order string and creating an Order object.
In this case, it is assumed that the format of the order will remain the same.

***BaseRule class***: This is the base class for all rule classes. It's an abstract class.
It has an abstract method. i.e. executeRule() which returns a list of response objects.
This method is overridden by all derived Rule classes. There are two concrete methods. getSuccessResponse() and getErrorResponse(). 
These methods create response objects and return a list of response objects.
These methods are called by child classes based on the success or failure of the response.

***Derived classes***: All derived rule classes [PriceRule, QuantityRule, SymbolRule].
Here we divided the rules into different classes based on their attributes.
All price related checks go into the PriceRule class. All quantity-related checks go into the QuantityRule class. etc
These classes implement an executeRule() method that calls getSuccessResponse() if the response is successful.
Or getErrorResponse() if the response failed.

***RuleManager class***: This class creates objects for all Rule classes. Iterate over all objects and run the rules.
Collect response objects from all Rule classes. It finally returns a list of response strings.   

***CompareResult class***: This class compares the actual response with the expected response and writes to a file if there is a difference. 

***Constants class***: Contains all constants required for this application. 

***Utility class***: Contains some helper methods required for this application. 

***RuleDriver class***: This is the entry point for this project. It has a main() method.
Below are the steps performed in the main method.
1) Call the getOrders() method available in the Parser class. This method reads the input order file and returns a list of Order objects.
2) Iterate through the list and call the executeRules() method. 
3) Collect the response string.
4) Call the CompareResults() method to compare the expected output with the actual output. 
