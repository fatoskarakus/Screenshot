package ScreenShotTest;

import Utility.TakeScreenShot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class screenShotTest {

    public static WebDriver driver;
    public static String sUrl = "https://www.google.com/";

    @BeforeMethod
    public void SetUp() {
        System.setProperty("webdriver.edge.driver", "C:/Users/FATMA/Selenium/MsedgeDriver/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get(sUrl);
    }
    @Test
    public void TestCase_1() throws IOException {
        driver.findElement(By.name("q")).sendKeys("Take the ScreenShot!");
        TakeScreenShot.screenShot(driver,"Evidance_1");
    }
    @Test
    public void TestCase_2() throws IOException {
        TakeScreenShot.screenShot(driver,"Evidance_2");
    }
    @AfterMethod
    public void CloseApp(){
        driver.quit();
    }
}
