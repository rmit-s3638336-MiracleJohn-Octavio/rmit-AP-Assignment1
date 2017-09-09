import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

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
			{"S01","Ian Thorpe","21","VIC"},
			{"S02","Dawn Fraser","23","VIC"},
			{"S03","Libby Trickett","24","QLD"},
			{"S04","Murray Rose","21","QLD"},
			{"S05","Grant Hackett","20","NSW"},
			{"S06","Michael Klim","23","NSW"},
			{"S07","John Devitt","21","ACT"},
			{"S08","Michael Wenden","24","ACT"},
			{"S09","Todd Pearson","22","SA"},
			{"S10","David Theile","21","SA"}
		};
	static String _arrAthlete_Cyclist[][]= 
		{
			{"C01","Christopher Scott","21","VIC"},
			{"C02","Mark le Flohic","23","VIC"},
			{"C03","Greg Ball","24","QLD"},
			{"C04","Kial Stewart","21","QLD"},
			{"C05","Peter Brooks","20","NSW"},
			{"C06","Robert Crowe","23","NSW"},
			{"C07","David Short","21","ACT"},
			{"C08","Kieran Modra","24","ACT"},
			{"C09","Michael Gallagher","22","SA"},
			{"C10","Tyson Lawrence","21","SA"}
		};
	static String _arrAthlete_Sprinter[][]= 
		{
			{"R01","Matt Shirvington","21","VIC"},
			{"R02","Patrick Johnson","23","VIC"},
			{"R03","Joshua Ross","24","QLD"},
			{"R04","Otis Gowa","21","QLD"},
			{"R05","Tim Leathart","20","NSW"},
			{"R06","Joshua Clarke","23","NSW"},
			{"R07","Alex Hartmann","21","ACT"},
			{"R08","Steve Brimacombe","24","ACT"},
			{"R09","Damien Marsh","22","SA"},
			{"R10","Gerard Barrett","21","SA"}
		};
	static String _arrAthlete_Super[][]= 
		{
			{"X01","Craig Alexander","21","VIC"},
			{"X02","Greg Bennett","23","VIC"},
			{"X03","Chris McCormack","24","QLD"},
			{"X04","Peter Robertson","21","QLD"},
			{"X05","Brendan Sexton","20","NSW"},
			{"X06","Greg Stewart","23","NSW"},
			{"X07","Ryan Fisher","21","ACT"},
			{"X08","Simon Thompson","24","ACT"},
			{"X09","Pete Jacobs","22","SA"},
			{"X10","Luke McKenzie","21","SA"}
		};
	
	// Hashmap
	static HashMap<String, Athlete> _mapAthlete;				// This will hold all the Athletes
	 
	// Enum
	private enum _enmSport {
		Swimming,
		Cycling,
		Running;
	}
	
	// Constants
	static final String _SWIMMER = "Swimmer";
	static final String _CYCLIST = "Cyclist";
	static final String _SPRINTER = "Sprinter";
	static final String _SUPER = "Super";
	
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
	    		// If the user wants to play the game
	    		// ** PLay Game Here
	    		break;
	    	} else if (strChoice.equals("2")) {
	    		// If the user decided to reset the selection
	    		resetSelection();	    		
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
	
// ---------- Sub Methods
	
	static void loadToHashmap() {
		// Sample / Pattern
		// ----------------
		// HashMap<String, Swimmer> _mapSwimmer = new HashMap<>();
		//	_mapSwimmer.put("S01", new Swimmer("NS01"));
		//	...
		//
		// AthleteSwimmer swimmer = _mapSwimmer.get("NS01");
		// String name = swimmer.getName();
		
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
		String strSport = "";										// Name of Sport Selected
		String arrMenuOptions[] = {};								// Array that will hold the Menu Options
		String strDelimitedNames = 
				" Code   | Name of Athlete,"
			  + "~";	// This will be the column header
		
		if (enmSport == _enmSport.Swimming) {
			strSport = _SWIMMER;
		} else if (enmSport == _enmSport.Cycling) {
			strSport = _CYCLIST;
		} else if (enmSport == _enmSport.Running) {
			strSport = _SPRINTER;
		}
		
		// Sort the HashMap using TreeMap
		TreeMap<String, Athlete> treeAthlete = new TreeMap<>(_mapAthlete);		
		for(Entry<String, Athlete> entry : treeAthlete.entrySet()) {
			
			// Get the value and put it on local variable
			String type = entry.getValue().getType();
			String uid = entry.getValue().getUid();
			String name = entry.getValue().getName();
			boolean isSelected = entry.getValue().isSelected();
			
			// Generate delimited string from data
			if (type == strSport) {
				strDelimitedNames += ((strDelimitedNames != "") ? "," : "") 
						+ "[ " + uid+ " ] - " 
						+ name + ((isSelected) ? " (Selected)" : "");	
			}	
			
			// Add the Super Athletes
			if (type == _SUPER) {
				strDelimitedNames += ((strDelimitedNames != "") ? "," : "") 
						+ "[ " + uid+ " ] - " 
						+ name + "*" + ((isSelected) ? " (Selected)" : "");;	
			}
		}
		
		// Add the "Play" and "Back" option to delimiter
		strDelimitedNames += ((strDelimitedNames != "") ? "," : "")
					+ "~,"
					+ "[  1  ] - Play Game,"
					+ "[  2  ] - Reset Selection,"
					+ "[  0  ] - Back to Main Menu,"
					+ "~,"
					+ "Legend: * - Super Athletes";

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
	
	static void resetSelection() {

		// Sort the HashMap using TreeMap
		TreeMap<String, Athlete> treeAthlete = new TreeMap<>(_mapAthlete);		
		for(Entry<String, Athlete> entry : treeAthlete.entrySet()) {
			
			// Update the isSelected field
			Athlete objAthlete = (Athlete) entry.getValue();
			objAthlete.setSelected(false);
			
		} // End of Loop

	}
	
}
