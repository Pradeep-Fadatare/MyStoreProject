package pradeepfadatareacademy.Tests.MyStoreTests;

import PradeepFadatareAutomation.PageObject.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pradeepfadatareacademy.Tests.TestComponent.BaseTest1;
public class SearchResultTest extends BaseTest1 {


    @Test(groups = "smoke")
    public void productValidation() {
        SearchResultPage searchResultPage = indexPage.searchProduct("T-Shirt");
        boolean result = searchResultPage.isProductAvailable();
        Assert.assertTrue(result);
    }
}
