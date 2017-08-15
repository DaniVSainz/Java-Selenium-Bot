/**
 * 
 */
package botFarm.com.Github;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author daniel
 *This class with store the login page and follower process.
 */
public class LoginPage {
	WebDriver driver;
	By username = By.xpath("//*[@id=\"user[login]\"]");
	By email = By.xpath("//*[@id=\"user[email]\"]");
	By password = By.xpath("//*[@id=\"user[password]\"]");
	By signUpButton = By.xpath("//*[@id=\"user[password]\"]");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void typeUsername() {
		driver.findElement(username).click();
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
}
