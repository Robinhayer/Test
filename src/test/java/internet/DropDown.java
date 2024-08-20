package internet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown 
{
	@Test
	public void DragandDrop()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		try
		{
			driver.get("https://the-internet.herokuapp.com/dropdown");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebElement drpdown=driver.findElement(By.xpath("//select[@id='dropdown']"));
			Select drp=new Select(drpdown);
			drp.selectByIndex(2);
			
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