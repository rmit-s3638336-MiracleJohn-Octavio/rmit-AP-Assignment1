
public class AthleteSwimmer extends Athlete {

	public AthleteSwimmer(String uid, String name, int age, String state) {
		super("Swimmer", uid, name, age, state );
		// TODO Auto-generated constructor stub
	}

	@Override
	public void compete(myLibrary._enmSport enmSport) {
		int intMin = 0;
		int intMax = 0;
		
		if (enmSport == myLibrary._enmSport.Swimming) {
			intMin = 100;
			intMax = 200;
		} else if (enmSport == myLibrary._enmSport.Cycling) {
			intMin = 500;
			intMax = 800;
		} else if (enmSport == myLibrary._enmSport.Running) {
			intMin = 10;
			intMax = 20;
		}
		
		int intRandomNumber = myLibrary.getRandomNumber(intMin, intMax);
		super.setCurrentScore(intRandomNumber);
		
		int intTotalScore = super.getTotalScore();
		super.setTotalScore(intTotalScore + intRandomNumber);
	}

}
