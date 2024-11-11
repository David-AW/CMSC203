import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

	Property property;
	
	@BeforeEach
	void setUp() throws Exception {
		property = new Property();
	}

	@AfterEach
	void tearDown() throws Exception {
		property = null;
	}

	@Test
	void testDefaultConstructor() {
		property = new Property();
		assertEquals("", property.getPropertyName());
		assertEquals("", property.getCity());
		assertEquals("", property.getOwner());
		assertEquals(0.0, property.getRentAmount());
		assertNotNull(property.getPlot());
	}

	@Test
	void testParameterizedConstructor() {
		property = new Property("House", "New York", 1500.0, "John Doe");
		assertEquals("House", property.getPropertyName());
		assertEquals("New York", property.getCity());
		assertEquals("John Doe", property.getOwner());
		assertEquals(1500.0, property.getRentAmount());
		assertNotNull(property.getPlot());
	}

	@Test
	void testParameterizedConstructorWithPlotValues() {
		property = new Property("House", "New York", 1500.0, "John Doe", 5, 5, 20, 20);
		assertEquals("House", property.getPropertyName());
		assertEquals("New York", property.getCity());
		assertEquals("John Doe", property.getOwner());
		assertEquals(1500.0, property.getRentAmount());
		assertNotNull(property.getPlot());
	}

	@Test
	void testCopyConstructor() {
		Property original = new Property("Apartment", "Washington D.C.", 2000.0, "Jane Doe", 10, 10, 30, 30);
		property = new Property(original);
		assertEquals(original.getPropertyName(), property.getPropertyName());
		assertEquals(original.getCity(), property.getCity());
		assertEquals(original.getOwner(), property.getOwner());
		assertEquals(original.getRentAmount(), property.getRentAmount());
	}

	@Test
	void testSetters() {
		property.setPropertyName("Condo");
		property.setCity("Miami");
		property.setOwner("Bob");
		property.setRentAmount(1800.0);
		Plot newPlot = new Plot(10, 10, 50, 50);
		property.setPlot(newPlot);
		assertEquals("Condo", property.getPropertyName());
		assertEquals("Miami", property.getCity());
		assertEquals("Bob", property.getOwner());
		assertEquals(1800.0, property.getRentAmount());
		assertEquals(newPlot, property.getPlot());
	}

	@Test
	void testGetters() {
		property = new Property("House", "New York", 1500.0, "David");
		assertEquals("House", property.getPropertyName());
		assertEquals("New York", property.getCity());
		assertEquals("David", property.getOwner());
		assertEquals(1500.0, property.getRentAmount());
		assertNotNull(property.getPlot());
	}

	@Test
	void testToString() {
		property = new Property("House", "New York", 3000.0, "David");
		assertEquals("House,New York,David,3000.0", property.toString());
	}

}
