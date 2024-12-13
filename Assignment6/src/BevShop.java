import java.util.ArrayList;

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

public class BevShop implements BevShopInterface {

	private ArrayList<Order> orders;
	private int curr_order_index;
	private int curr_order_alcohol_count;

	public BevShop() {
		orders = new ArrayList<Order>();
	}

	@Override
	public boolean isValidTime(int time) {
		return time >= MIN_TIME && time <= MAX_TIME;
	}

	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int num_of_fruits) {
		return num_of_fruits > MAX_FRUIT;
	}

	@Override
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore() {
		return curr_order_alcohol_count < MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public int getNumOfAlcoholDrink() {
		return curr_order_alcohol_count;
	}

	@Override
	public boolean isValidAge(int age) {
		return age >= MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public void startNewOrder(int time, Day day, String customer_name, int customer_age) {
		curr_order_index = orders.size();
		curr_order_alcohol_count = 0;
		orders.add(new Order(time, day, new Customer(customer_name, customer_age)));
	}

	@Override
	public void processCoffeeOrder(String beverage_name, Size size, boolean extra_shot, boolean extra_syrup) {
		getCurrentOrder().addNewBeverage(beverage_name, size, extra_shot, extra_syrup);
	}

	@Override
	public void processAlcoholOrder(String beverage_name, Size size) {
		getCurrentOrder().addNewBeverage(beverage_name, size);
		curr_order_alcohol_count++;
	}

	@Override
	public void processSmoothieOrder(String beverage_name, Size size, int num_of_fruits, boolean add_protein) {
		getCurrentOrder().addNewBeverage(beverage_name, size, num_of_fruits, add_protein);
	}

	@Override
	public int findOrder(int order_num) {
		int order_index = -1;
		for (int i = 0; i < orders.size(); i++)
			if (orders.get(i).getOrderNo() == order_num) {
				order_index = i;
				break;
			}
		return order_index;
	}

	@Override
	public double totalOrderPrice(int order_num) {
		return orders.get(findOrder(order_num)).calcOrderTotal();
	}

	@Override
	public double totalMonthlySale() {
		double sales = 0;
		for (Order o : orders)
			sales += o.calcOrderTotal();
		return sales;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	@Override
	public Order getCurrentOrder() {
		return orders.get(curr_order_index);
	}

	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	@Override
	public void sortOrders() {
		for (int start = 0; start < orders.size() - 1; start++) {

			int min_order_num_index = start;
			// Find the minimum order number
			for (int i = start + 1; i < orders.size(); i++) {
				if (orders.get(i).getOrderNo() < orders.get(min_order_num_index).getOrderNo())
					min_order_num_index = i;
			}

			// Swap min value with starting index
			Order temp = orders.get(min_order_num_index);
			orders.set(min_order_num_index, orders.get(start));
			orders.set(start, temp);

			// also swap the current order index if the objects were swapped
			if (curr_order_index == min_order_num_index)
				curr_order_index = start;
			else if (curr_order_index == start)
				curr_order_index = min_order_num_index;
		}
	}

}
