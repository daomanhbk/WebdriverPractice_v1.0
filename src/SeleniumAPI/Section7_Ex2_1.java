package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section7_Ex2_1 {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void Ex2_1() {
		//Step 1
		driver.get("http://the-internet.herokuapp.com/upload");
		
		//Step 2
		WebElement UPLOAD_BTN = driver.findElement(By.xpath("//input[@id='file-upload']"));
		UPLOAD_BTN.sendKeys("C:\\Users\\manhdao\\eclipse-workspace\\WebDriverPractive\\Image\\download.jpeg");
		
		//Step 3
		WebElement SUBMIT_BTN = driver.findElement(By.xpath("//input[@id='file-submit']"));
		SUBMIT_BTN.click();
		
		//Step 4
		WebElement MESSAGE_MSG = driver.findElement(By.xpath("//h3"));
		Assert.assertEquals(MESSAGE_MSG.getText(), "File Uploaded!");
	}
	
	@AfterClass
	public void afterClass() {
		
	}
}
