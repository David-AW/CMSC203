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

class CoffeeTestStudent {
	private Coffee coffee_with_extras;
	private Coffee coffee_no_extras;
	private Coffee coffee_shot_only;
	private Coffee coffee_syrup_only;

	@BeforeEach
	void setUp() throws Exception {
		coffee_with_extras = new Coffee("Latte", Size.MEDIUM, true, true);
		coffee_no_extras = new Coffee("Americano", Size.LARGE, false, false);
		coffee_shot_only = new Coffee("Espresso", Size.SMALL, true, false);
		coffee_syrup_only = new Coffee("Mocha", Size.MEDIUM, false, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		coffee_with_extras = coffee_no_extras = coffee_shot_only = coffee_syrup_only = null;
	}

	@Test
	void testGetters() {
		assertTrue(coffee_with_extras.getExtraShot());
		assertFalse(coffee_no_extras.getExtraShot());
		assertTrue(coffee_shot_only.getExtraShot());
		assertFalse(coffee_syrup_only.getExtraShot());

		assertTrue(coffee_with_extras.getExtraSyrup());
		assertFalse(coffee_no_extras.getExtraSyrup());
		assertFalse(coffee_shot_only.getExtraSyrup());
		assertTrue(coffee_syrup_only.getExtraSyrup());
	}

	@Test
	void testToString() {
		assertEquals("Latte, MEDIUM, extra shot: yes, extra syrup: yes, $3.5", coffee_with_extras.toString());
		assertEquals("Americano, LARGE, extra shot: no, extra syrup: no, $3.0", coffee_no_extras.toString());
		assertEquals("Espresso, SMALL, extra shot: yes, extra syrup: no, $2.5", coffee_shot_only.toString());
		assertEquals("Mocha, MEDIUM, extra shot: no, extra syrup: yes, $3.0", coffee_syrup_only.toString());
	}

	@Test
	void testEquals() {
		Coffee same_coffee = new Coffee("Espresso", Size.SMALL, true, false);
		assertTrue(coffee_shot_only.equals(same_coffee));
		assertFalse(coffee_with_extras.equals(coffee_no_extras));
	}

	@Test
	void testCalcPrice() {
		assertEquals(3.5, coffee_with_extras.calcPrice());
		assertEquals(3.0, coffee_no_extras.calcPrice());
		assertEquals(2.5, coffee_shot_only.calcPrice());
		assertEquals(3.0, coffee_syrup_only.calcPrice());
	}

}
