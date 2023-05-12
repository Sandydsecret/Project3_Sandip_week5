package com.lumaproject.testsuite;

import com.lumaproject.customslisteners.CustomListeners;
import com.lumaproject.pages.HomePage;
import com.lumaproject.pages.WomenPage;
import com.lumaproject.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Listeners(CustomListeners.class)
public class WomenTest extends BaseTest {


    HomePage homePage;
    WomenPage womenPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        womenPage = new WomenPage();
    }

    @Test(groups = {"sanity","regression"})
    public void sortByProductName() {
        homePage.mouseHoverWomenMenu();
        homePage.mouseHoverOnTop();
        womenPage.clickOnJacket();

        List<WebElement> jacketsElementsList = driver.findElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        List<String> jacketsNameListBefore = new ArrayList<>();
        for (WebElement value : jacketsElementsList) {
            jacketsNameListBefore.add(value.getText());
        }
        selectByVisibleTextFromDropDown(By.xpath("(//select[@id='sorter'])[1]"), "Product Name");

        // After Sorting value
        jacketsElementsList = driver.findElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        List<String> jacketsNameListAfter = new ArrayList<>();

        //waitUntilVisibilityOfElementLocated(By.xpath("//strong[@class='product name product-item-name']//a"),10);
        for (WebElement value : jacketsElementsList) {
            jacketsNameListAfter.add(value.getText());
        }
        // Sort the before name list into Ascending Order
        jacketsNameListBefore.sort(String.CASE_INSENSITIVE_ORDER);// Ascending order

        // Verify the products name display in alphabetical order

        Assert.assertEquals(jacketsNameListBefore, jacketsNameListAfter);

    }



    @Test(groups = {"sanity","smoke","regression"})
    public void sortByPriceFilter()
    {
        homePage.mouseHoverWomenMenu();
        homePage.mouseHoverOnTop();
        womenPage.clickOnJacket();

        // Storing jackets price in list
        List<WebElement> jacketsPriceElementList = driver.findElements(By.xpath("//span[@class='price-wrapper ']//span"));
        List<Double> jacketsPriceListBefore = new ArrayList<>();
        for (WebElement value : jacketsPriceElementList)
        {
            //Converting price in to Double and Removing $ from price
            jacketsPriceListBefore.add(Double.valueOf(value.getText().replace("$", "")));
        }

        // Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(By.xpath("(//select[@id='sorter'])[1]"), "Price");

        // waitUntilVisibilityOfElementLocated(By.xpath("//li[@class='item product product-item']"),10);

        // After Sorting Products by Price
        jacketsPriceElementList = driver.findElements(By.xpath("//span[@class='price-wrapper ']//span"));
        List<Double> jacketsPriceListAfter = new ArrayList<>();

        for (WebElement value : jacketsPriceElementList)
        {
            //Converting price in to Double and Removing $ from price
            jacketsPriceListAfter.add(Double.valueOf(value.getText().replace("$", "")));
        }
        // Sort the jacketPriceListBefore to Ascending Order
        Collections.sort(jacketsPriceListBefore);
        // Verify the products price display in Low to High
        Assert.assertEquals(jacketsPriceListBefore, jacketsPriceListAfter);

    }

}