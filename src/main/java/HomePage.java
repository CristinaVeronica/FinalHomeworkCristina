import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Arrays;
import java.util.List;

public class HomePage {
    WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean logo() {
        return driver.findElement(By.cssSelector("body > app-root > div.container-fluid > nav > div > div > a")).isDisplayed();
    }

    public String textDisplayed() {
        return driver.findElement(By.cssSelector("app-root > app-welcome > h1")).getText();
    }

    public boolean welcomeImageIsPresent() {
        return driver.findElement(By.cssSelector("app-welcome > div > div > div > div > img")).isDisplayed();
    }

    public boolean menuBar() {
        boolean x = false;
        List<String> menuList = Arrays.asList("HOME", "OWNERS", "VETERINARIANS", "PET TYPES", "SPECIALTIES");
        String s = driver.findElement(By.cssSelector("div.container-fluid > nav > div > ul")).getText();
        for (int i = 0; i < menuList.size(); i++) {
            if(s.contains(menuList.get(i))) {
                x = true;
                continue;
            }else{
                x = false;
            }
        }
        return x;
    }
}


