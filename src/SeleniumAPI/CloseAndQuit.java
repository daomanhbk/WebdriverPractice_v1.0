package SeleniumAPI;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.google.common.base.Function;

public class CloseAndQuit {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 30);
	}

	@Test
	public void testcase01() throws Exception {
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.findElement(By.xpath("//a[@href='http://www.sakinalium.in']//button[contains(text(),'click')]")).click();

		Thread.sleep(2000);

		driver.close();

//		Thread.sleep(2000);
//		driver.quit();

		Thread.sleep(2000);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
//		driver.quit();
	}
}
