package PradeepFadatareAutomation.AbstaractComponents;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends Abstractclass {

    WebDriver driver;
    public boolean match;
    public OrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/app-root/app-myorders/div[1]/table/tbody/tr/td[2]")
    List<WebElement> orderedele;

    public void checkproduct(String productName){
        for(WebElement e:orderedele){
            if(e.getText().equalsIgnoreCase(productName)) {
                System.out.println(e.getText());
            }
        }
    }
}
