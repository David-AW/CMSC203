
/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: 1000-1140 Morning Class
 * Due: 10/04/2024
 * Platform/compiler: Ubuntu Linux / JDK 21
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: David Wery
*/

public class Procedure {

	private String procedure_name;
	private String date;
	private String doctors_name;
	private double price;
	
	public Procedure() {
		procedure_name = "Physical Exam";
		date = "10/04/2024";
		doctors_name = "Dr. Irvine";
		price = 3250.0;
	}
	
	public Procedure(String procedure_name, String date) {
		this.procedure_name = procedure_name;
		this.date = date;
		doctors_name = "Dr. Jamison";
		price = 5500.43;
	}
	
	public Procedure(String procedure_name, String date, String doctors_name, double price) {
		this.procedure_name = procedure_name;
		this.date = date;
		this.doctors_name = doctors_name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return    "\tProcedure: " + procedure_name + "\n"
				+ "\tProcedureDate=" + date + "\n"
				+ "\tPractitioner="+doctors_name + "\n"
				+ "\tCharge="+price;
	}
	
	public String getProcedureName() {
		return procedure_name;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getDoctorsName() {
		return doctors_name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setProcedureName(String procedure_name) {
		this.procedure_name = procedure_name;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setDoctorsName(String doctors_name) {
		this.doctors_name = doctors_name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
}
