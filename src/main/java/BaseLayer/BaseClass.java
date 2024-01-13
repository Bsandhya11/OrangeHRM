package BaseLayer;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

	// public static global WebDriver reference
	public static WebDriver driver;

	
	
	// create static initialization() method
	public static void initialization() {
		// connect to the actual browser

		// Up casting
		driver = new ChromeDriver();

		// maximize browser
		driver.manage().window().maximize();
		// implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// pageLoadTimeOut code
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		// delete all cookies
		driver.manage().deleteAllCookies();

		// open a url
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

}
