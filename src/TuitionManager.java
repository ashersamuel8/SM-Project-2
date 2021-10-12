import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
/**
 * This class performs the Input/Output part of this project.
 * It uses an instance of the Roster class to process all tuition related commands
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */
public class TuitionManager {
	
	private Scanner inputObj;				
	private String inputString;				
	private StringTokenizer input;			
	String command;							
	public static Roster roster;	

	/**
	 * This is the method that's called by the main method in the runProject2 class
	 * This method runs until the input command is "Q"
	 */
	public void run() {
		
		System.out.println("Tuition Manager starts running.");
		System.out.println();
		
		roster = new Roster();
		
	
		while(true) {
			
			try {	
				
				inputObj = new Scanner(System.in);			
		
				inputString = inputObj.nextLine();	
				
				//Input String is Tokenized by the delimiter ","
				input = new StringTokenizer(inputString, ",");		
		 		
				//gets the input command
				command = input.nextToken();
		 		
				if(command.equals("Q")) break;
				
				readInput();
		 
			} catch(NoSuchElementException e){
			
				System.out.println("Missing data in command line.");
			
			} catch(Exception e) {
				
				System.out.println(e);
			}
		 
		} 
		
		System.out.println("Tuition Manager Terminated.");		
		
	}
	
	/**
	 * This method calls various methods based on the input command.
	 */
	private void readInput(){
		
		switch(command) {
		case "AR":							
				 addResidentStudent();
				 break;
		
		case "AN":							
				 addNonResidentStudent();
				 break;
				 
		case "AT":						
				 addTriStateStudent();
				 break;
	
		case "AI":							
				 addInternationalStudent();
				 break;
	
		case "R":							
				 removeStudent();
				 break;
			
		
		case "C":							
				 calculateTuition();
				 break;
		
		case "T":							
				 payTuitionFees();
				 break;
				 
		case "S":
				 studyAbroad();
				 break;
				
		case "F":		
				 setFinancialAid();
				 break;
				
		case "P":
				 print();
				 break;
			
		case "PN":
				 printByStudentName();
				 break;
				
		case "PT":
				 printByPaymentDate();
				 break;
			
		default:
			
			System.out.println("Command '" + command + "' not supported!");
			
		}
		
		return;
	}
	
	/**
	 * Takes in all the input attributes, creates a Resident object,
	 * and passes it to the add() method in the Roster class
	 */
	private void addResidentStudent() {
		
		try {
			
			String studentName = input.nextToken();
			String majorString = input.nextToken();
			
			if(!majorString.toLowerCase().equals("cs") && !majorString.toLowerCase().equals("it") && 
			   !majorString.toLowerCase().equals("ba") && !majorString.toLowerCase().equals("ee") && 
			   !majorString.toLowerCase().equals("me")) {
				
				System.out.println("'" + majorString + "' is not a valid major.");
				return;
				
			}
			
			Major major = getMajor(majorString);
			
			if(!input.hasMoreTokens()) {
				
				System.out.println("Credit hours missing.");
				return;
			}
			
			int credits = Integer.parseInt(input.nextToken());
			
			if(credits < 0) {
				System.out.println("Credit hours cannot be negative.");
				return;
			}
			else if(credits < 3) {
				System.out.println("Minimum credit hours is 3.");
				return;
			}
			else if(credits > 24) {
				System.out.println("Credit hours exceed the maximum 24.");
				return;
			}
			
			Resident newStudent = new Resident(studentName, major, credits);
			
			if (roster.add(newStudent)) { 
				System.out.println("Student added.");
			}
			else {
				System.out.println("Student is already in the roster.");
			}
			
		
		} catch(NumberFormatException e) {
			
			System.out.println("Invalid credit hours");
			
		} catch(InputMismatchException e) {
			
			System.out.println("Missing data in command line.");
			
		}
		
		return;
		
	}
	
	/**
	 * Takes in all the input attributes, creates a NonResident object,
	 * and passes it to the add() method in the Roster class
	 */
	private void addNonResidentStudent() {
		
		try {
			
			String studentName = input.nextToken();
			String majorString = input.nextToken();
			
			if(!majorString.toLowerCase().equals("cs") && !majorString.toLowerCase().equals("it") && 
			   !majorString.toLowerCase().equals("ba") && !majorString.toLowerCase().equals("ee") && 
			   !majorString.toLowerCase().equals("me")) {
				
				System.out.println("'" + majorString + "' is not a valid major.");
				return;
				
			}
			
			Major major = getMajor(majorString);
			
			if(!input.hasMoreTokens()) {
				
				System.out.println("Credit hours missing.");
				return;
			}
			
			int credits = Integer.parseInt(input.nextToken());

			if(credits < 0) {
				System.out.println("Credit hours cannot be negative.");
				return;
			}
			else if(credits < 3) {
				System.out.println("Minimum credit hours is 3.");
				return;
			}
			else if(credits > 24) {
				System.out.println("Credit hours exceed the maximum 24.");
				return;
			}
			
			
			NonResident newStudent = new NonResident(studentName, major, credits);
			
			if (roster.add(newStudent)) { 
				System.out.println("Student added.");
			}
			else {
				System.out.println("Student is already  in the roster.");
			}
			
		
		} catch(NumberFormatException e) {
			
			System.out.println("Invalid credit hours");
			
		} catch(InputMismatchException e) {
			
			System.out.println("Missing data in command line.");
			
		}
		
		return;
		
	}
	
	/**
	 * Takes in all the input attributes, creates a TriState object,
	 * and passes it to the add() method in the Roster class
	 */
	private void addTriStateStudent() {
	

		try {
			
			String studentName = input.nextToken();
			String majorString = input.nextToken();

			if(!majorString.toLowerCase().equals("cs") && !majorString.toLowerCase().equals("it") && 
			   !majorString.toLowerCase().equals("ba") && !majorString.toLowerCase().equals("ee") && 
			   !majorString.toLowerCase().equals("me")) {
				
				System.out.println("'" + majorString + "' is not a valid major.");
				return;
				
			}

			Major major = getMajor(majorString);

			if(!input.hasMoreTokens()) {
				
				System.out.println("Credit hours missing.");
				return;
			}
			
			int credits = Integer.parseInt(input.nextToken());
			String state = input.nextToken();
			

			if(credits < 0) {
				System.out.println("Credit hours cannot be negative.");
				return;
			}
			else if(credits < 3) {
				System.out.println("Minimum credit hours is 3.");
				return;
			}
			else if(credits > 24) {
				System.out.println("Credit hours exceed the maximum 24.");
				return;
			}

			if (!state.toUpperCase().equals("NY") && !state.toUpperCase().equals("CT")) {
				
				System.out.println("Not part of the tri-state area.");
				return;
				
			}
			
			
			TriState newStudent = new TriState(studentName, major, credits, state.toUpperCase());
			
			if (roster.add(newStudent)) { 
				System.out.println("Student added.");
			}
			else {
				System.out.println("Student is already in the roster.");
			}
			
		
		} catch(NumberFormatException e) {
			
			System.out.println("Invalid credit hours.");
			
		} catch(InputMismatchException e) {
			
			System.out.println("Missing data in command line.");
			
		}
		
		return;
		
	}
	
	/**
	 * Takes in all the input attributes, creates an International object,
	 * and passes it to the add() method in the Roster class
	 */
	private void addInternationalStudent() {

		try {
			
			String studentName = input.nextToken();
			String majorString = input.nextToken();

			if(!majorString.toLowerCase().equals("cs") && !majorString.toLowerCase().equals("it") && 
			   !majorString.toLowerCase().equals("ba") && !majorString.toLowerCase().equals("ee") && 
			   !majorString.toLowerCase().equals("me")) {
				
				System.out.println("'" + majorString + "' is not a valid major.");
				return;
				
			}
			
			Major major = getMajor(majorString);

			if(!input.hasMoreTokens()) {
				
				System.out.println("Credit hours missing.");
				return;
			}
			
			int credits = Integer.parseInt(input.nextToken());
			boolean isStudyAbroad = false;
			
			if(credits < 0) {
				System.out.println("Credit hours cannot be negative.");
				return;
			}
			else if(credits < 3) {
				System.out.println("Minimum credit hours is 3.");
				return;
			}
			else if(credits < 12) {
				System.out.println("International students must enroll at least 12 credits.");
				return;
			}
			else if(credits > 24) {
				System.out.println("Credit hours exceed the maximum 24.");
				return;
			}
			
			
			if(input.hasMoreTokens()) {
				
				String isStudyAbroadString = input.nextToken();
				
				if(isStudyAbroadString.toLowerCase().equals("true")) isStudyAbroad = true;
				
				else if (!isStudyAbroadString.toLowerCase().equals("false")) {
					System.out.println("Enter a valid Study abroad status.");
					return;
					
				}
		
			}
			
			International newStudent = new International(studentName, major, credits, isStudyAbroad);
			
			
			if (roster.add(newStudent)) { 
				System.out.println("Student added.");
			}
			else {
				System.out.println("Student is already in the roster.");
			}
			
		
		} catch(NumberFormatException e) {
			
			System.out.println("Invalid credit hours.");
			
		} catch(InputMismatchException e) {
			
			System.out.println("Missing data in command line.");
			
		}
		
		return;
		
	}
	
	/**
	 * A method that converts a string to a Major Object
	 * @param majorString
	 * @return major
	 */
	private Major getMajor(String majorString) {
		
		Major major = null;
		
		if(majorString.toUpperCase().equals("CS")) major = Major.CS;
		
		else if(majorString.toUpperCase().equals("IT")) major = Major.IT;
		
		else if(majorString.toUpperCase().equals("BA")) major = Major.BA;
		
		else if(majorString.toUpperCase().equals("EE")) major = Major.EE;
		
		else if(majorString.toUpperCase().equals("ME")) major = Major.ME;
		
		return major;
		
		
	}
	
	/**
	 * Takes the input attributes and passes them to the remove() method in the Roster class
	 */
	private void removeStudent() {
		
		try {
			
			String studentName = input.nextToken();
			String majorString = input.nextToken();
			
			if(!majorString.toLowerCase().equals("cs") && !majorString.toLowerCase().equals("it") && 
			   !majorString.toLowerCase().equals("ba") && !majorString.toLowerCase().equals("ee") && 
			   !majorString.toLowerCase().equals("me")) {
						
				    System.out.println("'" + majorString + "' is not a valid major.");
					return;
						
			}
			
			Major major = getMajor(majorString);
			
			Student removeStudent = new Student(studentName, major);
				
			if(roster.remove(removeStudent)) System.out.println("Student removed from the roster.");
			
			else System.out.println("Student is not in the roster.");
					
			
		} catch(InputMismatchException e) {
			
			System.out.println("Missing data in command line.");
			
		}
		
		return;
		
	}
	
	/**
	 * Invokes the calculateTuition() method in the Roster Class
	 */
	private void calculateTuition() {
		
		roster.calculateTuition();
		System.out.println("Calculation completed.");
		
	}
	
	/**
	 * Takes in the input attributes and passes them to the payTuition() method in the Roster class
	 */
	private void payTuitionFees() {
		
		try {
			String name = input.nextToken();
			String majorString = input.nextToken();
			
			if(!majorString.toLowerCase().equals("cs") && !majorString.toLowerCase().equals("it") && 
			   !majorString.toLowerCase().equals("ba") && !majorString.toLowerCase().equals("ee") && 
			   !majorString.toLowerCase().equals("me")) {
						
				    System.out.println("'" + majorString + "' is not a valid major.");
					return;
						
			}
			
			Major major = getMajor(majorString);
			
			if(!input.hasMoreTokens()) {
				System.out.println("Payment amount missing.");
				return;
			}
			
			double fees = Double.parseDouble(input.nextToken());
			
			if(fees <= 0) {
				System.out.println("Invalid Amount.");
				return;
			}
			
			Date paymentDate = new Date(input.nextToken());
		
			if(!paymentDate.isValid()) {
			
				System.out.println("Payment date invalid.");
				return;
			
			}
			
			if(fees == 0) System.out.println("Invalid amount");
		
			switch(roster.payTuition(name, major, fees, paymentDate)) {
			
				case 1:
					System.out.println("Amount is greater than amount due.");
					break;
					
				case 0:
					System.out.println("Payment applied.");
					break;
					
				case -1:
					System.out.println("Student does not exist in the roster.");
					break;
			}
			
		} catch(NumberFormatException e) {
			
			System.out.println("Invalid Amount.");
			
		} catch(InputMismatchException e) {
			
			System.out.println("Missing date in command line.");
			
		}
		return;
	}
	
	/**
	 * Takes in the input study abroad status and passes it to the setStudyAbroadStatus() in the Roster class
	 */
	private void studyAbroad() {
		try {
			
			String name = input.nextToken();
			String majorString = input.nextToken();

			if(!majorString.toLowerCase().equals("cs") && !majorString.toLowerCase().equals("it") && 
			   !majorString.toLowerCase().equals("ba") && !majorString.toLowerCase().equals("ee") && 
			   !majorString.toLowerCase().equals("me")) {
						
				    System.out.println("'" + majorString + "' is not a valid major.");
					return;
						
			}
			
			Major major = getMajor(majorString);
			boolean studyAbroadStatus = Boolean.parseBoolean(input.nextToken());
			
			switch(roster.setStudyAbroadStatus(name, major, studyAbroadStatus)) {
			
			case 1:
				System.out.println("Tuition Updated.");
				break;
				
			case 0:
				System.out.println("Enter a new status.");
				break;
				
			case -1:
				System.out.println("Couldn't find the international student.");
				break;
			}
			
		} catch (Exception e) {
			System.out.println("Missing data in command line.");
			
		} 
		
	}
	
	/**
	 * Takes in the input financial aid amount and passes it to the calculateFinancialAid() method in the Roster class
	 */
	private void setFinancialAid() {
		
		try {
			
			String name = input.nextToken();
			String majorString = input.nextToken();

			if(!majorString.toLowerCase().equals("cs") && !majorString.toLowerCase().equals("it") && 
			   !majorString.toLowerCase().equals("ba") && !majorString.toLowerCase().equals("ee") && 
			   !majorString.toLowerCase().equals("me")) {
						
				    System.out.println("'" + majorString + "' is not a valid major.");
					return;
						
			}
			
			Major major = getMajor(majorString);
			
			if(!input.hasMoreTokens()) {
				
				System.out.println("Missing the amount.");
				return;
			}
			
			double aid = Double.parseDouble(input.nextToken());
			
			if(aid < 0 || aid > 10000) {
				System.out.println("Invalid Amount.");
				return;
			}

			switch(roster.calculateFinancialAid(name, major, aid)) {
			
			case 2:
				System.out.println("Tuition Updated.");
				break;
				
			case 1:
				System.out.println("Awarded once already.");
				break;
				
			case 0:
				System.out.println("Parttime student doesn't qualify for the award.");
				break;
				
			case -1:
				System.out.println("Not a resident student.");
				break;
				
			case -2:
				System.out.println("Student not in the roster.");
			}
			
			
			
		} catch (NumberFormatException e) {
			System.out.println("Invalid amount.");
			
		} catch (InputMismatchException e) {
			System.out.println("Missing data in command line.");
			
		}
		
	}
	
	/**
	 * Invokes print method in Roster class
	 */
	private void print() {
		
		roster.print();
		
	}
	
	/**
	 * Invokes printByStudentName() method in Roster class.
	 */
	private void printByStudentName() {
		
		roster.printByStudentName();
		
	}
	
	/**
	 * Invokes printByPaymentDate() method in the Roster class
	 */
	private void printByPaymentDate() {
		
		roster.printByPaymentDate();
		
	}

	
}
