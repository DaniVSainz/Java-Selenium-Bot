/**
 * 
 */
package botFarm.com.Github;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author daniel
 *This class with store the login page and follower process.
 */
public class LoginPage {
	String gender;
	String firstName ;
	String lastName ;
	String city;
	String state;
	String picture;
	static String[] myUser = new String[6];
	static Random rand = new Random();

//	String usernameStr = firstName + lastName;
	String usernameStr = "danivsainz";

	WebDriver driver;
	By username = By.xpath("//*[@id=\"user[login]\"]");
	By isUsernameTaken = By.xpath("//dd[contains(text(),'Username is ')]");
	By email = By.xpath("//*[@id=\"user[email]\"]");
	By password = By.xpath("//*[@id=\"user[password]\"]");
	By signUpButton = By.xpath("//*[@id=\"user[password]\"]");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
//	Types in the provided username, if Username is taken alert appears adds random integers while it is displayed.
	public void typeUsernameAndVerify(String userName) {
		driver.findElement(username).click();
		driver.findElement(username).sendKeys(usernameStr);
		if (driver.findElement(isUsernameTaken).isDisplayed()) {
			usernameStr = usernameStr + rand.nextInt(99) + 1;
			driver.findElement(username).clear();
			driver.findElement(username).sendKeys(usernameStr);
		}
	}
	public void typeEmail() {
		driver.findElement(email);
	}
	public void typePassword() {
		driver.findElement(password);
	}
	
	public void signUp() {
		driver.findElement(signUpButton);
	}
	
	public static void main(String[] args) {
		
	}
}
