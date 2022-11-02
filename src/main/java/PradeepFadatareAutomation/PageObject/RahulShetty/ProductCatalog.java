package PradeepFadatareAutomation.PageObject.RahulShetty;

import PradeepFadatareAutomation.AbstaractComponents.Abstractclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class ProductCatalog extends Abstractclass {
    WebDriver driver;
    public WebElement name;
    public WebElement selected_product;
    public String productname;

    public ProductCatalog(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"products\"]/div[1]/div[2]/div/div")
    List<WebElement> product;

    @FindBy(xpath = "//*[@id=\'toast-container\']")
    WebElement spinner;



    By product1 = By.xpath("//*[@id=\'products\']/div[1]/div[2]/div");
    By toastmsg = By.xpath("//*[@id=\'toast-container\']");

    public List<WebElement> getproductlist() {
        waitUntillElementToAppear(product1);
        return product;
    }

    public WebElement getproductByName(String productname) {
        for (WebElement e : getproductlist()) {
            // name = e.findElement(By.xpath("//*[@id=\'products\']/div[1]/div[2]/div/div/div/h5"));
            name = e.findElement(By.xpath("//*[@id='products']/div[1]/div[2]/div/div/div"));
            WebElement prod_name = name.findElement(By.xpath("//*[@id=\'products\']/div[1]/div[2]/div[1]/div/div/h5/b"));
            if (prod_name.getText() == productname) {
                selected_product = e.findElement(By.xpath("//*[@id='products']/div[1]/div[2]/div/div/div"));
                break;
            }
//        if (name.getText()==productname){
//            prod=e.findElement(By.xpath("//*[@id=\"products\"]/div[1]/div[2]/div[1]/div/div"));
//        }
        }
            return name;

    }
        By cartelement = By.xpath("//*[@id='products']/div[1]/div[2]/div/div/div/button[2]");

        public void addProductTocart () {
            WebElement prod1 = getproductByName(productname);
            prod1.findElement(cartelement).click();
            waitUntillElementToAppear(toastmsg);
            waitForElementToDisappear(spinner);
        }
    }




