
public class International extends NonResident {
	private static final int INTERNATIONAL_FEE = 2650;
	private boolean studyAbroadProgram = false;
	
	public International() {
	}
	
	public International(String name, Major major, int numberOfCredits, boolean studyAbroadProgram) {
		super(name, major, numberOfCredits);
		this.studyAbroadProgram = studyAbroadProgram;
	}
	
	public void setStudyAbroadStatus(boolean status) {
		this.studyAbroadProgram = status;
	}
	public boolean getStudyAbroadStatus() {
		return this.studyAbroadProgram;
	}
	
	@Override
	public void tuitionDue() {
		super.tuitionDue();
		this.setTuition(getTuition() + International.INTERNATIONAL_FEE);
		if (studyAbroadProgram) {
			this.setTuition(getTuition() - NonResident.NON_RESIDENT_TUITION);
		}
	}
}
