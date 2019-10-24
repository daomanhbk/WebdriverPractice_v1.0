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

public class DemoJquery {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
//		driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
//		driver.get("http://demo.guru99.com/V4/");
//		driver.manage().window().maximize();
	}

	@Test
	public void demoJquery() throws InterruptedException {
		// 1. Click on Click Link
		WebElement CLICK_LNK = driver.findElement(By.xpath("//a[contains(text(),'here')]"));
		CLICK_LNK.click();

		// 2. Input random email
		String randomEmail = "abc" + randomemail() + "@gmail.com";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("$('input[name=\"emailid\"]').val('" + randomEmail + "')");

		// 3. Click on Submit button
		js.executeScript("$('input[type=\"submit\"]').click()");

		// 4. Get Username and password
		String username = js.executeScript("return $('td:contains(\"User\")').siblings('td[align=\"center\"]').text()")
				.toString();
		Thread.sleep(1000);
		String password = js
				.executeScript("return $('td:contains(\"Password\")').siblings('td[align=\"center\"]').text()")
				.toString().trim();
		System.out.println(password);
		// 5. Get URL
		driver.get("http://demo.guru99.com/V4/");

		// 6. Enter Username, password and click
		js.executeScript("$('input[name=\"uid\"]').val('" + username + "')");
		js.executeScript("$('input[name=\"password\"]').val('" + password + "')"); // input[name="password"]
		js.executeScript("$('input[name=\"btnLogin\"]').click()");

		// 7. Assert
		String welcomeText = js.executeScript("return $('marquee.heading3').text()").toString();
		Assert.assertTrue(welcomeText.contains("Welcome"));

	}
	
//	@Test
//    public void TC_06_DragAndDrop() throws InterruptedException {
//		driver.get("http://demos.telerik.com/kendo-ui/dragdrop/angular");
//		WebElement dropTarget = driver.findElement(By.xpath("//div[@id='droptarget']"));
//		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
//		Assert.assertEquals(dropTarget.getText(), "Drag the small circle here.");
//		
//		Actions action = new Actions(driver);		
////		Action dragAndDrop = action.clickAndHold(drag).moveToElement(dropTarget).release(dropTarget).build();
////		dragAndDrop.perform();
//		
//		action.dragAndDrop(drag, dropTarget).build().perform();
//		Thread.sleep(3000);
//		Assert.assertEquals(dropTarget.getText(), "You did great!");
//		
//	}

	public String randomemail() {
		Random rand = new Random();
		int number = rand.nextInt(900000);
		String numberString = Integer.toString(number);
		return numberString;
	}

	@AfterClass
	public void afterClass() {
//		driver.close();
	}
}
