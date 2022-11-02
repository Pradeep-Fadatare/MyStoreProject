package pradeepfadatareacademy.Tests.MyStoreTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pradeepfadatareacademy.Tests.TestComponent.BaseTest1;

import java.io.IOException;


public class IndexValidationText extends BaseTest1 {

    @Test(groups = "smoke")
    public void logoVAlidation() throws IOException {

        boolean result = indexPage.validateLogo();
        System.out.println(result);
        String title = indexPage.getTitle(driver);
        Assert.assertEquals(title, "My Store");
    }
}
