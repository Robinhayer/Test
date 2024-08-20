package internet;

import org.testng.Assert;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag_Drop 
{
	@Test
	public void DragandDrop()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		try
		{
			driver.get("https://the-internet.herokuapp.com/drag_and_drop");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Actions act=new Actions(driver);
			WebElement ele=driver.findElement(By.xpath("//div[@id='column-a']"));
			WebElement ele1=driver.findElement(By.xpath("//div[@id='column-b']"));
			act.dragAndDrop(ele, ele1).build().perform();
			Thread.sleep(3000);
			
		}
		catch(Exception e)
		{
			Assert.fail();
			System.out.println(e.getMessage());
		}
		finally
		{
			driver.quit();
		}
	}

}
