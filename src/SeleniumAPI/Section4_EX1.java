package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Section4_EX1 {
	WebDriver driver;
	
	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void TestEx1() throws InterruptedException {
		//Step 1
		driver.get("https://www.24h.com.vn");
		driver.manage().window().maximize();
		
		//Step 2
		WebElement danhmuc_tab = driver.findElement(By.xpath("//a[text()='Danh mục']"));		
		Actions action = new Actions(driver);
		action.moveToElement(danhmuc_tab).perform();
		Thread.sleep(1000);
		WebElement bongda_tab = driver.findElement(By.xpath("//a[text()='Bóng đá']"));
		action.moveToElement(bongda_tab).perform();
		WebElement lichthidaubongdat_tab = driver.findElement(By.xpath("//a[text()='Lịch thi đấu bóng đá']"));
		action.moveToElement(lichthidaubongdat_tab).perform();
		
		//Step 3
		lichthidaubongdat_tab.click();
		
		//Step 4
		Thread.sleep(3000);
		String currentTitle = driver.getTitle();
		Assert.assertEquals(currentTitle, "Lịch thi đấu Bóng Đá Anh, Ý TBN C1, Kết quả Tỉ lệ cược 24h");
		
		
	}
	
	@AfterClass
	public void AfterClass() {
//		driver.close();
	}
	
}
