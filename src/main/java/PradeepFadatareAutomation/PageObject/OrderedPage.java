package PradeepFadatareAutomation.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderedPage {

    WebDriver driver;
    public OrderedPage(WebDriver driver) {
        super();
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//table[@id='cart_summary']/tbody/tr/td[4]/span/span")
    WebElement unitprice;

    @FindBy(id = "total_price")
    WebElement totalprice;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
    WebElement proceedToChckOut;

    public double getUnitPrice(){
        String unitPriceprod=unitprice.getText();
        String unit=unitPriceprod.replaceAll("[^a-zA-Z0-9]","");
        double finalunitprice=Double.parseDouble(unit);
        return finalunitprice/100;

    }
    public double getTotalPrice(){
        String totalpriseprod=totalprice.getText();
        String tot=totalpriseprod.replaceAll("[^a-zA-Z0-9]","");
        double finalTOtalPrice=Double.parseDouble(tot);
        return finalTOtalPrice/100;
    }

    public LoginPage clickOnChckout(){
        proceedToChckOut.click();
        return new LoginPage(driver);
    }
}
