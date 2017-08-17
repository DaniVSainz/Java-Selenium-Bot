package botFarm.com.Github;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyEmailPage {
	WebDriver driver;
	WebDriver driver2;
	By usernameInput = By.xpath(".//*[@id='inbox']");
	By clickSubmitUsername = By.xpath(".//*[@id='custom']/div/div/div[1]/form/button");
	
	public void run() {
		System.setProperty("webdriver.chrome.driver","/home/daniel/Documents/chromedriver");
		WebDriver driver2 = new ChromeDriver();	
	}

	
}
