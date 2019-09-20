import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class CreateOwners {

    WebDriver driver;
    Faker faker = new Faker();

    By clickOnOwnerFirstName = By.id("firstName");
    By clickOnOwnerLastName = By.id("lastName");
    By clickOnAddress = By.id("address");
    By clickOnCity = By.id("city");
    By clickOnTelephone = By.id("telephone");


    public CreateOwners(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstName() {
    String firstName = faker.name().firstName();
    return firstName;
    }
    String firstName = getFirstName();

    public String getLastName(){
        String lastName = faker.name().lastName();
        return lastName;
    }
    String lastName = getLastName();

    public String getAddress(){
        String streetAddress = faker.address().streetAddress();
        return streetAddress;

    }

    public String getCiy(){
        String city = faker.address().city();
        return city;
    }

    public String getPhoneNumber(){

        String prefix = "07";
        Random rnd = new Random();
        int number = rnd.nextInt(99999999);
        return prefix + String.format("%08d",number);
    }


    public boolean addOwner(){
        WebElement checkAddOwner = driver.findElement(By.cssSelector("div > button:nth-child(2)"));
        return checkAddOwner.isDisplayed();
    }

    public void clickAddOwner(){
        WebElement clickAdd = driver.findElement(By.cssSelector("div > button:nth-child(2)"));
        clickAdd.click();
    }

    public void identifyFirstName(){
        driver.findElement(clickOnOwnerFirstName).sendKeys(firstName);
    }

    public void identifyLastName(){
        driver.findElement(clickOnOwnerLastName).sendKeys(lastName);
    }

    public void identifyAddress(){
        driver.findElement(clickOnAddress).sendKeys(getAddress());
    }

    public void identifyCity(){
        driver.findElement(clickOnCity).sendKeys(getCiy());
    }

    public void identifyPhone(){
        driver.findElement(clickOnTelephone).sendKeys(getPhoneNumber());
    }

    public boolean checkOwnerIsCreated(){
        List<WebElement> owners = driver.findElements(By.cssSelector("div > table > tbody >tr"));
        boolean isPresent = false;
        for(int i=0;i<owners.size();i++){
//            System.out.println(owners.get(i).getText());
            if(owners.get(i).getText().contains(firstName +" "+ lastName)){
                isPresent = true;
            }
        }
        return isPresent;
    }


}
