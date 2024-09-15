/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: 1000-1140 Morning Class
 * Due: 09/18/2024
 * Platform/compiler: Ubuntu Linux / JDK 21
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: David Wery
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class ESPGame {

	public static void main(String[] args) {
		
		Scanner player_input = new Scanner(System.in);
		File file;
		Random rng = new Random();
		
		System.out.println("CMSC203 Assignment 1: Test your ESP skills!");
		
		// Keep asking for file until a valid file is presented.
		do {
			System.out.print("Enter the filename: ");
			file = new File(player_input.nextLine());
		} while(!file.exists());
		
		try {
			Scanner file_scanner = new Scanner(file);
			
			System.out.println("There are sixteen colors from a file:");
			
			while (file_scanner.hasNextLine()) {
				System.out.println(file_scanner.nextLine());
			}
			file_scanner.close();
			
			/*
			 *	------------------
			 *  	GAME LOOP
			 * 	------------------
			 */
			
			int cpu_num;
			int correct_guesses = 0;
			String player_guess, cpu_guess;
			
			for (int round = 1; round <= 3; round++) {
				cpu_num = rng.nextInt(0, 16);
				
				System.out.println("Round " + round + "\n");
				System.out.println("I am thinking of a color.");
				System.out.println("Is it one of the colors listed above?");
				System.out.println("Enter your guess:");
				player_guess = player_input.nextLine();
				
				// Working around not using Array for this
				file_scanner = new Scanner(file);
				for (int skip = 0; skip < cpu_num; skip++) {
					file_scanner.nextLine(); // skip every line before cpu_num
				}
				cpu_guess = file_scanner.nextLine();
				cpu_guess = cpu_guess.substring(cpu_guess.indexOf(" ")+1); //Format number out of string
				file_scanner.close();
				
				System.out.println();
				System.out.println("I was thinking of " + cpu_guess + ".");
				
				if (cpu_guess.trim().equalsIgnoreCase(player_guess.trim())) correct_guesses++;
			}
			
			System.out.println("Game Over\n");
			System.out.println("You guessed " + correct_guesses + " out of 3 colors correctly.");
			
			/*
			 *	------------------
			 *  	PLAYER INFO
			 * 	------------------
			 */
			
			System.out.print("Enter your name: ");
			String name = player_input.nextLine();
			System.out.print("Describe yourself: ");
			String desc = player_input.nextLine();
			System.out.print("Due Date MM/DD: ");
			String date = player_input.nextLine();
			
			System.out.println("User Name: " + name);
			System.out.println("User Description: " + desc);
			System.out.println("Date: " + date);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Exiting program.");
		}
		
		player_input.close();
	}

}
