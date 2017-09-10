import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import com.sun.javafx.fxml.ParseTraceElement;

public class Main {

// ---------- Variables
	
	// Object | int
	static Scanner _objScanner = new Scanner(System.in); 		// Important: Should use only 1 scanner call
	private int _intUserPrediction = 0;
	
	// Array
	static String _arrMenuOptionsSports[]= {
			"Code  | Description",
			"~",
			"[ 1 ] - Swimming",
			"[ 2 ] - Cycling",
			"[ 3 ] - Running",
			"~",
			"[ 0 ] - Exit"
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
	private enum _enmSport {
		Swimming,
		Cycling,
		Running;
	}
	private enum _enmSetSelection {
		SelectAll,
		ClearAll
	}
	
// ---------- Main Methods
	
 	public static void main(String[] args) {
			
		// Local Variables
	    int intChoice;
	    boolean blnIsExitLoop;

	    // Load the array (athlete) to hashmap
	    loadToHashmap();	    
	    
	    //Begin Infinite Loop
	    while (true) {	    	
	    	
	    	// Reset 
	    	blnIsExitLoop  = false;
	    	// Reset Selected Athlete here

	    	// Display
	    	myLibrary.displayMenu("Ozlympic Games MENU", _arrMenuOptionsSports);	    	
	    	intChoice = _objScanner.nextInt();	    	
	    	// Choices
	    	switch (intChoice) {
	        case 1:
	        	selectAthlete(_enmSport.Swimming);
	            break;
	        case 2:
	        	selectAthlete(_enmSport.Cycling);
	        	break;
	        case 3:
	        	selectAthlete(_enmSport.Running);
	        	break;
	        case 0:
	        	if (isExitGame()) {
	        		// Exit the Loop
	        		blnIsExitLoop = true;
	        	}
	        	break;
	        default:
	        	// Do Nothing
	    	}	

	    	if (blnIsExitLoop) { 
	    		// intChoice = 0 	    		
	    		// Exit the loop
	    		break;
	    	} else {
	    		// intChoice = 1,2,3 
	    		// Do nothing 	
	    	}
	    }
	}
	
	static void selectAthlete(_enmSport enmSport) {
		
		// Local Variables
		String strChoice;
		boolean blnIsExitLoop;

		while (true) {
			
			// Reset 
	    	blnIsExitLoop  = false;
		
	    	// Display the Athlete Menu
			createAthleteMenu(enmSport);
			// Get the input
			strChoice = _objScanner.next();	    	
			strChoice = strChoice.toUpperCase();
	    	if (strChoice.equals("1")) {
	    		playGame(enmSport);
	    		break;
	    	} else if (strChoice.equals("2")) {
	    		// If the user decided to select all selection
	    		setSelection(_enmSetSelection.SelectAll,enmSport);
	    	} else if (strChoice.equals("3")) {
	    		// If the user decided to clear all selection
	    		setSelection(_enmSetSelection.ClearAll,enmSport);
	    	} else if (strChoice.equals("0")) {
	    		// If the user decided not to go back to Main Menu
	    		blnIsExitLoop = true;
	    		break;
	    	} else {
	    		if (isAthleteCodeValid(strChoice)) {
					
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
	
	static void playGame(_enmSport enmSport) {
		
		// Variables
		String strSport = "";
				
		try {
			
			// Evaluate the sport
			if (enmSport == _enmSport.Swimming) {
				strSport = myLibrary._strSWIMMER;
			} else if (enmSport == _enmSport.Cycling) {
				strSport = myLibrary._strCYCLIST;
			} else if (enmSport == _enmSport.Running) {
				strSport = myLibrary._strSPRINTER;
			}
			
			// Sort the HashMap using TreeMap
			TreeMap<String, Athlete> treeAthlete = new TreeMap<>(_mapAthlete);		
			for(Entry<String, Athlete> entry : treeAthlete.entrySet()) {
				
				// Get the value and put it on local variable
				String type = entry.getValue().getType();
				String uid = entry.getValue().getUid();
				String name = entry.getValue().getName();
				boolean isSelected = entry.getValue().isSelected();
				
				// Generate Random Numbers
				if (isSelected && (type == strSport || type == myLibrary._strSUPER)) {
					entry.getValue().compete();
					myLibrary.printIt(Integer.toString(entry.getValue().getCurrentScore()));
				}
			}
		} catch (Exception e) {
			myLibrary.printIt(e.getMessage());
		}	
	}
	
// ---------- Sub Methods
	
	static void loadToHashmap() {
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
	
	static void createAthleteMenu(_enmSport enmSport) {
		
		/*
		 * This will create a menu for a selected Sport
		 * - It will use the HashMap Data to populate the Menu Options 
		 */
		
		// Variables
		int intSelected = 0;
		String strSport = "";										// Name of Sport Selected
		String arrMenuOptions[] = {};								// Array that will hold the Menu Options
		String strDelimitedNames = 									         
				" Code  | " + myLibrary.padRight("Name of Athlete", 23) + " | Selected | Score"
						+ ","
			  + "~";	// This will be the column header
		
		if (enmSport == _enmSport.Swimming) {
			strSport = myLibrary._strSWIMMER;
		} else if (enmSport == _enmSport.Cycling) {
			strSport = myLibrary._strCYCLIST;
		} else if (enmSport == _enmSport.Running) {
			strSport = myLibrary._strSPRINTER;
		}
		
		// Sort the HashMap using TreeMap
		TreeMap<String, Athlete> treeAthlete = new TreeMap<>(_mapAthlete);		
		for(Entry<String, Athlete> entry : treeAthlete.entrySet()) {
			
			// Get the value and put it on local variable
			String type = entry.getValue().getType();
			String uid = entry.getValue().getUid();
			String name = entry.getValue().getName();
			boolean isSelected = entry.getValue().isSelected();
			
			String strTotalScore = Integer.toString(entry.getValue().getTotalScore());
			
			String strSelectedMark = ((isSelected) ? "*" : " ");
			intSelected += ((isSelected) ? 1 : 0);
			
			// Generate delimited string from data
			if (type == strSport) {
				strDelimitedNames += ((strDelimitedNames != "") ? "," : "") 
						+ "[ " + uid+ " ] - " 
						+ myLibrary.padRight(name, 23) + " |     " + strSelectedMark + "    | " + strTotalScore;	
			}	
			
			// Add the Super Athletes
			if (type == myLibrary._strSUPER) {
				strDelimitedNames += ((strDelimitedNames != "") ? "," : "") 
						+ "[ " + uid+ " ] - " 
						+ myLibrary.padRight(name + " (s)", 23) + " |     " + strSelectedMark + "    | " + strTotalScore;	
			}
		}
		
		// Add the "Play" and "Back" option to delimiter
		strDelimitedNames += ((strDelimitedNames != "") ? "," : "")
					+ "~,"
					+ "[  1 ] - Play Game,"
					+ "[  2 ] - Select All,"
					+ "[  3 ] - Clear All,"
					+ "[  0 ] - Back to Main Menu,"
					+ "~,"
					+ "Legend: (s) - Super Athletes  | Selected: " + Integer.toString(intSelected);

		// Split the delimited string and put it to an array
		arrMenuOptions = strDelimitedNames.split(",", -1);
		
		// Display the Menu
		myLibrary.displayMenu("Select 4-8 Athletes (" + strSport + ")", arrMenuOptions);
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
		
	static void setSelection(_enmSetSelection enmSetSelection, _enmSport enmSport) {

		// Variables
		String strSport = "";
		
		// Evaluate the sport
		if (enmSport == _enmSport.Swimming) {
			strSport = myLibrary._strSWIMMER;
		} else if (enmSport == _enmSport.Cycling) {
			strSport = myLibrary._strCYCLIST;
		} else if (enmSport == _enmSport.Running) {
			strSport = myLibrary._strSPRINTER;
		}
		
		// Sort the HashMap using TreeMap
		TreeMap<String, Athlete> treeAthlete = new TreeMap<>(_mapAthlete);		
		for(Entry<String, Athlete> entry : treeAthlete.entrySet()) {
			String type = entry.getValue().getType();
			
			if ((type == strSport) || (type == myLibrary._strSUPER) ) {
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
