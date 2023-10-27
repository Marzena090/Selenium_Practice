import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropDownTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/marze/Documents/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://theinternet.przyklady.javastart.pl/dropdown");
    }

    @Test
    public void dropDownTest(){
        // grab the dropdown menu
        WebElement optionsWebelement = driver.findElement(By.id("dropdown"));
        // using Select class to work with dropdown menu
        Select select = new Select(optionsWebelement);
        // printing to the console the first selected option
        System.out.println("First selected option: " + select.getFirstSelectedOption().getText());
        // test that after opening the website the option "Please select an option" is selected
        assertEquals(select.getFirstSelectedOption().getText(), "Please select an option");
        // pause the code for 3 sec
        sleep();
        // select Option 1
        select.selectByValue("1");
        // test the option "Option 1" is now selected
        assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
        // pause the code for 3 sec
        sleep();
        // select Option 2
        select.selectByValue("2");
        // test the option "Option 2" is now selected
        assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
        // pause the code for 3 sec
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
