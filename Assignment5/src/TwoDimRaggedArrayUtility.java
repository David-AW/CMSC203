import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

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

public class TwoDimRaggedArrayUtility {

	private static final int MAX_ROW = 10, MAX_COLUMN = 10;
	
	/**
	 * Reads from a file and returns a ragged array of doubles.
	 * 
	 * @param file The file from which the data will be read.
	 * @return A 2D ragged array of doubles or null.
	 */	
	public static double[][] readFile(File file) {
		Scanner input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.err.println("Error: Unable to read from file " + file.getName() + ".");
			return null;
		}
		
		String contents = "";
		for (int i = 0; i < MAX_ROW; i++) {
			if (input.hasNextLine())
				contents += input.nextLine() + "\n"; //add newline char back to utilize String's split method
			else
				break;
		}
		input.close();
		
		if (contents.equals(""))
			return null;
		
		String[] str_array = contents.strip().split("\n"); // This array is already limited to 10 rows from loop above.
		double[][] array = new double[str_array.length][];
		
		for (int row = 0; row < str_array.length; row++) {
			String[] temp_str_array_row = str_array[row].trim().split(" "); //trim to minimize user error from inputing numbers into a text file.
			array[row] = new double[temp_str_array_row.length <= MAX_COLUMN ? temp_str_array_row.length : MAX_COLUMN];
			
			for (int col = 0; col < MAX_COLUMN; col++) {
				if (col >= temp_str_array_row.length)
					break;
				try {
					array[row][col] = Double.parseDouble(temp_str_array_row[col]);
				}catch(NumberFormatException e) {
					System.err.println("Error: Non-number characters inside of file " + file.getName() + ".");
					return null;
				}
			}
		}
		return array;
	}

	/**
	 * Writes a ragged array of doubles to a file.
	 * 
	 * @param data The 2D array of doubles to be written to the file.
	 * @param output_file The file where the data will be written.
	 */
	public static void writeToFile(double[][] data, File output_file) {
		PrintWriter printer = null;
		try {
			printer = new PrintWriter(output_file);
		} catch (FileNotFoundException e) {
			System.err.println("Error: Unable to write to file " + output_file.getName() + ".");
			return;
		}
		for (int row = 0; row < data.length; row++) {
			String line = "";
			for (int col = 0; col < data[row].length; col++) {
				line += data[row][col];
				// print space to separate; if end of line, put newline instead, unless last line, add nothing
				line += (col < data[row].length-1 ? " " : (row == data.length-1 ? "" : "\n")); 
			}
			printer.print(line);
		}
		printer.close();
	}

	/**
	 * Returns the average of the elements in the 2D array.
	 * 
	 * @param data A 2D array of doubles.
	 * @return The average of all the elements in the array.
	 */
	public static double getAverage(double[][] data) {
		double sum = 0;
		int num_elements = 0;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				sum += data[row][col];
				num_elements++;
			}
		}
		return sum/num_elements;
	}

	/**
	 * Returns the total of the selected column in the 2D array.
	 * 
	 * @param data A 2D array of doubles.
	 * @param col The index of the column whose total is to be calculated.
	 * @return The total of the specified column.
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double sum = 0;
		for (int row = 0; row < data.length; row++) {
			if (data[row].length <= col)
				continue;
			sum += data[row][col];
		}
		return sum;
	}

	/**
	 * Returns the total of the selected row in the 2D array.
	 * 
	 * @param data A 2D array of doubles.
	 * @param row The index of the row whose total is to be calculated.
	 * @return The total of the specified row.
	 */
	public static double getRowTotal(double[][] data, int row) {
		double sum = 0;
		for (int col = 0; col < data[row].length; col++) {
			sum += data[row][col];
		}
		return sum;
	}
	
	/**
	 * Returns the total sum of all the elements in the 2D array.
	 * 
	 * @param data A 2D array of doubles.
	 * @return The total sum of all the elements in the 2D array.
	 */
	public static double getTotal(double[][] data) {
		double sum = 0;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				sum += data[row][col];
			}
		}
		return sum;
	}

	/**
	 * Returns the largest element of the selected column in the 2D array.
	 * 
	 * @param data A 2D array of doubles.
	 * @param col The index of the column whose largest element is to be found.
	 * @return The largest value in the specified column.
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = -Double.MAX_VALUE;
		for (int row = 0; row < data.length; row++) {
			if (data[row].length <= col)
				continue;
			if (data[row][col] > highest)
				highest = data[row][col];
		}
		return highest;
	}
	
	/**
	 * Returns the largest element's index of the selected column in the 2D array.
	 * 
	 * @param data A 2D array of doubles.
	 * @param col The index of the column whose largest element is to be found.
	 * @return The largest value's index in the specified column.
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highest = -Double.MAX_VALUE;
		int index = -1;
		for (int row = 0; row < data.length; row++) {
			if (data[row].length <= col)
				continue;
			if (data[row][col] > highest) {
				highest = data[row][col];
				index = row;
			}
		}
		return index;
	}
	
	/**
	 * Returns the largest element of the selected row in the 2D array.
	 * 
	 * @param data A 2D array of doubles.
	 * @param row The index of the row whose largest element is to be found.
	 * @return The largest value in the specified row.
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest = -Double.MAX_VALUE;
		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] > highest)
				highest = data[row][col];
		}
		return highest;
	}
	
	/**
	 * Returns the largest element's index of the selected row in the 2D array.
	 * 
	 * @param data A 2D array of doubles.
	 * @param row The index of the row whose largest element is to be found.
	 * @return The largest value's index in the specified row.
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest = -Double.MAX_VALUE;
		int index = 0;
		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] > highest) {
				highest = data[row][col];
				index = col;
			}
		}
		return index;
	}
	
	/**
	 * Returns the largest element of the 2D array.
	 * 
	 * @param data A 2D array of doubles.
	 * @return The largest value in the 2D array.
	 */
	public static double getHighestInArray(double[][] data) {
		double highest = -Double.MAX_VALUE;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {	
				if (data[row][col] > highest)
					highest = data[row][col];
			}
		}
		return highest;
	}
	
	/**
	 * Returns the smallest element of the 2D array.
	 * 
	 * @param data A 2D array of doubles.
	 * @return The smallest value in the 2D array.
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest = Double.MAX_VALUE;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] < lowest)
					lowest = data[row][col];
			}
		}
		return lowest;
	}
	
	/**
	 * Returns the smallest element of the selected column in the 2D array.
	 * 
	 * @param data A 2D array of doubles.
	 * @param col The index of the column whose smallest element is to be found.
	 * @return The smallest value in the specified column.
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = Double.MAX_VALUE;
		for (int row = 0; row < data.length; row++) {
			if (data[row].length <= col)
				continue;
			if (data[row][col] < lowest)
				lowest = data[row][col];
		}
		return lowest;
	}
	
	/**
	 * Returns the smallest element's index of the selected column in the 2D array.
	 * 
	 * @param data A 2D array of doubles.
	 * @param col The index of the column whose smallest element is to be found.
	 * @return The smallest value's index in the specified column.
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowest = Double.MAX_VALUE;
		int index = 0;
		for (int row = 0; row < data.length; row++) {
			if (data[row].length <= col)
				continue;
			if (data[row][col] < lowest) {
				lowest = data[row][col];
				index = row;
			}
		}
		return index;
	}
	
	/**
	 * Returns the smallest element of the selected row in the 2D array.
	 * 
	 * @param data A 2D array of doubles.
	 * @param row The index of the row whose smallest element is to be found.
	 * @return The smallest value in the specified row.
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = Double.MAX_VALUE;
		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] < lowest)
				lowest = data[row][col];
		}
		return lowest;
	}
	
	/**
	 * Returns the smallest element's index of the selected row in the 2D array.
	 * 
	 * @param data A 2D array of doubles.
	 * @param row The index of the row whose smallest element is to be found.
	 * @return The smallest value's index in the specified row.
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowest = Double.MAX_VALUE;
		int index = 0;
		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] < lowest) {
				lowest = data[row][col];
				index = col;
			}
		}
		return index;
	}
	
}
