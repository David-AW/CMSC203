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

class OrderTestStudent {

	private Customer customer;
	private Order weekday_order;
	private Order weekend_order;

	@BeforeEach
	void setUp() throws Exception {
		customer = new Customer("John Doe", 30);

		weekday_order = new Order(10, Day.MONDAY, customer);
		weekend_order = new Order(14, Day.SATURDAY, customer);
	}

	@AfterEach
	void tearDown() throws Exception {
		customer = null;
		weekday_order = weekend_order = null;
	}

	@Test
	void testGenerateOrder() {
		int orderNumber = weekday_order.getOrderNo();
		assertTrue(orderNumber >= 10000 && orderNumber < 90000);
	}

	@Test
	void testGetOrderNo() {
		assertEquals(weekday_order.getOrderNo(), weekday_order.getOrderNo());
	}

	@Test
	void testGetOrderTime() {
		assertEquals(10, weekday_order.getOrderTime());
		assertEquals(14, weekend_order.getOrderTime());
	}

	@Test
	void testGetOrderDay() {
		assertEquals(Day.MONDAY, weekday_order.getOrderDay());
		assertEquals(Day.SATURDAY, weekend_order.getOrderDay());
	}

	@Test
	void testIsWeekend() {
		assertFalse(weekday_order.isWeekend());
		assertTrue(weekend_order.isWeekend());
	}

	@Test
	void testGetTotalItems() {
		weekday_order = new Order(10, Day.MONDAY, customer);
		weekday_order.addNewBeverage("Latte", Size.MEDIUM, true, true);
		weekday_order.addNewBeverage("Mocha", Size.LARGE, false, false);
		assertEquals(2, weekday_order.getTotalItems());
	}

	@Test
	void testAddNewBeverageCoffee() {
		weekday_order = new Order(10, Day.MONDAY, customer);
		weekday_order.addNewBeverage("Espresso", Size.SMALL, true, false);
		assertEquals(1, weekday_order.getTotalItems());
	}

	@Test
	void testAddNewBeverageAlcohol() {
		weekend_order = new Order(14, Day.SATURDAY, customer);
		weekend_order.addNewBeverage("Beer", Size.MEDIUM);
		assertEquals(1, weekend_order.getTotalItems());
	}

	@Test
	void testCalcOrderTotal() {
		weekday_order = new Order(10, Day.MONDAY, customer);
		weekday_order.addNewBeverage("Espresso", Size.SMALL, true, false);
		weekday_order.addNewBeverage("Latte", Size.MEDIUM, true, true);
		double expectedTotal = 2.0 + 0.5 + 2.0 + 0.5 + 0.5 + 0.5;
		assertEquals(expectedTotal, weekday_order.calcOrderTotal());
	}

	@Test
	void testFindNumOfBeveType() {
		weekday_order = new Order(10, Day.MONDAY, customer);
		weekday_order.addNewBeverage("Espresso", Size.SMALL, true, false);
		weekday_order.addNewBeverage("Latte", Size.MEDIUM, true, true);
		weekday_order.addNewBeverage("Beer", Size.MEDIUM);
		assertEquals(2, weekday_order.findNumOfBeveType(Type.COFFEE));
		assertEquals(1, weekday_order.findNumOfBeveType(Type.ALCOHOL));
	}

	@Test
	void testToString() {
		weekday_order = new Order(10, Day.MONDAY, customer);
		weekday_order.addNewBeverage("Espresso", Size.SMALL, true, false);
		weekday_order.addNewBeverage("Latte", Size.MEDIUM, true, true);
		String expectedToString = "Order #" + weekday_order.getOrderNo() + " 10:00 MONDAY for John Doe [30]\n"
				+ "Order Details:\n" + " - Espresso, SMALL, extra shot: yes, extra syrup: no, $2.5\n"
				+ " - Latte, MEDIUM, extra shot: yes, extra syrup: yes, $3.5\n";
		assertTrue(weekday_order.toString().equals(expectedToString));
	}

	@Test
	void testCompareTo() {
		Order another_order = new Order(12, Day.TUESDAY, customer);
		Order order1 = null, order2 = null;
		if (weekday_order.getOrderNo() > another_order.getOrderNo()) {
			order1 = another_order;
			order2 = weekday_order;
		} else if (weekday_order.getOrderNo() < another_order.getOrderNo()) {
			order1 = weekday_order;
			order2 = another_order;
		} else {
			System.err.println("Very rare edge case met with random numbers, re-run junit test");
			fail("Very rare edge case met with random numbers, re-run junit test");
		}
		assertTrue(order1.compareTo(order2) < 0);
		assertTrue(order2.compareTo(order1) > 0);
		assertEquals(0, weekday_order.compareTo(weekday_order));
	}

}
