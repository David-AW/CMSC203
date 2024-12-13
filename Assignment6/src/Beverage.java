
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

public abstract class Beverage {

	private final String name;
	private final Type type;
	private final Size size;
	private final double BASE_PRICE = 2;
	private final double SIZE_PRICE = 0.5;

	public Beverage(String beverage_name, Type type, Size size) {
		name = beverage_name;
		this.type = type;
		this.size = size;
	}

	public final double addSizePrice() {
		return BASE_PRICE + SIZE_PRICE * size.ordinal();
	}

	public abstract double calcPrice();

	public final double getBasePrice() {
		return BASE_PRICE;
	}

	/**
	 * @return the name of the beverage
	 */
	public final String getBevName() {
		return name;
	}

	/**
	 * @return the type of beverage
	 */
	public final Type getType() {
		return type;
	}

	/**
	 * @return the size of beverage
	 */
	public final Size getSize() {
		return size;
	}

	@Override
	public String toString() {
		return name + ", " + size;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Beverage) {
			Beverage other = (Beverage) obj;
			return other.name.equals(this.name) && other.type == this.type && other.size == this.size;
		}
		return false;
	}

}
