package internet;

import java.nio.file.spi.FileSystemProvider;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {
	@Test
	public void testElement() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement ele1=driver.findElement(By.xpath("//input[1]"));
		ele1.click();
		Thread.sleep(5000);
		WebElement ele2=driver.findElement(By.xpath("//input[2]"));
		ele2.click();
		if(ele1.isSelected())
		{
			System.out.println("CheckBox 1 is Selected");
		}
		else
		{
			System.out.println("CheckBox 1 is NotSelected");
		}
		if(ele2.isSelected())
		{
			System.out.println("CheckBox 2 is Selected");
		}
		else
		{
			System.out.println("CheckBox 2 is NotSelected");
		}
		driver.quit();


}
	
	}