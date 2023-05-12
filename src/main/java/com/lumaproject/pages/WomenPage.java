package com.lumaproject.pages;

import com.aventstack.extentreports.Status;
import com.lumaproject.customslisteners.CustomListeners;
import com.lumaproject.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class WomenPage extends Utility {
    public WomenPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//a[@id='ui-id-11']//span[contains(text(),'Jackets')]")
    WebElement clickOnJacket;

    public void clickOnJacket() {
        Reporter.log("Click On Jacket");
        clickOnElement(clickOnJacket);
        CustomListeners.test.log(Status.PASS, "Click On Jacket");
    }
}