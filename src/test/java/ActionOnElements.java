import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertTrue;

public class ActionOnElements {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/marze/Documents/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://przyklady.javastart.pl/test/hover_mouse.html");
    }

    @Test
    public void clickSmileySimulation(){
        // grab smiley element
        WebElement smiley = driver.findElement(By.id("smiley"));
        // creating instance of Actions class
        Actions action = new Actions(driver);
        // move the mouse and click the smiley number one
        action.moveToElement(smiley).click().build().perform();
        sleep();
        // gram smiley two
        WebElement smiley2 = driver.findElement(By.id("smiley2"));
        // move the mouse to the smiley number two
        Actions secondAction = new Actions(driver);
        secondAction.clickAndHold(smiley2).build().perform();
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
