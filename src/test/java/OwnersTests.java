import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class OwnersTests extends BaseClass{

    String pathHomePageLogFile = System.getProperty("user.dir") + "/logs/OwnersPage_LogFile.log";
    Logger homePageLogger = LogsClass.createLogger(pathHomePageLogFile);
    CreateOwners newOwner;

    @Test
    public void createAnOwner() throws InterruptedException {
        headers = new Headers(driver);
        newOwner = new CreateOwners(driver);
        homePageLogger.info("Click on owners");
        headers.clickOnOwners();
        homePageLogger.info("Click on add new owner");
        headers.clickAddNewOwner();
        homePageLogger.info("Fill in first name");
        newOwner.identifyFirstName();
        homePageLogger.info("Fill in last name");
        newOwner.identifyLastName();
        homePageLogger.info("Fill in address");
        newOwner.identifyAddress();
        homePageLogger.info("Fill in city");
        newOwner.identifyCity();
        homePageLogger.info("Fill in phone number");
        newOwner.identifyPhone();
        homePageLogger.info("Check if add owned button apears");
        Assert.assertTrue(newOwner.addOwner());
        newOwner.clickAddOwner();
        Thread.sleep(3000);
        homePageLogger.info("Check if owner has been added to list");
        Assert.assertTrue(newOwner.checkOwnerIsCreated());
    }


}
