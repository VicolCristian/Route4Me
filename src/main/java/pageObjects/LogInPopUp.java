package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Getter
public class LogInPopUp {
    private final WebDriver webDriver;
    public LogInPopUp(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(xpath = "//input[@id='auth_email']")
    private WebElement emailTextField;
    @FindBy(xpath = "//input[@id='auth_pass']")
    private WebElement passwordTextField;
    @FindBy(css = ".auth-modal__form-bottom .auth-modal__submit")
    private WebElement submitBtn;
}