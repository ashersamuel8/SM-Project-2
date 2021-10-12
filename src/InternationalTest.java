import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is the JUnit test class for the tuitionDue() method in the International class
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 *
 */


public class InternationalTest {


	@Test
	public void testTuitionDue() {
		
		International student1 = new International("Mary Johnson",Major.BA,16,false);
		International student2 = new International("Sunny Lin",Major.IT,18,false);
		International student3 = new International("Joshua Patel",Major.CS,12,true);
		International student4 = new International("John Doe",Major.ME,20,true);
		
		student1.tuitionDue();
		student2.tuitionDue();
		student3.tuitionDue();
		student4.tuitionDue();
		
		assertEquals(student1.getTuition(), 35655.00, 0.00);
		assertEquals(student2.getTuition(), 37587.00, 0.00);
		assertEquals(student3.getTuition(), 5918.00, 0.00);
		assertEquals(student4.getTuition(), 9782.00, 0.00);
		
		
	}

}
