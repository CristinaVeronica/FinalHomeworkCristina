import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.logging.Logger;

public class HomePageTests extends BaseClass{

String pathHomePageLogFile = System.getProperty("user.dir") + "/logs/HomePage_LogFile.log";
Logger homePageLogger = LogsClass.createLogger(pathHomePageLogFile);
    HomePage homePage;


    @Test
    public void checkLogo(){
        headers= new Headers(driver);
        homePage = new HomePage(driver);
        homePageLogger.info("Check if logo appears on the home page");
        Assert.assertTrue(homePage.logo());
    }

    @Test
    public void checkTextIsDisplayed(){
        homePage = new HomePage(driver);
        homePageLogger.info("Check if welcome message appears on the home page");
        Assert.assertEquals("Welcome to Petclinic",homePage.textDisplayed());
    }

    @Test
    public void checkWelcomePicture(){
        homePage = new HomePage(driver);
        homePageLogger.info("Check if welcome picture is present on the home page");
        Assert.assertTrue(homePage.welcomeImageIsPresent());
    }

    @Test
    public void checkMenuBar(){
        homePage = new HomePage(driver);
        homePageLogger.info("Check if menu bar is on the home page");
        Assert.assertTrue(homePage.menuBar());
    }

}
