package ActionOnElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoverTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/marze/Documents/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://theinternet.przyklady.javastart.pl/hovers");
    }

    @Test
    public void hoverTest(){
        // grab users
        WebElement userOne = driver.findElement(By.xpath("//div[@class='example']/div[1]"));
        WebElement userTwo = driver.findElement(By.xpath("//div[@class='example']/div[2]"));
        WebElement userThree = driver.findElement(By.xpath("//div[@class='example']/div[3]"));
        // grab users info
        WebElement descriptionUserOne = driver.findElement(By.xpath("//div[@class='example']/div[1]/div"));
        WebElement descriptionUserTwo = driver.findElement(By.xpath("//div[@class='example']/div[2]/div"));
        WebElement descriptionUserThree = driver.findElement(By.xpath("//div[@class='example']/div[3]/div"));
        // create instance of Action class
        Actions action = new Actions(driver);
        // FIRST USER
        // move the mouse to the first user image
        action.moveToElement(userOne).perform();
        sleep();
        // test if after moving the mouse to the first user information about this user showed up under the image (user1)
        // and for user two and three information continues to be hidden
        assertTrue(descriptionUserOne.isDisplayed());
        assertEquals(driver.findElement(By.xpath("//div[@class='example']/div[1]/div/h5")).getText(), "name: user1");
        assertFalse(descriptionUserTwo.isDisplayed());
        assertFalse(descriptionUserThree.isDisplayed());
        sleep();
        // SECOND USER
        // move the mouse to the second user image
        action.moveToElement(userTwo).perform();
        sleep();
        // test if after moving the mouse to the second user information about this user showed up under the image (user2)
        // and for user one and three information continues to be hidden
        assertTrue(descriptionUserTwo.isDisplayed());
        assertEquals(driver.findElement(By.xpath("//div[@class='example']/div[2]/div/h5")).getText(), "name: user2");
        assertFalse(descriptionUserOne.isDisplayed());
        assertFalse(descriptionUserThree.isDisplayed());
        sleep();
        // USER THREE
        // move the mouse to the third user image
        action.moveToElement(userThree).perform();
        sleep();
        // test if after moving the mouse to the second user information about this user showed up under the image (user2)
        // and for user one and three information continues to be hidden
        assertTrue(descriptionUserThree.isDisplayed());
        assertEquals(driver.findElement(By.xpath("//div[@class='example']/div[3]/div/h5")).getText(), "name: user3");
        assertFalse(descriptionUserTwo.isDisplayed());
        assertFalse(descriptionUserOne.isDisplayed());
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
    public void afterMethod(){
        driver.close();
        driver.quit();
    }
}
