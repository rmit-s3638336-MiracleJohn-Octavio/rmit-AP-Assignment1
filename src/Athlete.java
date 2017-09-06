
public abstract class Athlete {

	private int uid;
	private String name;
	private int age;
	
	public Athlete(int uid, String name, int age) {
		super();
		this.uid = uid;
		this.name = name;
		this.age = age;
	}
		 
	public abstract void compete();
	
}


