/**
 * This class creates an object of TuitionManager class in order to start the application.
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */

public class RunProject2 {

	public static void main(String args[]) {
		Date currentDate = new Date();
		System.out.println(currentDate.getMonth());
		System.out.println(currentDate.getDay());
		new TuitionManager().run();
		
	}
	
}
