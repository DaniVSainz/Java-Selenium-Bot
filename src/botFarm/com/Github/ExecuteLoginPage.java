/**
 * 
 */
package botFarm.com.Github;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import botFarm.GetRequest;
import botFarm.JsonParser;

/**
 * @author daniel
 *	This will execute our login Page
 */
public class ExecuteLoginPage {
	static String apiUrl = "https://randomuser.me/api/?inc=gender,name,nat,location,picture";
	String gender;
	String firstName ;
	String lastName ;
	String city;
	String state;
	String picture;
	static String[] myUser = new String[6];
	static Random rand = new Random();

//	String usernameStr = firstName + lastName;
	static String usernameStr = "danivsainz";
	
	@Test
	public static void executeLogin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/home/daniel/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/");
		
		LoginPage login = new LoginPage(driver);
		
		login.typeUsernameAndVerify(usernameStr);
	}
	
	public static void main(String[] args) throws Exception {
		GetRequest requestor = new GetRequest();
		JsonParser parseRequest = new JsonParser();
		String request = requestor.get(apiUrl);
		myUser = parseRequest.parseUserString(request);
		
		executeLogin();
	}
}
