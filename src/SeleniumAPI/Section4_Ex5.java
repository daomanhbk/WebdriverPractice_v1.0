package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section4_Ex5 {
	WebDriver driver;
	
	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void Ex5() throws InterruptedException {
		//Step 1
		driver.get("http://interactjs.io");
		
		//Step 2
		WebElement yesDrop_item = driver.findElement(By.xpath("//div[@id='yes-drop']"));
		WebElement inner_dropzone = driver.findElement(By.xpath("//div[@id='inner-dropzone']"));
		
		Actions action = new Actions(driver);
		Action dragAndDrop = action.clickAndHold(yesDrop_item).moveToElement(inner_dropzone).release(inner_dropzone).build();
		dragAndDrop.perform();
		
		//Step 3
		Thread.sleep(3000);
		String yesDrop_item_lbl = yesDrop_item.getText();
		Assert.assertEquals(yesDrop_item_lbl, "Dropped");
	}
	
	@AfterClass
	public void AfterClass() {
		
	}
}
