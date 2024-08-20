package internet;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
public class Rediraction 
{
	@Test
	public void redirect()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/redirector");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		try
		{
			driver.findElement(By.xpath("//a[@id='redirect']")).click();
			List<WebElement> links=driver.findElements(By.xpath("//a"));
			for(WebElement link:links)
				
			{
				String url=link.getAttribute("href");
				if(url!=null)
				{
					try {
					HttpURLConnection connection=(HttpURLConnection) new URL(url).openConnection();
					connection.setRequestMethod("HEAD");
					connection.connect();
					int StatusCode=connection.getResponseCode();
					System.out.println(url+"   "+StatusCode);
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
				}
			}
				else
				{
					System.out.println("Links do not have HREF Attribute");
				}
			}}
			catch(Exception e)
			{
				Assert.fail();
				System.out.println(e.getMessage());
			}
		driver.quit();
	}

}
