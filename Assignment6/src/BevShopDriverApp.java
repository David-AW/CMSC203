import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: 1000-1140 Morning Class
 * Due: 12/15/2024
 * Platform/compiler: Ubuntu Linux / JDK 21
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: David Wery
*/

public class BevShopDriverApp {

	private static String[] coffee_names = { "Coffee", "Latte", "Caffe Mocha", "Cappuccino", "Americano" };
	private static String[] smoothie_names = { "Dee Bliss", "Energy Boost", "Sunshine", "Tropical Twist", "Start Up" };
	private static String[] alcohol_names = { "Old Fashioned", "Guinness", "Martini", "Margarita", "Moscow Mule" };
	private static boolean using_test_file = false;

	public static void main(String[] args) {

		BevShop davids_cafe = new BevShop();
		Random random = new Random();

		Scanner scanner = new Scanner(System.in);
		if (askYesOrNo(scanner, "Do you want to load the test file?")) {
			try {
				scanner = new Scanner(new File("test_driver.txt"));
				using_test_file = true;
			} catch (FileNotFoundException e) {
				System.out.println("File wasnt found.");
				System.exit(0);
			}
		}
		boolean ask_for_order = true;
		while (ask_for_order) {

			String name = askForStringResponse(scanner, "What is the customer's name?");
			int age = askForIntegerResponse(scanner, "How old is the customer?");

			davids_cafe.startNewOrder(random.nextInt(8, 24), Day.values()[random.nextInt(0, 7)], name, age);
			if (age >= davids_cafe.getMinAgeForAlcohol())
				System.out.println("The customer's age is above " + davids_cafe.getMinAgeForAlcohol()
						+ " and is eligible to order alcohol");

			System.out.println("Today is " + davids_cafe.getCurrentOrder().getOrderDay() + " at "
					+ davids_cafe.getCurrentOrder().getOrderTime() + ":00");

			Type type = askTypeOfBeverage(scanner);

			while (type != null) {
				Size drink_size;

				if (type == Type.COFFEE) 
				{
					String drink_name = coffee_names[random.nextInt(0, coffee_names.length)];
					drink_size = askSizeOfBeverage(scanner);
					boolean extra_shot = askYesOrNo(scanner, "Do you want an extra shot of espresso?");
					boolean extra_syrup = askYesOrNo(scanner, "Do you want an extra pump of syrup?");

					davids_cafe.processCoffeeOrder(drink_name, drink_size, extra_shot, extra_syrup);
				} 
				else if (type == Type.SMOOTHIE) 
				{
					String drink_name = smoothie_names[random.nextInt(0, smoothie_names.length)];
					drink_size = askSizeOfBeverage(scanner);
					int num_of_fruit = askForIntegerResponse(scanner, "How many fruits do you want?");
					if (num_of_fruit <= davids_cafe.getMaxNumOfFruits()) {
						boolean add_protein = askYesOrNo(scanner, "Do you want to add protein powder?");
						davids_cafe.processSmoothieOrder(drink_name, drink_size, num_of_fruit, add_protein);
					} else {
						System.out.println("You reached the maximum number of fruits");
					}
				} 
				else if (type == Type.ALCOHOL) 
				{
					if (davids_cafe.isValidAge(age)) {
						if (davids_cafe.isEligibleForMore()) {
							String drink_name = alcohol_names[random.nextInt(0, alcohol_names.length)];
							drink_size = askSizeOfBeverage(scanner);
							davids_cafe.processAlcoholOrder(drink_name, drink_size);
						} else {
							System.out.println("The customer has reached the maximum number of alcoholic drinks");
						}
					} else {
						System.out.println("The customer's age is not appropriate for alcoholic drinks!");
					}
				}

				System.out.println("The current order of drinks is " + davids_cafe.getCurrentOrder().getTotalItems());
				System.out.println("The total price on the order: $" + davids_cafe.getCurrentOrder().calcOrderTotal());

				type = askTypeOfBeverage(scanner);
			}
			System.out.println();
			System.out.println(davids_cafe.getCurrentOrder());
			ask_for_order = askYesOrNo(scanner, "Do you want to enter a new order?");
		}
		System.out.println("Total orders: " + davids_cafe.totalNumOfMonthlyOrders());
		System.out.println("Total amount for all orders: $" + davids_cafe.totalMonthlySale());
	}

	private static Type askTypeOfBeverage(Scanner scanner) {
		String response = askForAnySpecificStringResponse(scanner, "Add a beverage or end this order?", "coffee",
				"alcohol", "smoothie", "end");
		switch (response) {
		case "coffee":
			return Type.COFFEE;
		case "alcohol":
			return Type.ALCOHOL;
		case "smoothie":
			return Type.SMOOTHIE;
		case "end":
			return null;
		default:
			return askTypeOfBeverage(scanner);
		}
	}

	private static Size askSizeOfBeverage(Scanner scanner) {
		String response = askForAnySpecificStringResponse(scanner, "What size beverage do you want?", "small", "medium",
				"large");
		switch (response) {
		case "small":
			return Size.SMALL;
		case "medium":
			return Size.MEDIUM;
		case "large":
			return Size.LARGE;
		default:
			return askSizeOfBeverage(scanner);
		}
	}

	private static boolean askYesOrNo(Scanner scanner, String question) {
		String response = askForAnySpecificStringResponse(scanner, question + " (yes or no)", "yes", "no");
		if (response.equalsIgnoreCase("yes"))
			return true;
		else if (response.equalsIgnoreCase("no"))
			return false;
		else
			return askYesOrNo(scanner, question);
	}

	private static int askForIntegerResponse(Scanner scanner, String question) {
		System.out.print(question + " ");
		try {
			int response = scanner.nextInt();
			if (using_test_file)
				System.err.println(response);
			scanner.nextLine();
			return response;
		} catch (InputMismatchException e) {
			String temp = scanner.nextLine();
			if (using_test_file)
				System.err.println(temp);
			return askForIntegerResponse(scanner, question);
		}
	}

	private static String askForStringResponse(Scanner scanner, String question) {
		System.out.print(question + " ");
		String response = scanner.nextLine();
		if (using_test_file)
			System.err.println(response);
		if (response.isEmpty())
			askForStringResponse(scanner, question);
		return response;
	}

	private static String askForAnySpecificStringResponse(Scanner scanner, String question, String... responses) {
		String response = askForStringResponse(scanner, question);
		for (int i = 0; i < responses.length; i++) { // trying out VarArgs
			if (response.toUpperCase().contains(responses[i].toUpperCase()))
				return responses[i];
		}
		return askForAnySpecificStringResponse(scanner, question, responses);
	}

}
