import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class VeterinariansTests extends BaseClass{

    String pathHomePageLogFile = System.getProperty("user.dir") + "/logs/VeterinariansPage_LogFile.log";
    Logger homePageLogger = LogsClass.createLogger(pathHomePageLogFile);

    CreateVeterinarians newVeterinarian;
    CreateManualVeterins newManualVeterin;


    @Test
    public void createRandomVeterinarians() throws InterruptedException {
        headers = new Headers(driver);
        newVeterinarian = new CreateVeterinarians(driver);
        homePageLogger.info("Click on veterinarians ");
        headers.clickVeterin();
        homePageLogger.info("Click on add veterinarians");
        headers.clickAddVeter();
        homePageLogger.info("Fill in veterinarian's first name");
        newVeterinarian.identifyVeterinFirstName();
        homePageLogger.info("Fill in veterinarian's last name");
        newVeterinarian.identifyVeterinLastName();
        homePageLogger.info("Choose veterinarian type");
        newVeterinarian.chooseVeterinType();
        homePageLogger.info("Click on save button");
        newVeterinarian.clickOnSaveButton();
        Thread.sleep(3000);
        homePageLogger.info("Check if veterinarian has been added to list");
        Assert.assertTrue(newVeterinarian.searchListVeterinRand());
    }

    @Test
    public void createManualVeterins(){
        headers = new Headers(driver);
        newManualVeterin = new CreateManualVeterins(driver);
        headers.clickVeterin();
        headers.clickAddVeter();
        newManualVeterin.fillInFirstName("Pavelescu");
        newManualVeterin.fillInLastName("Cristina");
        newManualVeterin.fillInType("dentistry");
        newManualVeterin.clickOnSaveButton();

        Assert.assertTrue(newManualVeterin.searchVeterin());
    }

    @Test
    public void deleteVeterin() throws InterruptedException {
        headers = new Headers(driver);
        newVeterinarian = new CreateVeterinarians(driver);
        homePageLogger.info("Click on veterinarians ");
        headers.clickVeterin();
        homePageLogger.info("Click on add veterinarians");
        headers.clickAddVeter();
        homePageLogger.info("Fill in veterinarian's first name");
        newVeterinarian.identifyVeterinFirstName();
        Thread.sleep(2000);
        homePageLogger.info("Fill in veterinarian's last name");
        newVeterinarian.identifyVeterinLastName();
        Thread.sleep(2000);
        homePageLogger.info("Choose veterinarian type");
        newVeterinarian.chooseVeterinType();
        Thread.sleep(2000);
        homePageLogger.info("Click on save button");
        newVeterinarian.clickOnSaveButton();
        Thread.sleep(3000);
        homePageLogger.info("Delete the veterinarian previously added");
        newVeterinarian.deleteVeterin();
        Thread.sleep(2000);
        homePageLogger.info("Check if veterinarian has been deleted from list");
        Assert.assertTrue(newVeterinarian.checkVeterinarianIsDeleted());

    }



}