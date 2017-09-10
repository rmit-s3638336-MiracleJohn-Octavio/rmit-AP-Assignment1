
public class AthleteSuper extends Athlete {

	public AthleteSuper(String uid, String name, int age, String state) {
		super("Super", uid, name, age, state);
	}

	@Override
	public void compete(String strSport) {
		int intMin;
		int intMax;
		
		if (strSport == ) {
			
		}
		
		int intRandomNumber = myLibrary.getRandomNumber(100, 200);
		super.setCurrentScore(intRandomNumber);
		
		int intTotalScore = super.getTotalScore();
		super.setTotalScore(intTotalScore + intRandomNumber);
	}

}
