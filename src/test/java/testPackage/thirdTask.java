package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class thirdTask {

    @Test

    public void thirdTest(){
        WebDriver driver = new ChromeDriver();
        try {
        driver.get("https://duckduckgo.com");
        WebElement searchInput = driver.findElement(new By.ByClassName("searchbox_input__rnFzM"));
        searchInput.sendKeys("Selenium WebDriver");
        searchInput.submit();
        WebElement resultStats = driver.findElement(By.cssSelector("a[data-testid=\"result-extras-url-link\"]"));
        String expectedResult = resultStats.getText();
        String actualResult = "https://www.selenium.dev/documentation/webdriver/";
        Assert.assertEquals(expectedResult, actualResult, "Results is match");
        }finally {
            driver.quit();
        }
    }
}
