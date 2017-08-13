package botFarm;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Bot {
	static Random rand = new Random();

	static int  randomNumber = rand.nextInt(1000+1);
	static String password = "daniGetsBotted" + randomNumber + "$" ;
	static String myGithub = "DaniVSainz";	
	public static String username;
	public WebDriver driver = new ChromeDriver();

	public void killDriver() {
      driver.quit();
	}
	

	public String generateUsername() throws InterruptedException {
		Random rand = new Random();

		int  randomUsernameDiv = rand.nextInt(59) + 1;
   		driver.get("http://namegenerators.org/random-username-generator/");
   		Thread.sleep(2000);
   		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[3]/form/input")).click();
   		username = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[5]/div[" + randomUsernameDiv + "]")).getText();
		return username;
	}
	
	public void generateEmail(String username) {
		WebDriver driver2 = new ChromeDriver();
   		driver2.get("https://maildrop.cc/");
   		WebElement input = driver2.findElement(By.xpath("//*[@id=\"inbox\"]"));
   		input.sendKeys(username);
   		driver2.findElement(By.xpath("//*[@id=\"custom\"]/div/div/div[1]/form/button")).click();
   		driver2.quit();
	}
	
	protected boolean validateUsername() {
		  try {
			  driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/dl[1]/dd[2]")).getText();
		      return true;
		     } catch (NoSuchElementException e) {
		         return false;
		    }
		}
	
	public void botGithub() throws InterruptedException {

		driver.get("https://github.com/");
		driver.findElement(By.xpath("//*[@id=\"user[login]\"]")).sendKeys(username);
		Thread.sleep(600);
		System.out.println(validateUsername());
		while (validateUsername() == true) {
			username = username + "1";
			driver.findElement(By.xpath("//*[@id=\"user[login]\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"user[login]\"]")).sendKeys(username);
		}
		generateEmail(username);
		driver.findElement(By.xpath("//*[@id=\"user[email]\"]")).sendKeys(username + "@maildrop.cc");
		driver.findElement(By.xpath("//*[@id=\"user[password]\"]")).sendKeys("daniGetsBotted123$");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/button")).click();
		driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div/form/button")).click();
		driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div/form/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div/div/form/label/input[1]")).sendKeys(myGithub);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div/div/form/label/input[1]")).sendKeys(Keys.ENTER);
		Thread.sleep(800);
		driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div[1]/div/nav/a[6]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"user_search_results\"]/div/div/div[1]/span/span[1]/form/button")).click();
	
	}
	
	public void verifyEmail(String username) throws InterruptedException {
		driver.get("https://maildrop.cc/");
   		WebElement input = driver.findElement(By.xpath("//*[@id=\"inbox\"]"));
   		input.sendKeys(username);
   		driver.findElement(By.xpath("//*[@id=\"custom\"]/div/div/div[1]/form/button")).click();
   		driver.findElement(By.xpath("//*[@id=\"inboxtbl\"]/tbody/tr/td[2]/a")).click();
   		Thread.sleep(2500);
   		String goHere = driver.findElement(By.xpath("/html/body/div[2]/p[3]/a")).getText();
   		driver.get(goHere);
	}
	
	public void loginToVerify(String username, String password) {
		driver.findElement(By.xpath("//*[@id=\"login_field\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/input[3]")).click();

		
	}
	
//	public void imageGenerator() {
//		try {
//		     driver.get("http://agiletesters.com.br");
////		     driver.get("https://randomuser.me/api/?inc=gender,name,nat,picture");
//		     WebElement logo = driver.findElement(By.cssSelector(".forum-logo"));
//		     String logoSRC = logo.getAttribute("src");
//		     
//		     URL imageURL = new URL(logoSRC);
//		     BufferedImage saveImage = ImageIO.read(imageURL);
//		     
//		     ImageIO.write(saveImage, "jpg", new File("/home/daniel/Pictures/" + ));
//		     
//		     } catch (Exception e) {
//		        e.printStackTrace();
//		     } finally {
//		        driver.close();
//		     }
//	}
	

   public static void main(String[] args) throws InterruptedException  {

	   System.setProperty("webdriver.chrome.driver","/home/daniel/Documents/chromedriver");
	   AccountLogger logger = new AccountLogger();

       for(int i=1; i< 300; i++){
    	   Bot bot = new Bot();
    	   bot.generateUsername();
//    	   bot.generateEmail();
    	   bot.botGithub();
//    	   Thread.sleep(20000);
//    	   bot.verifyEmail(username);
//    	   bot.loginToVerify(username, password);
    	   bot.killDriver();
    	   Random rand = new Random();
    	   logger.logAccount(username, password);
    	   System.out.println(username);
    	   Thread.sleep(rand.nextInt(200000 + 35001));
    	   
      }
   }

}