package com.lumaproject.testsuite;

import com.lumaproject.customslisteners.CustomListeners;
import com.lumaproject.pages.HomePage;
import com.lumaproject.pages.MenPage;
import com.lumaproject.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class MenTest extends BaseTest {
    HomePage homePage;
    MenPage menPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt()
    {
        homePage = new HomePage();
        menPage = new MenPage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldAddProductSuccessFullyToShoppingCart()
    {
        homePage.mouseHoverOnMenMenu();
        homePage.mouseHoverOnBottom();
        menPage.clickPants();
        menPage.productNameCronusYogaPantCLickOnSize32();
        menPage.productNameCronusYogaPantClickOnColourBlack();
        menPage.CronusYogaPantClickAddToCartButton();
        menPage.verifyTextMessage();
        menPage.shoppingCartLink();
        menPage.verifyShoppingCart();
        menPage.verifyProductNameCronusYogaPant();
        menPage.verifyProductSize32();
        menPage.verifyProductColourBlack();
    }


}