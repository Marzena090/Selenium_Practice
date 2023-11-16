package AdditionalExercise.tests;

import AdditionalExercise.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.jar.Manifest;

import static org.testng.Assert.assertEquals;

public class ShoppingCartTests extends TestBase {

    @Test
    public void userCantCheckoutWithoutLogin(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnFishImgBtn();

        FishListPage fishListPage = new FishListPage(driver);
        fishListPage.clickOnAnglefishId();

        AngelfishListPage angelfishListPage = new AngelfishListPage(driver);
        angelfishListPage.addSmallAngelfishToCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickOnProceedToCheckOutBtn();

        LoginPage loginPage = new LoginPage(driver);
        assertEquals(loginPage.getWarningMessage(), "You must sign on before attempting to check out. Please sign on and try checking out again.");
    }

}
