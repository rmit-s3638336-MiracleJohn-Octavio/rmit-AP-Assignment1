
public abstract class Athlete {

	// Required Fields	
	private String uid;
	private String name;
	private int age;
	private String state;
	
	// User Defined Fields
	private String type;					// Type of Athlete
	private boolean isSelected = false;		// Is Athlete Selected
	private int currentPoint = 0;			// Current Game Score (Who's the winner?)
	private int totalPoint = 0;				// Overall Score
		
	// Constructor (For Subclass)
	
	public Athlete(String type, String uid, String name, int age, String state) {
		super();
		this.type = type;
		this.uid = uid;
		this.name = name;
		this.age = age;
		this.state = state;
	}
		 
	// User defined Method/s
	
	public abstract void compete(myLibrary._enmGame enmGame);
	
	// Getters and Setters
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	

	public int getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(int currentPoint) {
		this.currentPoint = currentPoint;
	}

	
	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}
	
}





