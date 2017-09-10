
public class AthleteSwimmer extends Athlete {

	public AthleteSwimmer(String uid, String name, int age, String state) {
		super("Swimmer", uid, name, age, state );
		// TODO Auto-generated constructor stub
	}

	@Override
	public void compete(myLibrary._enmGame enmGame) {
		int intMin = 0;
		int intMax = 0;
		
		if (enmGame == myLibrary._enmGame.Swimming) {
			intMin = 100;
			intMax = 200;
		} else if (enmGame == myLibrary._enmGame.Cycling) {
			intMin = 500;
			intMax = 800;
		} else if (enmGame == myLibrary._enmGame.Running) {
			intMin = 10;
			intMax = 20;
		}
		
		int intRandomNumber = myLibrary.getRandomNumber(intMin, intMax);
		super.setCurrentSeconds(intRandomNumber);
	}

}
