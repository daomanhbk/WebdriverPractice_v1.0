package SeleniumAPI;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section7_Ex2_2 {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void Ex2_2() throws AWTException, InterruptedException {
		//Step 1
		driver.get("http://the-internet.herokuapp.com/upload");
		
		//Step 2
//		WebElement UPLOAD_BTN = driver.findElement(By.xpath("//input[@id='file-upload']"));
//		UPLOAD_BTN.sendKeys("C:\\Users\\manhdao\\eclipse-workspace\\WebDriverPractive\\Image\\download.jpeg");
		
		StringSelection select = new StringSelection("C:\\Users\\manhdao\\eclipse-workspace\\WebDriverPractive\\Image\\download.jpeg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		
		WebElement UPLOAD_BTN = driver.findElement(By.xpath("//input[@id='file-upload']"));
		UPLOAD_BTN.click();
		
		Robot robot = new Robot();
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
		//Step 3
		WebElement SUBMIT_BTN = driver.findElement(By.xpath("//input[@id='file-submit']"));
		SUBMIT_BTN.click();
		
//		Thread.sleep(1000);
		//Step 4
		WebElement MESSAGE_MSG = driver.findElement(By.xpath("//h3"));
		Assert.assertEquals(MESSAGE_MSG.getText(), "File Uploaded!");
	}
	
	@AfterClass
	public void afterClass() {
		
	}
}
