package pageObjects;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Wait;

@Getter
public class CartPopUp {
    private WebDriver webDriver;

    public CartPopUp(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(xpath = "(//a[@class='cart-product__title'])[1]")
    private WebElement productTitle;
    @FindBy(xpath = "//a[contains(@href, 'checkout')]")
    private WebElement checkoutBtn;

    public void clickCheckoutBtn(){
        Wait.untilElementIsClickable(webDriver, checkoutBtn, 30L);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", checkoutBtn);
    }
}
