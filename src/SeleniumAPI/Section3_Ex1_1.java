package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section3_Ex1_1 {
	WebDriver driver;

	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void testcase_3_1() {
		// Step 01:
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		driver.manage().window().maximize();

		// Step 02:
		WebElement enterMessage_txt = driver.findElement(By.xpath("//input[@id='user-message']"));
		enterMessage_txt.sendKeys("Manh Dao");

		// Step 03:
		WebElement showMessage_btn = driver.findElement(By.xpath("//button[text()='Show Message']"));
		showMessage_btn.click();

		// Step 04:
		WebElement yourMessage_lbl1 = driver.findElement(By.xpath("//span[@id='display']"));
		String yourMessage_Text1 = yourMessage_lbl1.getText();

		WebElement yourMessage_lbl2 = driver.findElement(By.xpath("//label[contains(text(),'Your')]"));
		String yourMessage_Text2 = yourMessage_lbl2.getText();

		String yourMessage_lbl = yourMessage_Text2 + " " + yourMessage_Text1;
		System.out.println("yourMessage_lbl is: " + yourMessage_lbl);
		Assert.assertEquals(yourMessage_lbl, "Your Message: Manh Dao");
	}

	@Test
	public void testcase_3_2() {

		// Step 1:
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		driver.manage().window().maximize();

		// Step 2:
		WebElement enterA_txt = driver.findElement(By.xpath("//input[@id='sum1']"));
		int a = 100;
		enterA_txt.sendKeys(String.valueOf(a));

		// Step 3:
		WebElement enterB_txt = driver.findElement(By.xpath("//input[@id='sum2']"));
		int b = 50;
		enterB_txt.sendKeys(String.valueOf(b));

		int total = a + b;
		String expectedString = "Total a + b = " + total;

		// Step 4:
		WebElement getTotal_btn = driver.findElement(By.xpath("//button[contains(text(),'Get')]"));
		getTotal_btn.click();

		// Step 5:
		WebElement getTotal_lbl1 = driver.findElement(By.xpath("//label[contains(text(),'Total')]"));
		String getTotal_text = getTotal_lbl1.getText();

		WebElement getTotal_lbl2 = driver.findElement(By.xpath("//span[@id='displayvalue']"));
		String actualValueEntered = getTotal_lbl2.getText();
		String getTotalString = getTotal_text + " " + actualValueEntered;

		Assert.assertEquals(getTotalString, expectedString);

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
	public void afterClass() {
//		driver.close();
	}
}
