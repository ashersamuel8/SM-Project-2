/**
 * This class defines all of the properties specific to international students, it is a child of the NonResident class. 
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */

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
	
	@Override
	public String toString() {
		return super.toString();
	}
}
