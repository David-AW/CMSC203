
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

public final class Alcohol extends Beverage {

	private final boolean SOLD_ON_WEEKEND; // Up to interpretation, but this should not change because the day it was
											// sold should be constant
	private final double WEEKEND_FEE = 0.6;

	public Alcohol(String beverage_name, Size size, boolean sold_on_weekend) {
		super(beverage_name, Type.ALCOHOL, size);
		this.SOLD_ON_WEEKEND = sold_on_weekend;
	}

	@Override
	public String toString() {
		return super.toString() + ", offered on weekend: " + (SOLD_ON_WEEKEND ? "yes" : "no") + ", $" + calcPrice();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Alcohol) {
			Alcohol other = (Alcohol) obj;
			return super.equals(other) && this.SOLD_ON_WEEKEND == other.SOLD_ON_WEEKEND;
		}
		return false;
	}

	/**
	 * @return true if this beverage was sold on the weekend
	 */
	public boolean isWeekend() {
		return SOLD_ON_WEEKEND;
	}

	@Override
	public double calcPrice() {
		return addSizePrice() + (SOLD_ON_WEEKEND ? WEEKEND_FEE : 0);
	}

}
