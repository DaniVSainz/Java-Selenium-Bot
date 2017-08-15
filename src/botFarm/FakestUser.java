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
	
	
//	Sets all of our username Fields that we got from Parsed get Request ;) ;) 
	public FakestUser(String[] myUser) {

	setGender(myUser[0]);
	setFirstName(myUser[1]);
	setLastName(myUser[2]);
	setCity(myUser[3]);
	setState(myUser[4]);
	setPicture(myUser[5]);
	setUsername(myUser[1], myUser[2]);
}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String firstName,String lastName) {
		this.username = firstName + lastName;
	}
	

	
	
	
}
