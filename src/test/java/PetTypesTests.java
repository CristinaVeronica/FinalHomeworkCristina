import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class PetTypesTests extends BaseClass {

    String pathHomePageLogFile = System.getProperty("user.dir") + "/logs/PetTypesPage_LogFile.log";
    Logger homePageLogger = LogsClass.createLogger(pathHomePageLogFile);

    PetTypes newPetType;

    @Test
    public void addPetType() throws InterruptedException {
        headers = new Headers(driver);
        newPetType = new PetTypes(driver);
        homePageLogger.info("Click on Pet Types");
        headers.clickPetTypes();
        homePageLogger.info("Insert pet name");
        newPetType.insertPetName();
        Thread.sleep(2000);
        homePageLogger.info("Check if animal type has been added to list");
        Assert.assertTrue(newPetType.searchAnimal());
    }

     @Test
    public void deletePets() throws InterruptedException {
         headers = new Headers(driver);
         newPetType = new PetTypes(driver);
         homePageLogger.info("Click on Pet Types");
         headers.clickPetTypes();
         homePageLogger.info("Insert pet name");
         newPetType.insertPetName();
         Thread.sleep(3000);
         homePageLogger.info("Delete pet type");
         newPetType.deletePetType();
        Thread.sleep(2000);
         homePageLogger.info("Check if pet type has been deleted");
         Assert.assertTrue(newPetType.checkPetTypeIsDeleted());
     }


}


