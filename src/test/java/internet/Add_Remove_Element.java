package internet;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Add_Remove_Element 
{
	@Test
	public void testElement() throws InterruptedException 
	{
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[normalize-space()='Add/Remove Elements']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Add Element']")).click();
		Thread.sleep(2000);
		WebElement delete_btn=driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
		if(delete_btn.isDisplayed())
		{
			delete_btn.click();
			System.out.println("Delete button is visible");
		}
		else
		{
			Assert.fail();
			System.out.println("Not Displayed");
		}
		driver.quit();
	}

}
