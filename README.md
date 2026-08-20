# Flipkart Selenium Automation

This project contains a simple Selenium WebDriver automation test for Flipkart using **Java**, **TestNG**, and **Maven**.

The test searches for **iPhone 16** on Flipkart, collects the displayed product names, prints them in the console, and verifies that at least one product is displayed.

## Technologies Used

* Java
* Selenium WebDriver
* TestNG
* Maven
* ChromeDriver
* Eclipse IDE
* Git & GitHub

## Test Scenario

The automation performs the following steps:

1. Launches Google Chrome.
2. Opens the Flipkart website.
3. Closes the login popup.
4. Locates the Flipkart search box.
5. Searches for **iPhone 16**.
6. Clicks the search button.
7. Collects all displayed product names.
8. Prints the total number of products found.
9. Prints each product name in the console.
10. Verifies that at least one product is displayed.
11. Closes the browser after test execution.

## Project Structure

```text
flipkart-selenium-automation
│
├── src
│   └── test
│       └── java
│           └── org.test.flipkart
│               └── ProductSearchTest.java
│
├── pom.xml
├── testng.xml
└── README.md
```

## Automation Code

```java
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

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.flipkart.com/");
    }

    @Test
    public void searchProductTest() {

        WebElement loginbtn =
                driver.findElement(By.xpath("//span[@role='button']"));

        loginbtn.click();

        WebElement searchBox =
                driver.findElement(By.name("q"));

        searchBox.sendKeys("iPhone 16");

        driver.findElement(
                By.xpath("//button[@type='submit']")).click();

        List<WebElement> products =
                driver.findElements(
                        By.xpath("//div[contains(@class,'KzDlHZ')]"));

        System.out.println(
                "Total Products Found: " + products.size());

        for (WebElement product : products) {

            System.out.println(product.getText());
        }

        Assert.assertTrue(
                products.size() > 0,
                "Products are not displayed");

        System.out.println(
                "Flipkart Product Search Test Passed");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}
```

## How to Run the Project

Clone the repository:

```bash
git clone <your-repository-url>
```

Open the project in **Eclipse IDE**.

Make sure Maven dependencies are downloaded.

Run the test using:

```text
Right Click ProductSearchTest.java
→ Run As
→ TestNG Test
```

You can also run the project using `testng.xml`.

## Expected Output

The console will display:

```text
Total Products Found: <number>

iPhone 16
iPhone 16 Plus
iPhone 16 Pro
...

Flipkart Product Search Test Passed
```

## Validation

The following TestNG assertion verifies that products are displayed:

```java
Assert.assertTrue(
    products.size() > 0,
    "Products are not displayed");
```

The test passes when at least one matching product is available in the Flipkart search results.

## Learning Outcomes

This project demonstrates hands-on experience with:

* Selenium WebDriver
* WebElement handling
* XPath locators
* Name locators
* Implicit waits
* Handling multiple WebElements
* Java collections using `List`
* TestNG annotations
* TestNG assertions
* Browser setup and teardown
* Maven-based Selenium projects
* Git and GitHub version control

## Author

**Lithishwaran A**

QA Automation | Java | Selenium WebDriver | TestNG | Maven
