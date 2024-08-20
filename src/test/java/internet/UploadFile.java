package internet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile 
{	WebDriver driver;
WebDriverWait mywait;
@BeforeClass
public void setup()
{
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	   driver.get("https://the-internet.herokuapp.com/upload");
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
}
    @Test
	public void testUpload()
	{
    	String file="C:\\Users\\robin\\Downloads\\test.txt";
	   try {
		   
		  WebElement ele=driver.findElement(By.xpath("//input[@id='file-upload']"));
		  ele.sendKeys(file);
		  WebElement ele1=driver.findElement(By.xpath("//input[@id='file-submit']"));
		  ele1.click();
		  WebElement ele2=driver.findElement(By.xpath("//div[@id='uploaded-files']"));
		  if(ele2.getText().equals("test.txt"))
		  {
			  System.out.println("Passed:"+ele2.getText());
		  }
		  else
		  {
		  System.out.println("Failed:"+ele2.getText());
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


