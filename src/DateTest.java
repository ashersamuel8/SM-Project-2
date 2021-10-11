import static org.junit.Assert.*;

import org.junit.Test;

public class DateTest {

	@Test
	public void testIsValid() {
		
		Date date1 = new Date("21/1/2021");
		Date date2 = new Date("2/29/2021");
		Date date3 = new Date("4/31/2021");
		Date date4 = new Date("12/1/2021");
		Date date5 = new Date("11/1/2020");
		Date date6 = new Date("7/32/2021");
		Date date7 = new Date("2/1/2021");
		Date date8 = new Date("9/12/2021");
		Date date9 = new Date("8/30/2021");
		Date date10 = new Date("6/12/2021");
		Date date11 = new Date("7/12/2021");
		Date date12 = new Date("8/12/2021");
		Date date13 = new Date("5/31/2021");
		
		assertFalse(date1.isValid());
		assertFalse(date2.isValid());
		assertFalse(date3.isValid());
		assertFalse(date4.isValid());
		assertFalse(date5.isValid());
		assertFalse(date6.isValid());
		assertTrue(date7.isValid());
		assertTrue(date8.isValid());
		assertTrue(date9.isValid());
		assertTrue(date10.isValid());
		assertTrue(date11.isValid());
		assertTrue(date12.isValid());
		assertTrue(date13.isValid());
		
		
	}

}
