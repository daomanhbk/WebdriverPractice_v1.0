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

public class Section7_Ex1_2 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void Ex1_2() throws InterruptedException, AWTException {
		// Step 1
		driver.get("http://demo.guru99.com/test/upload");
		
		//Step 2
		StringSelection select = new StringSelection("C:\\Users\\manhdao\\eclipse-workspace\\WebDriverPractive\\Image\\download.jpeg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		
		WebElement CHOOSEFILE_BTN = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		CHOOSEFILE_BTN.click();
		
		Robot robot = new Robot();
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Step 3
		WebElement ACCEPT_CHK = driver.findElement(By.xpath("//input[@id='terms']"));
		ACCEPT_CHK.click();

		// Step 4
		WebElement SUBMITFILE_BTN = driver.findElement(By.xpath("//button[@id='submitbutton']"));
		SUBMITFILE_BTN.click();

		// Step 5
		Thread.sleep(2000);
		WebElement DISPLAY_MSG = driver.findElement(By.xpath("//h3[@id='res']//center"));
		Assert.assertEquals(DISPLAY_MSG.getText(), "1 file\nhas been successfully uploaded.");
	}

	@AfterClass
	public void afterClass() {

	}
}
