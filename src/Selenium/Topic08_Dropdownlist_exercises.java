package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic08_Dropdownlist_exercises {
	WebDriver driver;
	Select select;
	Actions action;
	WebDriverWait wait;
	JavascriptExecutor js;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 30);
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
	}

	@Test
	public void TC_04_CustomDropdown_KendoUI() throws InterruptedException {
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		clickItemInDropdownlist("//span[@role='listbox' and @aria-owns='color_listbox']",
				"//ul[@id='color_listbox']/li", "Orange");
		
		WebElement SelectedElement = driver.findElement(By.xpath("//input[@id='color']//..//span[@class='k-input']"));		
		Assert.assertTrue(SelectedElement.getText().equals("Orange"));
		
		//Print out the selected element
		System.out.println("Element is selected: " + SelectedElement.getText());

	}

	public void clickItemInDropdownlist(String parentLocator, String allItems, String expectedItem)
			throws InterruptedException {
		//1. Wait and Click on Parent Locator
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parentLocator)));
		WebElement parentDropdown = driver.findElement(By.xpath(parentLocator));		
		js.executeScript("arguments[0].click();", parentDropdown);
		
		//2. Create a list of elements
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(allItems)));
		List<WebElement> allitemsinDropdown = driver.findElements(By.xpath(allItems));
		
		//3. Find the the expected element and click
		for (WebElement item : allitemsinDropdown) {
			if (item.getText().equals(expectedItem)) {
//				javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", item);   //Cai nay ko dung cung duoc
				js.executeScript("arguments[0].click();", item);
				break;
			}
		}
	}

	@AfterClass
	public void afterClass() {
        driver.quit();
	}

}