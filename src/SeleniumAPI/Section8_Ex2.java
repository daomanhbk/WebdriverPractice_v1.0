package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section8_Ex2 {
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
	public void ex2() {
		// Step 1
		driver.get("http://the-internet.herokuapp.com/dynamic_controls");

		// Step 2
		WebElement REMOVE_BTN = driver.findElement(By.xpath("//button[text()='Remove']"));
		REMOVE_BTN.click();

		//Step 3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']")));
		
		//Step 4
		WebElement MSG_MSG = driver.findElement(By.xpath("//p[@id='message']"));
		Assert.assertEquals(MSG_MSG.getText(), "It's gone!");

	}

	@AfterClass
	public void afterClass() {

	}
}
