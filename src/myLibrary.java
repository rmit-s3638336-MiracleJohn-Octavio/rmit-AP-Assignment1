import java.io.IOException;
import java.util.Random;

public class myLibrary {

// --- Variables	
	
	// Constants
	static final int _intMENU_WIDTH = 55;
	
	static final String _strSWIMMER = "Swimmer";
	static final String _strCYCLIST = "Cyclist";
	static final String _strSPRINTER = "Sprinter";
	static final String _strSUPER = "Super";
	
	// Enums
	static enum _enmGame {
		Swimming,
		Cycling,
		Running;
	}
	
// --- Menu | Message Box
	
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
		// "Type the code of your choice below:";
		
		clearScreen();
		displayMenuTitle(strMenuTitle);
		displayMenuOptions(arrMenuOptions);
		displaySeparator();
		printIt("Type the code of your choice below:");
	}	
	static void displayMenuPrompt(String strMenuTitle, String arrMenuOptions[]) {
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
		// "Type the code of your choice below:";
		
		clearScreen();
		displayMenuTitle(strMenuTitle);
		displayMenuOptions(arrMenuOptions);
		displaySeparator();
		
		// Display press <Enter> to continue
    	pressAnyKey();
	}	
	static void displayMenuTitle(String strMessage) {
		displaySeparator();
		printIt("|" + padCenter("** Ozlympic Game **", _intMENU_WIDTH-2) + "|");
		printIt("|" + padRight(" " + strMessage, _intMENU_WIDTH-2) + "|");
		displaySeparator();
	}
	static void displayMenuOptions(String arrValue[]) {
		for (int i = 0; i < arrValue.length; i++) {
			String value = arrValue[i];
			String tilde = "~";
			if ( value.equals(tilde)) {
				displaySeparator();
			} else {
				printIt("| " + padRight(value, _intMENU_WIDTH-4) + " |");	
			}	
		}
	}
	
	static void displaySeparator() {
		printIt("+" + strReplicate("-", _intMENU_WIDTH-2) + "+");
	}
	
	static void displayMessageBox(String strMessage) {		
		// Display the Message
		clearScreen();
		displaySeparator();
		printIt("|" + padCenter(strMessage, _intMENU_WIDTH-2) + "|");
		displaySeparator();
	}
	
	static void displayMessagePrompt(String strMessage) {
		// Display the Prompt
		clearScreen();
		displaySeparator();
		printIt("|" + padCenter(strMessage, _intMENU_WIDTH-2) + "|");
		displaySeparator();
		
		// Display press <Enter> to continue
    	pressAnyKey();
	}
	
	static void printIt(String strValue) {
		System.out.println(strValue);
	}
	
	static void clearScreen() {
		for (int i = 1; i < 5; i++) {
    		System.out.println("");	
		}		
	}
	
// --- Justify
	
	static String padRight(String strValue, int intCount) {
	    return String.format("%1$-" + intCount + "s", strValue);
	}
	
	static String padLeft(String strValue, int intCount) {
	    return String.format("%1$" + intCount + "s", strValue);
	}
	
	static String padCenter(String strValue, int intCount) {
		String returnValue = "";
		
		// Get the length of the String
		double dblStringLength = strValue.length();		
		// Get the difference then divide it with 2
		double dblSpace = ((double)intCount - dblStringLength) / 2;
		// Convert it to int
		int intSpace = (int) dblSpace;
				
		// Get the number of space for leading and trailing
		String strSpace = "";
		for (int i = 0; i < intSpace; i++) {
			strSpace += " ";
		}
		
		if (
			(isEven(intCount) && isEven((int)dblStringLength)) || 
			(!isEven(intCount) && !isEven((int)dblStringLength))) {
			
			// If both Lengths are Odd or Even, then add space equally
			returnValue = strSpace + strValue + strSpace;
			
		} else {
			
			// Otherwise, add one space on leading
			returnValue = " " + strSpace + strValue + strSpace;
			
		}
		
	    return  returnValue;
	}
	
// --- String
	
	static String strReplicate(String strValue, int intCount) {
		String strReturnValue = "";
		
		for (int i = 0; i < intCount; i++) {
			strReturnValue += strValue;
		}
	
		return strReturnValue;
	}
	
	static int getRandomNumber(int intMin, int intMax) {

		if (intMin >= intMax) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((intMax - intMin) + 1) + intMin;
	}
	
// --- Validation
	
	static boolean isEven(int intValue) {
		// Declare Variable
		boolean returValue = false;
		
		try {
			// Check if the value is odd or even
			if (intValue % 2 == 0) {
				returValue = true;
			}	
		} catch (Exception e) {
			printIt(e.getMessage());
		}
		
		// Return the value
		return returValue;
	}

// --- I/O
	
	static void pressAnyKey() {
		System.out.println("Press <Enter> key to continue!");
    	try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}    	
	}
}
