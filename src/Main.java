import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.sun.javafx.fxml.ParseTraceElement;

public class Main {

// ---------- Variables
	
	// Object | int
	static Scanner _objScanner = new Scanner(System.in); 		// Important: Should use only 1 scanner call
	
	static myLibrary._enmGame _enmSelectedGame;
	static String _strSelectedGame = "";
	static String _strSelectedAthlete = "";
	
	static String _strPredictedCode = "";
	static String _strPredictedName = "";
	
	// Array
	static String _arrMenuOptionMain[]= {
			"Code  | Description",
			"~",
			"[ 1 ] - Select a game to run",
			"[ 2 ] - Predict the winner of the game",
			"[ 3 ] - Start the game",
			"[ 4 ] - Display the final results of all games",
			"[ 5 ] - Display the points of all athletes",
			"~",
			"[ 6 ] - Exit"
			};	
	static String _arrMenuOptionGame[]= {
			"Code  | Description",
			"~",
			"[ 1 ] - Swimming",
			"[ 2 ] - Cycling",
			"[ 3 ] - Running",
			"~",
			"[ 0 ] - Back"
			};	
	static String _arrMenuOptionsYesNo[]= {
			"[ 1 ] - Yes",			
			"[ 0 ] - No"
			};
	// Array - Athlete Data
	static String _arrAthlete_Swimmer[][]= 
		{
			{"S1","Ian Thorpe","21","VIC"},
			{"S2","Dawn Fraser","23","VIC"},
			{"S3","Libby Trickett","24","QLD"},
			{"S4","David Theile","21","SA"}
		};
	static String _arrAthlete_Cyclist[][]= 
		{
			{"C1","Christopher Scott","21","VIC"},
			{"C2","Mark le Flohic","23","VIC"},
			{"C3","Greg Ball","24","QLD"},
			{"C4","Tyson Lawrence","21","SA"}		};
	static String _arrAthlete_Sprinter[][]= 
		{
			{"R1","Matt Shirvington","21","VIC"},
			{"R2","Patrick Johnson","23","VIC"},
			{"R3","Joshua Ross","24","QLD"},
			{"R4","Gerard Barrett","21","SA"}
		};
	static String _arrAthlete_Super[][]= 
		{
			{"X1","Craig Alexander","21","VIC"},
			{"X2","Greg Bennett","23","VIC"},
			{"X3","Chris McCormack","24","QLD"},
			{"X4","Luke McKenzie","21","SA"}
		};
	
	// Hashmap
	static HashMap<String, Athlete> _mapAthlete;				// This will hold all the Athletes
	 
	// Enum	
	private enum _enmSetSelection {
		SelectAll,
		ClearAll
	}
	
// ---------- Main Methods
	
	public static void main(String[] args) {

		// Load the array (athlete) to hashmap
	    loadAthleteToHashmap();	    
	    
	    // Start the Main Menu
	    mainMenu();
	}
	
	static void mainMenu() {
		// Local Variables
	    int intChoice;
	    boolean blnIsExitLoop;
	    
	    //Begin Infinite Loop
	    while (true) {	    	
	    	
	    	// Reset 
	    	blnIsExitLoop  = false;

	    	// Display
	    	String arrMenuOptionMain[] = {
	    			"Code  | Description",
	    			"~",
	    			"[ 1 ] - Select a game to run " + (_strSelectedGame == "" ? "" : "[ " + _strSelectedGame + " ]") + " ",
	    			"[ 2 ] - Predict the winner of the game " + (_strPredictedCode == "" ? "" : "[ " + _strPredictedCode + " ]") + " ",
	    			"[ 3 ] - Start the game",
	    			"[ 4 ] - Display the final results of all games",
	    			"[ 5 ] - Display the points of all athletes",
	    			"~",
	    			"[ 6 ] - Exit"
	    			};	
	    	_arrMenuOptionMain = arrMenuOptionMain;
	    	
	    	myLibrary.displayMenu("Select Menu to execute..", _arrMenuOptionMain);	    	
	    	intChoice = _objScanner.nextInt();	    	
	    	// Choices
	    	switch (intChoice) {
	        case 1:
	        	// Select a game to run
	        	selectGame();
	            break;
	        case 2:
	        	// Predict the winner of the game
	        	if (_strSelectedGame == "") {
	        		// Display invalid key choice
		    		myLibrary.displayMessagePrompt("Please choose 'Select a game to run' first!");
				} else {
					// Select the athlete and predict the winner
					selectAthlete();	
				}
	        	break;
	        case 3:
	        	// Start the game
	        	playGame();
	        	break;
	        case 6:
	        	if (isExitGame()) {
	        		// Exit the Loop
	        		blnIsExitLoop = true;
	        	}
	        	break;
	        default:
	        	// Display invalid key choice
	    		myLibrary.displayMessagePrompt("You have selected an invalid choice!");
	    	}	

	    	if (blnIsExitLoop) { 
	    		// intChoice = 6 	    		
	    		// Exit the loop
	    		break;	    		    		 	
	    	}
	    }
	}
	
 	static void selectGame() {
			
		// Local Variables
	    int intChoice;
	    boolean blnIsExitLoop;

	    //Begin Infinite Loop
	    while (true) {	    	
	    	
	    	// Reset 
	    	blnIsExitLoop  = false;
	    	// Reset Selected Athlete here

	    	// Display
	    	myLibrary.displayMenu("Select a game to run..", _arrMenuOptionGame);	    	
	    	intChoice = _objScanner.nextInt();	    	
	    	// Choices
	    	switch (intChoice) {
	        case 1:
	        	_enmSelectedGame = myLibrary._enmGame.Swimming;
	        	_strSelectedGame = "Swimming";
	        	_strSelectedAthlete = "Swimmer";
	        	blnIsExitLoop = true;
	            break;
	        case 2:
	        	_enmSelectedGame = myLibrary._enmGame.Cycling;
	        	_strSelectedGame = "Cycling";
	        	_strSelectedAthlete = "Cyclist";
	        	blnIsExitLoop = true;
	        	break;
	        case 3:
	        	_enmSelectedGame = myLibrary._enmGame.Running;
	        	_strSelectedGame = "Running";
	        	_strSelectedAthlete = "Sprinter";
	        	blnIsExitLoop = true;
	        	break;
	        case 0:
	        	// Exit the Loop
        		blnIsExitLoop = true;	        	
	        	break;
	        default:
	        	// Do Nothing
	    	}	

	    	if (blnIsExitLoop) { 
	    		// intChoice = 0,1,2,3 	    		
	    		// Exit the loop
	    		break;
	    	} else {
	    		// intChoice = 1,2,3 
	    		// Display invalid key choice
	    		myLibrary.displayMessagePrompt("You have selected an invalid choice!"); 	
	    	}
	    }
	}
	
	static void selectAthlete() {
		
		// Local Variables
		String strChoice;
		boolean blnIsExitLoop;

		while (true) {
			
			// Reset 
	    	blnIsExitLoop  = false;
		
	    	// Display the Athlete Menu
	    	createMenuAthlete();
			// Get the input
			strChoice = _objScanner.next();	    	
			strChoice = strChoice.toUpperCase();
	    	if (strChoice.equals("1")) {
	    		// If the user decided to select all selection
	    		setSelection(_enmSetSelection.SelectAll,_enmSelectedGame);
	    	} else if (strChoice.equals("2")) {
	    		// If the user decided to clear all selection
	    		setSelection(_enmSetSelection.ClearAll,_enmSelectedGame);
	    	} else if (strChoice.equals("3")) {
	    		// Predict the winner
	    		if (predictWinner()) {
	    			// If the user had predicted a winner go to Main
		    		blnIsExitLoop = true;
		    		break;
				}
	    	} else if (strChoice.equals("0")) {
	    		// If the user decided not to go back to Main Menu
	    		blnIsExitLoop = true;
	    		break;
	    	} else {
	    		if (isAthleteCodeValid(strChoice)) {
					// Do nothing 
				} else {
					// Display invalid key choice
		    		myLibrary.displayMessagePrompt("You have selected an invalid choice!");	
				}
	    	}	  
	    	
	    	if (blnIsExitLoop) { 
	    		// strChoice = "0" 	    		
	    		// Exit the loop
	    		break;
	    	} else {
	    		// strChoice = should be valid choice
	    		// Do nothing 	
	    	}
			
		} // Exit the Loop
	}
	
	static boolean predictWinner() {
		
		// Local Variables
		boolean blnReturnValue = false;
		String strChoice;
		boolean blnIsExitLoop;

		while (true) {
			
			// Reset 
	    	blnIsExitLoop  = false;
		
	    	// Display the Athlete Menu
	    	createMenuPredict();
			// Get the input
			strChoice = _objScanner.next();	    	
			strChoice = strChoice.toUpperCase();
	    	if (strChoice.equals("0")) {
	    		// If the user decided not to go back to Main Menu
	    		blnIsExitLoop = true;
	    		break;
	    	} else {
	    		if (isSelectedAthleteCodeValid(strChoice)) {
	    			blnReturnValue = true;
	    			blnIsExitLoop = true;
		    		break; 
				} else {
					// Display invalid key choice
		    		myLibrary.displayMessagePrompt("You have selected an invalid choice!");	
				}
	    	}	  
	    	
	    	if (blnIsExitLoop) { 
	    		// strChoice = "0" 	    		
	    		// Exit the loop
	    		break;
	    	} else {
	    		// strChoice = should be valid choice
	    		// Do nothing 	
	    	}
			
		} // Exit the Loop
		
		return blnReturnValue;

	}
	
	static void playGame() {
		
		try {
			
			// Sort the HashMap using TreeMap
			TreeMap<String, Athlete> treeAthlete = new TreeMap<>(_mapAthlete);		
			for(Entry<String, Athlete> entry : treeAthlete.entrySet()) {
				
				// Get the value and put it on local variable
				String type = entry.getValue().getType();
				String uid = entry.getValue().getUid();
				String name = entry.getValue().getName();
				boolean isSelected = entry.getValue().isSelected();
				
				// Generate Random Numbers
				if (isSelected && (type == _strSelectedAthlete || type == myLibrary._strSUPER)) {
					entry.getValue().compete(_enmSelectedGame);
					myLibrary.printIt(Integer.toString(entry.getValue().getCurrentSeconds()));
				}
			}
			
			// Get the winners
			int intLowest = getLowest(treeAthlete);
			int intHighest = getHighest(treeAthlete);
			String strWinner = "";
			int intRank = 1;
			String arrMenuOptions[] = {};								// Array that will hold the Menu Options
			
			String strDelimitedNames = 									         
					" Code  | " + myLibrary.padRight("Name of Athlete", 23) + " | Rank | Point"
							+ ","
				  + "~";
			
			for (int i = intLowest; i < intHighest; i++) {
				
				// Search the selected Athlete
				for(Entry<String, Athlete> entry : treeAthlete.entrySet()) {
					
					// Get the value and put it on local variable
					String type = entry.getValue().getType();
					String uid = entry.getValue().getUid();
					String name = entry.getValue().getName();
					boolean isSelected = entry.getValue().isSelected();
					int intCurrentSeconds = entry.getValue().getCurrentSeconds();
					
					int intPoints = 0;
					
					// If Found!
					if (intCurrentSeconds == i) {
						if (isSelected && (type == _strSelectedAthlete || type == myLibrary._strSUPER)) {						
							myLibrary.printIt(Integer.toString(entry.getValue().getCurrentSeconds()));
							
							if (intRank == 1) {
								intPoints = 5;
								strWinner = uid;
							} else if (intRank == 2) {
								intPoints = 2;
							} else if (intRank == 3) {
								intPoints = 1;								
							} 
							
							strDelimitedNames += ((strDelimitedNames != "") ? "," : "") 
									+ "[ " + uid+ " ] - " 
									+ myLibrary.padRight(name, 24) + "| " 
									+ Integer.toString(intRank) 
									+ myLibrary.padLeft("| ", 6) 
									+ Integer.toString(intPoints);
							
							if (intRank == 3) {
								strDelimitedNames += ",~";
							}
							
							// Increment
							intRank ++;
						}	
					}
				}
			}
			
			// Add the "Back" option to delimiter
			String strMessage = "";
			if (strWinner == _strPredictedCode) {
				strMessage = "Congratulations!";
			} else {
				strMessage = "Better luck next time!";
			}
			strDelimitedNames += ((strDelimitedNames != "") ? "," : "")
						+ "~,"
						+ "Prediction: " + _strPredictedCode +" - " + _strPredictedName + ","
						+ "Result: " + strMessage;
			
			myLibrary.printIt("Lowest: " + Integer.toString(intLowest) + "  Highest:  " + Integer.toString(intHighest) );
			
			// Split the delimited string and put it to an array
			arrMenuOptions = strDelimitedNames.split(",", -1);
			
			// Display the Menu
			myLibrary.displayMenuPrompt("The winners..", arrMenuOptions);
			
		} catch (Exception e) {
			myLibrary.printIt(e.getMessage());
		}	
	}
	
// ---------- Sub Methods
	
	static int getLowest(TreeMap<String, Athlete> treeMap) {
		
		// Variables
		int intReturnValue = 0;
		int intLowest = 1000;
		
		for(Entry<String, Athlete> entry : treeMap.entrySet()) {
			
			// Get the value and put it on local variable
			String type = entry.getValue().getType();
			String uid = entry.getValue().getUid();
			String name = entry.getValue().getName();
			boolean isSelected = entry.getValue().isSelected();
			int intCurrentSeconds = entry.getValue().getCurrentSeconds();
			
			if (isSelected && (type == _strSelectedAthlete || type == myLibrary._strSUPER)) {
				if (intCurrentSeconds < intLowest) {
					intLowest = intCurrentSeconds;
				}	
			}
						
		}
		
		// Return the value
		intReturnValue = intLowest;
		return intReturnValue;

	} 
	
	static int getHighest(TreeMap<String, Athlete> treeMap) {
		
		// Variables
		int intReturnValue = 0;
		int intHighest = 0;
		
		for(Entry<String, Athlete> entry : treeMap.entrySet()) {
			
			// Get the value and put it on local variable
			String type = entry.getValue().getType();
			String uid = entry.getValue().getUid();
			String name = entry.getValue().getName();
			boolean isSelected = entry.getValue().isSelected();
			int intCurrentSeconds = entry.getValue().getCurrentSeconds();
			
			if (isSelected && (type == _strSelectedAthlete || type == myLibrary._strSUPER)) {
				if (intCurrentSeconds > intHighest) {
					intHighest = intCurrentSeconds;
				}	
			}
						
		}
		
		// Return the value
		intReturnValue = intHighest;
		return intReturnValue;

	}
	
		
static void loadAthleteToHashmap() {
		try {

			// Load Swimmer Data to HashMap
			_mapAthlete = new HashMap<String, Athlete>();
			for (int i = 0; i < _arrAthlete_Swimmer.length; i++) {
				// Temp Variables
				String uid = _arrAthlete_Swimmer[i][0];
				String name = _arrAthlete_Swimmer[i][1];
				String age = _arrAthlete_Swimmer[i][2];
				String state = _arrAthlete_Swimmer[i][3];
				_mapAthlete.put(uid, new AthleteSwimmer(uid,name,Integer.parseInt(age), state));			
			}

			// Load Cyclist Data to HashMap
			for (int i = 0; i < _arrAthlete_Cyclist.length; i++) {
				// Temp Variables
				String uid = _arrAthlete_Cyclist[i][0];
				String name = _arrAthlete_Cyclist[i][1];
				String age = _arrAthlete_Cyclist[i][2];
				String state = _arrAthlete_Cyclist[i][3];
				_mapAthlete.put(uid, new AthleteCyclist(uid,name,Integer.parseInt(age), state));			
			}

			// Load Sprinter Data to HashMap
			for (int i = 0; i < _arrAthlete_Sprinter.length; i++) {
				// Temp Variables
				String uid = _arrAthlete_Sprinter[i][0];
				String name = _arrAthlete_Sprinter[i][1];
				String age = _arrAthlete_Sprinter[i][2];
				String state = _arrAthlete_Sprinter[i][3];
				_mapAthlete.put(uid, new AthleteSprinter(uid,name,Integer.parseInt(age), state));			
			}
			
			// Load Super Data to HashMap
			for (int i = 0; i < _arrAthlete_Super.length; i++) {
				// Temp Variables
				String uid = _arrAthlete_Super[i][0];
				String name = _arrAthlete_Super[i][1];
				String age = _arrAthlete_Super[i][2];
				String state = _arrAthlete_Super[i][3];
				_mapAthlete.put(uid, new AthleteSuper(uid,name,Integer.parseInt(age), state));			
			}
			
		} catch (Exception e) {
			myLibrary.printIt(e.getMessage());
		}
		
	}
	
	static void createMenuAthlete() {
		
		/*
		 * This will create a menu for a selected Game
		 * - It will use the HashMap Data to populate the Menu Options 
		 */
		
		// Variables
		int intSelected = 0;
		String arrMenuOptions[] = {};								// Array that will hold the Menu Options
		String strDelimitedNames = 									         
				" Code  | " + myLibrary.padRight("Name of Athlete", 23) + " | Selected | Point"
						+ ","
			  + "~";	// This will be the column header
		
		// Sort the HashMap using TreeMap
		TreeMap<String, Athlete> treeAthlete = new TreeMap<>(_mapAthlete);		
		for(Entry<String, Athlete> entry : treeAthlete.entrySet()) {
			
			// Get the value and put it on local variable
			String type = entry.getValue().getType();
			String uid = entry.getValue().getUid();
			String name = entry.getValue().getName();
			boolean isSelected = entry.getValue().isSelected();
			
			String strTotalPoint = Integer.toString(entry.getValue().getTotalPoint());
			
			String strSelectedMark = ((isSelected) ? "*" : " ");
			intSelected += ((isSelected) ? 1 : 0);
			
			// Generate delimited string from data
			if (type == _strSelectedAthlete) {
				strDelimitedNames += ((strDelimitedNames != "") ? "," : "") 
						+ "[ " + uid+ " ] - " 
						+ myLibrary.padRight(name, 23) + " |     " + strSelectedMark + "    | " + strTotalPoint;	
			}	
			
			// Add the Super Athletes
			if (type == myLibrary._strSUPER) {
				strDelimitedNames += ((strDelimitedNames != "") ? "," : "") 
						+ "[ " + uid+ " ] - " 
						+ myLibrary.padRight(name + " (s)", 23) + " |     " + strSelectedMark + "    | " + strTotalPoint;	
			}
		}
		
		// Add the "Play" and "Back" option to delimiter
		strDelimitedNames += ((strDelimitedNames != "") ? "," : "")
					+ "~,"					
					+ "[  1 ] - Select All,"
					+ "[  2 ] - Clear All,"
					+ "[  3 ] - Predict the winner,"
					+ "~,"
					+ "[  0 ] - Back to Main Menu,"
					+ "~,"
					+ "Legend: (s) - Super Athletes  | Selected: " + Integer.toString(intSelected);

		// Split the delimited string and put it to an array
		arrMenuOptions = strDelimitedNames.split(",", -1);
		
		// Display the Menu
		myLibrary.displayMenu("Select 4-8 " + _strSelectedAthlete + "s..", arrMenuOptions);
	}
	
	
	static void createMenuPredict() {
		
		/*
		 * This will create a menu for a selected Game
		 * - It will use the HashMap Data to populate the Menu Options 
		 */
		
		String arrMenuOptions[] = {};								// Array that will hold the Menu Options
		String strDelimitedNames = 									         
				" Code  | " + myLibrary.padRight("Name of Athlete", 23) + myLibrary.padLeft("", 10) + "| Point"
						+ ","
			  + "~";	// This will be the column header
		
		// Sort the HashMap using TreeMap
		TreeMap<String, Athlete> treeAthlete = new TreeMap<>(_mapAthlete);		
		for(Entry<String, Athlete> entry : treeAthlete.entrySet()) {
			
			// Get the value and put it on local variable
			String type = entry.getValue().getType();
			String uid = entry.getValue().getUid();
			String name = entry.getValue().getName();
			boolean isSelected = entry.getValue().isSelected();
			
			String strTotalPoint = Integer.toString(entry.getValue().getTotalPoint());
			
			String strSelectedMark = ((isSelected) ? "*" : " ");
			// Generate delimited string from data
			if (type == _strSelectedAthlete && isSelected) {
				strDelimitedNames += ((strDelimitedNames != "") ? "," : "") 
						+ "[ " + uid+ " ] - " 
						+ myLibrary.padRight(name, 23) + myLibrary.padLeft("", 10) + "| " + strTotalPoint;	
			}	
			
			// Add the Super Athletes
			if (type == myLibrary._strSUPER && isSelected) {
				strDelimitedNames += ((strDelimitedNames != "") ? "," : "") 
						+ "[ " + uid+ " ] - " 
						+ myLibrary.padRight(name + " (s)", 23) + myLibrary.padLeft("", 10) + "| " + strTotalPoint;	
			}
		}
		
		// Add the "Back" option to delimiter
		strDelimitedNames += ((strDelimitedNames != "") ? "," : "")
					+ "~,"					
					+ "[  0 ] - Back";

		// Split the delimited string and put it to an array
		arrMenuOptions = strDelimitedNames.split(",", -1);
		
		// Display the Menu
		myLibrary.displayMenu("Predict the winner..", arrMenuOptions);
	}
	
	
	static boolean isExitGame() {
		
		// Local Variables
		boolean blnReturnValue = false;
		int intChoice;
	    
	    while (true) {
	    	
	    	// Display the Exit Menu	    		    	
	    	myLibrary.displayMenu("Do you want to EXIT Ozlympic Games?", _arrMenuOptionsYesNo);	    	
	    	// Get the input
	    	intChoice = _objScanner.nextInt();	    	
	    	if (intChoice == 1) {
	    		// If the user confirmed to exit (Noo!)
	    		myLibrary.displayMessageBox("Thank you for using Ozlympic Games!!!");	    		
	    		blnReturnValue = true;
	    		break;
	    	} else if (intChoice == 0) {
	    		// If the user decided not to exit the program (Yey!)
	    		blnReturnValue = false;
	    		break;
	    	} else {
	    		// Display invalid key choice
	    		myLibrary.displayMessagePrompt("You have selected an invalid choice!");	    		
	    	}	    	
	    }
	    
	    // Return the value
		return blnReturnValue;
		
	}
	

	static boolean isAthleteCodeValid(String strChoice) {

		// Local Variables
		boolean blnReturnValue = false;
		
		// Sort the HashMap using TreeMap
		TreeMap<String, Athlete> treeAthlete = new TreeMap<>(_mapAthlete);		
		for(Entry<String, Athlete> entry : treeAthlete.entrySet()) {
			
			// Get the value and put it on local variable
			String type = entry.getValue().getType();
			String uid = entry.getValue().getUid();
			
			// Generate delimited string from data
			if (uid.equals(strChoice)) {
				blnReturnValue = true;
				
				// Update the isSelected field
				Athlete objAthlete = (Athlete) entry.getValue();
				objAthlete.setSelected(!objAthlete.isSelected());
				break;
				
			}
		}
		
		// Return the value
		return blnReturnValue;

	}
	
	
	static boolean isSelectedAthleteCodeValid(String strChoice) {

		// Local Variables
		boolean blnReturnValue = false;
		
		// Sort the HashMap using TreeMap
		TreeMap<String, Athlete> treeAthlete = new TreeMap<>(_mapAthlete);		
		for(Entry<String, Athlete> entry : treeAthlete.entrySet()) {
			
			// Get the value and put it on local variable
			String type = entry.getValue().getType();
			String uid = entry.getValue().getUid();
			String name = entry.getValue().getName();
			boolean isSelected = entry.getValue().isSelected();
			
			// Generate delimited string from data
			if (uid.equals(strChoice) && isSelected) {
				blnReturnValue = true;
				
				_strPredictedCode = uid;
				_strPredictedName = name;
				break;
				
			}
		}
		
		// Return the value
		return blnReturnValue;

	}
	
		
	static void setSelection(_enmSetSelection enmSetSelection, myLibrary._enmGame enmGame) {

		// Variables
		String strGame = "";
		
		// Evaluate the Game
		if (enmGame == myLibrary._enmGame.Swimming) {
			strGame = myLibrary._strSWIMMER;
		} else if (enmGame == myLibrary._enmGame.Cycling) {
			strGame = myLibrary._strCYCLIST;
		} else if (enmGame == myLibrary._enmGame.Running) {
			strGame = myLibrary._strSPRINTER;
		}
		
		// Sort the HashMap using TreeMap
		TreeMap<String, Athlete> treeAthlete = new TreeMap<>(_mapAthlete);		
		for(Entry<String, Athlete> entry : treeAthlete.entrySet()) {
			String type = entry.getValue().getType();
			
			if ((type == strGame) || (type == myLibrary._strSUPER) ) {
				// Update the isSelected field
				Athlete objAthlete = (Athlete) entry.getValue();
				if (enmSetSelection == _enmSetSelection.SelectAll) {
					objAthlete.setSelected(true);
				} else {
					objAthlete.setSelected(false);	
				}	
			}
			
		} // End of Loop

	}
	
}
