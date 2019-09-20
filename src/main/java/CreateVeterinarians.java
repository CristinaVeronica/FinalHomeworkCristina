import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateVeterinarians {

    WebDriver driver;
    Faker faker = new Faker();

    By clickOnVeterinFirstName = By.id("firstName");
    By clickOnVeterinLastName = By.id("lastName");
    By clickOnSaveVeterin = By.cssSelector("#vet > div:nth-child(5) > div > button:nth-child(3)");

    public CreateVeterinarians(WebDriver driver) {
        this.driver = driver;
    }

    public String getVeterinFirstName() {
        String veterinFirstName = faker.name().firstName();
        return veterinFirstName;
    }

    String firstName = getVeterinFirstName();

    public String getVeterinLastName() {
        String veterinLastName = faker.name().lastName();
        return veterinLastName;
    }

    String lastName = getVeterinFirstName();

    public void chooseVeterinType() {
        Select veterinType = new Select(driver.findElement(By.id("specialties")));

        veterinType.selectByVisibleText("radiology");
    }

    public void identifyVeterinFirstName() {
        driver.findElement(clickOnVeterinFirstName).sendKeys(firstName);

    }

    public void identifyVeterinLastName() {
        driver.findElement(clickOnVeterinLastName).sendKeys(lastName);
    }

    public void clickOnSaveButton() {
        driver.findElement(clickOnSaveVeterin).click();
    }


    public boolean searchListVeterinRand() {
        List<WebElement> veterinarians = driver.findElements(By.cssSelector("#vets > tbody > tr"));
        boolean isPresent = false;
        System.out.println(firstName);
        System.out.println(lastName);
        for (int i = 0; i < veterinarians.size(); i++) {
            if (veterinarians.get(i).getText().contains(firstName + " " + lastName)) {
                isPresent = true;

            }
        }
        return isPresent;

    }

    public void deleteVeterin() {

        List<WebElement> veterinList = driver.findElements(By.cssSelector("#vets > tbody > tr"));
        for (int i = 0; i < veterinList.size(); i++) {
            if (veterinList.get(i).getText().contains(firstName + " " + lastName)) {
                driver.findElement(By.cssSelector("tbody tr:nth-child(" + (i + 1) + ") td:nth-child(3) button:nth-child(2)")).click();
                driver.findElement(By.cssSelector("tbody tr:nth-child(" + (i + 1) + ") td:nth-child(3) button:nth-child(2)")).click();
            }
        }

    }

    public boolean checkVeterinarianIsDeleted() {
        List<WebElement> veterinariansAfterDelete = driver.findElements(By.cssSelector("#vets > tbody > tr"));
        boolean isDeleted = false;
        for (int i = 0; i < veterinariansAfterDelete.size(); i++) {
            if (!veterinariansAfterDelete.get(i).getText().contains(firstName + " " + lastName)) {
                isDeleted = true;
            }else{
                isDeleted = false;
            }
        }
        return isDeleted;
    }

}

