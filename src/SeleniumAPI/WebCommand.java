package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebCommand {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void testcase_01() throws Exception {
		driver.get("http://demo.guru99.com/V4/");
		driver.manage().window().maximize();
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The current URL is: " + currentUrl);
		
		
		
//		String pageSource = driver.getPageSource();
//		System.out.println("The current PageSource is:" + pageSource);
		
//		String title = driver.getTitle();
//		System.out.println("Title is: " + title);
//		
//		driver.navigate().to("https://www.google.com/");
//		String title2 = driver.getTitle();
//		System.out.println("Title 2 is: " + title2);
//		
//		driver.navigate().back();
//		Thread.sleep(2000);
//		String title3 = driver.getTitle();
//		System.out.println("Title 3 is: " + title3);
//		driver.navigate().forward();
		
		WebElement userID_txt =  driver.findElement(By.xpath("//input[@name='uid']"));
		userID_txt.sendKeys("mngr198750");
//		userID_txt.clear();
		String userID_attribute = userID_txt.getAttribute("onkeyup");
		System.out.println("userID_attribute is: " + userID_attribute);
		
		WebElement password_txt = driver.findElement(By.xpath("//input[@name='password']"));
		password_txt.sendKeys("AsugEvU");
		
//		WebElement login_btn = driver.findElement(By.xpath("//input[@type='submit']"));
//		login_btn.click();
		
		WebElement userID_lbl = driver.findElement(By.xpath("//input[@name='uid']/ancestor::td/preceding-sibling::td"));
		String userID_label = userID_lbl.getText();
		System.out.println("userID_label is: "+ userID_label);
		
		WebElement password_lbl = driver.findElement(By.xpath("//input[@name='password']/ancestor::td/preceding-sibling::td"));
		String password_label = password_lbl.getText();
		System.out.println("password_label is " + password_label);		
	
	}

	@AfterTest
	public void afterClass() {
//		driver.close();
	}
}
