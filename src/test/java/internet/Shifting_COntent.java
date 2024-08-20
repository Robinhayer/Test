package internet;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;



public class Shifting_COntent 
{

	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/shifting_content/menu?mode=random");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	@Test
	public void click_Home()
	{
		try 
		{
		driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
		driver.navigate().back();
		System.out.println("Clicked Successfully on Home");
		}
		catch(Exception e)
		{
			Assert.fail();
			System.out.println("FAiled to click on Home"+e.getMessage());
		}
		
	}
	@Test
	public void click_About()
	{
		try 
		{
		driver.findElement(By.xpath("//a[normalize-space()='About']")).click();
		driver.navigate().back();
		System.out.println("Clicked Successfully on About");
		}
		catch(Exception e)
		{
			Assert.fail();
			System.out.println("FAiled to click on About"+e.getMessage());
		}
	}
	@Test
	public void click_COntact()
	{
		try 
	{
	driver.findElement(By.xpath("//a[normalize-space()='Contact Us']")).click();
	driver.navigate().back();
	System.out.println("Clicked Successfully on COntact");
	}
	catch(Exception e)
	{
		Assert.fail();
		System.out.println("FAiled to click on Contact"+e.getMessage());
	}
		
	}
	@Test
	public void CLick_Portfolio()
	{
		try 
		{
		driver.findElement(By.xpath("//a[normalize-space()='Portfolio']")).click();
		driver.navigate().back();
		System.out.println("Clicked Successfully on Portfolio");
		}
		catch(Exception e)
		{
			Assert.fail();
			System.out.println("FAiled to click on Portfolio"+e.getMessage());
		}
	}
	@Test
	public void Click_Gallery()
	{
		try 
		{
		driver.findElement(By.xpath("//a[@class='shift']")).click();
		driver.navigate().back();
		System.out.println("Clicked Successfully on Gallery");
		}
		catch(Exception e)
		{
			Assert.fail();
			System.out.println("FAiled to click on Gallery"+e.getMessage());
		}
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}
