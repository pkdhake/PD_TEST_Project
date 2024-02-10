package Practice_Test;

import javafx.scene.layout.Priority;
import org.testng.annotations.Test;

public class PriorityTest {
    @Test
    public void ZTest()
    {
        System.out.println("ZTest");
    }
    @Test(priority = 1)
    public void PTest()
    {
        System.out.println("PTest");
    }
    @Test(priority = 1)
    public void BTest()
    {
        System.out.println("BTest");
    }
    @Test
    public void ATest()
    {
        System.out.println("ATest");
    }
}
