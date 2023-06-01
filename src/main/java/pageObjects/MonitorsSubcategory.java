package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Wait;

@Getter
public class MonitorsSubcategory {
    private WebDriver webDriver;
    public MonitorsSubcategory(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(xpath = "(//button[contains(@class, 'goods-tile__buy-button')])[2]")
    private WebElement addToCartBtn;
    @FindBy(xpath = "(//span[@class='goods-tile__title'])[2]")
    private WebElement monitorTitle;
    public void clickAddToCartBtn(){
        Wait.untilElementIsVisible(webDriver, addToCartBtn, 30L);
        addToCartBtn.click();
    }
}
