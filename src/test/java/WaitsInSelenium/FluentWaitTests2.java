package WaitsInSelenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class FluentWaitTests2 {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/marze/Documents/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://theinternet.przyklady.javastart.pl/dynamic_loading/2");
    }

    @Test
    public void fluentWaitWithExceptionTest(){
        WebElement startBtn = driver.findElement(By.xpath("//div[@id ='start'] /button"));
        // click the start button
        startBtn.click();
        // check that after some time the text Hello World! is visible
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        WebElement foundWebElement = fluentWait
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(15))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish'] / h4")));

        assertTrue(foundWebElement.isDisplayed());
    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }



}
