package com.inet.pageobjects;

import com.inet.utilities.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class NseHomePage {
    WebDriver driver;
    JavascriptExecutor js;

    @FindBy(xpath = "//input[@id='header-search-input']")
    WebElement txt_Searchbox;

    @FindBy(xpath = "//span[@class='lt']")
    List<WebElement> list_SearchedResults;


    @FindBy(xpath = "//a[@id='NSE Indices']")
    WebElement link_NSE_Indices;

    @FindBy(xpath = "//a[@id='Equities']")
    WebElement link_Equities;

    @FindBy(xpath = "//a[@id='Derivatives']")
    WebElement link_Derivatives;

    @FindBy(xpath = "//a[text()='Top 10 Gainers/Loser']")
    WebElement link_TopGainers;

    @FindBy(xpath = "//a[text()=' Most Active Equities']")
    WebElement link_MostActiveEquites;



    //a[text()='Equity Derivatives']
    //a[text()='Currency Derivatives']
    //a[text()='Commodity Derivatives']
    //a[text()='Interest Rate Derivatives']

    public NseHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
    }

    public void click_on_Equities()
    {
        link_Equities.click();
    }

    public void click_on_Derivatives()
    {
        Utils.explicitWait(driver,link_Derivatives,10);
        link_Derivatives.click();
    }
    public void verify_Tabs() {
        Utils.explicitWait(driver,link_TopGainers,20);

       Assert.assertTrue(link_TopGainers.isDisplayed());
        Assert.assertTrue(link_MostActiveEquites.isDisplayed());
    }

    public void test_Enable_Disable()
    {

        String toenable = "document.getElementById(\"header-search-input\").setAttribute(\"disabled\", true);";
        js.executeScript(toenable);

        System.out.println("header-search-input "+toenable);
    }
}

