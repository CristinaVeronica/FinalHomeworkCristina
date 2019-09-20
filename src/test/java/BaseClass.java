import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    WebDriver driver;
    private String baseUrl = "http://bhdtest.endava.com/petclinic/";
    Headers headers;


    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/config/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

        @AfterMethod
    public void afterMethod(){
        driver.close();
        driver.quit();
    }
}
