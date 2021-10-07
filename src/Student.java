
public class Student {
	
	private Profile profile;
	private int numberOfCredits;
	private double tuition;
	private static final int FULL_TIME_UNIVERSITY_FEE = 3628;
	private static final double PART_TIME_UNIVERSITY_FEE = FULL_TIME_UNIVERSITY_FEE * 0.8; 
	private static final int RESIDENT_CREDIT_RATE = 404;
	private static final int NON_RESIDENT_CREDIT_RATE = 966;
	
	public Student() {
	}
	
	public Student(String name, Major major, int numberOfCredits) {
		this.profile = new Profile(name, major);
		this.numberOfCredits = numberOfCredits;
	}
	
	public void tuitionDue() { 
	}
	
	@Override
	public String toString() {
		return this.profile.toString() + ":" + this.numberOfCredits + " credits hours";
	}
	
	public void setTuition(double tuition) {
		this.tuition = tuition;
	}
	
	public double getTuition() {
		return this.tuition;
	}
	
	public int getNumberOfCredits() {
		return this.numberOfCredits;
	}
	
	public int getFullTimeUniversityFee() {
		return this.FULL_TIME_UNIVERSITY_FEE;
	}

	public double getPartTimeUniversityFee() {
		return this.PART_TIME_UNIVERSITY_FEE;
	}

	/*
	public double getResidentCreditRate() {
		return this.RESIDENT_CREDIT_RATE;
	}
	
	public double getNonResidentCreditRate() {
		return this.NON_RESIDENT_CREDIT_RATE;
	}
	*/
}
