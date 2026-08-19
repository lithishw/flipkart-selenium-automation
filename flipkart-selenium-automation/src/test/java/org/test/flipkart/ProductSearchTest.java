package org.test.flipkart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductSearchTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.flipkart.com/");
	}

	@Test
	public void searchProductTest() {

		WebElement loginbtn = driver.findElement(By.xpath("//span[@role='button']"));
		loginbtn.click();

		WebElement searchBox = driver.findElement(By.name("q"));

		searchBox.sendKeys("iPhone 16");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class,'KzDlHZ')]"));

		System.out.println("Total Products Found: " + products.size());

		for (WebElement product : products) {

			System.out.println(product.getText());
		}

		Assert.assertTrue(products.size() > 0, "Products are not displayed");

		System.out.println("Flipkart Product Search Test Passed");
	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {

			driver.quit();

		}
	}
}