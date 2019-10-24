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
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic08_Dropdownlist_exercises2 {
	WebDriver driver;
	Select select;
	Actions action;
	WebDriverWait wait;
	JavascriptExecutor javascriptExecutor;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 30);
		javascriptExecutor = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
	}

	@Test
	public void TC_04_CustomDropdown_KendoUI() throws InterruptedException {
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");
		clickItemInDropdownlist("//span[@role='listbox' and @aria-owns='color_listbox']",
				"//ul[@id='color_listbox']/li", "Orange");
//		 Assert.assertTrue(driver.findElement(By.xpath("//ul[@id='color_listbox']//li[@aria-selected=\"true\"
//		 and text()='Orange']")).isSelected());

	}

	public void clickItemInDropdownlist(String parentLocator, String allItems, String expectedItem)
			throws InterruptedException {
		// click parent tag to display items inside
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parentLocator)));
		WebElement parentDropdown = driver.findElement(By.xpath(parentLocator));
		Thread.sleep(1000);
		// neu display thi dung click() cua selenium, k thi dung cua javascript
		if (parentDropdown.isDisplayed()) {
			// click
			parentDropdown.click();
		} else {
			// click by javascript
			javascriptExecutor.executeScript("arguments[0].click();", parentDropdown);
		}

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(allItems)));
		// tao 1 list web elements
		List<WebElement> allitemsinDropdown = driver.findElements(By.xpath(allItems));
		Thread.sleep(2000);

		// scan each item and gettext
		//////////////////////////////////
		// 4. Hover on View Data and select NetPRO ADD Subject
//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='lbl_ViewData_Row1']")));
//					WebElement VIEWDATA_LBL = driver.findElement(By.xpath("//span[@id='lbl_ViewData_Row1']"));
//					Actions action = new Actions(driver);
//					action.moveToElement(VIEWDATA_LBL).perform();
//
//					// 4.1 Hover on NetPro Add Subject and click
//					wait.until(
//							ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'NetPro Add')]")));
//					WebElement NETPROADDSUBJECT_LNK = driver.findElement(By.xpath("//span[contains(text(),'NetPro Add')]"));
//					action.moveToElement(NETPROADDSUBJECT_LNK).perform();
//					NETPROADDSUBJECT_LNK.click();
//
//					// 5. Select a site from DropDown List
//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ParamKrDOM']")));
//					Select PHASE_DDL = new Select(driver.findElement(By.xpath("//select[@id='ParamKrDOM']")));
//					PHASE_DDL.selectByIndex(commonData.getCreateSubject().getIndex());
		///////////////////////////////////////////////
		for (WebElement item : allitemsinDropdown) {
			if (item.getText().equals(expectedItem)) {
//
//				// neu = thi scroll den roi click vao
//				javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
//				Thread.sleep(1000);
//
//				if (item.isDisplayed()) {
//					item.click();
//				}
//
//				else {
//					javascriptExecutor.executeScript("arguments[0].click();", item);
//				}
//				// javascriptExecutor.executeScript("arguments[0].click();",item);
//				Thread.sleep(1500);

				javascriptExecutor.executeScript("arguments[0].click();", item);
				break;

			}
		}
	}

	@AfterClass
	public void afterClass() {
//        driver.quit();
	}

}