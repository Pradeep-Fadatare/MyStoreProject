package pradeepfadatareacademy.Tests.MyStoreTests;

import PradeepFadatareAutomation.PageObject.*;
import org.junit.Test;
import org.testng.Assert;
import pradeepfadatareacademy.Tests.TestComponent.BaseTest1;

public class EndToEndTest extends BaseTest1 {

    @Test
    public void finalTest() {
        SearchResultPage searchResultPage = indexPage.searchProduct("T-Shirt");
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
        shippingPage.proceedToCheckOut();
        PaymentPage paymentPage = shippingPage.proceedToCheckOut();
        OrdersummaryPage ordersummaryPage = paymentPage.clickOnPaymentMethod();
        OrderConfirmationPage orderConfirmationPage = ordersummaryPage.clickorderconfirm();
        String msg = orderConfirmationPage.confirmmsgofproduct();
        Assert.assertEquals(msg, "Your order on My Store is completed");

    }
}
