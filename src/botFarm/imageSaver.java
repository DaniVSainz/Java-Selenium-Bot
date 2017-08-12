package botFarm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class imageSaver {

	public static void main(String[] args) {
	   System.setProperty("webdriver.chrome.driver","/home/daniel/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();

		try {
		     driver.get("http://agiletesters.com.br");
		     
		     WebElement logo = driver.findElement(By.cssSelector(".forum-logo"));
		     String logoSRC = logo.getAttribute("src");
		     
		     URL imageURL = new URL(logoSRC);
		     BufferedImage saveImage = ImageIO.read(imageURL);
		     
		     ImageIO.write(saveImage, "png", new File("logo-forum.png"));
		     
		     } catch (Exception e) {
		        e.printStackTrace();
		     } finally {
		        driver.close();
		     }
	}

}
