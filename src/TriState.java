
public class TriState extends NonResident {
	private String state;
	
	public TriState() {
	}
	
	public TriState(String name, Major major, int numberOfCredits, String state) {
		super(name, major, numberOfCredits);
		this.state = state.toLowerCase();
	}
	
	@Override
	public void tuitionDue() {
		super.tuitionDue();
		
		switch(state) {
			case "ny":	
				this.setTuition(getTuition()-4000);
				break;
			case "ct":
				this.setTuition(getTuition()-5000);
				break;
		}
	}
}
