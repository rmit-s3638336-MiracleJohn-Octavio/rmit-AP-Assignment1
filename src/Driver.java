import java.io.IOException;
import java.util.Scanner;

public class Driver {

// ---------- Variables
	
	// Make sure you use only 1 scanner call for console apps
	static Scanner scanner = new Scanner(System.in);	
	static String arrMenuOptionsSports[]= {
			"[ 1 ] - Swimming",
			"[ 2 ] - Cycling",
			"[ 3 ] - Running",
			"~",
			"[ 0 ] - Exit"
			};
	static String arrMenuOptionsYesNo[]= {
			"[ 1 ] - Yes",			
			"[ 0 ] - No"
			};
	
	private int userPrediction = 0;
	private enum enumSport {
		Swimming,
		Cycling,
		Running;
	}
	
// ---------- Main Methods
	
	public static void main(String[] args) {
			
		// Local Variables		
	    int choice;
	    boolean exitLoop;
	    
	    //Begin Infinite Loop
	    while (true) {	    	
	    	
	    	// Reset 
	    	exitLoop  = false;

	    	// Display
	    	displayMenu("Ozlympic Games MENU", arrMenuOptionsSports);	    	
	    	choice = scanner.nextInt();
	    	
	    	// Choices
	    	switch (choice) {
	        case 1:
	        	selectAthlete(enumSport.Swimming);
	            break;
	        case 2:
	        	selectAthlete(enumSport.Cycling);
	        	break;
	        case 3:
	        	selectAthlete(enumSport.Swimming);
	        	break;
	        case 0:
	        	if (exitGame()) {
	        		// Close the scanner object
	        		exitLoop = true;
//		        	scanner.close();
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
	
	static void selectAthlete(enumSport lenumSport) {
		if (lenumSport == enumSport.Swimming) {
			
		} else if (lenumSport == enumSport.Cycling) {
			
		} else if (lenumSport == enumSport.Running) {
			
		}
	}
	
// ---------- Sub Methods
	
	static boolean exitGame() {
		
		// Local Variables
		boolean returnValue = false;
		int intChoice;
	    
	    while (true) {
	    	
	    	// Display the Menu	    		    	
	    	displayMenu("Do you want to EXIT Ozlympic Games?", arrMenuOptionsYesNo);
	    	
	    	// Get the input
	    	intChoice = scanner.nextInt();
	    	
	    	if (intChoice == 1) {
	    		// If the user confirmed to exit (Noo!)
	    		displayMessageBox("Thank you for using Ozlympic Games!!!");	    		
	    		returnValue = true;
	    		break;
	    	} else if (intChoice == 0) {
	    		// If the user decided not to exit the program (Yey!)
	    		returnValue = false;
	    		break;
	    	} else {
	    		// Display invalid key choice
	    		displayMessagePrompt("You have selected an invalid choice!");	    		
	    	}	    	
	    }
	    // Return the value
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

	// Display
	
	static int _intMenuWidth = 50;	
	static void displayMenu(String strMenuTitle, String arrMenuOptions[]) {
		// Pattern
    	// 			 1         2         3         4         5
		//  12345678901234567890123456789012345678901234567890
		// "+------------------------------------------------+");
		// "|               Ozlympic Games MENU              |");
		// "+------------------------------------------------+");
		// "| [ 1 ] - Swimming                               |");
		// "| [ 2 ] - Cycling                                |");
		// "| [ 3 ] - Running                                |");
		// "+------------------------------------------------+");
		// "| [ 0 ] - Exit                                   |");
		// "+------------------------------------------------+");
		// "Select the number of your choice (Type Below):");		
		
		clearScreen();
		displayMenuTitle(strMenuTitle);
		displayMenuOptions(arrMenuOptions);
		displaySeparator();
		printIt("Select the number of your choice (Type Below):");
	}	
	static void displayMenuTitle(String strMessage) {
		displaySeparator();
		printIt("|" + padCenter(strMessage, _intMenuWidth-2) + "|");
		displaySeparator();
	}
	static void displayMenuOptions(String arrValue[]) {
		for (int i = 0; i < arrValue.length; i++) {
			if (arrValue[i] == "~") {
				displaySeparator();
			} else {
				printIt("| " + padRight(arrValue[i], _intMenuWidth-4) + " |");	
			}	
		}
	}
	
	static void displaySeparator() {
		printIt("+" + strReplicate("-", _intMenuWidth-2) + "+");
	}
	
	static void displayMessageBox(String strMessage) {		
		// Display the Message
		clearScreen();
		displaySeparator();
		printIt("|" + padCenter(strMessage, _intMenuWidth-2) + "|");
		displaySeparator();
	}
	
	static void displayMessagePrompt(String strMessage) {
		// Display the Prompt
		clearScreen();
		displaySeparator();
		printIt("|" + padCenter(strMessage, _intMenuWidth-2) + "|");
		displaySeparator();
		
		// Display press <Enter> to continue
    	pressAnyKey();
	}
	
	static void printIt(String strValue) {
		System.out.println(strValue);
	}
	
	// Justify
	
	public static String padRight(String str, int num) {
	    return String.format("%1$-" + num + "s", str);
	}
	
	public static String padLeft(String str, int num) {
	    return String.format("%1$" + num + "s", str);
	}
	
	public static String padCenter(String strValue, double dblTotalLength) {
		String returnValue = "";
		
		// Get the length of the String
		double dblStringLength = strValue.length();		
		// Get the difference then divide it with 2
		double dblSpace = (dblTotalLength - dblStringLength) / 2;
		// Convert it to int
		int intSpace = (int) dblSpace;
				
		// Get the number of space for leading and trailing
		String strSpace = "";
		for (int i = 0; i < intSpace; i++) {
			strSpace += " ";
		}
		
		if (
			(isEven((int)dblTotalLength) && isEven((int)dblStringLength)) || 
			(!isEven((int)dblTotalLength) && !isEven((int)dblStringLength))) {
			
			// If both Lengths are Odd or Even, then add space equally
			returnValue = strSpace + strValue + strSpace;
			
		} else {
			
			// Otherwise, add one space on leading
			returnValue = " " + strSpace + strValue + strSpace;
			
		}
		
	    return  returnValue;
	}
	
	// String
	
	public static String strReplicate(String strValue, int intCount) {
		String strReturnValue = "";
		
		for (int i = 0; i < intCount; i++) {
			strReturnValue += strValue;
		}
	
		return strReturnValue;
	}
	
	// Validation
	
	public static boolean isEven(int intValue) {
		// Declare Variable
		boolean returValue = false;
		
		// Check if the value is odd or even
		if (intValue % 2 == 0) {
			returValue = true;
		}
		
		// Return the value
		return returValue;
	}
	
}
