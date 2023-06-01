package pageObjects;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Wait;

@Getter
public class MainPage {
    private final WebDriver webDriver;
    public MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(css = ".header-actions__item--user button")
    private WebElement logInBtn;
    @FindBy(xpath = "(//a[contains(@href, 'computers-notebooks')])[2]")
    private WebElement computersAndNotebooksCategory;
    @FindBy(css = ".header-actions__item--cart .header__button")
    private WebElement addToCartBtn;
    public void clickLogInButton(){
        Wait.untilElementIsClickable(webDriver, logInBtn, 30L);
        logInBtn.click();
    }
    public void clickComputersAndNotebooksCategory(){
        Wait.untilElementIsVisible(webDriver, computersAndNotebooksCategory, 30L);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", computersAndNotebooksCategory);
    }
    public void clickAddToCartBtn(){
        Wait.untilElementIsClickable(webDriver, addToCartBtn, 30L);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", addToCartBtn);
    }
}
