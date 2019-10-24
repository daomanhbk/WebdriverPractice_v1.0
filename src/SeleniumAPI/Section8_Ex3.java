package SeleniumAPI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Section8_Ex3 {
	WebDriver driver;
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void ex3() {
		// Step 1
		driver.get("http://www.w3schools.com/howto/howto_js_countdown.asp");

		// Step 2
		WebElement COUNTDOWN_LBL = driver.findElement(By.xpath("//p[@id='countdown1']"));
		new FluentWait<WebElement>(COUNTDOWN_LBL).withTimeout(70, 
				TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
		.until(new Function<WebElement, Boolean>() {
			public Boolean apply(WebElement element) {
				boolean flag = element.getText().endsWith("25s");
				return flag;
			}
			
		});

	}

	@AfterClass
	public void afterClass() {
		driver.switchTo();
	}
}
