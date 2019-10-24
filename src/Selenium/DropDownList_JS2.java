package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDownList_JS2 {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	String jsText, att;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
	}

	@Test
	public void dropDownListJS() throws InterruptedException {
		// 1. Navigate to URL
		driver.get("http://indrimuska.github.io/jquery-editable-select/");

		// 2. Choose option in "It transforms this"
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='base']")));
		Select select = new Select(driver.findElement(By.xpath("//select[@id='base']")));
		select.selectByVisibleText("Audi");

		String actualText = select.getFirstSelectedOption().getText();
		Assert.assertEquals(actualText, "Audi");

		// 3 Choose option in "Into this"
		clickItemInDropdownlist("//div[@id='basic-place']/input",
				"//div[@id='basic-place']//li[@class='es-visible selected']", "a", 1);
		checkElementIsSelected("//div[@id='basic-place']//li[@class='es-visible']");

		// 4. Choose option in "Default"
		clickItemInDropdownlist("//div[@id='default-place']/input",
				"//div[@id='default-place']//li[@class='es-visible selected']", "b", 1);
		checkElementIsSelected("//div[@id='default-place']//li[@class='es-visible']");

		// 5. Choose option in "Slide"
		clickItemInDropdownlist("//div[@id='slide-place']/input",
				"//div[@id='slide-place']//li[@class='es-visible selected']", "c", 1);
		checkElementIsSelected("//div[@id='slide-place']//li[@class='es-visible']");

		// 6. Choose option in "Fade"
		clickItemInDropdownlist("//div[@id='fade-place']/input",
				"//div[@id='fade-place']//li[@class='es-visible selected']", "f", 1);
		checkElementIsSelected("//div[@id='fade-place']//li[@class='es-visible']");

	}

	public void clickItemInDropdownlist(String parentLocator, String allItems, String expectedItem, int index) {
		WebElement PARENTELEMENT = driver.findElement(By.xpath(parentLocator));
		PARENTELEMENT.clear();
		PARENTELEMENT.sendKeys(expectedItem);

		List<WebElement> ALLELEMENTS = driver.findElements(By.xpath(allItems));
		int i = 0;
		for (WebElement childElement : ALLELEMENTS) {
			i = i + 1;
			if (i == index) {
				childElement.click();
				System.out.println("Text of childElement: " + childElement.getText());
				break;
			}
		}
	}

	public void checkElementIsSelected(String value) {
		WebElement selectedFade = driver.findElement(By.xpath(value));
		selectedFade.isDisplayed();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
