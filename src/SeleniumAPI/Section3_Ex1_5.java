package SeleniumAPI;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class Section3_Ex1_5 {
	WebDriver driver;

	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test3_5() {
		//Step 1
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		//Step 2
		Select date_Select = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		date_Select.selectByVisibleText("14");
		
		Select month_Select = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		month_Select.selectByValue("2");
		
		Select year_Select = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		year_Select.selectByValue("2018");
		
		//Step 3
		String actualDate_txt = date_Select.getFirstSelectedOption().getText();
		String actualMonth_txt = month_Select.getFirstSelectedOption().getText();
		String actualYear_txt = year_Select.getFirstSelectedOption().getText();
		
		String ExpectedDate_txt = "14";
		String ExpectedMonth_txt = "Tháng 2";
		String ExpectedYear_txt = "2018";
		Assert.assertEquals(actualDate_txt, ExpectedDate_txt);
		Assert.assertEquals(actualMonth_txt, ExpectedMonth_txt);
		Assert.assertEquals(actualYear_txt, ExpectedYear_txt);
	}

	@AfterClass
	public void AfterClass() {
//		driver.close();
	}
}

