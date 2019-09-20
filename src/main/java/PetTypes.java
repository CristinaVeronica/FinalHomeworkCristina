import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PetTypes {
    WebDriver driver;

    By clickOnAddPet = By.cssSelector("div > button:nth-child(2)");
    By clickOnNameField = By.cssSelector("#name");
    By clickOnSaveButton = By.cssSelector("#pettype > div.form-group.has-feedback > div > button");

    public PetTypes(WebDriver driver) {
        this.driver = driver;
    }


    public String getRandomAnimal(){
        List<String> animals = Arrays.asList("Tigru","Leo","Babuin","Veverita","Iepure","Pisica","Soarece");
        Random rand = new Random();
        return animals.get(rand.nextInt(animals.size()));
        }
    String animal = getRandomAnimal();

    public void insertPetName(){
        driver.findElement(clickOnAddPet).click();
        driver.findElement(clickOnNameField).sendKeys(animal);
        driver.findElement(clickOnSaveButton).click();
    }

    public boolean searchAnimal() {
        driver.navigate().refresh();
        boolean isPresent = false;
        List<WebElement> animalList = driver.findElements(By.cssSelector("#pettypes tbody td:first-child input"));
        for(int i=0;i<animalList.size();i++){
            System.out.println(animalList.get(i).getAttribute("value"));
            if(animalList.get(i).getAttribute("value").contains(animal)){
                isPresent = true;
            }
        }
        return isPresent;
    }

    public void deletePetType() {
        List<WebElement> petsList = driver.findElements(By.cssSelector("#pettypes tbody td:first-child input"));
        for(int i=0;i<petsList.size();i++){
            if (petsList.get(i).getAttribute("value").contains(animal)){
                driver.findElement(By.cssSelector("tbody tr:nth-child(" + (i+1) + ") td:nth-child(2) button:nth-child(2)")).click();

            }
        }

    }

    public boolean checkPetTypeIsDeleted(){
        List<WebElement> pets = driver.findElements(By.cssSelector("#pettypes tbody td:first-child input"));
        boolean isDeleted = false;
        for(int i=0;i<pets.size();i++){
            if (!pets.get(i).getAttribute("value").contains(animal)){
                isDeleted = true;
            }
        }
        return isDeleted;
    }
}
