package SeleniumAPI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section6_Ex2 {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void Ex2() {
		//Step 1
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		
		//Step 2
		WebElement clickForJSConfirm_btn = driver.findElement(By.xpath("//button[contains(text(),'JS Confirm')]"));
		clickForJSConfirm_btn.click();
		
		//Step 3
		Alert alert = driver.switchTo().alert();
		String alert_msg = alert.getText();
		Assert.assertEquals(alert_msg, "I am a JS Confirm");
		
		//Step 4
		alert.dismiss();
		WebElement RESULT_MSG = driver.findElement(By.xpath("//p[@id='result']"));
		Assert.assertEquals(RESULT_MSG.getText(), "You clicked: Cancel");
		
		
	}
	
	@AfterClass
	public void AfterClass() {
		
	}
}
