package PradeepFadatareAutomation.PageObject;

import PradeepFadatareAutomation.AbstaractComponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends Abstractclass {

    WebDriver driver;
    public SearchResultPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
    WebElement product;

    public boolean isProductAvailable(){
        return product.isDisplayed();
    }

    public AddToCartPage clickOnProduct(){
        product.click();

        return new AddToCartPage(driver);
    }


}
