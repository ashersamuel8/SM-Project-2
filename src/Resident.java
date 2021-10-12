/**
 * This class defines the properties specific to resident students, it is a child of the Student class.
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */

public class Resident extends Student {
	
	private double financialAid = 0;
	
	/**
	 * This is the constructor method for Resident class
	 * @param name
	 * @param major
	 * @param numberOfCredits
	 */
	public Resident(String name, Major major, int numberOfCredits) {
		super(name, major, numberOfCredits);
	}
	
	/**
	 * A setter method that sets the financial aid of the resident student
	 * @param financialAid
	 */
	public void setFinancialAid(double financialAid) {
		this.financialAid = financialAid;
	}
	
	/**
	 * A getter method that returns the financial aid of the resident student
	 * @return Financial Aid 
	 */
	public double getFinancialAid() {
		return this.financialAid;
	}
	
	/**
	 * This method calculates the tuition for Resident students
	 */
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
	
	/**
	 * A method that prints out the data of the resident student
	 */
	@Override
	public String toString() {
		return super.toString() + ":resident";
	}
}
