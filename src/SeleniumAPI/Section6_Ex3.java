package SeleniumAPI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section6_Ex3 {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void ex3() {
		//Step 1
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		
		//Step 2
		WebElement CLICKFORJSPROMPT_BTN = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
		CLICKFORJSPROMPT_BTN.click();
		
		//Step 3
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		
		//Step 4
		alert.sendKeys("manh dao");
		alert.accept();
		WebElement RESULT_MSG = driver.findElement(By.xpath("//p[@id='result']"));
		Assert.assertEquals(RESULT_MSG.getText(), "You entered: manh dao");
		
		
	}
}
