package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Section3_EX2_3 {
	WebDriver driver;
	
	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void Test_3_3() {
		//Step 1
		driver.get("http://demo.guru99.com/test/radio.html");	
		
		//Step 2
		WebElement firstRadio_btn = driver.findElement(By.xpath("//input[@id='vfb-7-1']"));
				
		if(firstRadio_btn.isSelected() == false) {
			firstRadio_btn.click();	
			Assert.assertTrue(firstRadio_btn.isSelected());
		} 
		
		
		//Step 3
		WebElement thirdCheckBox = driver.findElement(By.xpath("//input[@id='vfb-6-2']"));
		if(thirdCheckBox.isSelected()) {
			thirdCheckBox.click();
			Assert.assertTrue(thirdCheckBox.isSelected());
		}
		
	}
	
	@AfterClass
	public void AfterClass() {
//		driver.close();
	}
}
