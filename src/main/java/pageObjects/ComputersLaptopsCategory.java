package pageObjects;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Wait;
@Getter
public class ComputersLaptopsCategory {
    private WebDriver webDriver;

    public ComputersLaptopsCategory(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(xpath = "(//a[contains(@href, 'monitors')])[2]")
    private WebElement monitorsSubcategory;
    @FindBy(css = ".ng-star-inserted .portal__heading")
    private WebElement subcategoryHeader;

    public void clickMonitorsSubcategory(){
        Wait.untilElementIsVisible(webDriver, monitorsSubcategory, 30L);
        new Actions(webDriver).moveToElement(monitorsSubcategory).perform();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", monitorsSubcategory);
     }
}
