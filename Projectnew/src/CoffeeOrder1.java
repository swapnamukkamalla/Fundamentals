/**************************************************************************
 * Project 3 for IT501 													  *	
 * Ordering System 														  *
 * Programmer: Group2 
 * Last modified:May 4, 2019
 * Purpose: Constructor method for all the variables,get and set methods,* 
 * 			are written in this class *
 **************************************************************************/
public class CoffeeOrder1 {

	int cafeName;

	int flaName;

	double price;

	String customerName;

	String time;

//Constructor with parameters to initialize the values
	public CoffeeOrder1(int cafeName, int flaName, double price, String customerName, String time) {

		super();

		this.cafeName = cafeName;

		this.flaName = flaName;

		this.price = price;

		this.customerName = customerName;

		this.time = time;

	}

//Get method for CoffeeName 
	public int getCoffeeName() {

		return cafeName;

	}

//set method for coffeename
	public void setCoffeeName(int coffeeName) {

		this.cafeName = coffeeName;

	}

//get method for flavourname variable
	public int getFlaName() {

		return flaName;

	}

//set method for flavourname variable
	public void setFlaName(int flaName) {

		this.flaName = flaName;

	}

//get method for price 
	public double getPrice() {

		return price;

	}

//set method for price variable
	public void setPrice(double price) {

		this.price = price;

	}

//get method for customer name field
	public String getCustomerName() {

		return customerName;

	}

//set method for customer name data field
	public void setCustomerName(String customerName) {

		this.customerName = customerName;

	}

//get method for time 
	public String getTime() {

		return time;

	}

//set method for time
	public void setTime(String time) {

		this.time = time;

	}
}