package internet;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tables 
{
	@Test
	public void TestTables()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
			driver.get("https://the-internet.herokuapp.com/tables");
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		    WebElement table = driver.findElement(By.id("table1"));
			List <WebElement> rows=driver.findElements(By.xpath("//table[@id='table1']//tr"));
			List<WebElement> cells=driver.findElements(By.xpath("//table[@id='table1']//tr/td"));
			for(int r=1;r<rows.size(); r++)
			{
			  String last_name=driver.findElement(By.xpath("//table[@id='table1']//tr["+r+"]/td[1]")).getText();
			  if(last_name.equals("Conway"))
			  {
				  String email=driver.findElement(By.xpath("//table[@id='table1']//tr["+r+"]/td[3]")).getText();
				  System.out.println("Email is--"+email);
			  }
			}
			driver.quit();
			
	}

}
/*for(int r=1;r<rows.size(); r++)
{
	
	for(int c=1;c<=6;c++)
	{
		String data=driver.findElement(By.xpath("//table[@id='table1']//tr["+r+"]/td["+c+"]")).getText();
		System.out.print(data+"    ");
	}
	System.out.println();
} */
