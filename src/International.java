
public class International extends NonResident {
	private static final int INTERNATIONAL_FEE = 2650;
	private boolean studyAbroadProgram = false;
	
	public International() {
	}
	
	public International(String name, Major major, int numberOfCredits) {
		super(name, major, numberOfCredits);
	}
	
	public void setStudyAbroadStatus(boolean status) {
		this.studyAbroadProgram = status;
	}
	
	@Override
	public void tuitionDue() {
		super.tuitionDue();
		this.setTuition(getTuition() + this.INTERNATIONAL_FEE);
		if (studyAbroadProgram) {
			this.setTuition(getTuition() - this.getNonResidentTuition());
		}
	}
}
