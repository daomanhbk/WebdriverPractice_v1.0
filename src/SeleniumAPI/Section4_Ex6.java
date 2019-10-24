package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section4_Ex6 {
	WebDriver driver;
	
	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void Ex6() {
		//Step 1
		driver.get("http://demo.guru99.com/v4");
		
		//Step 2
		WebElement userID_txt = driver.findElement(By.xpath("//input[@name='uid']"));
		userID_txt.sendKeys(Keys.TAB);
		
		//Step 3
		WebElement passWord_txt = driver.findElement(By.xpath("//input[@name='password']"));
		passWord_txt.sendKeys("123456");
		
		//Step 4
		passWord_txt.sendKeys(Keys.chord(Keys.SHIFT,"tab"));
		
		//Step 5
		userID_txt.sendKeys("Ronaldo");
		
		//Step 6
		userID_txt.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		
		//Step 7- delete
		userID_txt.sendKeys(Keys.DELETE);
		
		
	}
	
	@AfterClass
	public void AfterClass() {
		
	}
}
