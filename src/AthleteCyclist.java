
public class AthleteCyclist extends Athlete {

	public AthleteCyclist(String uid, String name, int age, String state) {
		super("Cyclist", uid, name, age, state);
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
