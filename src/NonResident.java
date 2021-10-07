
public class NonResident extends Student {
	private static final int NON_RESIDENT_TUITION = 29737;
	private static final int NON_RESIDENT_CREDIT_RATE = 966; 
	
	public NonResident() {	
	}
	
	public NonResident(String name, Major major, int numberOfCredits) {
		super(name, major, numberOfCredits);
	}
	
	@Override
	public void tuitionDue() {
		if (this.getNumberOfCredits() >= 12) {
			double tempTuition = this.NON_RESIDENT_TUITION + this.getFullTimeUniversityFee();
			if (this.getNumberOfCredits() > 16) {
				tempTuition += (this.getNumberOfCredits() - 16) * this.NON_RESIDENT_CREDIT_RATE;
			}
			
			this.setTuition(tempTuition);
		}
		else {
			double tempTuition = (this.NON_RESIDENT_CREDIT_RATE * this.getNumberOfCredits()) + this.getPartTimeUniversityFee();
			
			this.setTuition(tempTuition);
		}
	}
	
	public int getNonResidentTuition() {
		return this.NON_RESIDENT_TUITION;
	}
}
