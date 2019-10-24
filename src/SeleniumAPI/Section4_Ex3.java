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

public class Section4_Ex3 {
	WebDriver driver;
	
	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void Ex3() {
		//Step 1
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		
		
		//Step 2
		WebElement rightClickMe_btn = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action = new Actions(driver);
		action.contextClick(rightClickMe_btn).build().perform();
		
		//Step 3
		WebElement quit_lbl = driver.findElement(By.xpath("//span[text()='Quit']"));
		action.moveToElement(quit_lbl).perform();
		quit_lbl.click();
		
		//Step 4
		Alert alert = driver.switchTo().alert();
		String alert_msg = alert.getText();
		Assert.assertEquals(alert_msg, "clicked: quit");
		
		//Step 5
		alert.accept();
		
		
		
	}
	
	@AfterClass
	public void AfterClass() {

	}
	
}
