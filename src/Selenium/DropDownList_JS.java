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

public class DropDownList_JS {
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
		WebElement INTOTHIS = driver.findElement(By.xpath("//div[@id='basic-place']/input"));
		INTOTHIS.clear();
		String intoThisStr = "Renau";
		INTOTHIS.sendKeys(intoThisStr);

		WebElement itemIntoThis = driver.findElement(By.xpath("//li[@class='es-visible selected']"));
		System.out.println("Text of itemIntoThis: " + itemIntoThis.getText());
		itemIntoThis.click();
		WebElement selectedIntoThis = driver.findElement(By.xpath("//li[@class='es-visible']"));
		selectedIntoThis.isDisplayed();

		// 4. Choose option in "Default"
		WebElement INTODEFAULT = driver.findElement(By.xpath("//div[@id='default-place']/input"));
		INTODEFAULT.clear();
		String intoDefaultStr = "Fi";
		INTODEFAULT.sendKeys(intoDefaultStr);

		WebElement ITEMINDEFAULT = driver
				.findElement(By.xpath("//div[@id='default-place']//li[@class='es-visible selected']"));
		System.out.println("Text of ITEMINDEFAULT: " + ITEMINDEFAULT.getText());
		ITEMINDEFAULT.click();
		WebElement selectedDefault = driver
				.findElement(By.xpath("//div[@id='default-place']//li[@class='es-visible']"));
		selectedDefault.isDisplayed();

		// 5. Choose option in "Slide"
		WebElement INTOSLIDE = driver.findElement(By.xpath("//div[@id='slide-place']/input"));
		INTOSLIDE.clear();
		String intoSlideStr = "Ci";
		INTOSLIDE.sendKeys(intoSlideStr);

		WebElement ITEMSLIDE = driver
				.findElement(By.xpath("//div[@id='slide-place']//li[@class='es-visible selected']"));
		System.out.println("Text of ITEMSLIDE: " + ITEMSLIDE.getText());
		ITEMSLIDE.click();
		WebElement selectedSlide = driver.findElement(By.xpath("//div[@id='slide-place']//li[@class='es-visible']"));
		selectedSlide.isDisplayed();

		// 6. Choose option in "Fade"
		WebElement INTOFADE = driver.findElement(By.xpath("//div[@id='fade-place']/input"));
		INTOFADE.clear();
		String intoFadeStr = "fo";
		INTOFADE.sendKeys(intoFadeStr);

		WebElement ITEMFADE = driver.findElement(By.xpath("//div[@id='fade-place']//li[@class='es-visible selected']"));
		System.out.println("Text of ITEMFADE: " + ITEMFADE.getText());
		ITEMFADE.click();
		WebElement selectedFade = driver.findElement(By.xpath("//div[@id='fade-place']//li[@class='es-visible']"));
		selectedFade.isDisplayed();		

	}

	public void clickItemInDropdownlist(String parentLocator, String allItems, String expectedItem, int index) {
		WebElement PARENTELEMENT = driver.findElement(By.xpath(parentLocator));
		PARENTELEMENT.clear(); 
		PARENTELEMENT.sendKeys(expectedItem);
		
		List<WebElement> ALLELEMENTS = driver.findElements(By.xpath(allItems));
		int i = 0;
		for(WebElement childElement : ALLELEMENTS) {
			i=i+1;
			if(i==index) {
				childElement.click();
				System.out.println("Text of childElement: " + childElement.getText());
				break;
			}
		}
	}

	@AfterClass
	public void afterClass() {
//		driver.close();
	}
}
