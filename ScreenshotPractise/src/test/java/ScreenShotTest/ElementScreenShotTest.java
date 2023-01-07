package ScreenShotTest;

import Utility.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ElementScreenShotTest {

    public static WebDriver driver;
    public static String sUrl = "https://www.google.com/";

    WebElement element;

    @BeforeMethod
    public void SetUp() {
        System.setProperty("webdriver.edge.driver", "C:/Users/FATMA/Selenium/MsedgeDriver/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get(sUrl);
    }

    @Test
    public void takeTheElementScreenShot() throws IOException {
        element=driver.findElement(By.cssSelector("html > body > div > div:nth-of-type(2) > div > img"));
        TakeScreenShot.elementScreenShot(driver,element,"elementfilename");
    }

    @AfterMethod
    public void CloseApp() {
        driver.quit();
    }

}
