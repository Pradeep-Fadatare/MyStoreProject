package pradeepfadatareacademy.Tests;

import PradeepFadatareAutomation.PageObject.RahulShetty.CartPage;
import PradeepFadatareAutomation.PageObject.RahulShetty.ProductCatalog;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pradeepfadatareacademy.Tests.TestComponent.BaseTest;
import pradeepfadatareacademy.Tests.TestComponent.Retry;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ErroValidationTest extends BaseTest {

    public ErroValidationTest() throws IOException {
    }

    @Test(dataProvider = "getdata",retryAnalyzer = Retry.class)
    public void valideterror(HashMap<String,String> input) {
        landinPage.loginaction(input.get("email"), input.get("password"));
        Assert.assertEquals("Incorrect email  password.", landinPage.getmeErrormsg());
    }

    @Test(groups = {"Errorhandling"})
    public void producterrvalidation() throws IOException {
        String productname="ZARA COAT 3";
        ProductCatalog productCatalog=landinPage.loginaction("padyafadatare@gmail.com","1234pradeep");

        productCatalog.getproductlist();
        productCatalog.getproductByName(productname);
        productCatalog.addProductTocart();
        CartPage cartPage=productCatalog.goToCart();
        String match=cartPage.checkingtheproduct(productname);
    }



    @DataProvider
    public Object[][] getdata() throws IOException {

//        HashMap<String,String> map= new HashMap<String,String>();
//        map.put("email","padyafadatare@gmail.com");
//        map.put("password","1234pradeep");
//
//        HashMap<String,String> map1= new HashMap<String,String>();
//        map1.put("email","padyafare@gmail.com");
//        map1.put("password","1234pradeep");
        List<HashMap<String,String>> data=getjasondataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\pradeepfadatareacademy\\Data\\LoginValidation.json");
        return new Object [][]
                {{data.get(0)},{data.get(1)}};
    }

}
