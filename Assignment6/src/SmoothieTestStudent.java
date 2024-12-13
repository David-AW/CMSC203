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

class SmoothieTestStudent {

	private Smoothie smoothie_no_extras;
	private Smoothie smoothie_with_protein;
	private Smoothie smoothie_only_extra_fruit;
	private Smoothie smoothie_all_extras;

	@BeforeEach
	void setUp() throws Exception {
		smoothie_no_extras = new Smoothie("Energy Boost", Size.SMALL, 0, false);
		smoothie_with_protein = new Smoothie("Muscle Builder", Size.LARGE, 0, true);
		smoothie_only_extra_fruit = new Smoothie("Fruity Tootie", Size.MEDIUM, 5, false);
		smoothie_all_extras = new Smoothie("Everything Smoothie", Size.SMALL, 3, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		smoothie_no_extras = smoothie_with_protein = smoothie_only_extra_fruit = smoothie_all_extras = null;
	}

	@Test
	void testGetters() {
		assertEquals(0, smoothie_no_extras.getNumOfFruits());
		assertEquals(0, smoothie_with_protein.getNumOfFruits());
		assertEquals(5, smoothie_only_extra_fruit.getNumOfFruits());
		assertEquals(3, smoothie_all_extras.getNumOfFruits());

		assertFalse(smoothie_no_extras.getAddProtein());
		assertTrue(smoothie_with_protein.getAddProtein());
		assertFalse(smoothie_only_extra_fruit.getAddProtein());
		assertTrue(smoothie_all_extras.getAddProtein());
	}

	@Test
	void testToString() {
		assertEquals("Energy Boost, SMALL, has protein: no, number of fruits: 0, $2.0", smoothie_no_extras.toString());
		assertEquals("Muscle Builder, LARGE, has protein: yes, number of fruits: 0, $4.5",
				smoothie_with_protein.toString());
		assertEquals("Fruity Tootie, MEDIUM, has protein: no, number of fruits: 5, $5.0",
				smoothie_only_extra_fruit.toString());
		assertEquals("Everything Smoothie, SMALL, has protein: yes, number of fruits: 3, $5.0",
				smoothie_all_extras.toString());
	}

	@Test
	void testEquals() {
		Smoothie same_smoothie = new Smoothie("Everything Smoothie", Size.SMALL, 3, true);
		assertTrue(smoothie_all_extras.equals(same_smoothie));
		assertFalse(smoothie_all_extras.equals(smoothie_with_protein));
	}

	@Test
	void testCalcPrice() {
		assertEquals(2.0, smoothie_no_extras.calcPrice());
		assertEquals(4.5, smoothie_with_protein.calcPrice());
		assertEquals(5.0, smoothie_only_extra_fruit.calcPrice());
		assertEquals(5.0, smoothie_all_extras.calcPrice());
	}

}
