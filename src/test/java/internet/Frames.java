package internet;

import java.time.Duration;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Frames
{@Test
	public void testFrames()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-right");
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-bottom");
		
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		
driver.quit();
}
}
