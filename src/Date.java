import java.util.Calendar;

/**
 * This class defines the date object, and it also contains several methods to interact with these date objects.
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */

import java.util.StringTokenizer;

public class Date implements Comparable<Date> {

	private int year;
	private int month;
	private int day;

	//constant values used in isValid and isLeapYear methods
	private static final int QUADRENNIAL = 4;
	private static final int CENTENNIAL = 100;
	private static final int QUARTERCENTENNIAL = 400;
	private static final int TWO_THOUSAND_TWENTY_ONE = 2021;
	private static final int ALIGN_MONTHS = 1;
	private static final int NON_LEAP_YEAR_FEBRUARY = 28;
	private static final int LEAP_YEAR_FEBRUARY = 29;
	private static final int THIRTY_DAY_MONTH = 30;
	private static final int THIRTYONE_DAY_MONTH = 31;

	/**
	 * Date Constructor;
	 * Takes a date in "mm/dd/yyy" String format and converts it into a Date object
	 * @param date
	 */
	public Date(String date) {
		StringTokenizer buffer = new StringTokenizer(date, "/");

		this.month = Integer.parseInt(buffer.nextToken());
		this.day = Integer.parseInt(buffer.nextToken());
		this.year = Integer.parseInt(buffer.nextToken());
	}

	/**
	 * Default constructor creates a Date object with today's date
	 */
	public Date() {
		Calendar currentDate = Calendar.getInstance();

		this.year = currentDate.get(Calendar.YEAR);
		this.month = currentDate.get(Calendar.MONTH);
		this.day = currentDate.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Checks whether or not the Date object is actually representing a valid date
	 * @return true if date object is representing a valid date, false if it is not
	 */
	public boolean isValid() {
		Date currentDate = new Date();

		//if this date is after today's date or before 1980 it is invalid
		if (this.compareTo(currentDate) == 1 || this.year < TWO_THOUSAND_TWENTY_ONE) {
			return false;
		}

		//shift month value back 1 to align with Calendar class's value for each month
		int monthValue = this.month - ALIGN_MONTHS;

		//number of days must be greater than 0
		if (this.day <= 0) {
			return false;
		}

		//next several if-statements check if the date has too many days depending on which month it is in

		if (monthValue < Calendar.JANUARY || monthValue > Calendar.DECEMBER) {
			return false;
		}

		if (monthValue == Calendar.JANUARY || monthValue == Calendar.MARCH || monthValue == Calendar.MAY || monthValue == Calendar.JULY || monthValue == Calendar.AUGUST || monthValue == Calendar.OCTOBER || monthValue == Calendar.DECEMBER) {
			if (this.day > THIRTYONE_DAY_MONTH) {
				return false;
			}
		}

		if(monthValue == Calendar.APRIL || monthValue == Calendar.JUNE || monthValue == Calendar.SEPTEMBER || monthValue == Calendar.NOVEMBER) {
			if (this.day > THIRTY_DAY_MONTH) {
				return false;
			}
		}

		if(monthValue == Calendar.FEBRUARY) {
			if (isLeapYear(this.year)) {
				if (this.day > LEAP_YEAR_FEBRUARY) {
					return false;
				}
			}
			else {
				if (this.day > NON_LEAP_YEAR_FEBRUARY) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Checks if the given year is a leap year or not
	 * @param year
	 * @return true if given year is leap year, false if it is not
	 */
	private boolean isLeapYear(int year) {
		if (year % QUADRENNIAL == 0) {
			if (year % CENTENNIAL == 0) {
				if (year % QUARTERCENTENNIAL == 0) {
					return true;
				}
			}
			else {
				return true;
			}
		}

		return false;
	}

	/**
	 * Compares this.date with the date object passed
	 * @param date
	 * @return -1 if date is earlier than this.date, 1 if date is later than this.date, 0 if date is equal to this.date
	 */
	@Override
	public int compareTo(Date date) {
		if (this.year < date.year) {
			return -1;
		}
		if (this.year == date.year) {
			if (this.month < date.month) {
				return -1;
			}
			else if (this.month == date.month) {
				if (this.day < date.day) {
					return -1;
				}
				else if (this.day == date.day) {
					return 0;
				}
				else {
					return 1;
				}
			}
			else {
				return 1;
			}
		}

		return 1;
	}

	/**
	 * Returns date in String format
	 @return String version of this.date
	 */
	@Override
	public String toString() {
		return this.month + "/" + this.day + "/" + this.year;
	}

	/**
	 * This is a test bed main method that tests the validity of the isValid method by using a variety of test cases.
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		// Test Case 1
		if(new Date("10/20/1979").isValid()) {
			System.out.println("10/20/1979: Test passed.");
		}
		else {
			System.out.println("10/20/1979: Test failed.");
		}

		// Test Case 2
		if(new Date("10/20/2022").isValid()) {
			System.out.println("10/20/2022: Test passed.");
		}
		else {
			System.out.println("10/20/2022: Test failed.");
		}

		// Test Case 3
		if(new Date("0/20/2020").isValid()) {
			System.out.println("0/20/2020: Test passed.");
		}
		else {
			System.out.println("0/20/2020: Test failed.");
		}
		if(new Date("13/20/2020").isValid()) {
			System.out.println("13/20/2020: Test passed.");
		}
		else {
			System.out.println("13/20/2020: Test failed.");
		}

		// Test Case 4
		if(new Date("1/32/2020").isValid()) {
			System.out.println("1/32/2020: Test passed.");
		}
		else {
			System.out.println("1/32/2020: Test failed.");
		}
		if(new Date("1/0/2020").isValid()) {
			System.out.println("1/0/2020: Test passed.");
		}
		else {
			System.out.println("1/0/2020: Test failed.");
		}
		if(new Date("1/31/2020").isValid()) {
			System.out.println("1/31/2020: Test passed.");
		}
		else {
			System.out.println("1/31/2020: Test failed.");
		}

		// Test Case 5
		if(new Date("4/31/2020").isValid()) {
			System.out.println("4/31/2020: Test passed.");
		}
		else {
			System.out.println("4/31/2020: Test failed.");
		}
		if(new Date("4/0/2020").isValid()) {
			System.out.println("4/0/2020: Test passed.");
		}
		else {
			System.out.println("4/0/2020: Test failed.");
		}
		if(new Date("4/30/2020").isValid()) {
			System.out.println("4/30/2020: Test passed.");
		}
		else {
			System.out.println("4/30/2020: Test failed.");
		}

		// Test Case 6
		if(new Date("2/29/2020").isValid()) {
			System.out.println("2/29/2020: Test passed.");
		}
		else {
			System.out.println("2/29/2020: Test failed.");
		}
		if(new Date("2/30/2020").isValid()) {
			System.out.println("2/30/2020: Test passed.");
		}
		else {
			System.out.println("2/30/2020: Test failed.");
		}

		// Test Case 7
		if(new Date("2/28/2019").isValid()) {
			System.out.println("2/28/2019: Test passed.");
		}
		else {
			System.out.println("2/28/2019: Test failed.");
		}
		if(new Date("2/29/2019").isValid()) {
			System.out.println("2/29/2019: Test passed.");
		}
		else {
			System.out.println("2/29/2019: Test failed.");
		}
	}
}
