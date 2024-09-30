import java.util.Scanner;

/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: 1000-1140 Morning Class
 * Due: 10/02/2024
 * Platform/compiler: Ubuntu Linux / JDK 21
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: David Wery
*/

public class MovieDriver_Task1 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Movie movie = new Movie();
		
		System.out.println("Enter the name of the movie");
		movie.setTitle(input.nextLine());
		System.out.println("Enter the rating of the movie");
		movie.setRating(input.nextLine());
		System.out.println("Enter the number of tickets sold for this movie");
		movie.setSoldTickets(input.nextInt());
		input.nextLine();
		System.out.println(movie.toString());

		System.out.println("Goodbye");
		input.close();
	}
	
}
