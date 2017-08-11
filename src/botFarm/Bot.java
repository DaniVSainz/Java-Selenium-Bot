package botFarm;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

 

public class Bot {

/**

* @param args
 * @throws InterruptedException 

*/
	
//	driver.get("https://www.google.com");
//	WebElement inputBox =  driver.findElement(By.xpath("//*[@id='lst-ib']"));
//	inputBox.sendKeys("asdasdasd");
//	
//	
//	
//	
//	
//	
//	
//Thread.sleep(5000);
//
//	driver.quit();

       public static void main(String[] args) throws InterruptedException  {

	   System.setProperty("webdriver.chrome.driver","/home/daniel/Documents/chromedriver");

    	// Create a new instance of the Firefox driver
   		WebDriver driver = new ChromeDriver();

           //Launch the Online Store Website
   		driver.get("http://namegenerators.org/random-username-generator/");
//  		driver.manage().window().maximize();
//
//   		
//   		String title = driver.getTitle();
//
//           // Print a Log In message to the screen
//           System.out.println(title);
//           Thread.sleep(2000);
//           driver.findElement(By.xpath("html/body/div[1]/div/button[1]")).click();
//           driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/div/div[2]/form/div[1]/input")).sendKeys("danivsainz1@gmail.com");
//           driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/div/div[2]/form/div[2]/input")).sendKeys("123123123");
//           driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/div/div[2]/form/div[3]/input")).click();
//           driver.findElement(By.xpath("html/body/nav/ul/li[3]/a")).click();
//           driver.findElement(By.xpath("html/body/div[1]/div/div/form/input[9]")).click();
//           driver.switchTo().alert().accept();
   		Thread.sleep(2000);
   		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[3]/form/input")).click();
   		String username = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[5]/div[1]")).getText();
   		System.out.println(username);
   		String myGithub = "DaniVSainz";
   		driver.get("https://maildrop.cc/");
   		WebElement input = driver.findElement(By.xpath("//*[@id=\"inbox\"]"));
   		input.sendKeys(username);
   		driver.findElement(By.xpath("//*[@id=\"custom\"]/div/div/div[1]/form/button")).click();
   		
   		driver.get("https://github.com/");
   		driver.findElement(By.xpath("//*[@id=\"user[login]\"]")).sendKeys(username);
   		driver.findElement(By.xpath("//*[@id=\"user[email]\"]")).sendKeys(username + "@maildrop.cc");
   		driver.findElement(By.xpath("//*[@id=\"user[password]\"]")).sendKeys("daniGetsBotted123$");
   		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/button")).click();
   		driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div/form/button")).click();
   		driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div/form/a")).click();
   		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div/div/form/label/input[1]")).sendKeys(myGithub);
   		
   		
   		Thread.sleep(20000);
   		
           // Close the driver
//       driver.quit();
   		

		

       }

}