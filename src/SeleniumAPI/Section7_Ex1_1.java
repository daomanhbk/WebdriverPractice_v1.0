package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section7_Ex1_1 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void ex1() throws InterruptedException {
		// Step 1
		driver.get("http://demo.guru99.com/test/upload");

		// Step 2
		WebElement CHOOSEFILE_BTN = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		CHOOSEFILE_BTN.sendKeys("C:\\Users\\manhdao\\eclipse-workspace\\WebDriverPractive\\Image\\download.jpeg");

		// Step 3
		WebElement ACCEPT_CHK = driver.findElement(By.xpath("//input[@id='terms']"));
		ACCEPT_CHK.click();

		// Step 4
		WebElement SUBMITFILE_BTN = driver.findElement(By.xpath("//button[@id='submitbutton']"));
		SUBMITFILE_BTN.click();
		
		//Step 5
		Thread.sleep(2000);
		WebElement DISPLAY_MSG = driver.findElement(By.xpath("//h3[@id='res']//center"));
		Assert.assertEquals(DISPLAY_MSG.getText(), "1 file\nhas been successfully uploaded.");
	}

	@AfterClass
	public void afterClass() {

	}
}
