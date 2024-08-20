package internet;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class JavaScrpitError 
{
	@Test
      public void JavaScriptErrors()
      {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/javascript_error");
	driver.manage().window().maximize();
	Set<String> logs=driver.manage().logs().getAvailableLogTypes();
    for (String string : logs) {
		System.out.println(string);
	}
    LogEntries entries=driver.manage().logs().get(LogType.BROWSER);
    for (LogEntry logEntry : entries) 
    {
		System.out.println(logEntry);
	}  
    driver.quit();
}
}