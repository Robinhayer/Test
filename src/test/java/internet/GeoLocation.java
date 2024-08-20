package internet;
import org.testng.Assert;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class GeoLocation 
{
	WebDriver driver;
	WebDriverWait mywait;
	Actions act;
   @BeforeClass
   public void setup()
   {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	   driver.get("https://the-internet.herokuapp.com/geolocation");
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
   }
   @Test
   public void testGeoLocation() throws InterruptedException
   {
	   act=new Actions(driver);
	
	   WebElement ele=driver.findElement(By.xpath("//button[normalize-space()='Where am I?']"));
	   //mywait.until(ExpectedConditions.elementToBeClickable(ele)).click();
	   act.moveToElement(ele).click().perform();
	   Thread.sleep(4000);
	   
	 //mywait.until(ExpectedConditions.alertIsPresent()).accept();
	  
	   WebElement ele1=driver.findElement(By.xpath("//div[@id='long-value']"));
	   System.out.println("Longitude:"+ele1.getText());
	   WebElement el2=driver.findElement(By.xpath("//div[@id='lat-value']"));
	   System.out.println("Latitude:"+el2.getText());
	  
   }
   @AfterClass
   public void teardown()
   {
	   driver.quit();
   }
   

}
