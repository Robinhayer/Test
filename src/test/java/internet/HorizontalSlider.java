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
public class HorizontalSlider 
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
	   driver.get("https://the-internet.herokuapp.com/horizontal_slider");
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
   }
   @Test
   public void testSlider() throws InterruptedException
   {
	   act=new Actions(driver);
	   WebElement slider=driver.findElement(By.xpath("//input[@value='0']"));
	   System.out.println("Before Sliding:"+slider.getLocation());
	   act.dragAndDropBy(slider, 500, 165).perform();
	   Thread.sleep(2000);
	   System.out.println("After Sliding:"+slider.getLocation());
	   
   }
   @AfterClass
   public void teardown()
   {
	   driver.quit();
   }
   
}
