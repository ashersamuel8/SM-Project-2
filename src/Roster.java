/**
 * This class holds all students while the application is running.
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */

public class Roster {
	
	private Student[] rosterList;
	private int size; //keep track of the number of students in the roster 
	
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
	private void grow() { 
		
		Student[] buffArray = new Student[rosterList.length + 4];
		
			for (int i = 0; i < rosterList.length; i++) {
				
				buffArray[i] = rosterList[i];
			
			}
		
		rosterList = buffArray;
		
		
	}
	public boolean add(Student student) { 
		
		int exists = find(student);
		
		if ( exists == -1 ) {
		
			if ( size == rosterList.length ) {
				
				grow();
				rosterList[size] = student;
				size++;
			
			}
			else {
				
				rosterList[size] = student;
				size++;
				
			}
			
			return true;
			
		}
		
		return false;
			
	} 
	public boolean remove(Student student) { 
		

		int exists = find(student);
		
	
		if (exists != -1) {
			
			if(rosterList[exists] instanceof Resident) {
			
				for (int i = exists + 1; i < rosterList.length; i++ ) {
				
					rosterList[i-1] = rosterList[i];
					
				}	
				size--;
				return true;
			}
			
		}
		
		return false;
		
	}
	
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
	

	public void printByPaymentDate() {
		
		if (rosterList[0] == null ) {
			System.out.println("Student roster is empty!");
			return;
		}
		
		System.out.println("* List of students made payments ordered by payment date **");
		
		
		for( int i = 0; i < rosterList.length; i++ ) {
			
			if (rosterList[i] == null) break;
			
		    for( int j=0; j < rosterList.length - 1; j++ ) {
		    	
		    	if(rosterList[j] == null || rosterList[j+1] == null) break;
		    	
		    	if(rosterList[j].getTotalPayment() == 0) continue;
		    	
		        if( rosterList[j].getPaymentDate().compareTo(rosterList[j+1].getPaymentDate()) > 0 ) {
		        	
		        	Student temp = rosterList[j];
		        	rosterList[j] = rosterList[j+1];
		        	rosterList[j+1] = temp;
		        		
		       }
		    }
		    
		}
		
		for (int i = 0; i < rosterList.length; i++) {
			
			if (rosterList[i] == null) break;
			
			if (rosterList[i].getTotalPayment() == 0) continue;
			
			System.out.println(rosterList[i].toString());
			
		}
		
		System.out.println("* End of roster **");
		return;
		
	}

	public void calculateTuition() {
		
		for( int i = 0; i < rosterList.length; i++ ) {
			
			if (rosterList[i] == null) break;
			
			rosterList[i].tuitionDue();
			
		}
		
		
	}
	
	public int payTuition(String name, Major major, double fees, Date paymentDate) {
				
		Student student = new Student(name, major);
		int index = find(student);
		
		if(index != -1) {
			
			if((rosterList[index].getTotalPayment() + fees) > rosterList[index].getTuition()) {
				return 1;
			}
			else {
				rosterList[index].setTotalPayment(rosterList[index].getTotalPayment() + fees);
				return 0;		
			}	
			
		}
		return -1;
	}
	
	public int setStudyAbroadStatus(String name, Major major, boolean studyAbroadStatus) {
		
		Student student = new Student(name, major);
		
		int index = find(student);
		
		if(rosterList[index] instanceof International) {
			
			if(((International) rosterList[index]).getStudyAbroadStatus() == studyAbroadStatus) {
				return 0;
			}
			else {
				
				if(rosterList[index].getNumberOfCredits() > 12) {
					rosterList[index].setNumberOfCredits(12);
				}
					((International) rosterList[index]).tuitionDue();
					rosterList[index].setTotalPayment(0);
					rosterList[index].setPaymentDate(null);
					
			}
			
		}
		
		return -1;
		
	}
	
	public int calculateFinancialAid(String name, Major major, double financialAid) {
		
		Student student = new Student(name, major);
		
		int index = find(student);
		
		if(index != -1) {
			
			if(rosterList[index] instanceof Resident) {
				
				if(rosterList[index].getNumberOfCredits() < 12) return -1;
				
				else {
					
					if(((Resident) rosterList[index]).getFinancialAid() == 0) {
						
						((Resident) rosterList[index]).setFinancialAid(financialAid);
						
						return 1;
					}
					
					return 0;
					
				}
				
			}
	
		}
		
		return -2;
		
		
	}
	
	
	public Roster(){
		
		rosterList = new Student[4];
		size = 0;
		
	}
	

}
