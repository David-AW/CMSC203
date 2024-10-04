
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

public class PatientDriverApp {

	public static void main(String[] args) {
		Patient patient = new Patient();
		
		Procedure proc1 = new Procedure();
		Procedure proc2 = new Procedure("X-ray", "10/04/2024");
		Procedure proc3 = new Procedure("Blood Test", "10/04/2024", "Dr. Smith", 1400.75);
		
		System.out.println("Patient Info:");
		displayPatient(patient);
		displayProcedure(proc1);
		displayProcedure(proc2);
		displayProcedure(proc3);
		System.out.println("Total Charges: $" + calculateTotalCharges(proc1, proc2, proc3) + "\n");
		System.out.println("Student Name: David Wery");
		System.out.println("MC#: MC777777"); // I'm not posting my MC number on GitHub.
		System.out.println("Due Date: 10/04/2024");
	}

	public static void displayPatient(Patient patient) {
		System.out.println(patient.toString() + "\n");
	}
	
	public static void displayProcedure(Procedure procedure) {
		System.out.println(procedure.toString() + "\n");
	}
	
	public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
		return p1.getPrice() + p2.getPrice() + p3.getPrice();
	}
	
}
