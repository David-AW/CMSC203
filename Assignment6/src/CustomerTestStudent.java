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

class CustomerTestStudent {

	private Customer customer;

	@BeforeEach
	void setUp() throws Exception {
		customer = new Customer("John Doe", 30);
	}

	@AfterEach
	void tearDown() throws Exception {
		customer = null;
	}

	@Test
	void testGetName() {
		customer = new Customer("John Doe", 30);
		assertEquals("John Doe", customer.getName());
	}

	@Test
	void testGetAge() {
		customer = new Customer("John Doe", 30);
		assertEquals(30, customer.getAge());
	}

	@Test
	void testSetName() {
		customer.setName("Jane Smith");
		assertEquals("Jane Smith", customer.getName());
	}

	@Test
	void testSetAge() {
		customer.setAge(35);
		assertEquals(35, customer.getAge());
	}

	@Test
	void testToString() {
		customer = new Customer("John Doe", 30);
		assertEquals("John Doe 30", customer.toString());
	}
}
