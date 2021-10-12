import java.text.DecimalFormat;

/**
 * This class serves as a parent to all of the various types of students, as it defines all of the items which are common between all students.
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */

public class Student {
	
	private Profile profile;
	private int numberOfCredits;
	private double tuition;
	private double totalPayment;
	private Date paymentDate;
	public static final int FULL_TIME_UNIVERSITY_FEE = 3268;
	public static final double PART_TIME_UNIVERSITY_FEE = FULL_TIME_UNIVERSITY_FEE * 0.8; 
	public static final int RESIDENT_CREDIT_RATE = 404;
	public static final int NON_RESIDENT_CREDIT_RATE = 966;
	public static final int RESIDENT_TUITION = 12536;
	
	/**
	 * The constructor method for the student class
	 * @param name
	 * @param major
	 * @param numberOfCredits
	 */
	public Student(String name, Major major, int numberOfCredits) {
		this.profile = new Profile(name, major);
		this.numberOfCredits = numberOfCredits;
		this.totalPayment = 0;
		this.tuition = 0;
	}
	
	/**
	 * Another overloaded constructor method for the student class
	 * @param name
	 * @param major
	 */
	public Student(String name, Major major) {
		this.profile = new Profile(name, major);
		this.totalPayment = 0;
		this.tuition = 0;
	}
	
	/**
	 * The do-nothing method of the student class, serves as a placeholder for child classes
	 */
	public void tuitionDue() { 
		
	}
	
	/**
	 * This method prints out the data of the Student object
	 * @return string format of Student
	 */
	@Override
	public String toString() {
		
		final DecimalFormat decimalFormat = new DecimalFormat( "##,##,##0.00" );
		String output = this.profile.toString() + ":" + this.numberOfCredits + " credits hours:tuition due:" 
						+ decimalFormat.format(this.tuition) + ":total payment:";
		
		if(this.totalPayment == 0) {
			return output + "0.00:last payment date: --/--/--";
			
		}
		else {
			return output + decimalFormat.format(this.totalPayment) + ":last payment date: " 
					+ this.paymentDate.toString(); 
		}
		
	}
	
	/**
	 * A method to set the tuition of a student 
	 * @param tuition
	 */
	public void setTuition(double tuition) {
		this.tuition = tuition;
	}
	
	/**
	 * A method to get the tuition of a student 
	 * @return tuition
	 */
	public double getTuition() {
		return this.tuition;
	}
	
	/**
	 * A method to get the number of credits of a student
	 * @return number of credits
	 */
	public int getNumberOfCredits() {
		return this.numberOfCredits;
	}
	
	/**
	 * A method that sets the number of credits of a student
	 * @param credits
	 */
	public void setNumberOfCredits(int credits) {
		this.numberOfCredits = credits;
	}
	
	/**
	 * A method that gets the name of the student
	 * @return student name
	 */
	public String getName() {
		return this.profile.getName();
	}
	
	/**
	 * A method that gets the last payment date of the fees payed by the student
	 * @return payment date
	 */
	public Date getPaymentDate() {
		return this.paymentDate;
	}
	
	/**
	 * A method that sets the payment date of a student when fees is payed
	 * @param paymentDate
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	/**
	 * A method that returns the profile of the student
	 * @return profile
	 */
	public Profile getProfile() {
		return this.profile;
	}
	
	/**
	 * A method that sets the total payment of the student
	 * @param payment
	 */
	public void setTotalPayment(double payment) {
		this.totalPayment = payment;
		
	}
	
	/**
	 * A method that gets the total payment of the student 
	 * @return total payment
	 */
	public double getTotalPayment() {
		return this.totalPayment;
	}

	/**
	 * A method that checks if two students have the same profile or not
	 * @param obj
	 * @return true if equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			
			Student student = (Student) obj;
			
			return (this.profile.equals(student.getProfile()));
		}
		
		return false;
	}
	
}
