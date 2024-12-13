
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

public final class Smoothie extends Beverage {

	private final int NUM_OF_FRUIT;
	private final boolean ADDED_PROTEIN;
	private final double PRICE_PER_FRUIT = 0.5, PRICE_FOR_PROTEIN = 1.5;

	public Smoothie(String beverage_name, Size size, int num_of_fruits, boolean add_protein) {
		super(beverage_name, Type.SMOOTHIE, size);
		this.NUM_OF_FRUIT = num_of_fruits;
		this.ADDED_PROTEIN = add_protein;
	}

	@Override
	public String toString() {
		return super.toString() + ", has protein: " + (ADDED_PROTEIN ? "yes" : "no") + ", number of fruits: "
				+ NUM_OF_FRUIT + ", $" + calcPrice();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Smoothie) {
			Smoothie other = (Smoothie) obj;
			return super.equals(other) && this.NUM_OF_FRUIT == other.NUM_OF_FRUIT
					&& this.ADDED_PROTEIN == other.ADDED_PROTEIN;
		}
		return super.equals(obj);
	}

	public boolean getAddProtein() {
		return ADDED_PROTEIN;
	}

	public int getNumOfFruits() {
		return NUM_OF_FRUIT;
	}

	@Override
	public double calcPrice() {
		return addSizePrice() + (NUM_OF_FRUIT * PRICE_PER_FRUIT) + (ADDED_PROTEIN ? PRICE_FOR_PROTEIN : 0);
	}

}
