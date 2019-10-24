package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Section3_Ex2_2 {
	WebDriver driver;
	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdirver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void TestEx3_2() {
		//Step 1
		driver.get("http://the-internet.herokuapp.com/dynamic_controls");
		//Step 2
//		WebElement aCheckbox_chk = driver.findElement(By.xpath("//input[@label = 'blah']"));
//		Assert.assertFalse(aCheckbox_chk.isEnabled());
		WebElement aTextbox_txt = driver.findElement(By.xpath("//form[@id='input-example']/input"));
		Assert.assertFalse(aTextbox_txt.isEnabled());
		
		//Why assertFalse and assertTrue are responded equal values
	}
	
	@AfterClass
	public void AfterClass() {
//		driver.close();
	}
	
}
