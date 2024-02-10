package com.inet.pageobjects;

import com.inet.utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Derivatives {

    @FindBy(xpath = "//div[@class='nav nav-tabs']//a[text()='Equity Derivatives']")
    WebElement link_Equity_Derivatives;

    @FindBy(xpath = "//div[@class='nav nav-tabs']//a[text()='Currency Derivatives']")
    WebElement link_Currency_Derivatives;

    @FindBy(xpath = "//div[@class='nav nav-tabs']//a[text()='Commodity Derivatives']")
    WebElement link_Commodity_Derivatives;

    @FindBy(xpath = "//div[@class='nav nav-tabs']//a[text()='Interest Rate Derivatives']")
    WebElement link_InterestRate_Derivatives;


    WebDriver driver;

    public Derivatives(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verify_four_tabs()
    {
        Utils.explicitWait(driver,link_Equity_Derivatives,10);

        Assert.assertTrue(link_Equity_Derivatives.isDisplayed());
        Assert.assertTrue(link_Currency_Derivatives.isDisplayed());
        Assert.assertTrue(link_Commodity_Derivatives.isDisplayed());
        Assert.assertTrue(link_InterestRate_Derivatives.isDisplayed());
    }
}
