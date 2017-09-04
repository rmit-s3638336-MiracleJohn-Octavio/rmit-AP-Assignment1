import java.io.IOException;
import java.util.Scanner;

public class Main {

	int userPrediction = 0;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	    int choice;
	    boolean exitLoop;
	    
	    while (true) {	    	
	    	
	    	// Reset 
	    	exitLoop  = false;
	    	
	    	System.out.println("");
	    	System.out.println("+-----------------------------------------------+");
	    	System.out.println("|               Ozlympic Games MENU             |");
	    	System.out.println("+-----------------------------------------------+");
	    	System.out.println("| [ 1 ] - Swimming                              |");
	    	System.out.println("| [ 2 ] - Cycling                               |");
	    	System.out.println("| [ 3 ] - Running                               |");
	    	System.out.println("+-----------------------------------------------+");
	    	System.out.println("| [ 0 ] - Exit                                  |");
	    	System.out.println("+-----------------------------------------------+");
	    	System.out.println("Select the number of your choice (Type Below):");
	    
	    	choice = scanner.nextInt();
	    	
	    	switch (choice) {
	        case 1:
	            System.out.println("You have selected 1");
	            break;
	        case 2:
	        	System.out.println("You have selected 2");
	        	break;
	        case 3:
	        	System.out.println("You have selected 3");
	        	break;
	        case 0:
	        	if (exitGame()) {
	        		// Close the scanner object
	        		exitLoop = true;
		        	scanner.close();
	        	}
	        	break;
	        default:
	        	// Do Nothing
	    	}	

	    	if (exitLoop) { 
	    		// Exit the loop
	    		break;
	    	} else {
	    		// Clear the Screen
		    	clearScreen();	
	    	}
	    }
	}
	
	static boolean exitGame() {
		boolean returnValue = false;
		
		Scanner scanner = new Scanner(System.in);
	    int intChoice;
	    
	    while (true) {
	    	clearScreen();
	    	System.out.println("");
	    	System.out.println("+-----------------------------------------------+");
	    	System.out.println("|      Do you want to EXIT Ozlympic Games?      |");
	    	System.out.println("+-----------------------------------------------+");
	    	System.out.println("| [ 1 ] - Yes                                   |");
	    	System.out.println("| [ 0 ] - No                                    |");
	    	System.out.println("+-----------------------------------------------+");
	    	System.out.println("Select the number of your choice (Type Below):");
	    
	    	intChoice = scanner.nextInt();
	    	
	    	if (intChoice == 1) {
	    		clearScreen();
	    		System.out.println("+-----------------------------------------------+");
		    	System.out.println("|     Thank you for using Ozlympic Games!!!     |");
		    	System.out.println("+-----------------------------------------------+");
	        	 
	    		returnValue = true;
	    		break;
	    	} else if (intChoice == 0) {
	    		returnValue = false;
	    		break;
	    	} else {
	    		clearScreen();
	    		System.out.println("+-----------------------------------------------+");
		    	System.out.println("|     You have selected an invalid choice!      |");
		    	System.out.println("+-----------------------------------------------+");
	        	System.out.println("");
	        	pressAnyKey();
	    	}	    	
	    }
		
		return returnValue;
	}
	
	static void pressAnyKey() {
		System.out.println("Press <Enter> key to continue!");
    	try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	clearScreen();
	}
	
	static void clearScreen() {
		for (int i = 1; i < 50; i++) {
    		System.out.println("");	
		}
	}

}
