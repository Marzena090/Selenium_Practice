import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class ExplicitWaitTests2 {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/marze/Documents/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://theinternet.przyklady.javastart.pl/dynamic_controls");
    }

    @Test
    public void waitForPresenceOfTheElement(){
        // find the checkbox
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        // test if the checkbox is unchecked
        assertFalse(checkbox.isSelected());
        // test if the checkbox is visible
        assertTrue(checkbox.isDisplayed());
        // find the Remove button
        WebElement removeBtn = driver.findElement(By.cssSelector("[onclick='swapCheckbox()']"));
        // test if the button is swapped correctly to Remove
        assertEquals(removeBtn.getText(), "Remove");
        // click the remove button
        removeBtn.click();
        // wait until checkbox disappears
        WaitUntil waitUntil = new WaitUntil(driver);
        waitUntil.waitUntilElementIsInvisible(checkbox);

        // test if button swapped to Add
        assertEquals(removeBtn.getText(), "Add");
        // test if text "It's gone!" shows up
        assertEquals(driver.findElement(By.id("message")).getText(), "It's gone!");

        // click the Add button
        removeBtn.click();
        // wait until checkbox shows up again
        checkbox = waitUntil.waitUntilPresenceOfElementLocated(By.id("checkbox"));

        // test if the checkbox is visible and unchecked
        assertFalse(checkbox.isSelected());
        assertTrue(checkbox.isDisplayed());
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
        driver.quit();
    }
}
