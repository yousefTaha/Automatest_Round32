package testPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
    private WebDriver driver;

        @Test
                 public void firstTest() {
            driver.get("https://duckduckgo.com");
            String actualTitle = driver.getTitle();
            String expectedTitle = "Google";
            Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch");
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




