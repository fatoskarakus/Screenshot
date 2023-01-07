package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TakeScreenShot {
    public static void screenShot(WebDriver driver,String filename) throws IOException {
        TakesScreenshot screenShot= (TakesScreenshot) driver; //TakesScreenshot interface dir.
        File sourceFile=screenShot.getScreenshotAs(OutputType.FILE);
        //C:/Users/FATMA/IdeaProjects/ScreenshotPractise/=System.getProperty("user.dir")
        FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir")+"/ScreenShots/"+filename+".png"));
    }

    public static void fullScreenShot(WebDriver driver,String filename) throws IOException {
        Screenshot screenshot=new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(500))
                .takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(),"png",new File(System.getProperty("user.dir")+"/ScreenShots/"+filename+".png"));

    }

    public static void elementScreenShot(WebDriver driver, WebElement element,String filename) throws IOException {
        Screenshot screenshot=new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver,element);
        ImageIO.write(screenshot.getImage(),"png",new File(System.getProperty("user.dir")+"/ScreenShots/"+filename+".png"));
    }

    public static void takeBufferImage(WebDriver driver,WebElement element,String filename) throws IOException {

        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullbuffredimage=ImageIO.read(screenshot);

        Point point=element.getLocation();
        int eleWidth=element.getSize().getWidth();
        int eleHeight=element.getSize().getHeight();


        BufferedImage eleScreenshot=fullbuffredimage.getSubimage(point.getX(),point.getY(),eleWidth,eleHeight);
        ImageIO.write(eleScreenshot,"png",screenshot);

        File screenShotLocation =new File(System.getProperty("user.dir")+"/ScreenShots/"+filename+".png");
        FileUtils.copyFile(screenshot,screenShotLocation);

    }
}
