package testng;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDataProvider {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

//	@BeforeMethod
//	  public void beforeMethod() {		
//		driver.get("http://demo.guru99.com/V4/");
//	  }
//	@AfterMethod
//	  public void afterMethod() {
//		
//	  }
//	@Parameters({ "username1", "password1" })
	@Test(dataProvider = "userandpass")
	public void tc01(String username1, String password1) {
//		System.out.println(username1);
//		System.out.println(password1);
//		// Step 1
		driver.get("http://demo.guru99.com/V4/");

		// Step 2
		WebElement USERNAME = driver.findElement(By.xpath("//input[@name = 'uid']"));
		USERNAME.sendKeys(username1);

		// Step 2
		WebElement PASSWORD = driver.findElement(By.xpath("//input[@name = 'password']"));
		PASSWORD.sendKeys(password1);

		// Step 3
		WebElement SUBMIT_BTN = driver.findElement(By.xpath("//input[@name = 'btnLogin']"));
		SUBMIT_BTN.click();

		// Step 4
		WebElement Welcome_LBL = driver.findElement(By.xpath("//marquee[@class='heading3']"));
		Assert.assertEquals(Welcome_LBL.getText(), "Welcome To Manager's Page of Guru99 Bank");
	}

////	@Parameters({ "username2", "password2" })
	@Test(dataProvider = "userandpass")
	public void tc02(String username2, String password2) {
//		// Step 1
		driver.get("http://demo.guru99.com/V4/");

		// Step 2
		WebElement USERNAME = driver.findElement(By.xpath("//input[@name = 'uid']"));
		USERNAME.sendKeys(username2);

		// Step 2
		WebElement PASSWORD = driver.findElement(By.xpath("//input[@name = 'password']"));
		PASSWORD.sendKeys(password2);

		// Step 3
		WebElement SUBMIT_BTN = driver.findElement(By.xpath("//input[@name = 'btnLogin']"));
		SUBMIT_BTN.click();

		// Step 4
		WebElement Welcome_LBL = driver.findElement(By.xpath("//marquee[@class='heading3']"));
		Assert.assertEquals(Welcome_LBL.getText(), "Welcome To Manager's Page of Guru99 Bank");
	}

//	@Parameters({ "username3", "password3" })
	@Test(dataProvider = "userandpass")
	public void tc03(String username3, String password3) {
//		// Step 1
		driver.get("http://demo.guru99.com/V4/");

		// Step 2
		WebElement USERNAME = driver.findElement(By.xpath("//input[@name = 'uid']"));
		USERNAME.sendKeys(username3);

		// Step 2
		WebElement PASSWORD = driver.findElement(By.xpath("//input[@name = 'password']"));
		PASSWORD.sendKeys(password3);

		// Step 3
		WebElement SUBMIT_BTN = driver.findElement(By.xpath("//input[@name = 'btnLogin']"));
		SUBMIT_BTN.click();

		// Step 4
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "User or Password is not valid");
		alert.accept();
	}

	@AfterClass
	public void afterClass() {
//		driver.close();
	}

	@DataProvider(name = "userandpass")

	public Object[][] userandpass(Method method) {
		Object[][] result = null;
		if (method.getName().equals("tc01")) {
			result = new Object[][] { { "mngr214186", "jypAmYd" } };
		} else if(method.getName().equals("tc02")) {
			result = new Object[][] {{ "mngr214187", "nadEmEq" } };
		}
		else {
			result = new Object[][] { { "vunguyen", "12345678" } };
		}
		return result;
	}
}
