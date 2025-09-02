package testPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

        @Test
                public void thirdTest() {
            driver.get("https://duckduckgo.com");
            By searchInputLocator = By.xpath("//input [@class='searchbox_input__rnFzM']");
            driver.findElement(searchInputLocator).sendKeys("Selenium WebDriver");
            driver.findElement(searchInputLocator).submit();

            By firstResultLocator = By.xpath("//*[@id=\"r1-0\"]/div[2]/div/div/a");
            String firstResultText = driver.findElement(firstResultLocator).getText();
            assertEquals(firstResultText, "https://www.selenium.dev/documentation/webdriver/", "First search result does");
            //Assert.assertTrue (firstResultLocator = By.xpath("//*[@id=\"r1-0\"]/div[2]/div/div/a/div/p/span[1]");
          //  (firstResultLocator=("https://www.selenium.dev/documentation/webdriver/"), "", "Search results page title is match");

            //to see this code later
            /*
               @Test
    public void taskProblemThree(){
        SoftAssert softAssert = new SoftAssert();
        By searchBar = By.id("searchbox_input");
        By searchBtn = By.xpath("//button[@aria-label='Search']");
        By firstResult = By.xpath("//span[text()='WebDriver - Selenium']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       WebElement waitedBar = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
       // a jump over to the assertion then to the quit. (solved when each waitedElement is before it's interaction

       waitedBar.sendKeys("Selenium WebDriver");
        WebElement waitedSearchBtn =  wait.until(ExpectedConditions.presenceOfElementLocated(searchBtn));
       waitedSearchBtn.click();
        WebElement waitedResult = wait.until(ExpectedConditions.presenceOfElementLocated(firstResult));
       waitedResult.click();

        String URL = driver.getCurrentUrl();
        softAssert.assertEquals(URL, "https://www.selenium.dev/documentation/webdriver/");
        softAssert.assertAll();
             */


        }


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();}



    }




