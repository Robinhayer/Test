package internet;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Challenging_DOM
{
@Test
public void testElement() throws InterruptedException 
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/challenging_dom");
	driver.manage().window().maximize();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement ele=driver.findElement(By.xpath("//a[@class='button']"));
	WebElement ele1=driver.findElement(By.xpath("//a[@class='button alert']"));
	WebElement ele2=driver.findElement(By.xpath("//a[@class='button success']"));
	wait.until(ExpectedConditions.visibilityOf(ele1));
	ele1.click();
	
	
	WebElement table=driver.findElement(By.xpath("//div/table"));
	List<WebElement> rows=driver.findElements(By.xpath("//div//tr"));
	for(WebElement row:rows)
	{
		List<WebElement> cells=driver.findElements(By.xpath("//div//tr/td"));
		for(WebElement cell:cells)
		{
			System.out.print(cell.getText()+"  ");
		}
		System.out.println();
	}
	driver.quit();
}

}