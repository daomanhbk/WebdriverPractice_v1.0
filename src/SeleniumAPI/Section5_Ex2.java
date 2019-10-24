package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section5_Ex2 {
	WebDriver driver;
	
	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void Ex2() {
		//Step 1
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
		
		//Step 2
		WebElement iframeLookingfor = driver.findElement(By.xpath("//div[@id='iframewrapper']/iframe"));
		driver.switchTo().frame(iframeLookingfor);
		WebElement lastName_txt = driver.findElement(By.xpath("//input[@name='lname']"));
		Assert.assertFalse(lastName_txt.isEnabled());
		
		//Step 3
		WebElement firstName_txt = driver.findElement(By.xpath("//input[@name='fname']"));
		firstName_txt.sendKeys("nguyen");
		
		//Step 4
		WebElement submit_btn = driver.findElement(By.xpath("//input[@type='submit']"));
		submit_btn.click();
		
		//Step 5
		WebElement message_lbl = driver.findElement(By.xpath("//div[@style='word-wrap:break-word']"));
		String message_lblActual = message_lbl.getText();
		
		Assert.assertEquals(message_lblActual, "fname=nguyen ");
	}
	
	@AfterClass
	public void AfterClass() {
		
	}
}
