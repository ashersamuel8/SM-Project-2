/**
 * This class defines all of the properties specific to international students, it is a child of the NonResident class. 
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */

public class International extends NonResident {
	private static final int INTERNATIONAL_FEE = 2650;
	private boolean studyAbroadProgram = false;
	
	/**
	 * A constructor method for the class International.
	 * @param name
	 * @param major
	 * @param numberOfCredits
	 * @param studyAbroadProgram
	 */
	public International(String name, Major major, int numberOfCredits, boolean studyAbroadProgram) {
		super(name, major, numberOfCredits);
		this.studyAbroadProgram = studyAbroadProgram;
	}
	
	/**
	 * A setter method that sets the study abroad status of the international student
	 * @param status
	 */
	public void setStudyAbroadStatus(boolean status) {
		this.studyAbroadProgram = status;
	}
	public boolean getStudyAbroadStatus() {
		return this.studyAbroadProgram;
	}
	
	/**
	 * A method that calculates the tuition due of the International Student. 
	 * This method uses super.tuitionDue() and adds INTERNATIONAL_FEE to it.
	 * If Study abroad is true, it subtracts NON_RESIDENT_TUITION from the fees.
	 */
	@Override
	public void tuitionDue() {
		
		super.tuitionDue();
		this.setTuition(getTuition() + International.INTERNATIONAL_FEE);
		if (studyAbroadProgram) {
			this.setTuition(getTuition() - NonResident.NON_RESIDENT_TUITION);
		}
	}
	
	/**
	 * A method that prints the data of international student.
	 */
	@Override
	public String toString() {
		String output = super.toString() + ":international";
		if(this.studyAbroadProgram) return output + ":study abroad";
		return output;
	}
	
	public static void main (String args[]) {
		
		//Test cases for the tuitionDue() method  of this class
		
		International student1 = new International("Mary Johnson",Major.BA,16,false);
		International student2 = new International("Sunny Lin",Major.IT,18,false);
		International student3 = new International("Joshua Patel",Major.CS,12,true);
		International student4 = new International("John Doe",Major.ME,20,true);
		
		student1.tuitionDue();
		student2.tuitionDue();
		student3.tuitionDue();
		student4.tuitionDue();
		
		//Test case 1
		System.out.println(student1.toString());
		
		//Test case 2
		System.out.println(student2.toString());
				
		//Test case 3
		System.out.println(student3.toString());
				
		//Test case 4
		System.out.println(student4.toString());
		
		
	}
}
