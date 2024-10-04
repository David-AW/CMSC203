
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

public class Patient {

	private String first_name = "Jenny", middle_name = "Elaine", last_name = "Santori";
	private String address = "123 Main Street", city = "MyTown", state = "CA", zip_code = "01234";
	private String phone_number = "301-123-4567";
	private String emergency_contact_name = "Bill Santori", emergency_contact_number = "777-555-1212";

	public Patient() {
		// No-args constructor, values pre-initialized.
	}
	
	public Patient(String first_name, String middle_name, String last_name) {
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
	}
	
	public Patient(String first, String middle, String last, String address, String city, String state, String zip, String phone, String ec_name, String ec_number) {
		this.first_name = first;
		this.middle_name = middle;
		this.last_name = last;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip_code = zip;
		this.phone_number = phone;
		this.emergency_contact_name = ec_name;
		this.emergency_contact_number = ec_number;
	}
	
	public String buildFullName() {
		return first_name + " " + middle_name + " " + last_name;
	}
	
	public String buildAddress() {
		return address + " " + city + " " + state + " " + zip_code;
	}
	
	public String buildEmergencyContact() {
		return emergency_contact_name + " " + emergency_contact_number;
	}
	
	@Override
	public String toString() {
		return    "  Name: " + buildFullName() + "\n"
				+ "  Address: " + buildAddress() + "\n"
				+ "  EmergencyContact: " + buildEmergencyContact();
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public String getMiddleName() {
		return middle_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public String getPhoneNumber() {
		return phone_number;
	}
	
	public String getEmergencyContactName() {
		return emergency_contact_name;
	}
	
	public String getEmergencyContactNumber() {
		return emergency_contact_number;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZipCode() {
		return zip_code;
	}
	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public void setMiddleName(String middle_name) {
		this.middle_name = middle_name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public void setEmergencyContactName(String emergency_contact_name) {
		this.emergency_contact_name = emergency_contact_name;
	}
	
	public void setEmergencyContactNumber(String emergency_contact_number) {
		this.emergency_contact_number = emergency_contact_number;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}
	
}
