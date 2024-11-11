
/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: 1000-1140 Morning Class
 * Due: 11/11/2024
 * Platform/compiler: Ubuntu Linux / JDK 21
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: David Wery
*/

public class Property {
	
	String propertyName, city, owner;
	double rentAmount = 0.0;
	Plot plot;
	
	public Property() {
		propertyName = "";
		city = "";
		owner = "";
		plot = new Plot();
	}

	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		plot = new Plot(x,y,width,depth);
	}
	
	public Property(Property property) {
		propertyName = property.propertyName;
		city = property.city;
		owner = property.owner;
		rentAmount = property.rentAmount;
		plot = new Plot(property.plot);
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	public String getCity() {
		return city;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public double getRentAmount() {
		return rentAmount;
	}
	
	@Override
	public String toString() {
		return propertyName+","+city+","+owner+","+rentAmount;
	}
	
}
