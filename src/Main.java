import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

// ---------- Variables
	
	// Object | int
	static Scanner _objScanner = new Scanner(System.in); 		// Important: Should use only 1 scanner call
	private int _intUserPrediction = 0;
	
	// Array
	static String _arrMenuOptionsSports[]= {
			"[ 1 ] - Swimming",
			"[ 2 ] - Cycling",
			"[ 3 ] - Running",
			"~",
			"[ 0 ] - Exit"
			};	
	static String _arrMenuOptionsAthleteSwimmer[];
	static String _arrMenuOptionsAthleteCyclist[];
	static String _arrMenuOptionsAthleteSprinter[];
	static String _arrMenuOptionsAthleteSuper[];
	static String _arrMenuOptionsYesNo[]= {
			"[ 1 ] - Yes",			
			"[ 0 ] - No"
			};
	// Array - Athlete
	static String _arrAthlete_Swimmer[][]= 
		{
			{"AS01","Ian Thorpe","21","VIC"},
			{"AS02","Dawn Fraser","23","VIC"},
			{"AS03","Libby Trickett","24","QLD"},
			{"AS04","Murray Rose","21","QLD"},
			{"AS05","Grant Hackett","20","NSW"},
			{"AS06","Michael Klim","23","NSW"},
			{"AS07","John Devitt","21","ACT"},
			{"AS08","Michael Wenden","24","ACT"},
			{"AS09","Todd Pearson","22","SA"},
			{"AS10","David Theile","21","SA"}
		};
	static String _arrAthlete_Cyclist[][]= 
		{
			{"AC01","Christopher Scott","21","VIC"},
			{"AC02","Mark le Flohic","23","VIC"},
			{"AC03","Greg Ball","24","QLD"},
			{"AC04","Kial Stewart","21","QLD"},
			{"AC05","Peter Brooks","20","NSW"},
			{"AC06","Robert Crowe","23","NSW"},
			{"AC07","David Short","21","ACT"},
			{"AC08","Kieran Modra","24","ACT"},
			{"AC09","Michael Gallagher","22","SA"},
			{"AC10","Tyson Lawrence","21","SA"}
		};
	static String _arrAthlete_Sprinter[][]= 
		{
			{"AR01","Matt Shirvington","21","VIC"},
			{"AR02","Patrick Johnson","23","VIC"},
			{"AR03","Joshua Ross","24","QLD"},
			{"AR04","Otis Gowa","21","QLD"},
			{"AR05","Tim Leathart","20","NSW"},
			{"AR06","Joshua Clarke","23","NSW"},
			{"AR07","Alex Hartmann","21","ACT"},
			{"AR08","Steve Brimacombe","24","ACT"},
			{"AR09","Damien Marsh","22","SA"},
			{"AR10","Gerard Barrett","21","SA"}
		};
	static String _arrAthlete_Super[][]= 
		{
			{"AP01","Craig Alexander","21","VIC"},
			{"AP02","Greg Bennett","23","VIC"},
			{"AP03","Chris McCormack","24","QLD"},
			{"AP04","Peter Robertson","21","QLD"},
			{"AP05","Brendan Sexton","20","NSW"},
			{"AP06","Greg Stewart","23","NSW"},
			{"AP07","Ryan Fisher","21","ACT"},
			{"AP08","Simon Thompson","24","ACT"},
			{"AP09","Pete Jacobs","22","SA"},
			{"AP10","Luke McKenzie","21","SA"}
		};
	
	// Hashmap
	static HashMap<String, AthleteSwimmer> _mapSwimmer;
	static HashMap<String, AthleteCyclist> _mapCyclist;
	static HashMap<String, AthleteSprinter> _mapSprinter;
	static HashMap<String, AthleteSuper> _mapSuper;
	
	// Enum
	private enum _enmSport {
		Swimming,
		Cycling,
		Running;
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
	        	selectAthlete(_enmSport.Swimming);
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
	    		// Only intChoice = 0 will execute this
	    		
	    		// Exit the loop
	    		break;
	    	} else {
	    		// All intChoice = 1,2,3 will execute process this except intChoice = 0
	    		// Do nothing 	
	    	}
	    }
	}
	
	static void selectAthlete(_enmSport enmSport) {
		if (enmSport == _enmSport.Swimming) {
			createAthleteMenu(enmSport);
		} else if (enmSport == _enmSport.Cycling) {
			
		} else if (enmSport == _enmSport.Running) {
			
		}
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
			_mapSwimmer = new HashMap<String, AthleteSwimmer>();
			for (int i = 0; i < _arrAthlete_Swimmer.length; i++) {
				// Temp Variables
				String uid = _arrAthlete_Swimmer[i][0];
				String name = _arrAthlete_Swimmer[i][1];
				String age = _arrAthlete_Swimmer[i][2];
				String state = _arrAthlete_Swimmer[i][3];
				_mapSwimmer.put(uid, new AthleteSwimmer(uid,name,Integer.parseInt(age), state));			
			}
			
			// Load Cyclist Data to HashMap
			_mapCyclist = new HashMap<String, AthleteCyclist>();
			for (int i = 0; i < _arrAthlete_Cyclist.length; i++) {
				// Temp Variables
				String uid = _arrAthlete_Cyclist[i][0];
				String name = _arrAthlete_Cyclist[i][1];
				String age = _arrAthlete_Cyclist[i][2];
				String state = _arrAthlete_Cyclist[i][3];
				_mapCyclist.put(uid, new AthleteCyclist(uid,name,Integer.parseInt(age), state));			
			}
			
			// Load Sprinter Data to HashMap
			_mapSprinter = new HashMap<String, AthleteSprinter>();
			for (int i = 0; i < _arrAthlete_Sprinter.length; i++) {
				// Temp Variables
				String uid = _arrAthlete_Sprinter[i][0];
				String name = _arrAthlete_Sprinter[i][1];
				String age = _arrAthlete_Sprinter[i][2];
				String state = _arrAthlete_Sprinter[i][3];
				_mapSprinter.put(uid, new AthleteSprinter(uid,name,Integer.parseInt(age), state));			
			}
			
			// Load Super Data to HashMap
			_mapSuper = new HashMap<String, AthleteSuper>();
			for (int i = 0; i < _arrAthlete_Super.length; i++) {
				// Temp Variables
				String uid = _arrAthlete_Super[i][0];
				String name = _arrAthlete_Super[i][1];
				String age = _arrAthlete_Super[i][2];
				String state = _arrAthlete_Super[i][3];
				_mapSuper.put(uid, new AthleteSuper(uid,name,Integer.parseInt(age), state));			
			}
			
		} catch (Exception e) {
			myLibrary.printIt(e.getMessage());
		}
		
	}
	
	static void createAthleteMenu(_enmSport enmSport) {
		if (enmSport == _enmSport.Swimming) {
			// Load Athlete Names to Array from Hashmap
			String strDelimitedNames = "";
			for (Map.Entry<String, AthleteSwimmer> entry : _mapSwimmer.entrySet()) {
				strDelimitedNames += ((strDelimitedNames != "") ? "," : "") + entry.getValue().getName();
			}			
			_arrMenuOptionsAthleteSwimmer = strDelimitedNames.split(",", -1);			
			myLibrary.displayMenu("Select Athlete (Swimmer)", _arrMenuOptionsAthleteSwimmer);
		} else if (enmSport == _enmSport.Cycling) {
			
		} else if (enmSport == _enmSport.Running) {
			
		}
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
		
}
