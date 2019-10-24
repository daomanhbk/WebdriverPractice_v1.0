package SeleniumAPI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section3_Ex1_4 { //extends CommonFunctions
	

//	public Section3_Ex1_4(WebDriver driver) {
//		super(driver);
//		// TODO Auto-generated constructor stub
//	}

	WebDriver driver;
	CommonFunctions cf;	
	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		cf = new CommonFunctions(driver);
			
	}

	@Test
	public void test3_4() {
		//Step 1
//		driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		cf.openUrl("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		driver.manage().window().maximize();
		
		//Step 2;
//		WebElement checkbox_chk = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
//		checkbox_chk.click();
		cf.clickToElement("//input[@id='isAgeSelected']");
		
		
		
		//Step 3
//		WebElement String_txt = driver.findElement(By.xpath("//div[@id='txtAge']"));
//		String actualtxt = String_txt.getText();
		Assert.assertEquals(cf.getTextElement("//div[@id='txtAge']"), "Success - Check box is checked");
		
		System.out.println("WindowHandle: "+ cf.getWindow());
	}

	@AfterTest
	public void AfterClass() {
//		driver.close();
	}
}
