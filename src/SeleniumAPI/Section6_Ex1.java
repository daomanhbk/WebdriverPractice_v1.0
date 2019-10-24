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

public class Section6_Ex1 {
	WebDriver driver;
	
	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
	}
	
	@Test
	public void Ex1() {
		//Step 1
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		
		//Step 2
		WebElement iAmAJSAlert_btn = driver.findElement(By.xpath("//button[contains(text(),'Alert')]"));
		iAmAJSAlert_btn.click();
		
		//Step 3
		Alert alert = driver.switchTo().alert();
		String alert_msg = alert.getText();
		Assert.assertEquals(alert_msg, "I am a JS Alert");
		
		//Step 4
		alert.accept();
		WebElement result_lbl = driver.findElement(By.xpath("//p[@id='result']"));
		String result_actual = result_lbl.getText();
		Assert.assertEquals(result_actual, "You successfuly clicked an alert");
		
	}
	
	@AfterClass
	public void AfterClass() {
//		driver.close();
	}
}
