package pradeepfadatareacademy.Tests.MyStoreTests;

import PradeepFadatareAutomation.PageObject.AddToCartPage;
import PradeepFadatareAutomation.PageObject.OrderedPage;
import PradeepFadatareAutomation.PageObject.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pradeepfadatareacademy.Tests.TestComponent.BaseTest1;

public class OrderedPageTest extends BaseTest1 {

    @Test(groups = "regression")
    public void validateOrderedProd() {
        SearchResultPage searchResultPage = indexPage.searchProduct("T-Shirt");
        AddToCartPage addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("3");
        addToCartPage.selectSize("M");
        addToCartPage.addToCart();
        addToCartPage.setProductaddedmsg();
        OrderedPage orderedPage = addToCartPage.checkout();
        double unit = orderedPage.getUnitPrice();
        double total = orderedPage.getTotalPrice();
        Assert.assertEquals(unit * 3 + 2, total);
    }
}
