
public class Profile {
	
	private String name;
	private Major major; 	//5 majors and 2-charater each: CS, IT, BA, EE, ME
	
	public Profile(String name, Major major) {
		
		this.name = name;
		this.major = major;
		
	}
	
	@Override
	public String toString() {
		
		return this.name + ":" + this.major;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Profile) {
			
			Profile tempProfile = (Profile) obj;
			
			return (this.name.equals(tempProfile.name) && (this.major.equals(tempProfile.major)));
			
		}
		 
		return false;
		
	}

	
}
