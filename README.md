# My Solution


## Task 1
### Files
| File | Description |  
| --- | --- |  
| Application.java | Contains the main class to run the Spring Boot application.|
| Quote.java | Model used to encapsulate data from the request and for the response. |
| QuoteController.java | The Controller layer.  Receives the request body for "/quote" and instantiates a Quote object from it. Uses Service layer to calculate price and responds to client using Quote model.|
| PriceCalculator.java | The Service layer. Singleton class that uses a provided Quote object to calculate the basic price from pickup and delivery postcode, and a price with markup depending on delivery vehicle if one exists. |

### Tests
The test cases I have added simply check that the correct price is returned when a particular vehicle is involved in the request.

### Future Developments
To meet the requirements of the task, the expected markup for each vehicle was hardcoded into PriceCalculator.java. As the app grows, this data should be retrieved from carrier_data.json when the delivery time, company and vehicle availability are incorporated into the calculation and logic.  

Following this, I would make Vehicle an abstract class and define each vehicle type as a child of it. Then when instantiating a Quote object in the request, I would instantiate an appropriate vehicle object from a singleton factory class and make it an attribute to further encapsulate the details and calculation of the quote.



## Task 2
index.html can be found at src/client/view
  
Keeping in mind the time guidline, my interface consists of a simple form with two text fields to input the postcodes, and a drop-down menu to select from a choice of delivery vehicles.  The result label will automatically update as the user updates their input. There is a button to manually check the delivery price, however its main function is to highlight where the user has entered invalid input.

**Please note** that I display the price from the response without any formatting as it was not specified to do so. A real solution would likely display it as a float to 2 decimal places, as expected for a price. The result label will display "error" if there is an issue with the API.

### Future Developments
The main future development would be how I structure the JavaScript for maintainability as the app grew. I would try and follow the MVVM pattern and have code that updates the view in one file and POST request logic in some data service singleton class with a view model to communicate and prepare raw data between them.



# Dependencies
This project can be run with Java 11 and Gradle 7.0  
