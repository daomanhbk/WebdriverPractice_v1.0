package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section5_Ex1 {
	WebDriver driver;

	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void Ex1() throws InterruptedException {
		// Step 1
		driver.get("http://the-internet.herokuapp.com/iframe");

		// Step 2 - Swith to iframe

		WebElement iframeLookingfor = driver.findElement(By.xpath("//div[@id='mceu_27']/iframe"));
		driver.switchTo().frame(iframeLookingfor);

		WebElement body_txt = driver.findElement(By.xpath("//body[@id='tinymce']"));

		// Step 2- Select all
		body_txt.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		// Step 2- delete
		body_txt.sendKeys(Keys.DELETE);

		// Step 2-send key
		String sendKey_text = "Ronaldo";
		body_txt.sendKeys(sendKey_text);

//		body_txt.clear();

		// Step 3
		String entered_Text = body_txt.getText();
		Assert.assertEquals(entered_Text, sendKey_text);

		// Step 4
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		WebElement title_lbl = driver.findElement(By.xpath("//h3"));
		String currentTitle = title_lbl.getText();
		Assert.assertEquals(currentTitle, "An iFrame containing the TinyMCE WYSIWYG Editor");

	}

	@AfterClass
	public void AfterClass() {

	}
}
