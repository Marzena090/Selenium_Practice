import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class WebElementsTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/marze/Documents/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://przyklady.javastart.pl/test/full_form.html");
    }

    @Test
    public void typingIntoWebElementTest(){
        WebElement userNameField = driver.findElement(By.id("username"));
        // pause
        sleep();
        userNameField.sendKeys("Selenium Start");
        // ! value stores what's inside the field
        String userNameValue = userNameField.getAttribute("value");
        System.out.println(userNameValue);
        // pause
        sleep();
        // check if this what has been typed inside the field equals Selenium Start
        assertEquals(userNameValue, "Selenium Start");
    }

    @Test
    public void filePickingTest(){
        sleep();
        WebElement uploadFilePicker = driver.findElement(By.id("upload_file"));
        uploadFilePicker.sendKeys("C:\\Users\\marze\\Desktop\\test.txt");
        sleep();
    }

    @Test
    public void typingAndClearingValueInsideWebElementTest(){
        WebElement userNameField = driver.findElement(By.id("username"));
        sleep();
        userNameField.sendKeys("Selenium Start");
        String userNameValue = userNameField.getAttribute("value");
        sleep();
        assertEquals(userNameValue, "Selenium Start");
        // clear text inside the username field
        userNameField.clear();
        sleep();
        // check if the field was succesfully cleared
        String emptyUserNameField = userNameField.getAttribute("value");
        assertEquals(emptyUserNameField, "");
    }

    @Test
    public void checkRadioButtonTest(){
        WebElement radioButtonFemale = driver.findElement(By.cssSelector("input[value='female']"));
        WebElement radioButtonMale = driver.findElement(By.cssSelector("input[value='male']"));
        sleep();
        // choose the male radio button
        radioButtonMale.click();
        sleep();
        // check if the male button has been clicked
        assertTrue(radioButtonMale.isSelected());
        // click female button now
        radioButtonFemale.click();
        sleep();
        // check if male has been deselected and female has been selected
        assertTrue(radioButtonFemale.isSelected());
        assertFalse(radioButtonMale.isSelected());
    }

    @Test
    public void checkboxButtonTest(){
        WebElement checkboxPizza = driver.findElement(By.cssSelector("input[value='pizza']"));
        WebElement checkboxSpaghetti = driver.findElement(By.cssSelector("input[value='spaghetti']"));
        WebElement checkboxHamburger = driver.findElement(By.cssSelector("input[value='hamburger']"));
        // test if all checkboxes are deselected
        assertFalse(checkboxPizza.isSelected());
        assertFalse(checkboxSpaghetti.isSelected());
        assertFalse(checkboxHamburger.isSelected());
        // pause
        sleep();
        // select all the checkboxes
        checkboxPizza.click();
        checkboxSpaghetti.click();
        checkboxHamburger.click();
        // test if all checkboxes have been selected
        assertTrue(checkboxPizza.isSelected());
        assertTrue(checkboxSpaghetti.isSelected());
        assertTrue(checkboxHamburger.isSelected());
        // pause
        sleep();
        // deselect all the checkboxes
        checkboxPizza.click();
        checkboxSpaghetti.click();
        checkboxHamburger.click();
        // test if all checkboxes have been deselected
        assertFalse(checkboxPizza.isSelected());
        assertFalse(checkboxSpaghetti.isSelected());
        assertFalse(checkboxHamburger.isSelected());

    }

    @Test
    public void dropDownListTest(){
        sleep();
        WebElement countryDropDown = driver.findElement(By.id("country"));
        // creating instance of Select class
        Select countryDropDownList = new Select(countryDropDown);
        // creating list of webelements and storing all the options of country drop down element.
        List<WebElement> options = countryDropDownList.getOptions();
        // creating a list of strings
        List<String> namesOfOptions = new ArrayList<>();
        // iterating through the elements and getting their text pushed into namesOfOptions array
        for (WebElement option : options) {
            namesOfOptions.add(option.getText());
            //printing names for each option
            System.out.println(option.getText());
        }
        // test if the list contains the correct data
        List<String> expectedNamesOfOptions = new ArrayList<>();
        expectedNamesOfOptions.add("Germany");
        expectedNamesOfOptions.add("Poland");
        expectedNamesOfOptions.add("UK");
        sleep();
        assertEquals(namesOfOptions, expectedNamesOfOptions);
    }

    @Test
    public void selectingOptionsFromDropDownTest(){
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);
        sleep();
        // select option: Poland by its index
        countryDropDown.selectByIndex(1);
        sleep();
        // testing if option Poland has been chosen
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Poland");
        // select option: Germany by its value
        countryDropDown.selectByValue("de_DE");
        sleep();
        // testing if option Germany has been chosen
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Germany");
        // select option: UK by its visible text
        countryDropDown.selectByVisibleText("UK");
        sleep();
        // testing if option UK has been chosen
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "UK");
    }

    @Test
    public void checkElementsOnPageTest(){
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement emailLabel = driver.findElement(By.cssSelector("span[class='help-block']"));
        // checking the state for each element
        System.out.println("Is usernameField displayed: " + usernameField.isDisplayed());
        System.out.println("Is usernameField enabled: " + usernameField.isEnabled());

        System.out.println("Is passwordField displayed: " + passwordField.isDisplayed());
        System.out.println("Is passwordField enabled: " + passwordField.isEnabled());

        System.out.println("Is emailLabel displayed: " + emailLabel.isDisplayed());
        System.out.println("Is emailLabel enabled: " + emailLabel.isEnabled());
        // testing if elements are visible on the page
        assertTrue(usernameField.isDisplayed());
        assertTrue(passwordField.isDisplayed());
        assertTrue(emailLabel.isDisplayed());
        // testing if username and password fields are enabled
        assertTrue(usernameField.isEnabled());
        assertFalse(passwordField.isEnabled());
    }



    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterMethod
    public void afterMethod() {
        driver.close();
        driver.quit();
    }
}
