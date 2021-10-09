
public class Student {
	
	private Profile profile;
	private int numberOfCredits;
	private double tuition;
	private double totalPayment;
	private Date paymentDate;
	public static final int FULL_TIME_UNIVERSITY_FEE = 3628;
	public static final double PART_TIME_UNIVERSITY_FEE = FULL_TIME_UNIVERSITY_FEE * 0.8; 
	public static final int RESIDENT_CREDIT_RATE = 404;
	public static final int NON_RESIDENT_CREDIT_RATE = 966;
	public static final int RESIDENT_TUITION = 12536;
	
	public Student() {
	}
	
	public Student(String name, Major major, int numberOfCredits) {
		this.profile = new Profile(name, major);
		this.numberOfCredits = numberOfCredits;
		this.totalPayment = 0;
		this.tuition = 0;
	}
	public Student(String name, Major major) {
		this.profile = new Profile(name, major);
		this.totalPayment = 0;
		this.tuition = 0;
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
	public void setNumberOfCredits(int credits) {
		this.numberOfCredits = credits;
	}
	public String getName() {
		return this.profile.getName();
	}
	public Date getPaymentDate() {
		return this.paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
//	public boolean getIsDue() {
//		return this.isDue;
//	}
//	public boolean setIsDue(boolean isDue) {
//		
//		this.isDue = isDue;
//		return isDue;
//		
//	}
	public Profile getProfile() {
		return this.profile;
	}
	public void setTotalPayment(double payment) {
		this.totalPayment = payment;
		
	}
	public double getTotalPayment() {
		return this.totalPayment;
	}

	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			
			Student student = (Student) obj;
			
			return (this.profile.equals(student.getProfile()));
		}
		
		return false;
	}
	
}
