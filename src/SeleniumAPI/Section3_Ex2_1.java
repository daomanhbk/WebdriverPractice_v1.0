package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Section3_Ex2_1 {
	WebDriver driver;
	
	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void Test3_Ex3_1() {
		//Step 1 - Vao trang xxxx
		driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		
		//Step 2
		WebElement getCheckedValue_btn = driver.findElement(By.xpath("//button[@id='buttoncheck']"));
		Assert.assertTrue(getCheckedValue_btn.isDisplayed());
	}
	
	@AfterClass
	public void AfterClass() {
//		driver.close();
	}
	
}
