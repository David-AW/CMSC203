
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

public class ManagementCompany {

	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;
	
	private String name, taxID;
	private double mgmtFee;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;
	
	public ManagementCompany() {
		properties = new Property[MAX_PROPERTY];
		this.name = "";
		this.taxID = "";
		this.mgmtFee = 0;
		numberOfProperties = 0;
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
	}
	
	public ManagementCompany(String name, String taxID, double mgmtFee) {
		properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmtFee = mgmtFee;
		numberOfProperties = 0;
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
	}
	
	public ManagementCompany(String name, String taxID, double mgmtFee, int x, int y, int width, int depth) {
		this(name, taxID, mgmtFee);
		plot = new Plot(x,y,width,depth);
	}
	
	public ManagementCompany(ManagementCompany company) {
		properties = new Property[MAX_PROPERTY];
		for (int i = 0; i < MAX_PROPERTY; i++) 
			if (company.properties[i] != null)
				properties[i] = new Property(company.getProperties()[i]);
		
		name = company.name;
		taxID = company.taxID;
		mgmtFee = company.mgmtFee;
		numberOfProperties = company.numberOfProperties;
		plot = new Plot(company.getPlot());
	}
	
	public int addProperty(Property property) {
		if (numberOfProperties >= MAX_PROPERTY)
			return -1;
		if (property == null)
			return -2;
		if (!plot.encompasses(property.getPlot()))
			return -3;
		for (int i = 0; i < MAX_PROPERTY; i++)
			if (properties[i] != null)
				if (properties[i].getPlot().overlaps(property.getPlot()))
					return -4;
		properties[numberOfProperties] = property;
		return numberOfProperties++;
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		return addProperty(new Property(name, city, rent, owner));
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	}

	public void removeLastProperty() {
		properties[numberOfProperties-1] = null;
		numberOfProperties--;
	}
	
	public boolean isPropertiesFull() {
		return numberOfProperties >= MAX_PROPERTY;
	}
	
	public Property[] getProperties() {
		return properties;
	}

	public double getTotalRent() {
		double rent = 0.0;
		for (int i = 0; i < MAX_PROPERTY; i++)
			if (properties[i] != null)
				rent += properties[i].getRentAmount();
		return rent;
	}
	
	public Property getHighestRentPropperty() {
		double top_rent = 0.0;
		Property property = null;
		for (int i = 0; i < MAX_PROPERTY; i++)
			if (properties[i] != null)
				if (properties[i].getRentAmount() > top_rent) {
					top_rent = properties[i].getRentAmount();
					property = properties[i];
				}
		return property;
	}

	public Plot getPlot() {
		return plot;
	}

	public int getPropertiesCount() {
		return numberOfProperties;
	}
	
	public double getMgmFeePer() {
		return mgmtFee;
	}
	
	public boolean isManagementFeeValid() {
		return mgmtFee >= 0 && mgmtFee <= 100;
	}
	
	public String getName() {
		return name;
	}

	public String getTaxID() {
		return taxID;
	}

	@Override
	public String toString() {
		String temp = "List of the properties for " + name + ", taxID: " + taxID + "\n" 
				+ "______________________________________________________\n";
		for (Property property : properties)
			if (property != null)
				temp += property + "\n";
		temp += "______________________________________________________\n"
				+ "\n"
				+ " total management Fee: " + (mgmtFee * getTotalRent() / 100);
		return temp;
	}
	
}
