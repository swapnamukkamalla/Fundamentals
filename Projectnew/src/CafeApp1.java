
/************************************************************************ 
*  Project 3 for IT501 													*
*  Ordering System														*
*  Programmer: Group2													*
*  Last modified: May 4, 2019											*
*  Purpose: This program allows customers to place orders in a cafe,	*
*           limited menu selection available that includes coffees 	    *
*           and flavors. Customers select the their choices from the    *
*           list of available items.This program displays the price     * 
*           for the selected options,Asks for customer names and 		*
*           displays the receipt with selected items and total price.	*
*           It also adds the Receipt details to a file named Receipt.txt*
*************************************************************************/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CafeApp1 {

	public static void main(String[] args) throws IOException {
		int cafeItem = 0;
		int flaNum = 0;
		String chosen = "n";

		do {

			CoffeeOrder1 cafe1 = new CoffeeOrder1(0, 0, 0, null, null);

			double cafePrice = 0.0;

			double flaPrice = 0.0;
			int flag = 0;
//for customer input
			Scanner input = new Scanner(System.in);
			showCafe();

			do {
				flag = 0;
				String line = input.nextLine();
				int digit;
				String one = "1";
//validating the input from the customer
				if (line.equals("1") || line.equals("2") || line.equals("3") || line.equals("4") || line.equals("5")
						|| line.equals("6")) {
					digit = Integer.parseInt(line);
					cafeItem = digit;
				} else {
					System.out.println("Error! You need to enter a number between 1 and 6!");
					flag = 1;
				}
			} while (flag == 1);

			cafe1.setCoffeeName(cafeItem);

			cafe1.getCoffeeName();

			switch (cafeItem) {

			case 1:

				System.out.println("1.     Iced Coffee	 Single     $3.00");

				cafePrice = 3.00;

				break;

			case 2:

				System.out.println("2.     Iced Coffee	 Double     $3.50");

				cafePrice = 3.50;

				break;

			case 3:

				System.out.println("3.     Cappuccino	 Single     $3.50");

				cafePrice = 3.50;

				break;

			case 4:

				System.out.println("4.     Cappuccino	 Double     $4.00");

				cafePrice = 4.00;

				break;

			case 5:

				System.out.println("5.     Latte	         Single     $3.50");

				cafePrice = 3.50;

				break;

			case 6:

				System.out.println("6.     Latte	         Double     $4.00");

				cafePrice = 4.00;

				break;

			}
//Calling methods to display the customer all the flavors available and their price
			showFla();

			do {
				flag = 0;
				String line = input.nextLine();
				int digit;
				if (line.equals("1") || line.equals("2") || line.equals("3") || line.equals("4") || line.equals("5")
						|| line.equals("6") || line.equals("7")) {
					digit = Integer.parseInt(line);
					flaNum = digit;
				} else {
					System.out.println("Error! You need to enter a number between 1 and 6!");
					flag = 1;
				}
			} while (flag == 1);

			cafe1.setFlaName(flaNum);

			cafe1.getFlaName();

			ArrayList<Integer> flaArrayList = new ArrayList<Integer>();

			while ((flaNum > 7) || (flaNum < 1)) {

				System.out.println("Error! You need to enter a number between 1 and 7!");

				flaNum = input.nextInt();

			}

			while (flaNum > 0 && flaNum < 7) {

				switch (flaNum) {

				case 1:

					System.out.println("1.     Cream     $0.0");

					System.out.println("Please select other flavors, enter 7, Complete selection");

					flaNum = validateInput();

					// flaNum = input.nextInt();

					flaArrayList.add(1);

					flaPrice += 0.0;

					break;

				case 2:

					System.out.println("2.     Sugar     $0.0");

					System.out.println("Please select other flavors, enter 7, Complete selection");
					flaNum = validateInput();

					// flaNum = input.nextInt();

					flaArrayList.add(2);

					flaPrice += 0.0;

					break;

				case 3:

					System.out.println("3.     Almond    $0.50");

					System.out.println("Please select other flavors, enter 7, Complete selection");

					flaNum = validateInput();

					// flaNum = input.nextInt();

					flaArrayList.add(3);

					flaPrice += 0.50;

					break;

				case 4:

					System.out.println("4.     Banana    $0.50");

					System.out.println("Please select other flavors, enter 7, Complete selection");
					flaNum = validateInput();

					// flaNum = input.nextInt();

					flaArrayList.add(4);

					flaPrice += 0.50;

					break;

				case 5:

					System.out.println("5.     Cinnamon  $1.00");

					System.out.println("Please select other flavors, enter 7, Complete selection");
					flaNum = validateInput();
					// flaNum = input.nextInt();

					flaArrayList.add(5);

					flaPrice += 1.00;

					break;

				case 6:

					System.out.println("6.     Cherry    $1.50");

					System.out.print("Please select other flavors, enter 7, Complete selection");
					flaNum = validateInput();
					// flaNum = input.nextInt();

					flaArrayList.add(6);

					flaPrice += 1.50;

					break;

				}

			}

			System.out.println(flaArrayList);

			double total = cafePrice + flaPrice;

			cafe1.setPrice(total);

			cafe1.getPrice();

			if (flaNum == 7) {

				System.out.println("Thanks for your selection!");

			}

			System.out.println("Please enter your name: ");

			String inputName = input.next();

			cafe1.setCustomerName(inputName);

			cafe1.getCustomerName();

			Date now = new Date();

			DateFormat defaultDate = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);

			String time = defaultDate.format(now);
//To set the current time 
			cafe1.setTime(time);
//To get the current time 
			cafe1.getTime();

//Calling method showReceipt to display the order
			String c = showReceipt(time, inputName, cafeItem, cafePrice);
			
//Calling method diansha to get all the flavor names selected by the customer
			String s = diansha(flaArrayList);

			System.out.println("The total flavor price is " + "$" + flaPrice);

			System.out.println("Subtotal is " + "$" + total);

			String fileContent = time + "  Customer Name: " + inputName + " " + c + " " + s + " $" + total;
			
//Calling the ReceiptTOFile method to write to Receipt.txt by passing the file content
			ReceiptToFile(fileContent);
			
//Asking customers if they want to  continue order 
			System.out.print("Continue to order more? (y/n) ");

			Scanner inputChose = new Scanner(System.in);

			String chose = input.next();

			chosen = chose;

		} while (chosen.equals("y"));
//If the customer is done with the order 
		System.out.println("Thanks for using this system!");

	}

//To display the available Coffee types  and their prices to the Customer for selection
	public static void showCafe() {

		System.out.println("=== Select Coffee ===");

		System.out.println("1.     Iced Coffee	 Single     $3.00");

		System.out.println("2.     Iced Coffee	 Double     $3.50");

		System.out.println("3.     Cappuccino	 Single     $3.50");

		System.out.println("4.     Cappuccino	 Double     $4.00");

		System.out.println("5.     Latte	         Single     $3.50");

		System.out.println("6.     Latte	         Double     $4.00");

		System.out.print("Select Coffee [1-6]: ");

	}

//To display the available flavors and their prices to the Customer for selection
	public static void showFla() {

		System.out.println("=== Select Additional: ===");

		System.out.println("1.     Cream     $0.0");

		System.out.println("2.     Sugar     $0.0");

		System.out.println("3.     Almond    $0.50");

		System.out.println("4.     Banana    $0.50");

		System.out.println("5.     Cinnamon  $1.00");

		System.out.println("6.     Cherry    $1.50");

		System.out.println("7.     No More flavors!");

		System.out.print("Select Flavor [1-7]: ");

	}

//To display the Receipt after the customer selection with all the selected items and prices
	public static String showReceipt(String time, String customerName, int cafeName, double price) {

		System.out.println(time);

		System.out.println(customerName);

		String c = outputCafeName(cafeName);

		System.out.println("$" + price);

		return c;

	}

//To output the coffee selected by the customer
	public static String outputCafeName(int a) {

		String Coffeename = " ";

		switch (a) {

		case 1:

			System.out.println("Iced Coffee	 Single");

			Coffeename = Coffeename + "Iced Coffee	 Single";

			break;

		case 2:

			System.out.println("Iced Coffee	 double");

			Coffeename = Coffeename + "Iced Coffee	 double";
			break;

		case 3:

			System.out.println("Cappuccino	 Single");

			Coffeename = Coffeename + "Cappuccino	 Single";

			break;

		case 4:

			System.out.println("Cappuccino	 double");

			Coffeename = Coffeename + "Cappuccino	 double";
			break;

		case 5:

			System.out.println("Latte	         Single");

			Coffeename = Coffeename + "Latte        Single";
			break;

		case 6:

			System.out.println("Latte	         double");

			Coffeename = Coffeename + "Latte      double";
			break;

		default:

			System.out.println("Invalid number");

			break;

		}
		return Coffeename;

	}

	
//To display the flavor names on the console output 
	public static void outputFlaName(int a) {

		switch (a) {

		case 1:

			System.out.println("Cream");

			break;

		case 2:

			System.out.println("Sugar");

			break;

		case 3:

			System.out.println("Almond");

			break;

		case 4:

			System.out.println("Banana");

			break;

		case 5:

			System.out.println("Cinnamon");

			break;

		case 6:

			System.out.println("Cherry");

			break;

		default:

			System.out.println("Invalid number");

			break;

		}

	}

	public static String chose(String a) {

		return a;

	}

	// To get all the flavor names selected by the Customer while placing the order
	public static String diansha(ArrayList<Integer> ArrayList) {

		String Flavours = " ";
		for (Integer integer : ArrayList) {

			if (integer == 1) {

				System.out.println("Cream");
				Flavours = Flavours + "Cream ";

			} else if (integer == 2) {

				System.out.println("Sugar");
				Flavours = Flavours + "Sugar ";

			} else if (integer == 3) {

				System.out.println("Almond");
				Flavours = Flavours + "Almond ";

			} else if (integer == 4) {

				System.out.println("Banana");
				Flavours = Flavours + "Banana ";

			} else if (integer == 5) {

				System.out.println("Cinnamon");
				Flavours = Flavours + "Cinnamon ";

			} else {

				System.out.println("Cherry");
				Flavours = Flavours + "Cherry ";

			}

		}
		return Flavours;

	}

//This method writes the Receipt data into the file Receipt.txt 
//if it is for the first time and later on appends the records to the same file
	public static void ReceiptToFile(String filecontent) throws IOException {
		String content = filecontent;
		File log = new File("Receipt.txt");
		try {
			if (log.exists() == false) {
				log.createNewFile();
			}
			PrintWriter out = new PrintWriter(new FileWriter(log, true));
			out.append(content);
			out.println();

			out.close();
		} catch (IOException e) {

		}

	}

//To validate the input user data
	public static int validateInput() {
		Scanner input = new Scanner(System.in);
		int flaNum = 0;
		int flag = 0;
		do {
			flag = 0;
			String line = input.nextLine();
			int digit;
			String one = "1";

			if (line.equals("1") || line.equals("2") || line.equals("3") || line.equals("4") || line.equals("5")
					|| line.equals("6") || line.equals("7")) {
				digit = Integer.parseInt(line);
				flaNum = digit;
			} else {
				System.out.println(
						"Error! You need to enter a number between 1 and 6 to select flavours, 7 to complete selection");
				flag = 1;
			}
		} while (flag == 1);
		return flaNum;
	}
}