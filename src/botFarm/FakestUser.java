/**
 * 
 */
package botFarm;

/**
 * @author daniel
 * Getter and setters for user
 */
public class FakestUser {
	String gender;
	String firstName ;
	String lastName ;
	String city;
	String state;
	String picture;
	String username;
	String email;
	
	
//	Sets all of our username Fields that we got from Parsed get Request ;) ;) 
	public FakestUser(String[] myUser) {

	setGender(myUser[0]);
	setFirstName(myUser[1]);
	setLastName(myUser[2]);
	setCity(myUser[3]);
	setState(myUser[4]);
	setPicture(myUser[5]);
	setUsername(myUser[1], myUser[2]);
	setEmail(myUser[1], myUser[2]);
}
	

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender.replaceAll("^\"|\"$", "");
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName.replaceAll("^\"|\"$", "");
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city.replaceAll("^\"|\"$", "");
	}
	public void setCity(String city) {
		this.city = city.replaceAll("^\"|\"$", "");
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state.replaceAll("^\"|\"$", "");
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture.replaceAll("^\"|\"$", "");
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String firstName,String lastName) {
		this.username = firstName.replaceAll("^\"|\"$", "") + lastName.replaceAll("^\"|\"$", "");
	}
	public String getEmail() {
		return email;
	}
	private void setEmail(String firstName,String lastName) {
		this.email = firstName.replaceAll("^\"|\"$", "") + lastName.replaceAll("^\"|\"$", "") + "@maildrop.cc";
		
	}
	

	
	
	
}
