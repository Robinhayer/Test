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
public class MouseActions 
{
	WebDriver driver;
	WebDriverWait mywait;
   @BeforeClass
   public void setup()
   {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	   driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
   }
   @Test
	public void MouseActions()
	{
	   try {
		  WebElement ele=driver.findElement(By.xpath("//a[normalize-space()='Enabled']"));
		  WebElement ele1=driver.findElement(By.xpath("//a[normalize-space()='Downloads']"));
		  WebElement ele2=driver.findElement(By.xpath("//a[normalize-space()='PDF']"));
		  Actions act=new Actions(driver);
		  act.moveToElement(ele).perform();
		  Thread.sleep(1000);
		  act.moveToElement(ele1).perform();
		  Thread.sleep(1000);
		  act.moveToElement(ele2).click().perform();
		  Thread.sleep(1000);
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
