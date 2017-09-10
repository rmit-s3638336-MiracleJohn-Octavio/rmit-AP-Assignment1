
public class AthleteSwimmer extends Athlete {

	public AthleteSwimmer(String uid, String name, int age, String state) {
		super("Swimmer", uid, name, age, state );
		// TODO Auto-generated constructor stub
	}

	@Override
	public void compete(String strSport) {
		int intRandomNumber = myLibrary.getRandomNumber(100, 200);
		super.setCurrentScore(intRandomNumber);
		
		int intTotalScore = super.getTotalScore();
		super.setTotalScore(intTotalScore + intRandomNumber);
	}

}
