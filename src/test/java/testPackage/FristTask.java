package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FristTask {


    @Test

    public void  test(){


        WebDriver driver = new ChromeDriver();
        try {

        driver.get("https://duckduckgo.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
        } finally {

            driver.quit();
        }




    }}

