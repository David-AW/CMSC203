
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

public class HolidayBonus {

	/**
	 * Returns an array of holiday bonuses calculated from the provided 2D array.
	 * 
	 * @param data A 2D array of doubles.
	 * @return double array of holiday bonuses.
	 */
	public static double[] calculateHolidayBonus(double[][] data) {
		double[] bonuses = new double[data.length];
		
		for (int row = 0; row < bonuses.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] <= 0)
					continue;
				if (TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col) == row)
					bonuses[row] += 5000;
				else if (TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col) == row)
					bonuses[row] += 1000;
				else 
					bonuses[row] += 2000;
			}
		}
		return bonuses;
	}
	
	/**
	 * Returns the total amount of holiday bonus money.
	 * 
	 * @param data A 2D array of doubles.
	 * @return total amount of holiday bonuses.
	 */
	public static double calculateTotalHolidayBonus(double[][] data) {
		double[] bonuses = calculateHolidayBonus(data);
		double sum = 0;
		for (double bonus : bonuses)
			sum += bonus;
		return sum;
	}
	
}
