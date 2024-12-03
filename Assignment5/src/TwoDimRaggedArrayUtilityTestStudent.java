import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

class TwoDimRaggedArrayUtilityTestStudent {

	private double[][] test = {
			{1.0, 2.0, 3.0, 9.0},
			{4.0, -5.0},
			{6.0, 7.0, 8.0, 5.0}
	};

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void testReadFile() {
		double[][] expected_file_values = {{1, 2, 3}, {4, 5}, {6, 7, 8}};
		double[][] actual_file_values = null;
		File data_set1 = new File("dataSet1.txt");
		
		actual_file_values = TwoDimRaggedArrayUtility.readFile(data_set1);

		assertNotNull(actual_file_values);
		assertEquals(expected_file_values.length, actual_file_values.length, "Row count mismatch [expected: " 
				+ expected_file_values.length + ", got: " + actual_file_values.length + "]");
		
		for (int row = 0; row < expected_file_values.length; row++) {
			assertEquals(expected_file_values[row].length, actual_file_values[row].length, "Column count mismatch on row: " + row 
					+ " [expected: " + expected_file_values[row].length + ", got: " + actual_file_values[row].length + "]");
			
			for (int col = 0; col < expected_file_values[row].length; col++) {
				assertEquals(expected_file_values[row][col], actual_file_values[row][col]);
			}
		}
	}
	
	@Test
	public void testWriteToFile() {
		double[][] expected_file_values = {{1, 2, 3}, {4, 5}, {6, 7, 8}};
		String data_set1 = "1.0 2.0 3.0\n"
						 + "4.0 5.0\n"
						 + "6.0 7.0 8.0";
		File test_file = new File("dataSetStudent.txt");
		
		TwoDimRaggedArrayUtility.writeToFile(expected_file_values, test_file);
		
		String test_string = "";
		
		try {
			Scanner scan_test = new Scanner(test_file);
			while(scan_test.hasNextLine()) {
				test_string += scan_test.nextLine() + "\n";
			}
			scan_test.close();
			test_string = test_string.strip();
		} catch (FileNotFoundException e) {
			fail("Unable to locate file: " + test_file.getName());
		}
		
		assertEquals(data_set1, test_string);
	}
	
	@Test
	public void testGetAverage() {
		assertEquals(4.0, TwoDimRaggedArrayUtility.getAverage(test)); // (1+2+3+9+4-5+6+7+8+5)/10 --> 40 / 10 = 4
	}

	@Test
	public void testGetColumnTotal() {
		assertEquals(11, TwoDimRaggedArrayUtility.getColumnTotal(test, 0)); // 1 + 4 + 6 = 11
		assertEquals(4, TwoDimRaggedArrayUtility.getColumnTotal(test, 1));  // 2 - 5 + 7 = 4
		assertEquals(11, TwoDimRaggedArrayUtility.getColumnTotal(test, 2)); // 3 + 8 = 11
		assertEquals(14, TwoDimRaggedArrayUtility.getColumnTotal(test, 3)); // 9 + 5 = 14
	}

	@Test
	public void testGetRowTotal() {
		assertEquals(15.0, TwoDimRaggedArrayUtility.getRowTotal(test, 0)); // 1 + 2 + 3 + 9 = 15
		assertEquals(-1.0, TwoDimRaggedArrayUtility.getRowTotal(test, 1)); // 4 - 5 = -1
		assertEquals(26.0, TwoDimRaggedArrayUtility.getRowTotal(test, 2)); // 6 + 7 + 8 + 5 = 26
	}

	@Test
	public void testGetTotal() {
		assertEquals(40, TwoDimRaggedArrayUtility.getTotal(test)); // 1 + 2 + 3 + 9 + 4 - 5 + 6 + 7 + 8 + 5 = 40
	}

	@Test
	public void testGetHighestInColumn() {
		assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInColumn(test, 0));
		assertEquals(7.0, TwoDimRaggedArrayUtility.getHighestInColumn(test, 1));
		assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInColumn(test, 2));
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInColumn(test, 3));
	}

	@Test
	public void testGetHighestInColumnIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(test, 0));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(test, 1));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(test, 2));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(test, 3));
	}

	@Test
	public void testGetHighestInRow() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInRow(test, 0));
		assertEquals(4.0, TwoDimRaggedArrayUtility.getHighestInRow(test, 1));
		assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInRow(test, 2));
	}

	@Test
	public void testGetHighestInRowIndex() {
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(test, 0));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(test, 1));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(test, 2));
	}

	@Test
	public void testGetHighestInArray() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInArray(test));
	}

	@Test
	public void testGetLowestInArray() {
		assertEquals(-5.0, TwoDimRaggedArrayUtility.getLowestInArray(test));
	}

	@Test
	public void testGetLowestInColumn() {
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(test, 0));
		assertEquals(-5.0, TwoDimRaggedArrayUtility.getLowestInColumn(test, 1));
		assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInColumn(test, 2));
		assertEquals(5.0, TwoDimRaggedArrayUtility.getLowestInColumn(test, 3));
	}

	@Test
	public void testGetLowestInColumnIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(test, 0));
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(test, 1));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(test, 2));
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(test, 3));
	}

	@Test
	public void testGetLowestInRow() {
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(test, 0));
		assertEquals(-5.0, TwoDimRaggedArrayUtility.getLowestInRow(test, 1));
		assertEquals(5.0, TwoDimRaggedArrayUtility.getLowestInRow(test, 2));
	}

	@Test
	public void testGetLowestInRowIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(test, 0));
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(test, 1));
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInRowIndex(test, 2));
	}
}
