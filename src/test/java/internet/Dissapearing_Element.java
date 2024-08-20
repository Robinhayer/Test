package internet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dissapearing_Element 
{
	@Test
	public void test_issapearing_Element() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		   try {
	            driver.get("https://the-internet.herokuapp.com/disappearing_elements");
	            driver.manage().window().maximize();
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	            WebElement ele1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='Gallery']")));

	            if (ele1.isDisplayed() && ele1.isEnabled()) {
	                wait.until(ExpectedConditions.elementToBeClickable(ele1));
	                ele1.click();
	            } else {
	                driver.navigate().refresh();
	                ele1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='Gallery']")));
	                wait.until(ExpectedConditions.elementToBeClickable(ele1));
	                ele1.click();
	            }

	        } catch (Exception e) {
	            Assert.fail("Test Failed: " + e.getMessage());
	            System.out.println("Test Failed: " + e.getMessage());
	        } finally {
	            driver.quit();
	        }
}
	
}
