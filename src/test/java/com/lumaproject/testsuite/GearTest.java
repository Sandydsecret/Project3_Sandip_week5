package com.lumaproject.testsuite;

import com.lumaproject.customslisteners.CustomListeners;
import com.lumaproject.pages.GearPage;
import com.lumaproject.pages.HomePage;
import com.lumaproject.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class GearTest extends BaseTest {

    HomePage homePage;
    GearPage gearPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt()
    {
        homePage = new HomePage();
        gearPage = new GearPage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldAddProductSuccessFullyToShoppingCart()
    {
        homePage.mouseHoveOnGearMenu();
        gearPage.clickOnBags();
        gearPage.productNameOvernightDuffle();
        gearPage.verifyTextOvernightDuffle();
        gearPage.changeQty3();
        gearPage.addToCart();
        gearPage.verifyTextShoppingCart();
        gearPage.shoppingCartLinkMessage();
        // gearPage.verifyQty3();
        gearPage.productPrice$135();
        gearPage.changeQty5();
        gearPage.updateShoppingCartButton();
        gearPage.productPrice$225();
    }
}