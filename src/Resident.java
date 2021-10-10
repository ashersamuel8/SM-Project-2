/**
 * This class defines the properties specific to resident students, it is a child of the Student class.
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */

public class Resident extends Student {
	
	private double financialAid = 0;
	
	public Resident() {
	}
	
	public Resident(String name, Major major, int numberOfCredits) {
		super(name, major, numberOfCredits);
	}
	
	public void setFinancialAid(double financialAid) {
		this.financialAid = financialAid;
	}
	public double getFinancialAid() {
		return this.financialAid;
	}
	
	@Override
	public void tuitionDue() {
		if (this.getNumberOfCredits() >= 12) {
			double tempTuition = Student.RESIDENT_TUITION + Student.FULL_TIME_UNIVERSITY_FEE;
			if (this.getNumberOfCredits() > 16) {
				tempTuition += (this.getNumberOfCredits() - 16) * Student.RESIDENT_CREDIT_RATE;
			}
			tempTuition -= this.financialAid;
			
			this.setTuition(tempTuition);
		}
		else {
			double tempTuition = (Student.RESIDENT_CREDIT_RATE * this.getNumberOfCredits()) + Student.PART_TIME_UNIVERSITY_FEE;
			tempTuition -= this.financialAid;
			
			this.setTuition(tempTuition);
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
