import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is the JUnit test class for add() and remove() methods in the Roster class
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 *
 */
public class RosterTest {

	@Test
	public void testAdd() {
		
		Roster testRoster = new Roster();
		
		
		Student student1 = new Student("John Doe", Major.CS, 13);
		NonResident student2 = new NonResident("John Doe", Major.CS, 20);
		Resident student3 = new Resident("Rob Harrinson", Major.EE, 15);
		TriState student4 = new TriState("Jane Doe", Major.ME, 12, "NY");
		International student5 = new International("Joshua Patel", Major.BA, 14, false);
		TriState student6 = new TriState("Sunny Lin", Major.IT, 18, "CT");
		International student7 = new International("Joshua Patel", Major.CS, 14, true);
		
		assertTrue(testRoster.add(student1));		//Test 1
		assertFalse(testRoster.add(student2));		//Test 2
		assertTrue(testRoster.add(student3));		//Test 3
		assertTrue(testRoster.add(student4));		//Test 4
		assertTrue(testRoster.add(student5));		//Test 5
		assertTrue(testRoster.add(student6));		//Test 6
		assertTrue(testRoster.add(student7));		//Test 7
				
	
	}
	
	@Test
	public void testRemove() {
		
		Roster testRoster = new Roster();
		
		
		Student student1 = new Student("John Doe", Major.CS, 13);
		Resident student2 = new Resident("Rob Harrinson", Major.EE, 15);
		TriState student3 = new TriState("Jane Doe", Major.ME, 12, "NY");
		International student4 = new International("Joshua Patel", Major.BA, 14, false);
		NonResident student5 = new NonResident("John Doe", Major.CS, 20);
		
		testRoster.add(student1);
		testRoster.add(student2);
		testRoster.add(student3);
		testRoster.add(student4);
		
		assertTrue(testRoster.remove(student1));	//Test 1
		assertTrue(testRoster.remove(student2));	//Test 2
		assertTrue(testRoster.remove(student3));	//Test 3
		assertTrue(testRoster.remove(student4));	//Test 4
		assertFalse(testRoster.remove(student5));	//Test 5
		
	
	}
}
