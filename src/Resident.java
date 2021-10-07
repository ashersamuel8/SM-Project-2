
public class Resident extends Student {
	private int financialAid = 0;
	private static final int RESIDENT_TUITION = 12536;
	private static final int RESIDENT_CREDIT_RATE = 404; 
	
	public Resident() {
	}
	
	public Resident(String name, Major major, int numberOfCredits) {
		super(name, major, numberOfCredits);
	}
	
	public void setFinancialAid(int financialAid) {
		this.financialAid = financialAid;
	}
	
	@Override
	public void tuitionDue() {
		if (this.getNumberOfCredits() >= 12) {
			double tempTuition = this.RESIDENT_TUITION + this.getFullTimeUniversityFee();
			if (this.getNumberOfCredits() > 16) {
				tempTuition += (this.getNumberOfCredits() - 16) * this.RESIDENT_CREDIT_RATE;
			}
			tempTuition -= this.financialAid;
			
			this.setTuition(tempTuition);
		}
		else {
			double tempTuition = (this.RESIDENT_CREDIT_RATE * this.getNumberOfCredits()) + this.getPartTimeUniversityFee();
			tempTuition -= this.financialAid;
			
			this.setTuition(tempTuition);
		}
	}
}
