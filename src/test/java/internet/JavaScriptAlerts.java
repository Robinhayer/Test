 package internet;
 import org.testng.Assert;

 import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class JavaScriptAlerts 
{
	WebDriver driver;
	WebDriverWait mywait;
   @BeforeClass
   public void setup()
   {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	   driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
   }

  @Test(priority=1)
   public void testJSAlert()
   {
	   try 
	   {
		   
	   driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
	   Alert alertwin=mywait.until(ExpectedConditions.alertIsPresent());
	   alertwin.accept();
	   }
	   catch(Exception e)
	   {
		   System.out.println(e.getMessage());
		   Assert.fail();
	   }
   }
   @Test(priority=2)
   public void testJSConfirm()
   {
	   try 
	   {
	   driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
	   Alert alertwin=mywait.until(ExpectedConditions.alertIsPresent());
	   alertwin.accept();
	   }
	   catch(Exception e)
	   {
		   System.out.println(e.getMessage());
		   Assert.fail();
	   }
   }
   @Test(priority=3)
   public void testJSPrompt()
   {
	   try 
	   {
	   driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
	   Alert alertwin=mywait.until(ExpectedConditions.alertIsPresent());
	   alertwin.sendKeys("Hello");
	   alertwin.accept();
	   String txt=driver.findElement(By.xpath("//p[@id='result']")).getText();
	   if(txt.equals("You entered: Hello"))
	   {
		   System.out.println("Passed:"+txt);
	   }
	   else
	   {
		   System.out.println("Failed:"+txt);
		   Assert.fail();
	   }
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
