package FormTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/marze/Documents/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://theinternet.przyklady.javastart.pl/upload");
    }

    @Test
    public void fileUploadTest(){
        WebElement chooseFileBtn = driver.findElement(By.id("file-upload"));
        WebElement uploadBtn = driver.findElement(By.id("file-submit"));
        // choose the file named: test.txt*
        chooseFileBtn.sendKeys("C:\\Users\\marze\\Desktop\\test.txt");
        sleep();
        // load the file by clicking Upload button
        uploadBtn.click();
        sleep();
        // test if name of loaded file is available on the website
        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        assertEquals(uploadedFile.getText(), "test.txt");
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
