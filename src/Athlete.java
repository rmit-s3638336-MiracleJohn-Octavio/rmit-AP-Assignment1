
public abstract class Athlete {

	private String uid;
	private String name;
	private int age;
	private String state;
	
	public Athlete(String uid, String name, int age, String state) {
		super();
		this.uid = uid;
		this.name = name;
		this.age = age;
		this.state = state;
	}
		 
	public abstract void compete();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}





