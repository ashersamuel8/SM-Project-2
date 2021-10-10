/**
 * This class defines properties specific to TriState students, it is a child of the NonResident class.
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */

public class TriState extends NonResident {
	private String state;
	
	public TriState() {
	}
	
	public TriState(String name, Major major, int numberOfCredits, String state) {
		super(name, major, numberOfCredits);
		this.state = state;
	}
	
	@Override
	public void tuitionDue() {
		super.tuitionDue();
		
		switch(state) {
			case "NY":	
				this.setTuition(getTuition()-4000);
				break;
			case "CT":
				this.setTuition(getTuition()-5000);
				break;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + ":" + this.state;
	}
}
