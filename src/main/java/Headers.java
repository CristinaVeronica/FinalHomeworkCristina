import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Headers {
    WebDriver driver;


    public Headers(WebDriver driver) {
        this.driver = driver;
    }

    By clickOnHomePage = By.cssSelector("div.container-fluid > nav > div > ul > li:first-child");
    By clickOnOwnersButton = By.cssSelector("div.container-fluid > nav > div > ul > li:nth-child(2)");
    By clickOnSearchOwner = By.cssSelector("div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(1)");
    By clickOnAddNewOwner = By.cssSelector("div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(2)");
    By clickOnVeterinarians = By.cssSelector("div.container-fluid > nav > div > ul > li:nth-child(3)");
    By clickOnSearchVeterinarians = By.cssSelector(" div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(1) > a");
    By clickOnAddVeterinarians = By.cssSelector("div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(2) > a");
    By clickOnPetTypes = By.cssSelector("div.container-fluid > nav > div > ul > li:nth-child(4)");
    By clickOnSpecialties = By.cssSelector("div.container-fluid > nav > div > ul > li:nth-child(5)");


public void HomePage(){
        driver.findElement(clickOnHomePage).click();
}

public void clickOnOwners(){
        driver.findElement(clickOnOwnersButton).click();
}

public void SearchOwner(){
    driver.findElement(clickOnSearchOwner).click();
}

public void clickAddNewOwner(){
    driver.findElement(clickOnAddNewOwner).click();
}

public void clickVeterin(){
    driver.findElement(clickOnVeterinarians).click();
}

public void SearchVeterin(){
    driver.findElement(clickOnSearchVeterinarians).click();
}

public void clickAddVeter(){
    driver.findElement(clickOnAddVeterinarians).click();
}

public void clickPetTypes(){
    driver.findElement(clickOnPetTypes).click();

}

public void clickSpecialties(){
    driver.findElement(clickOnSpecialties).click();
}

}
