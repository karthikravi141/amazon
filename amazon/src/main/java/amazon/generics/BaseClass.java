package amazon.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public static WebDriver driver;
	public static FileLib fl;
	
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	@BeforeTest
	public void openBrowser() throws IOException {
		fl=new FileLib();
		String url=fl.getProperty("url");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);	
	}
	
	@AfterTest
	public void closeBrowser() {
//		driver.quit();
		
	}
}
