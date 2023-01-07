package ScreenShotTest;

import Utility.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class fullPageScreenShotTest {

    public static WebDriver driver;
    public static String sUrl="https://www.javatpoint.com/log4j-properties";

    @BeforeMethod
    public void SetUp() {
        System.setProperty("webdriver.edge.driver", "C:/Users/FATMA/Selenium/MsedgeDriver/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get(sUrl);
    }

    @Test
    public void TestCase_2() throws IOException {
        TakeScreenShot.fullScreenShot(driver,"FullEvidance_1");
    }

    @AfterMethod
    public void CloseApp(){
        driver.quit();
    }
}
