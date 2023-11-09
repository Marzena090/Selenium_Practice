package WaitsInSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class FluentWaitTests {

    private WebDriver driver;
    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/marze/Documents/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://theinternet.przyklady.javastart.pl/dynamic_loading/1");
    }

    @Test
    public void fluentWaitTest(){
        WebElement text = driver.findElement(By.cssSelector("#finish h4"));
        // test if "Hello World!" is invisible
        assertFalse(text.isDisplayed());
        // click the Start button
        WebElement startBtn = driver.findElement(By.xpath("//div[@id='start'] / button"));
        startBtn.click();
        // check that after some time the text Hello World! is visible
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(text));
        assertTrue(text.isDisplayed());
    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();

    }
}
