import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateManualVeterins {

    WebDriver driver;

    By clickOnVeterinFirstName = By.id("firstName");
    By clickOnVeterinLastName = By.id("lastName");
    By clickOnType = By.id("specialties");
    By clickOnSaveVeterin = By.cssSelector("#vet > div:nth-child(5) > div > button:nth-child(3)");

    public CreateManualVeterins(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInFirstName(String firstName) {
        driver.findElement(clickOnVeterinFirstName).sendKeys(firstName);
    }

    public void fillInLastName(String lastName) {
        driver.findElement(clickOnVeterinLastName).sendKeys(lastName);
    }

    public void fillInType(String type) {
        Select veterinType = new Select(driver.findElement(clickOnType));
        veterinType.selectByVisibleText(type);

    }

    public void clickOnSaveButton() {
        driver.findElement(clickOnSaveVeterin).click();
    }

    public boolean searchVeterin(){
        List<WebElement> veterins = driver.findElements(By.cssSelector("#vets > tbody > tr"));
        boolean a = false;
        for(int i =0; i<veterins.size();i++){
            if(veterins.get(i).getText().contains("Pavelescu Cristina")){
                a = true;
            }else{
                a= false;
            }
        }
        return a;
    }

}
