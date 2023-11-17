package AdditionalExercise.pages;

import AdditionalExercise.tests.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    @FindBy(css = "a[href$='newOrderForm=']")
    private WebElement proceedToCheckoutBtn;

    public ShoppingCartPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnProceedToCheckOutBtn(){
        proceedToCheckoutBtn.click();
    }
}
