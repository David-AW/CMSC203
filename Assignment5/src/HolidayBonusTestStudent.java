import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: 1000-1140 Morning Class
 * Due: 12/03/2024
 * Platform/compiler: Ubuntu Linux / JDK 21
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: David Wery
*/

class HolidayBonusTestStudent {

	private double[][] test = {
			{1.0, 2.0, 3.0, 9.0}, // L M L H = 1000 + 2000 + 1000 + 5000 = 9000
			{4.0, -5.0},		  // M L     = 2000 + 0 (negative)       = 2000
			{6.0, 7.0, 8.0, 5.0}  // H H H L = 5000 + 5000 + 5000 + 1000 = 16000
	};
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}

	@Test
	void testCalculateHolidayBonus() {
		double[] expected = {9000.0, 2000.0, 16000.0};
		double[] actual = HolidayBonus.calculateHolidayBonus(test);
		for (int i = 0; i < actual.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}

	@Test
	void testCalculateTotalHolidayBonus() {
		assertEquals(27000.0, HolidayBonus.calculateTotalHolidayBonus(test)); // 9,000 + 2,000 + 16,000 = 27,000
	}

	
}
