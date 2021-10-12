/**
 * This class defines properties specific to TriState students, it is a child of the NonResident class.
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */

public class TriState extends NonResident {
	private String state;
	
	
	/**
	 * A constructor method for TriState class
	 * @param name
	 * @param major
	 * @param numberOfCredits
	 * @param state
	 */
	public TriState(String name, Major major, int numberOfCredits, String state) {
		super(name, major, numberOfCredits);
		this.state = state;
	}
	
	/**
	 * This method calculates the tuition for TriState students, it takes into account the scholarship for NY and CT students.
	 */
	@Override
	public void tuitionDue() {
		super.tuitionDue();
		
		if(super.getNumberOfCredits() >= 12) {
			switch(state) {
				case "NY":	
					this.setTuition(getTuition()-4000);
					break;
				case "CT":
					this.setTuition(getTuition()-5000);
					break;
			}
		}
	}
	
	/**
	 * A method that prints out the data of the tri-state student
	 */
	@Override
	public String toString() {
		return super.toString() + ":non-resident(tri-state):" + this.state;
	}
}
