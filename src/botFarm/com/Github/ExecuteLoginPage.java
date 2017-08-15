/**
 * 
 */
package botFarm.com.Github;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author daniel
 *	This will execute our login Page
 */
public class ExecuteLoginPage {
	
	@Test
	public void executeLogin() {
		System.setProperty("webdriver.chrome.driver","/home/daniel/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/");
		
		LoginPage login = new LoginPage(driver);
		
	}
}
