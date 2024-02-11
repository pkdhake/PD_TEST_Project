package com.inet.testscripts;

import com.inet.base.BaseClass;
import com.inet.pageobjects.Derivatives;
import com.inet.pageobjects.NseHomePage;
import com.inet.utilities.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tc1 extends BaseClass {

    //TC1 Open NSE > Navigate to Equities > Verify Top 10 Gainers/Loser & Most Active Equities
    @Test(priority = 1,enabled = true)
    public void tc_verify_equities() {
        extentTest = extentReports.createTest("tc_verify_equities");
        System.out.println("======== Started : tc_verify_equities");

        //driver.get(baseURL);
        NseHomePage obj_nsehm = new NseHomePage(driver);

        extentTest.createNode("test_Enable_Disable");
        obj_nsehm.test_Enable_Disable();
        obj_nsehm.click_on_Equities();

        extentTest.createNode("verify_Tabs");
        obj_nsehm.verify_Tabs();
        System.out.println("======== Finished : tc_verify_equities");
    }

    //TC1 Open NSE > Navigate to Derivatives > Verify 4 tabs should display
    @Test(priority = 2, enabled = true)
    public void tc_verify_derivatives() {
        extentTest = extentReports.createTest("tc_verify_derivatives");
        System.out.println("======== Started : tc_verify_derivatives");

        //driver.get(baseURL);
        NseHomePage obj_nsehm = new NseHomePage(driver);
        Derivatives obj_derivatives = new Derivatives(driver);
        obj_nsehm.click_on_Derivatives();
        obj_derivatives.verify_four_tabs();
        System.out.println("======== Finished : tc_verify_derivatives");

    }


    @Test(priority = 3, enabled = true)
    public void tc_verifyTitle() {
        extentTest = extentReports.createTest("tc_verifyTitle");
        Assert.assertEquals("gg", driver.getTitle());
    }


    @Test(priority = 4, enabled = true)
    public void tc_test() {
        extentTest = extentReports.createTest("tc_test");
        Assert.assertTrue(true);
    }
}
