package internet;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiWindow 
{
	@Test
	public void testMultiWindow() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();
		Thread.sleep(2000);
		Set<String> windowsID=driver.getWindowHandles();
		List<String> windowList=new ArrayList(windowsID);
		String parentwin=windowList.get(0);
		String childwin=windowList.get(1);
		System.out.println("Parent window Handle is:"+parentwin);
		System.out.println("Child window Handle is:"+childwin);
		//switch to parent
		driver.switchTo().window(parentwin);
		Thread.sleep(2000);
		//chidl
		driver.switchTo().window(childwin);
		Thread.sleep(2000);
		driver.quit();
		
}
}