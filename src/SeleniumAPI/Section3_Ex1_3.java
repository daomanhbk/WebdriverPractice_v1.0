package SeleniumAPI;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section3_Ex1_3 {
	WebDriver driver;

	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test3_3() {
		// Step 1 
		driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		driver.manage().window().maximize();
		// Step 2
		WebElement getCheckedValue_btn = driver.findElement(By.xpath("//button[@id='buttoncheck']"));
		getCheckedValue_btn.click();
		// Step 3
		WebElement AfterClick_lbl = driver.findElement(By.xpath("//p[@class='radiobutton']"));
		String actualTextAfterClick_lbl = AfterClick_lbl.getText();
		String ExpectedAfterClick_lbl = "Radio button is Not checked";
		Assert.assertEquals(actualTextAfterClick_lbl, ExpectedAfterClick_lbl);

		// Step 4 - Click on radio button "Male"
		WebElement Male_rbrn = driver.findElement(By.xpath("//input[@value='Male' and @name = 'optradio']"));
		Male_rbrn.click();

		// Step 4.5
		getCheckedValue_btn.click();
		String actualTextAfterClick2_lbl = AfterClick_lbl.getText();
		String ExpectedAfterClick2_lbl = "Radio button 'Male' is checked";
		// Step 5 -Verify
		Assert.assertEquals(actualTextAfterClick2_lbl, ExpectedAfterClick2_lbl);

		// Step 6
		WebElement FeMale_rbrn = driver.findElement(By.xpath("//input[@value='Female' and @name = 'optradio']"));
		FeMale_rbrn.click();

		// Step 6.5
		getCheckedValue_btn.click();
		String actualTextAfterClick3_lbl = AfterClick_lbl.getText();
		String ExpectedAfterClick3_lbl = "Radio button 'Female' is checked";

		// Step 7 -Verify
		Assert.assertEquals(actualTextAfterClick3_lbl, ExpectedAfterClick3_lbl);

	}

	@AfterTest
	public void AfterClass() {
//		driver.close();
	}
}
