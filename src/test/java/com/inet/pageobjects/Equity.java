package com.inet.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Equity {
    WebDriver driver;

    Equity(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



}
