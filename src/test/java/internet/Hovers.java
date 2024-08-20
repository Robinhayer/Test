package internet;
import org.testng.Assert;


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
public class Hovers
{
	WebDriver driver;
	WebDriverWait mywait;
	Actions act;
   @BeforeClass
   public void setup()
   {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	   driver.get("https://the-internet.herokuapp.com/hovers");
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
   }
   
   @Test
   public void testHovers1()
   {
	   act=new Actions(driver);
	   try
	   {
	   WebElement ele=driver.findElement(By.xpath("//div[@class='example']//div[1]//img[1]"));
	   WebElement ele1=driver.findElement(By.xpath("//div[@class='example']//div[1]//div[1]//a[1]"));
	   act.moveToElement(ele).moveToElement(ele1).click().perform();
	   String txt=driver.findElement(By.xpath("//h1[normalize-space()='Not Found']")).getText();
	   if(txt.equals("Not Found"))
	   {
		   driver.navigate().back();
	   }
	   else
	   {
		   Assert.fail();
	   }
	   }
	   catch(Exception e)
	   {
		   System.out.println(e.getMessage());
		   Assert.fail();
	   }
   }
   @Test
   public void testHovers2()
   {
	   act=new Actions(driver);
	   try
	   {
	   WebElement ele=driver.findElement(By.xpath("//div[@class='example']//div[2]//img[1]"));
	   WebElement ele1=driver.findElement(By.xpath("//div[@class='row']//div[2]//div[1]//a[1]"));
	   act.moveToElement(ele).moveToElement(ele1).click().perform();
	   String txt=driver.findElement(By.xpath("//h1[normalize-space()='Not Found']")).getText();
	   if(txt.equals("Not Found"))
	   {
		   driver.navigate().back();
	   }
	   else
	   {
		   Assert.fail();
	   }
	   }
	   catch(Exception e)
	   {
		   System.out.println(e.getMessage());
		   Assert.fail();
	   }
	   
   }
   @Test
   public void testHovers3()
   {
	   act=new Actions(driver);
	   try
	   {
	   WebElement ele=driver.findElement(By.xpath("//div[@class='example']//div[3]//img[1]"));
	   WebElement ele1=driver.findElement(By.xpath("//div[@class='row']//div[3]//div[1]//a[1]"));
	   act.moveToElement(ele).moveToElement(ele1).click().perform();
	   String txt=driver.findElement(By.xpath("//h1[normalize-space()='Not Found']")).getText();
	   if(txt.equals("Not Found"))
	   {
		   driver.navigate().back();
	   }
	   else
	   {
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
