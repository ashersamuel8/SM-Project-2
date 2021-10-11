/**
 * This class defines the properties that are specific to nonresident students, it is a child of the Student class.
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */

public class NonResident extends Student {
	
	public static final int NON_RESIDENT_TUITION = 29737;
	private static final int NON_RESIDENT_CREDIT_RATE = 966; 
	
	/**
	 * A constructor method for the NonResident class
	 * @param name
	 * @param major
	 * @param numberOfCredits
	 */
	public NonResident(String name, Major major, int numberOfCredits) {
		super(name, major, numberOfCredits);
	}
	
	/**
	 * This method calculates the tuition for NonResident students.
	 */
	@Override
	public void tuitionDue() {
		if (this.getNumberOfCredits() >= 12) {
			double tempTuition = NonResident.NON_RESIDENT_TUITION + Student.FULL_TIME_UNIVERSITY_FEE;
			if (this.getNumberOfCredits() > 16) {
				tempTuition += (this.getNumberOfCredits() - 16) * NonResident.NON_RESIDENT_CREDIT_RATE;
			}
			
			this.setTuition(tempTuition);
		}
		else {
			double tempTuition = (NonResident.NON_RESIDENT_CREDIT_RATE * this.getNumberOfCredits()) + Student.PART_TIME_UNIVERSITY_FEE;
			
			this.setTuition(tempTuition);
		}
	}
	
	/**
	 * A method that prints out the data of a non-resident student
	 */
	@Override
	public String toString() {
		return super.toString() + ":non-resident";
	}	
}
