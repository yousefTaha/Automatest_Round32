package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTask {
    @Test
    public void Test(){
        WebDriver driver = new ChromeDriver();
        try{
        driver.get("https://duckduckgo.com");
       WebElement logo = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/article/div[1]/div[1]/div[1]/header/div[1]/section[1]/a/img"));
       // Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed!");
        Assert.assertTrue(logo.isDisplayed(), "Logo is displayed");
        } finally {
            driver.quit();
        }

    }
}
