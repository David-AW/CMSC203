
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

public final class Coffee extends Beverage {

	private final double EXTRA_SHOT_PRICE = 0.5, EXTRA_SYRUP_PRICE = 0.5;
	private final boolean EXTRA_SHOT;
	private final boolean EXTRA_SYRUP;

	public Coffee(String beverage_name, Size size, boolean extra_shot, boolean extra_syrup) {
		super(beverage_name, Type.COFFEE, size);
		this.EXTRA_SHOT = extra_shot;
		this.EXTRA_SYRUP = extra_syrup;
	}

	/**
	 * @return true if has extra shot
	 */
	public final boolean getExtraShot() {
		return EXTRA_SHOT;
	}

	/**
	 * @return true if has extra syrup
	 */
	public final boolean getExtraSyrup() {
		return EXTRA_SYRUP;
	}

	@Override
	public String toString() {
		return super.toString() + ", extra shot: " + (EXTRA_SHOT ? "yes" : "no") + ", extra syrup: "
				+ (EXTRA_SYRUP ? "yes" : "no") + ", $" + calcPrice();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Coffee) {
			Coffee other = (Coffee) o;
			return super.equals(other) && this.EXTRA_SHOT == other.EXTRA_SHOT && this.EXTRA_SYRUP == other.EXTRA_SYRUP;
		}
		return false;
	}

	/**
	 * @return the price of the coffee accounting for size and extras
	 */
	@Override
	public double calcPrice() {
		return addSizePrice() + (EXTRA_SHOT ? EXTRA_SHOT_PRICE : 0) + (EXTRA_SYRUP ? EXTRA_SYRUP_PRICE : 0);
	}

}
