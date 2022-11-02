package PradeepFadatareAutomation.PageObject;

import PradeepFadatareAutomation.AbstaractComponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends Abstractclass {

WebDriver driver;
    public AddToCartPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "quantity_wanted")
    WebElement quantity;

    @FindBy(css = "button.exclusive")
    WebElement addtocartbtn;

    @FindBy(css = "#group_1")
    WebElement size;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
    WebElement productaddedmsg;

    @FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
    WebElement chckOutbtn;

    public void enterQuantity(String size){
        quantity.clear();
        quantity.sendKeys(size);
    }
    public void selectSize(String name){
        selectByVisibletxt(size,name);
    }
    public void addToCart(){
        addtocartbtn.click();
    }

    public OrderedPage checkout(){
        waitUntillWebElementToAppear(chckOutbtn);
        chckOutbtn.click();
        return new OrderedPage(driver);
    }

    public boolean setProductaddedmsg(){
        waitUntillWebElementToAppear(productaddedmsg);
        boolean result=productaddedmsg.isDisplayed();
        return result;
    }
}
