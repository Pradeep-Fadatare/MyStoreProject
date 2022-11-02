package PradeepFadatareAutomation.PageObject.RahulShetty;

import PradeepFadatareAutomation.AbstaractComponents.Abstractclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends Abstractclass {
    public String match;
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "/html/body/app-root/app-profile/div/div[2]/ul/li/div")
    List<WebElement> addedproductlst;
    @FindBy(xpath = "/html/body/app-root/app-profile/div/div[3]/ul/li[3]/button")
    WebElement chkoutbtn;
    By addedproductname1 = By.xpath("/html/body/app-root/app-profile/div/div[2]/ul/li/div/div/h3");

    public String checkingtheproduct(String productname) {
        for (WebElement e : addedproductlst) {
            WebElement addprodname = e.findElement(addedproductname1);
            if (addprodname.getText() == productname) {
                match = "True";
                System.out.println(addprodname.getText());
            } else {
                match = "False";
            }
        }
        return match;
    }

    public Checkoutpage tocheckout() {
        chkoutbtn.click();
        Checkoutpage checkoutpage = new Checkoutpage(driver);
        return checkoutpage;
    }
}
