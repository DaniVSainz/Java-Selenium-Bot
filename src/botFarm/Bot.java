package botFarm;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Bot {
	static WebDriver driver = new ChromeDriver();
	AccountLogger logger = new AccountLogger();
	static String myGithub = "DaniVSainz";	
	static String username = "DanivSainz";
	
	protected boolean isElementPresent(By by) {
		  try {
		        driver.findElement(by);
		      return true;
		     } catch (NoSuchElementException e) {
		         return false;
		    }
		}



   public static void main(String[] args) throws InterruptedException  {

	   System.setProperty("webdriver.chrome.driver","/home/daniel/Documents/chromedriver");
	


   		driver.get("http://namegenerators.org/random-username-generator/");


   		Thread.sleep(2000);
   		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[3]/form/input")).click();
   		String username = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[5]/div[1]")).getText();

   		driver.get("https://maildrop.cc/");
   		WebElement input = driver.findElement(By.xpath("//*[@id=\"inbox\"]"));
   		input.sendKeys(username);
   		driver.findElement(By.xpath("//*[@id=\"custom\"]/div/div/div[1]/form/button")).click();

   	
   		driver.get("https://github.com/");
   		driver.findElement(By.xpath("//*[@id=\"user[login]\"]")).sendKeys(username);
   		String usernameValidation = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/dl[1]/dd[2]")).getText();
   		while (usernameValidation == "Username is already taken"){
   			username = username + "1992";
   			driver.findElement(By.xpath("//*[@id=\"user[login]\"]")).sendKeys(username);
   			usernameValidation = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/dl[1]/dd[2]")).getText();
   		}
   		driver.findElement(By.xpath("//*[@id=\"user[email]\"]")).sendKeys(username + "@maildrop.cc");
   		driver.findElement(By.xpath("//*[@id=\"user[password]\"]")).sendKeys("daniGetsBotted123$");
   		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/button")).click();
   		driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div/form/button")).click();
   		driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div/form/a")).click();
   		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div/div/form/label/input[1]")).sendKeys(myGithub);
   		
   		Thread.sleep(20000);
   		
       driver.quit();


	

   }

}