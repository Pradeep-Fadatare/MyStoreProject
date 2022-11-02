package pradeepfadatareacademy.Tests.MyStoreTests;

import PradeepFadatareAutomation.PageObject.AddToCartPage;
import PradeepFadatareAutomation.PageObject.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pradeepfadatareacademy.Data.DataProvider;
import pradeepfadatareacademy.Tests.TestComponent.BaseTest1;

public class AddToCartPageTest extends BaseTest1 {

    @Test(groups = {"regression","sanity"},dataProvider = "productdatails", dataProviderClass = DataProvider.class)
    public void addToCart(String prod,String qty,String size ){
        SearchResultPage searchResultPage = indexPage.searchProduct(prod);
        AddToCartPage addToCartPage=searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity(qty);
        addToCartPage.selectSize(size);
        addToCartPage.addToCart();

        boolean result=addToCartPage.setProductaddedmsg();
        Assert.assertTrue(result);
    }
}
