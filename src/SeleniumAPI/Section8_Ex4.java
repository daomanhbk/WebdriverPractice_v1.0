package SeleniumAPI;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.google.common.base.Function;

public class Section8_Ex4 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 30);
	}

	@Test
	public void ex4() {
		// Step 1
		driver.get("https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");

		// Step 2
		WebElement DOWNLOAD_BTN = driver.findElement(By.xpath("//button[@id='cricle-btn']"));
		DOWNLOAD_BTN.click();
		
		//div[@class='percenttext']
//		//Step 3
//		WebElement LOADING_LBL = driver.findElement(By.xpath("//div[@class='percenttext']"));
//		new FluentWait<WebElement>(LOADING_LBL).withTimeout(70, 
//				TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
//		.until(new Function<WebElement, Boolean>() {
//			public Boolean apply(WebElement element) {
//				boolean flag = element.getText().contains("100%");
//				return flag;
//			}
			
//		});
		
		//Step 3 - C2		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'100%')]")));
		WebElement LOADING_LBL = driver.findElement(By.xpath("//div[contains(text(),'100%')]"));
		Assert.assertEquals(LOADING_LBL.getText(), "100%");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
