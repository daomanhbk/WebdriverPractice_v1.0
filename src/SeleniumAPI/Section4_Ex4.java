package SeleniumAPI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section4_Ex4 {
	WebDriver driver;
	
	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void Ex4() throws InterruptedException {
		//Step 1
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		
		//Step 2
		WebElement doubleClick_btn = driver.findElement(By.xpath("//button[contains(text(),'Double-Click')]"));
		Actions action = new Actions(driver);
		action.doubleClick(doubleClick_btn).perform();
		
		//Step 3
		Alert alert = driver.switchTo().alert();
		String alert_lbl = alert.getText();
		Assert.assertEquals(alert_lbl, "You double clicked me.. Thank You..");
		
		//Step 4
		Thread.sleep(5000);
		alert.accept();
		
	}
	
	@AfterClass
	public void AfterClass() {
		
	}
}
