package internet;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker
{

	WebDriver driver;
	WebDriverWait mywait;
   @BeforeClass
   public void setup()
   {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   //mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	   driver.get("https://demo.automationtesting.in/Datepicker.html");
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   }
   @Test
   void testDatePicker()
   {try {
	   String year="2014";
	   String day="07";
	   String month="June";
	   WebElement ele=driver.findElement(By.xpath("//input[@id='datepicker2']"));
	   ele.click();
	   WebElement yr=driver.findElement(By.xpath("//select[@title='Change the year']"));
	   Select yrdrp=new Select(yr);
	   yr.click();
	   yrdrp.selectByVisibleText(year);
	   WebElement mnth=driver.findElement(By.xpath("//select[@title='Change the month']"));
	   Select mnthdrp=new Select(mnth);
	   mnthdrp.selectByVisibleText(month);
	   List<WebElement> dte=driver.findElements(By.xpath("//td"));
	   for(WebElement dt:dte)
	   {
		   if(dt.getText().equals(day))
		   {
			   dt.click();
			   Thread.sleep(5000);
			   break;
		   }
		   System.out.println(ele.getText());
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
