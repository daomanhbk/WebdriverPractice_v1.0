package SeleniumAPI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section4_Ex2 {
	WebDriver driver;
	
	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void TestEx2() {
		//Step 1
		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		driver.manage().window().maximize();
		
		//Step 2
		Actions action = new Actions(driver);
		List<WebElement> listItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		action.clickAndHold(listItems.get(0)).clickAndHold(listItems.get(7)).click().perform();
		action.release();
		
		//Step 3
		List<WebElement> listSelectedItems = driver.findElements(By.xpath("//li[contains(@class,'selected')]"));
		int size = listSelectedItems.size();
//		System.out.println(size);
		Assert.assertEquals(size, 8);
	}
	@AfterClass
	public void AfterClass() {
		
	}
}
