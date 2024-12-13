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

class AlcoholTestStudent {

	private Alcohol whiskey;
	private Alcohol beer;
	private Alcohol tequila;

	private Alcohol whiskey_weekend;
	private Alcohol beer_weekend;
	private Alcohol tequila_weekend;

	@BeforeEach
	void setUp() throws Exception {
		whiskey = new Alcohol("Whiskey", Size.SMALL, false);
		tequila = new Alcohol("Tequila", Size.MEDIUM, false);
		beer = new Alcohol("Beer", Size.LARGE, false);

		whiskey_weekend = new Alcohol("Whiskey", Size.SMALL, true);
		tequila_weekend = new Alcohol("Tequila", Size.MEDIUM, true);
		beer_weekend = new Alcohol("Beer", Size.LARGE, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		beer = whiskey = tequila = beer_weekend = whiskey_weekend = tequila_weekend = null;
	}

	@Test
	void testToString() {
		assertEquals("Whiskey, SMALL, offered on weekend: no, $2.0", whiskey.toString());
		assertEquals("Beer, LARGE, offered on weekend: no, $3.0", beer.toString());
		assertEquals("Tequila, MEDIUM, offered on weekend: no, $2.5", tequila.toString());

		assertEquals("Whiskey, SMALL, offered on weekend: yes, $2.6", whiskey_weekend.toString());
		assertEquals("Beer, LARGE, offered on weekend: yes, $3.6", beer_weekend.toString());
		assertEquals("Tequila, MEDIUM, offered on weekend: yes, $3.1", tequila_weekend.toString());
	}

	@Test
	void testEquals() {
		Alcohol same_whiskey = new Alcohol("Whiskey", Size.SMALL, false);
		assertTrue(whiskey.equals(same_whiskey));
		assertFalse(whiskey.equals(whiskey_weekend));
	}

	@Test
	void testIsWeekend() {
		assertTrue(whiskey_weekend.isWeekend());
		assertFalse(whiskey.isWeekend());
	}

	@Test
	void testCalcPriceWeekend() {
		assertEquals(2.6, whiskey_weekend.calcPrice());
		assertEquals(3.6, beer_weekend.calcPrice());
		assertEquals(3.1, tequila_weekend.calcPrice());
	}

	@Test
	void testCalcPriceWeekday() {
		assertEquals(2.0, whiskey.calcPrice());
		assertEquals(3.0, beer.calcPrice());
		assertEquals(2.5, tequila.calcPrice());
	}

}
