import java.util.Scanner;
import java.util.StringTokenizer;

public class TuitionManager {

	Roster roster = new Roster();
	String command;
	
	public static void run() {
		
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Payroll Processing starts.");
        
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(input, ",");
            
            command = tokenizer.nextToken();
            
            String name;
            String major;
            int creditHours;
            
            if (input.equals("Q")) {
                System.out.println("Tuition Manager terminated.");
                break;
            }
            
            //readInput();
            
            else if (command.equals("P")) {
                roster.print();
            }

            else if (command.equals("PN")) {
                roster.printByName();
            }

            else if (command.equals("PT")) {
                roster.printByPayment();
            }
            
            else if () {
            	
            }
        }
	}
	
	/*
	private void readInput() {
		
		switch(command) {
			case "P":
				roster.print();
				break;
			case "PN":
				roster.printByName();
				break;
			case "PT":
				roster.printByPayment();
				break;
			case "AR":
				roster.add();
				break;
			case "AN":
				break;
			case "AT":
				break;
			case "AI":
				break;
			case "R":
				break;
			case "C":
				break;
			case "T":
				break;
			case "S":
				break;
			case "F":
				break;
		}
	}
	*/
}
