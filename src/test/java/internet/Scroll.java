package internet;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
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
public class Scroll 
{
	WebDriver driver;
	WebDriverWait mywait;
   @BeforeClass
   public void setup()
   {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	   driver.get("https://the-internet.herokuapp.com/infinite_scroll");
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
   }
   @Test
   public void scrolldown()
   {
	   try {
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   // Get the initial height of the page
       Long lastHeight = (Long) js.executeScript("return document.body.scrollHeight");

       while (true) {
           // Scroll down to the bottom
           js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
           Thread.sleep(2000);

           // Calculate the new scroll height and compare with the last scroll height
           Long newHeight = (Long) js.executeScript("return document.body.scrollHeight");
           if (newHeight.equals(lastHeight)) {
               break; // If heights are the same, the end is reached
           }
           lastHeight = newHeight;
       }
       
       // Output the final scroll height
       System.out.println("Final Page Height: " + lastHeight);
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
