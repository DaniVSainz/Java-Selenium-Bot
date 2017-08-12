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
	
	public void generateEmail() {
   		driver.get("https://maildrop.cc/");
   		WebElement input = driver.findElement(By.xpath("//*[@id=\"inbox\"]"));
   		input.sendKeys(username);
   		driver.findElement(By.xpath("//*[@id=\"custom\"]/div/div/div[1]/form/button")).click();
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
		driver.findElement(By.xpath("//*[@id=\"user[email]\"]")).sendKeys(username + "@maildrop.cc");
		driver.findElement(By.xpath("//*[@id=\"user[password]\"]")).sendKeys("daniGetsBotted123$");
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/button")).click();
		driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div/form/button")).click();
		driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div/form/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div/div/form/label/input[1]")).sendKeys(myGithub);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div/div/form/label/input[1]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div[1]/div/nav/a[6]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id=\"user_search_results\"]/div/div/div[1]/span/span[1]/form/button")).click();
	
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
	
	public void fancyUserGenerator(){



   public static void main(String[] args) throws InterruptedException  {

	   System.setProperty("webdriver.chrome.driver","/home/daniel/Documents/chromedriver");
	   AccountLogger logger = new AccountLogger();
	   Bot bot = new Bot();
	   

//       for(int i=1; i<500; i++){
//    	   Bot bot = new Bot();
//    	   bot.generateUsername();
//    	   bot.generateEmail();
//    	   bot.botGithub();
//    	   bot.killDriver();
//      }
   }

}