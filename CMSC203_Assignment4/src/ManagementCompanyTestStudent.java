import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {

	private ManagementCompany company;
	private Property property1, property2, property3;

	@BeforeEach
	void setUp() {
		company = new ManagementCompany("Test Corp", "123456789", 10.0);
		property1 = new Property("Property1", "City1", 1000.0, "Owner1", 0, 0, 1, 1);
		property2 = new Property("Property2", "City2", 1500.0, "Owner2", 1, 0, 1, 1);
		property3 = new Property("Property3", "City3", 2000.0, "Owner3", 2, 0, 1, 1);
	}

	@AfterEach
	void tearDown() {
		company = null;
		property1 = property2 = property3 = null;
	}

	@Test
	void testAddProperty() {
		company = new ManagementCompany("Test Corp", "123456789", 10.0);
		int index = company.addProperty(property1);
		assertEquals(0, index);
		assertEquals(1, company.getPropertiesCount());
		assertEquals(property1, company.getProperties()[0]);
	}

	@Test
	void testAddPropertyFull() {
		company = new ManagementCompany("Test Corp", "123456789", 10.0); 
		company.addProperty(property1);
		company.addProperty(property2);
		company.addProperty(property3);
		company.addProperty(new Property("Property4", "City4", 1800.0, "Owner4", 3, 0, 1, 1));
		company.addProperty(new Property("Property5", "City5", 1900.0, "Owner5", 4, 0, 1, 1));
		int index = company.addProperty(new Property("Property6", "City6", 2500.0, "Owner6", 9, 9, 1, 1));
		assertEquals(-1, index);
	}

	@Test
	void testAddPropertyNull() {
		company = new ManagementCompany();
		int index = company.addProperty(null);
		assertEquals(-2, index);
	}

	@Test
	void testAddPropertyOutOfBounds() {
		company = new ManagementCompany();
		Property test = new Property("test", "test", 3000.0, "test", 11, 11, 2, 2);
		int index = company.addProperty(test);
		assertEquals(-3, index);
	}

	@Test
	void testAddPropertyOverlap() {
		company = new ManagementCompany();
		company.addProperty(property1);
		Property test = new Property("test", "test", 2000.0, "test", 0, 0, 2, 2);
		int index = company.addProperty(test);
		assertEquals(-4, index);
	}

	@Test
	void testRemoveLastProperty() {
		company = new ManagementCompany();
		company.addProperty(property1);
		company.addProperty(property2);
		assertEquals(2, company.getPropertiesCount());

		company.removeLastProperty();
		assertEquals(1, company.getPropertiesCount());
		assertNull(company.getProperties()[1]);
	}

	@Test
	void testIsPropertiesFull() {
		company = new ManagementCompany("Test Corp", "123456789", 10.0); 
		company.addProperty(property1);
		company.addProperty(property2);
		company.addProperty(property3);
		company.addProperty(new Property("Property4", "City4", 1800.0, "Owner4", 3, 0, 1, 1));
		company.addProperty(new Property("Property5", "City5", 1900.0, "Owner5", 4, 0, 1, 1));
		assertTrue(company.isPropertiesFull());
	}

	@Test
	void testGetTotalRent() {
		company = new ManagementCompany("Test Corp", "123456789", 10.0);
		company.addProperty(property1);
		company.addProperty(property2);
		company.addProperty(property3);

		double totalRent = company.getTotalRent();
		assertEquals(1000.0 + 1500.0 + 2000.0, totalRent);
	}

	@Test
	void testGetHighestRentProperty() {
		company = new ManagementCompany("Test Corp", "123456789", 10.0);
		company.addProperty(property1);
		company.addProperty(property2);
		company.addProperty(property3);

		Property highestRentProperty = company.getHighestRentPropperty();
		assertEquals(property3, highestRentProperty);
	}

	@Test
	void testIsManagementFeeValid() {
		company = new ManagementCompany("Test Corp", "123456789", 10.0);
		assertTrue(company.isManagementFeeValid());

		company = new ManagementCompany("Test Corp", "123456789", 105.0);
		assertFalse(company.isManagementFeeValid());

		company = new ManagementCompany("Test Corp", "123456789", -5.0);
		assertFalse(company.isManagementFeeValid());
	}

	@Test
	void testToString() {
		company = new ManagementCompany("Test Corp", "123456789", 10.0);
		company.addProperty(property1);
		company.addProperty(property2);

		String expectedString = "List of the properties for Test Corp, taxID: 123456789\n" 
				+ "______________________________________________________\n"
				+ "Property1,City1,Owner1,1000.0\n"
				+ "Property2,City2,Owner2,1500.0\n"
				+ "______________________________________________________\n"
				+ "\n"
				+ " total management Fee: 250.0";

		assertEquals(expectedString, company.toString());
	}
}
