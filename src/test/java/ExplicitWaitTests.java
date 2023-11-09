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

public class ExplicitWaitTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/marze/Documents/chromedriver.exe");
        driver = new ChromeDriver();
        // go to this website
        driver.get("https://theinternet.przyklady.javastart.pl/dynamic_controls");
    }

    @Test
    public void waitForDisappearingElement(){
        // find the checkbox
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        // test if the checkbox is unchecked
        assertFalse(checkbox.isSelected());
        // test if the checkbox is visible
        assertTrue(checkbox.isDisplayed());

        // find the Remove button
        WebElement removeBtn = driver.findElement(By.xpath("//form[@id='checkbox-example'] /button"));
        // test if the button is swapped correctly to Remove
        assertEquals(removeBtn.getText(), "Remove");
        // click the remove button
        removeBtn.click();

        // wait until checkbox disappears
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkbox));

        // test if button swapped to Add
        assertEquals(removeBtn.getText(), "Add");
        // test if text "It's gone!" shows up
        assertEquals(driver.findElement(By.id("message")).getText(), "It's gone!");
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
        driver.quit();
    }
}
