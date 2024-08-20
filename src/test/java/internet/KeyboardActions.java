package internet;
import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class KeyboardActions {
	
	@Test
	public void testKeyboardandMouse() 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/key_presses");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		WebElement target=driver.findElement(By.xpath("//input[@id='target']"));
		String ele=driver.findElement(By.xpath("//p[@id='result']")).getAttribute("p");
		target.sendKeys("Hello");
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		System.out.println(ele);
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		System.out.println(ele);
		act.keyDown(Keys.BACK_SPACE).keyUp(Keys.CONTROL).perform();
		System.out.println(ele);
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		System.out.println(ele);
		driver.quit();
	
		
	}

}
