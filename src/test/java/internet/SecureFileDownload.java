package internet;

import io.github.bonigarcia.wdm.WebDriverManager;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class SecureFileDownload 
{
	@Test
	public void test()
	{
		WebDriver driver;
		
		
		driver=new ChromeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/download_secure");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	try {
		driver.findElement(By.xpath("//a[normalize-space()='test.txt']")).click();
		Thread.sleep(5000);
		
		}
		catch(Exception e)
		{
			Assert.fail();
			System.out.println(e.getMessage());
		}driver.quit();
		}
	
	}
