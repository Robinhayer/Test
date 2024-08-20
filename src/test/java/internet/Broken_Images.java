package internet;

import java.net.HttpURLConnection;

import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Broken_Images {
	@Test
	public void testElement() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/broken_images");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> images=driver.findElements(By.xpath("//img"));
		/*for (WebElement image : images) {
		    try {
		        if (image.getAttribute("naturalWidth").equals("0") || image.getAttribute("naturalHeight").equals("0")) {
		            System.out.println("Broken image: " + image.getAttribute("src"));
		        }
		    } catch (Exception e) {
		        System.out.println("Error while checking image: " + e.getMessage());
		    }
		}*/
		for (WebElement image : images) {
	        try {
	            String src = image.getAttribute("src");
	            HttpURLConnection connection = (HttpURLConnection) new URL(src).openConnection();
	            connection.setRequestMethod("HEAD");
	            connection.connect();
	            int responseCode = connection.getResponseCode();
	            if (responseCode != 200) {
	                System.out.println("Broken image: " + src);
	            }
	        } catch (Exception e) {
	            System.out.println("Error while checking image: " + e.getMessage());
	        }
	    }
	    driver.quit();
	}

}
