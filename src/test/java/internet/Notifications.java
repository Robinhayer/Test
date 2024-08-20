package internet;

import java.time.Duration;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Notifications
{WebDriver driver;
	@Test
	public void redirect()
	{try
	{
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebElement btn=driver.findElement(By.xpath("//a[normalize-space()='Click here']"));
	btn.click();
		String txt=driver.findElement(By.xpath("//div[@id='flash']")).getText().trim();
		System.out.println(txt);
		Thread.sleep(5000);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		 if (txt.contains("Action successful")) 
		 {
             System.out.println("Action successful: " + txt);
         } 
		 else if (txt.contains("Action unsuccessful, please try again")) {
             btn.click();
            Thread.sleep(2000);
             txt = driver.findElement(By.xpath("//div[@id='flash']")).getText().trim();
             System.out.println(txt);

             if (!txt.contains("Action successful")) {
                 System.out.println("Failed again: " + txt);
                 Assert.fail("Expected 'Action successful' but got: " + txt);
             }
		 else
		 {
			 System.out.println("failed");
			 Assert.fail();
		 }
     } }catch (Exception e) {
         e.printStackTrace();
         Assert.fail("Test failed due to exception: " + e.getMessage());
     } finally 
	{
         driver.quit();
     }
	

	}}
