package SeleniumAPI;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section6_Ex4 {
	WebDriver driver;
	JavascriptExecutor js;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
	}
	
	@Test
	public void ex4() throws InterruptedException {
		//Step 1
		driver.get("http://live.guru99.com/");
		
		//Step 2
		WebElement MYACCOUNT_LNK = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
//		MYACCOUNT_LNK.click();	
		
		js.executeScript("arguments[0].click()", MYACCOUNT_LNK);
		
		//Step 3
		Thread.sleep(3000);
		WebElement CREATEANACCOUNT_BTN = driver.findElement(By.xpath("//a[@title='Create an Account']"));
//		CREATEANACCOUNT_BTN.click();		
		js.executeScript("arguments[0].click()", CREATEANACCOUNT_BTN);
		
		//Step 4
		Thread.sleep(3000);
		WebElement FIRSTNAME_TXT = driver.findElement(By.xpath("//input[@id='firstname']"));
		FIRSTNAME_TXT.sendKeys("testFN");
		
		WebElement LASTNAME_TXT = driver.findElement(By.xpath("//input[@id='lastname']"));
		LASTNAME_TXT.sendKeys("testLN");
		
		
		WebElement EMAILADDRESS_TXT = driver.findElement(By.xpath("//input[@id='email_address']"));
//		String email = mock.emails().val();
		String email = randomemail() + "@gmail.com";
		EMAILADDRESS_TXT.sendKeys(email);
		
		WebElement PASSWORD_TXT = driver.findElement(By.xpath("//input[@id='password']"));
		PASSWORD_TXT.sendKeys("123456");
		
		WebElement CONFIRMPASSWORD_TXT = driver.findElement(By.xpath("//input[@id='confirmation']"));
		CONFIRMPASSWORD_TXT.sendKeys("123456");
		
		//Step 5
		Thread.sleep(3000);
		WebElement REGISTER_BTN = driver.findElement(By.xpath("//span[text()='Register']"));		
		js.executeScript("arguments[0].click()", REGISTER_BTN);
		
		Thread.sleep(3000);
		WebElement SUCCESSFUL_LBL = driver.findElement(By.xpath("//li[@class='success-msg']//span"));
		Assert.assertEquals(SUCCESSFUL_LBL.getText(), "Thank you for registering with Main Website Store.");
		
		//Step 6
		WebElement ACCOUNT_LBL = driver.findElement(By.xpath("//div[contains(@class,'cart')]//span[text()='Account']"));
		js.executeScript("arguments[0].click()", ACCOUNT_LBL);
		
		WebElement LOGOUT_BTN = driver.findElement(By.xpath("//a[@title='Log Out']"));
		js.executeScript("arguments[0].click()", LOGOUT_BTN);
		
		//Step 7
		Thread.sleep(3000);
		WebElement MYACCOUNT_LNK1 = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
		js.executeScript("arguments[0].click()", MYACCOUNT_LNK1);
		Thread.sleep(2000);
		WebElement EMAILADDRESSLOGIN_TXT = driver.findElement(By.xpath("//input[@title='Email Address']"));
		EMAILADDRESSLOGIN_TXT.sendKeys(email);
		
		WebElement PASSWORDLOGIN_TXT = driver.findElement(By.xpath("//input[@title='Password']"));
		PASSWORDLOGIN_TXT.sendKeys("123456");
		
		WebElement LOGIN_BTN =driver.findElement(By.xpath("//button[@id='send2']"));
		js.executeScript("arguments[0].click()", LOGIN_BTN);
		
		//Step 8
		Thread.sleep(3000);
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "http://live.guru99.com/index.php/customer/account/index/");
	}
	
	@AfterClass
	public void afterClass() {
		
	}
	
	public String randomemail() {
		Random rand = new Random();
		int number = rand.nextInt(900000) + 1;
		String numberString = Integer.toString(number);
		return numberString;

	}
	
	
}
