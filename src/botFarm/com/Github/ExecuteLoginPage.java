/**
 * 
 */
package botFarm.com.Github;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import botFarm.AccountLogger;
import botFarm.FakestUser;
import botFarm.GetRequest;
import botFarm.JsonParser;

/**
 * @author daniel
 *	This will execute our login Page
 */
public class ExecuteLoginPage {
	static String apiUrl = "https://randomuser.me/api/?inc=gender,name,nat,location,picture";
	static FakestUser myUser ;
	static Random rand = new Random();
	
	@Test
	public static void run() throws Exception {
		setUser();
		
		System.setProperty("webdriver.chrome.driver","/home/daniel/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/");

		LoginPage login = new LoginPage(driver);
		login.typeUsernameAndVerify(myUser.getFirstName());
		login.typeEmail(myUser.getEmail());
		login.typePassword(myUser.getPassword());
		login.signUp();
	   AccountLogger logger = new AccountLogger();
 	   logger.logAccount(myUser.getUsername(), myUser.getPassword());
//		driver.quit();
	}
	
	public static void setUser() throws Exception {
//		Created our GetRequest class and JsonParser class and pass in the RandomUser api adress
//		Pass the JSON String to the Parser and get a string array with the values back"
		GetRequest requestor = new GetRequest();
		JsonParser parseRequest = new JsonParser();
//		Requests the api returns string json
		String request = requestor.get(apiUrl);
//		parses the response and Triggers setUser after and returns the fakest user you've ever seen 
		myUser = parseRequest.parseUserString(request);
//		Will run all my LoginMethods 
	}
	

}
