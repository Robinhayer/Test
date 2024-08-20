package internet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shadow_DOM 
{
	@Test
	public void TestStatusCode()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
			
		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
WebElement root=driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement shadowDom1=(WebElement)js.executeScript("return arguments[0].shadowRoot", root);
			WebElement appheader=shadowDom1.findElement(By.cssSelector("app-header[effects='waterfall']"));
			WebElement apptoolbar=appheader.findElement(By.cssSelector(".toolbar-bottom"));
			WebElement bookinput=apptoolbar.findElement(By.cssSelector("book-input-decorator"));
			WebElement input=bookinput.findElement(By.cssSelector("#input#input"));
			input.sendKeys("test");
			
	}
}


