/**
 * This class performs actions like add, remove, printing, setting study abroad status, and calculating tuition & financial aid
 * on the roster.
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */

public class Roster {
	
	private Student[] rosterList;
	private int size; 			//keep track of the number of students in the roster 
	
	/**
	 * A private method that searches for a student the roster array list and returns the index.
	 * @param student
	 * @return index of the student, -1 if student does not exist.
	 */
	private int find(Student student) {
		 
		int rosterIndex = -1;
		for ( int i = 0; i < rosterList.length; i++ ) {
			
			if (rosterList[i] == null) break;
			
			if (student.equals(rosterList[i])) {
				
				rosterIndex = i;
				break;
				
			}
			
		}
		
		return rosterIndex;
		
	} 
	
	/**
	 * This method grows the size of the roster array list by 4 every time its capacity is full.
	 */
	private void grow() { 
		
		Student[] buffArray = new Student[rosterList.length + 4];
		
			for (int i = 0; i < rosterList.length; i++) {
				
				buffArray[i] = rosterList[i];
			
			}
		
		rosterList = buffArray;
		
		
	}
	
	/**
	 * This method adds a student to the roster array list. 
	 * @param student
	 * @return true if student is added, false if student already exists
	 */
	public boolean add(Student student) { 
		
		int exists = find(student);
		
		if ( exists == -1 ) {
		
			if ( size == rosterList.length ) grow();
				
			rosterList[size] = student;
			size++;
			
			return true;
			
		}
		return false;	
	} 
	
	/**
	 * This method removes a student from the roster array list
	 * @param student
	 * @return true is student is removed, false if student doesnt exist/not removed
	 */
	public boolean remove(Student student) { 
		

		int exists = find(student);
		
	
		if (exists != -1) {
			
				for (int i = exists + 1; i <= rosterList.length; i++ ) {
					
					if(i != rosterList.length) rosterList[i-1] = rosterList[i];
					else rosterList[i-1] = null;
					
				}	
				size--;
				return true;
		}
		return false;
	}
	
	/**
	 * A method that prints out the roster list
	 */
	public void print() {	
		
		if (rosterList[0] == null ) {
			System.out.println("Student roster is empty!");
			return;
		}
		
		System.out.println("* List of students in the roster **");
		
		for(int i = 0; i < rosterList.length; i++) {
			
			if (rosterList[i] == null) break;
			
			System.out.println(rosterList[i].toString());	
			
		}	
		
		System.out.println("* End of roster **");
		return;
		
	}
	
	/**
	 * A method that prints out the roster list ordered by student name
	 */
	public void printByStudentName() {
		
		if (rosterList[0] == null ) {
			System.out.println("Student roster is empty!");
			return;
		}
		
	
		for( int i = 0; i < rosterList.length; i++ ) {
			
			if (rosterList[i] == null) break;
			
		    for( int j = 0; j < rosterList.length - 1; j++ ) {
		    	
		    	if(rosterList[j] == null || rosterList[j+1] == null) break;
		    	
		        if( rosterList[j].getName().compareTo(rosterList[j+1].getName()) > 0 ) {
		        	
		            Student temp = rosterList[j];
		            rosterList[j] = rosterList[j+1];
		            rosterList[j+1] = temp;
		       }
		    }
		}
		
		System.out.println("* List of students ordered by name **");
		
		
		for (int i = 0; i < rosterList.length; i++) {
			
			if (rosterList[i] == null) break;
			
			System.out.println(rosterList[i].toString());
			
		}	
		
		System.out.println("* End of roster **");
		return;
		
	}
	
	/**
	 * A method that prints out the roster list ordered by payment date. 
	 * Students who did not make at least one payment will not be displayed.
	 */
	public void printByPaymentDate() {
		
		if (rosterList[0] == null ) {
			System.out.println("Student roster is empty!");
			return;
		}
		
		System.out.println("* List of students ordered by payment date **");
		
		//Creating a temporary array list to store data of students who made at least one payment
		Student[] tempRosterList = new Student[rosterList.length];
		
		int rosterListIndex = 0;
		int tempRosterListIndex = 0;
		
		//Copying the data into the temporary array list
		while(true) {
			
			if (rosterListIndex == rosterList.length) break;
			if (rosterList[rosterListIndex] == null) break;
			if(rosterList[rosterListIndex].getTotalPayment() != 0) {
				tempRosterList[tempRosterListIndex] = rosterList[rosterListIndex];
				tempRosterListIndex++;
			}
			rosterListIndex++;
		}
		
		
		for( int i = 0; i < tempRosterList.length; i++ ) {
			
			if (tempRosterList[i] == null) break;
			
		    for( int j = 0; j < tempRosterList.length - 1; j++ ) {
		    	
		    	if(tempRosterList[j] == null || tempRosterList[j+1] == null) break;
		    	
		    	if(tempRosterList[j].getPaymentDate().compareTo(tempRosterList[j+1].getPaymentDate()) > 0 ) {
		        	
		        	Student temp = tempRosterList[j];
		        	tempRosterList[j] = tempRosterList[j+1];
		        	tempRosterList[j+1] = temp;
		      	
		       }
		    
		    }
		    
		}
		
		for (int i = 0; i < tempRosterList.length; i++) {
			
			if (tempRosterList[i] == null) break;
			System.out.println(tempRosterList[i].toString());
		}
		
		System.out.println("* End of roster **");
		return;
		
	}
	
	/**
	 * A method to calculate the tuition of all the students in the roster list
	 */
	public void calculateTuition() {
		
		for( int i = 0; i < rosterList.length; i++ ) {
			
			if (rosterList[i] == null) break;
			
			rosterList[i].tuitionDue();
			
		}
	}
	
	/**
	 * A method that updates the tuition due of a student when the fees is payed 
	 * @param name
	 * @param major
	 * @param fees
	 * @param paymentDate
	 * @return 1 if the fees exceeds tuition due
	 * @return 0 if the fees is payed and tuition is updated
	 * @return -1 if the student doesnt exist
	 */
	public int payTuition(String name, Major major, double fees, Date paymentDate) {
				
		Student student = new Student(name, major);
		int index = find(student);
		
		if(index != -1) {
			
			if((rosterList[index].getTuition() - fees) < 0) {
				return 1;
			}
			else {
				rosterList[index].setTotalPayment(rosterList[index].getTotalPayment() + fees);
				rosterList[index].setPaymentDate(paymentDate);
				rosterList[index].setTuition(rosterList[index].getTuition() - fees);
				return 0;		
			}	
			
		}
		return -1;
	}
	
	/**
	 * A method that sets the study abroad status of an international student
	 * @param name
	 * @param major
	 * @param studyAbroadStatus
	 * @return 1 if the study abroad status is succesfully changed
	 * @return 0 if the study abroad status is the same as the one that already exists
	 * @return -1 if the study abroad status is not changed/Student is not an itnernational student/Student not found
	 */
	public int setStudyAbroadStatus(String name, Major major, boolean studyAbroadStatus) {
		
		Student student = new Student(name, major);
		
		int index = find(student);
		
		if(index != -1) {
			if(rosterList[index] instanceof International) {
			
				if(((International) rosterList[index]).getStudyAbroadStatus() == studyAbroadStatus) {
					return 0;
				}
				else {
				
					if(rosterList[index].getNumberOfCredits() > 12) {
						rosterList[index].setNumberOfCredits(12);
					}
					
					((International) rosterList[index]).setStudyAbroadStatus(studyAbroadStatus);
					((International) rosterList[index]).tuitionDue();
					rosterList[index].setTotalPayment(0);
					rosterList[index].setPaymentDate(null);
					return 1;
				}
			
			}
		}
		return -1;
		
	}
	
	/**
	 * A method to calculate and update the financial aid and tuition of a resident student
	 * @param name
	 * @param major
	 * @param financialAid
	 * @return 2 if the financial aid is awarded
	 * @return 1 if financial aid has already been awarded
	 * @return 0 if the student is part time
	 * @return -1 if the student is not a resident student
	 * @return -2 if the student is not in the roster
	 */
	public int calculateFinancialAid(String name, Major major, double financialAid) {
		
		Student student = new Student(name, major);
		
		int index = find(student);
		
		if(index != -1) {
			
			if(rosterList[index] instanceof Resident) {
				
				if(rosterList[index].getNumberOfCredits() < 12) return 0;
				
				else {
					
					if(((Resident) rosterList[index]).getFinancialAid() == 0) {
						
						((Resident) rosterList[index]).setFinancialAid(financialAid);
						rosterList[index].setTuition(rosterList[index].getTuition() - financialAid);
						
						return 2;
					}
					
					return 1;
					
				}
				
			}
			
			return -1;
	
		}
		
		return -2;
		
	}
	
	public Roster(){
		
		rosterList = new Student[4];
		size = 0;
		
	}
	

}
