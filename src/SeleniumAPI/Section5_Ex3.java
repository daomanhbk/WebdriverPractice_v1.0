package SeleniumAPI;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section5_Ex3 {
	WebDriver driver;

	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void Ex3() throws InterruptedException {
		// Step 1
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");

		// Step 2
		WebElement followOnTwitter_btn = driver.findElement(By.xpath("//a[contains(text(),'Follow On Twitter')]"));
		followOnTwitter_btn.click();
//		Set<String> allWindows = driver.getWindowHandles();
//		int count=0;
//		for(String childWindows : allWindows) {
//			driver.switchTo().window(childWindows);
//			int i=0;			
//			if(count==1) {
//				break;
//			}
//			count = i+1;
//		}

//		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(1));

//		Thread.sleep(2000);
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			driver.switchTo().window(childWindows);
			String childTitle = driver.getTitle();
			if (childTitle.equals("Selenium Easy (@seleniumeasy) on Twitter")) {
				break;
			}
		}
		// Step 3
		String current_Title = driver.getTitle();
		String expectedTitle = "Selenium Easy (@seleniumeasy) on Twitter";
		Assert.assertEquals(current_Title, expectedTitle);

		// Step 4
		driver.close();

		// Step 5
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));

		// Step 6
		String current_Title2 = driver.getTitle();
		String expectedTitle2 = "Selenium Easy - Window Popup Modal Demo";
		Assert.assertEquals(current_Title2, expectedTitle2);

		// Step 7
		WebElement likeUsOnFacebook_btn = driver.findElement(By.xpath("//a[contains(text(),' On Facebook')]"));
		likeUsOnFacebook_btn.click();
		Set<String> allWindows2 = driver.getWindowHandles();
		for (String childWindows2 : allWindows2) {
			driver.switchTo().window(childWindows2);
			String childTitleF = driver.getTitle();
			if (childTitleF.equals("Selenium Easy - Trang chủ | Facebook")) {
				break;
			}
		}

		// Step 8
		String current_Title3 = driver.getTitle();
		String expectedTitle3 = "Selenium Easy - Trang chủ | Facebook";
		Assert.assertEquals(current_Title3, expectedTitle3);

		// Step 9
		driver.close();

		// Step 10
		Set<String> allWindows3 = driver.getWindowHandles();
		for (String childWindows : allWindows3) {
			driver.switchTo().window(childWindows);
			String childTitle = driver.getTitle();
			if (childTitle.equals("Selenium Easy - Window Popup Modal Demo")) {
				break;
			}
		}

		// Step 11
		String current_Title4 = driver.getTitle();
		String expectedTitle4 = "Selenium Easy - Window Popup Modal Demo";
		Assert.assertEquals(current_Title4, expectedTitle4);

	}

	@AfterClass
	public void AfterClass() {

	}
}
