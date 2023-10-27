import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class CheckboxesTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/marze/Documents/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void checkboxesTest(){
        // open this page
        driver.get("https://theinternet.przyklady.javastart.pl/checkboxes");
        // grab checkbox 1 and checkbox 2 elements
        WebElement checkBox1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
        // check that after opening the website checkbox number one is unchecked and checbox number two is checked
        System.out.println("checkbox number one is selected = " + checkBox1.isSelected());
        System.out.println("checkbox number two is selected = " + checkBox2.isSelected());
        assertFalse(checkBox1.isSelected());
        assertTrue(checkBox2.isSelected());
        sleep();
        // select checkbox number one and deselect checkbox number two
        checkBox1.click();
        checkBox2.click();
        sleep();
        // check that checkbox number one is selected and checkbox number two deselected
        assertTrue(checkBox1.isSelected());
        assertFalse(checkBox2.isSelected());
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
