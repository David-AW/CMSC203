import java.util.ArrayList;
import java.util.Random;

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

public class Order implements OrderInterface, Comparable {

	private final int ORDER_TIME;
	private final int ORDER_NUM;
	private final Day ORDER_DAY;
	private final Customer CUSTOMER;
	private ArrayList<Beverage> beverages;

	public Order(int order_time, Day order_day, Customer customer) {
		this.ORDER_TIME = Math.clamp(order_time, 8, 23);
		this.ORDER_DAY = order_day;
		this.CUSTOMER = customer;
		beverages = new ArrayList<Beverage>();
		ORDER_NUM = generateOrder();
	}

	public int generateOrder() {
		Random random = new Random();
		return random.nextInt(10000, 90001);
	}

	public int getOrderNo() {
		return ORDER_NUM;
	}

	public int getOrderTime() {
		return ORDER_TIME;
	}

	public Day getOrderDay() {
		return ORDER_DAY;
	}

	public int getTotalItems() {
		return beverages.size();
	}

	public Customer getCustomer() {
		return new Customer(CUSTOMER.getName(), CUSTOMER.getAge());
	}

	/**
	 * @return true if this order took place on a weekday
	 */
	@Override
	public boolean isWeekend() {
		return ORDER_DAY == Day.SATURDAY || ORDER_DAY == Day.SUNDAY;
	}

	@Override
	public Beverage getBeverage(int item_num) {
		return beverages.get(item_num);
	}

	@Override
	public void addNewBeverage(String beverage_name, Size size, boolean extra_shot, boolean extra_syrup) {
		beverages.add(new Coffee(beverage_name, size, extra_shot, extra_syrup));
	}

	@Override
	public void addNewBeverage(String beverage_name, Size size) {
		beverages.add(new Alcohol(beverage_name, size, isWeekend()));
	}

	@Override
	public void addNewBeverage(String beverage_name, Size size, int num_of_fruits, boolean add_protein) {
		beverages.add(new Smoothie(beverage_name, size, num_of_fruits, add_protein));
	}

	@Override
	public double calcOrderTotal() {
		double total = 0;
		for (Beverage bev : beverages)
			total += bev.calcPrice();
		return total;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int count = 0;
		for (Beverage bev : beverages)
			if (bev.getType() == type)
				count++;
		return count;
	}

	@Override
	public String toString() {
		String order_details = "Order Details:\n";
		for (Beverage bev : beverages)
			order_details += " - " + bev + "\n";
		return "Order #" + ORDER_NUM + " " + ORDER_TIME + ":00 " + ORDER_DAY + " for " + CUSTOMER.getName() + " ["
				+ CUSTOMER.getAge() + "]\n" + order_details;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Order) {
			Order other = (Order) o;
			if (this.ORDER_NUM > other.ORDER_NUM)
				return 1;
			else if (this.ORDER_NUM < other.ORDER_NUM)
				return -1;
		}
		return 0;
	}

}
