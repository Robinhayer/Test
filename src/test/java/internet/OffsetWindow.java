package internet;
import org.testng.Assert;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class OffsetWindow 
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
	   driver.get("https://the-internet.herokuapp.com/entry_ad");
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
   }
   @Test
	public void OffsetWindow()
	{
	   act=new Actions(driver);
	   try 
	   {
		Thread.sleep(5000);
		 driver.findElement(By.xpath("//p[normalize-space()='Close']")).click();
		 
	   }
	   catch(Exception e)
	   {
		   System.out.println(e.getMessage());
		   Assert.fail();
	   }
	}
	 @AfterClass
	   public void teardown()
	   {
		   driver.quit();
	   }
	   
}

