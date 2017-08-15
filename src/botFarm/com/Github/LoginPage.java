/**
 * 
 */
package botFarm.com.Github;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
	static Random rand = new Random();
	String usernameStr;

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
	public void typeUsernameAndVerify(String usernameStr) throws InterruptedException {
		driver.findElement(username).click();
		driver.findElement(username).sendKeys(usernameStr);
		Thread.sleep(600);
		while ( validateUsername() == true ) {
			usernameStr = usernameStr + rand.nextInt(99) + 1;
			driver.findElement(username).clear();
			driver.findElement(username).sendKeys(usernameStr);
		}
	}
	
//	Checks if user name is taken
	protected boolean validateUsername() {
		  try {
			  driver.findElement(isUsernameTaken).getText();
		      return true;
		     } catch (NoSuchElementException e) {
		         return false;
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
