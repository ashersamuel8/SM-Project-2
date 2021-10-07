
public class Roster {
	
	private Student[] roster;
	private int size; //keep track of the number of students in the roster 
	
	private int find(Student student) {
		 
		int rosterIndex = -1;
		for ( int i = 0; i < roster.length; i++ ) {
			
			if (roster[i] == null) break;
			
			if (student.equals(roster[i])) {
				
				rosterIndex = i;
				break;
				
			}
			
		}
		
		return rosterIndex;
		
	} 
	private void grow() { 
		
		Student[] buffArray = new Student[roster.length + 4];
		
			for (int i = 0; i < roster.length; i++) {
				
				buffArray[i] = roster[i];
			
			}
		
		roster = buffArray;
		
		
	}
	public boolean add(Student student) { 
		

		int exists = find(student);
		

		if ( exists == -1 ) {
		
			if ( size == roster.length ) {
				
				grow();
				roster[size] = student;
				size++;
			
			}
			else {
				
				roster[size] = student;
				size++;
				
			}
			
			return true;
			
		}
		
		return false;
		
		
	} 
	public boolean remove(Student student) { 
		

		int exists = find(student);
		
	
		if (exists != -1) {
			
			for (int i = exists + 1; i < roster.length; i++ ) {
				
				roster[i-1] = roster[i];
					
			}	
			size--;
			
			return true;
			
		}
		
		return false;
		
		
	}
	
	public void print() {	
		
		if (roster[0] == null ) {
			System.out.println("Student Roster is empty!");
			return;
		}
		
		System.out.println("* List of students in the roster **");
		
		for(int i = 0; i < roster.length; i++) {
			
			if (roster[i] == null) break;
			
			System.out.println(roster[i].toString());	
			
		}	
		
		System.out.println("* End of roster **");
		return;
		
	}
	

	public void printByStudentName() {
		
		if (roster[0] == null ) {
			System.out.println("Student roster is empty!");
			return;
		}
		
	
		for( int i = 0; i < roster.length; i++ ) {
			
			if (roster[i] == null) break;
			
		    for( int j = 0; j < roster.length - 1; j++ ) {
		    	
		    	if(roster[j] == null || roster[j+1] == null) break;
		    	
		        if( roster[j].getName().compareTo(roster[j+1].getName()) > 0 ) {
		        	
		            Student temp = roster[j];
		            roster[j] = roster[j+1];
		            roster[j+1] = temp;
		       }
		    }
		}
		
		System.out.println("* List of students ordered by name **");
		
		
		for (int i = 0; i < roster.length; i++) {
			
			if (roster[i] == null) break;
			
			System.out.println(roster[i].toString());
			
		}	
		
		System.out.println("* End of roster **");
		return;
		
	}
	

	public void printByPaymentDate() {
		
		if (roster[0] == null ) {
			System.out.println("Student roster is empty!");
			return;
		}
		
		System.out.println("* List of students made payments ordered by payment date **");
		
		
		for( int i = 0; i < roster.length; i++ ) {
			
			if (roster[i] == null) break;
			
		    for( int j=0; j < roster.length - 1; j++ ) {
		    	
		    	if(roster[j] == null || roster[j+1] == null) break;
		    	
		    	if(roster[j].getIsDue()) continue;
		    	
		        if( roster[j].getPaymentDate().compareTo(roster[j+1].getPaymentDate()) > 0 ) {
		        	
		        	Student temp = roster[j];
		        	roster[j] = roster[j+1];
		        	roster[j+1] = temp;
		        		
		       }
		    }
		    
		}
		
		for (int i = 0; i < roster.length; i++) {
			
			if (roster[i] == null) break;
			
			if (roster[i].getIsDue()) continue;
			
			System.out.println(roster[i].toString());
			
		}
		
		System.out.println("*End of list");
		return;
		
	}

	
	public Roster(){
		
		roster = new Student[4];
		size = 0;
		
	}
	

}
