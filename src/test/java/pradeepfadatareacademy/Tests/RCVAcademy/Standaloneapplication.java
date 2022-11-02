package pradeepfadatareacademy.Tests.RCVAcademy;

import PradeepFadatareAutomation.AbstaractComponents.OrderPage;

import PradeepFadatareAutomation.PageObject.RahulShetty.CartPage;
import PradeepFadatareAutomation.PageObject.RahulShetty.Checkoutpage;
import PradeepFadatareAutomation.PageObject.RahulShetty.ConfirmationPage;
import PradeepFadatareAutomation.PageObject.RahulShetty.ProductCatalog;
import org.testng.annotations.Test;
import pradeepfadatareacademy.Tests.TestComponent.BaseTest;
import java.io.IOException;

public class Standaloneapplication extends BaseTest  {

    public Standaloneapplication() throws IOException {
    }

    @Test
    public void submitproduct(){

        String productname="ZARA COAT 3";
        ProductCatalog productCatalog=landinPage.loginaction("padyafadatare@gmail.com","1234pradeep");

        productCatalog.getproductlist();
        productCatalog.getproductByName(productname);
        productCatalog.addProductTocart();
        CartPage cartPage=productCatalog.goToCart();
        String match=cartPage.checkingtheproduct(productname);
        System.out.println(match);
        Checkoutpage checkoutpage  =cartPage.tocheckout();
        checkoutpage.addCountry("india");
        ConfirmationPage confirmationPage=checkoutpage.submitOrder();
        confirmationPage.conirmationMsg();
        }

    @Test
    public void orderhistory(){
        ProductCatalog productCatalog=landinPage.loginaction("padyafadatare@gmail.com","1234pradeep");
         OrderPage orderPage=productCatalog.goToMyOrder();
         orderPage.checkproduct("adidas original");

    }



}


