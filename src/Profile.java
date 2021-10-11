/**
 * This class defines a profile based on name and major, and it is used to uniquely identify students.
 * @author Bhavya Patel
 * @author Samuel Asher Kappala
 */

public class Profile {
	
	private String name;
	private Major major; 	//5 majors and 2-charater each: CS, IT, BA, EE, ME
	
	public Profile(String name, Major major) {
		
		this.name = name;
		this.major = major;
		
	}
	
	/**
	 * Converts Profile object to a string
	 * @return String
	 */
	@Override
	public String toString() {
		
		return this.name + ":" + this.major;
		
	}
	
	/**
	 * Checks if two profiles are equal or not
	 * @param Object obj
	 * @return true if objects are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Profile) {
			
			Profile tempProfile = (Profile) obj;
			
			return ( (this.name.equals(tempProfile.name) && (this.major.equals(tempProfile.major))));
			
		}
		 
		return false;
		
	}
	
	/**
	 * A getter method to get the name attribute of the object Profile
	 * @return name of the student (profile)
	 */
	public String getName() {
		
		return this.name;
		
	}

	
}
