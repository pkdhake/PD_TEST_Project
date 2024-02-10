package PD_Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Class_ITestListener.class)
public class TestClass {
    @Test
    public void test1() {
        System.out.println("Test1");
        Assert.assertTrue(true);
    }
    @Test
    public void test2() {
        System.out.println("test2");
        Assert.assertTrue(false);
    }
}
