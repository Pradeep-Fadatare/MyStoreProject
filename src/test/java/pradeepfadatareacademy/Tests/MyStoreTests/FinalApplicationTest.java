package pradeepfadatareacademy.Tests.MyStoreTests;

import PradeepFadatareAutomation.PageObject.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pradeepfadatareacademy.Tests.TestComponent.BaseTest1;

public class FinalApplicationTest extends BaseTest1 {

    @Test(groups = "regression")
    public void lastTest(){
        SearchResultPage searchResultPage=indexPage.searchProduct("t-shirt");
        AddToCartPage addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("3");
        addToCartPage.selectSize("S");
        addToCartPage.addToCart();
        addToCartPage.setProductaddedmsg();
        OrderedPage orderedPage = addToCartPage.checkout();
        orderedPage.getUnitPrice();
        orderedPage.getTotalPrice();
        LoginPage loginPage = orderedPage.clickOnChckout();
        AddressPage addressPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
        ShippingPage shippingPage = addressPage.clickOnChckOut();
        PaymentPage paymentPage = shippingPage.proceedToCheckOut();
        OrdersummaryPage ordersummaryPage = paymentPage.clickOnPaymentMethod();
        OrderConfirmationPage orderConfirmationPage = ordersummaryPage.clickorderconfirm();
        String msg = orderConfirmationPage.confirmmsgofproduct();
        Assert.assertEquals(msg, "Your order on My Store is completed");

    }
}
