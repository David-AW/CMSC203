import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

class BevShopTestStudent {

	BevShop beverage_shop;

	@BeforeEach
	void setUp() throws Exception {
		beverage_shop = new BevShop();
	}

	@AfterEach
	void tearDown() throws Exception {
		beverage_shop = null;
	}

	@Test
	void testIsValidTime() {
		for (int i = 8; i < 24; i++)
			assertTrue(beverage_shop.isValidTime(i));
		assertFalse(beverage_shop.isValidTime(7));
		assertFalse(beverage_shop.isValidTime(24));
	}

	@Test
	void testIsValidAge() {
		assertTrue(beverage_shop.isValidAge(21));
		assertFalse(beverage_shop.isValidAge(20));
	}

	@Test
	void testStartNewOrder() {
		beverage_shop = new BevShop();
		beverage_shop.startNewOrder(11, Day.MONDAY, "John Doe", 45);
		Order currentOrder = beverage_shop.getCurrentOrder();
		assertNotNull(currentOrder);
		assertEquals("John Doe", currentOrder.getCustomer().getName());
	}

	@Test
	void testProcessCoffeeOrder() {
		beverage_shop = new BevShop();
		beverage_shop.startNewOrder(11, Day.MONDAY, "John Doe", 45);
		beverage_shop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
		Order currentOrder = beverage_shop.getCurrentOrder();
		assertEquals(1, currentOrder.getTotalItems());
		assertEquals(currentOrder.getBeverage(0).getType(), Type.COFFEE);
	}

	@Test
	void testProcessAlcoholOrder() {
		beverage_shop = new BevShop();
		beverage_shop.startNewOrder(11, Day.MONDAY, "John Doe", 45);
		beverage_shop.processAlcoholOrder("Guinness", Size.LARGE);
		Order currentOrder = beverage_shop.getCurrentOrder();
		assertEquals(1, currentOrder.getTotalItems());
		assertEquals(currentOrder.getBeverage(0).getType(), Type.ALCOHOL);
	}

	@Test
	void testProcessSmoothieOrder() {
		beverage_shop = new BevShop();
		beverage_shop.startNewOrder(11, Day.MONDAY, "John Doe", 45);
		beverage_shop.processSmoothieOrder("Berry Smoothie", Size.LARGE, 3, true);
		Order currentOrder = beverage_shop.getCurrentOrder();
		assertEquals(1, currentOrder.getTotalItems());
		assertEquals(currentOrder.getBeverage(0).getType(), Type.SMOOTHIE);
	}

	@Test
	void testFindOrder() {
		beverage_shop = new BevShop();
		beverage_shop.startNewOrder(11, Day.MONDAY, "John Doe", 45);
		beverage_shop.processCoffeeOrder("Latte", Size.MEDIUM, false, false);
		int order_num = beverage_shop.getCurrentOrder().getOrderNo();
		int found_order = beverage_shop.findOrder(order_num);
		assertEquals(0, found_order);
	}

	@Test
	void testTotalOrderPrice() {
		beverage_shop = new BevShop();
		beverage_shop.startNewOrder(11, Day.MONDAY, "John Doe", 45);
		beverage_shop.processCoffeeOrder("Espresso", Size.SMALL, true, false);
		beverage_shop.processAlcoholOrder("Beer", Size.MEDIUM);
		double expectedPrice = 2.0 + 0.5 + 2.0 + 0.5;
		assertEquals(expectedPrice, beverage_shop.totalOrderPrice(beverage_shop.getCurrentOrder().getOrderNo()));
	}

	@Test
	void testTotalMonthlySale() {
		beverage_shop = new BevShop();
		beverage_shop.startNewOrder(11, Day.MONDAY, "John Doe", 45);
		beverage_shop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
		beverage_shop.startNewOrder(9, Day.TUESDAY, "Jane Doe", 21);
		beverage_shop.processAlcoholOrder("Wine", Size.LARGE);
		double expectedSales = 2.0 + 0.5 + 0.5 + 0.5 + 2.0 + 0.5 + 0.5;
		assertEquals(expectedSales, beverage_shop.totalMonthlySale());
	}

	@Test
	void testTotalNumOfMonthlyOrders() {
		beverage_shop = new BevShop();
		beverage_shop.startNewOrder(11, Day.MONDAY, "John Doe", 45);
		beverage_shop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
		beverage_shop.startNewOrder(9, Day.TUESDAY, "Jane Doe", 21);
		beverage_shop.processAlcoholOrder("Wine", Size.LARGE);
		assertEquals(2, beverage_shop.totalNumOfMonthlyOrders());
	}

	@Test
	void testSortOrders() {
		beverage_shop = new BevShop();
		beverage_shop.startNewOrder(11, Day.MONDAY, "John Doe", 45);
		beverage_shop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
		beverage_shop.startNewOrder(9, Day.TUESDAY, "Jane Doe", 21);
		beverage_shop.processAlcoholOrder("Wine", Size.LARGE);
		beverage_shop.startNewOrder(9, Day.TUESDAY, "Jane Doe", 21);
		beverage_shop.processSmoothieOrder("Smoothie", Size.SMALL, 3, false);

		Order current_order_before = beverage_shop.getCurrentOrder();
		beverage_shop.sortOrders();
		Order current_order_after = beverage_shop.getCurrentOrder();

		assertTrue(beverage_shop.getOrderAtIndex(0).getOrderNo() < beverage_shop.getOrderAtIndex(1).getOrderNo());
		assertTrue(beverage_shop.getOrderAtIndex(1).getOrderNo() < beverage_shop.getOrderAtIndex(2).getOrderNo());
		assertTrue(current_order_before.equals(current_order_after));
	}

	@Test
	void testIsEligibleForMore() {
		beverage_shop = new BevShop();
		beverage_shop.startNewOrder(11, Day.MONDAY, "John Doe", 45);
		beverage_shop.processAlcoholOrder("Guinness", Size.LARGE);
		assertTrue(beverage_shop.isEligibleForMore());
		beverage_shop.processAlcoholOrder("Guinness", Size.LARGE);
		assertTrue(beverage_shop.isEligibleForMore());
		beverage_shop.processAlcoholOrder("Guinness", Size.LARGE);
		assertFalse(beverage_shop.isEligibleForMore());
	}

	@Test
	void testIsMaxFruit() {
		assertTrue(beverage_shop.isMaxFruit(11));
		assertFalse(beverage_shop.isMaxFruit(5));
	}

}
