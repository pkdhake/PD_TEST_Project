package com.inet.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public String baseURL = "https://www.nseindia.com/";
    public  WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        //Maximize the screen
        driver.manage().window().maximize();
        //Delete all the cookies
        driver.manage().deleteAllCookies();

       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //PageLoad TimeOuts
       // driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @BeforeTest
    public void launchBrowser()
    {

    }
   @AfterTest
    public void tearDown() {
      //  driver.quit();
    }


}
