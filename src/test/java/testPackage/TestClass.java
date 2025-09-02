package testPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class TestClass {
    private WebDriver driver;

        @Test
                 public void firstTest() {
            driver.get("https://duckduckgo.com");
            String actualTitle = driver.getTitle();
            String expectedTitle = "Google";
            assertEquals(actualTitle, expectedTitle, "Title mismatch");
        }

        @Test
                public void secondTest() {
            driver.get("https://duckduckgo.com");
            By logo = By.xpath("//div[contains(@class,'Desktop')]//img");
            boolean isLogoDisplayed = driver.findElement(logo).isDisplayed();
            Assert.assertTrue(isLogoDisplayed, "Logo is not displayed");
        }

    /**
     * open Chrome browser
     *  open duckduckgo.com
     *  search for "Selenium WebDriver"
     *  click on search button
     *  verify that the first result contains "https://www.selenium.dev/documentation/webdriver/"
     *  assert that first result is "https://www.selenium.dev/documentation/webdriver/"
     *  and display message "First search result is match"
     * */
    @Test
    public void thirdTest() {
        driver.get("https://duckduckgo.com");
        By searchInputLocator = By.xpath("//input [@class='searchbox_input__rnFzM']");
        driver.findElement(searchInputLocator).sendKeys("Selenium WebDriver");
        driver.findElement(searchInputLocator).submit();
        String firstResultText = "https://www.selenium.dev/documentation/webdriver/";
        By firstResultLocator = By.xpath("//*[@id=\"r1-0\"]/div[3]/h2/a");
        String actualFirstResultText = driver.findElement(firstResultLocator).getAttribute("href");
        assertEquals(actualFirstResultText, firstResultText, "First search result is match");
    }

    /**
     * Open Mozilla Firefox
     * navigate to duckduckgo.com
     * search for "TestNG"
     * Assert that the text of the fourth result is [TestNG Tutorial]
     * Close Mozilla Firefox
     */

    @Test
    public void fourthTest() {
        driver.get("https://duckduckgo.com");
        By searchInputLocator = By.xpath("//input [@class='searchbox_input__rnFzM']");
        driver.findElement(searchInputLocator).sendKeys("TestNG");
        driver.findElement(searchInputLocator).submit();
        String fourthResultText = "TestNG Tutorial";
        By fourthResultLocator = By.xpath("//*[@id=\"r1-3\"]/div[3]/h2/a");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String actualFourthResultText = driver.findElement(fourthResultLocator).getText();
        assertEquals(actualFourthResultText, fourthResultText, "Fourth search result is match");






        }








    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver = new FirefoxDriver();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();}



    }




