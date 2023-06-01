package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageObjectManager {
    private WebDriver driver;
    private MainPage mainPage;
    private LogInPopUp logInPopUp;
    private ComputersLaptopsCategory computersLaptopsSubcategory;
    private MonitorsSubcategory monitorsSubcategory;
    private CartPopUp cartPopUp;
    private CheckoutPage checkoutPage;
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }
    public MainPage getMainPage(){
        if(mainPage == null){
            mainPage = new MainPage(driver);
        }
        return mainPage;
    }
    public LogInPopUp getLogInPopUp(){
        if(logInPopUp == null){
            logInPopUp = new LogInPopUp(driver);
        }
        return logInPopUp;
    }
    public ComputersLaptopsCategory getComputersLaptopsSubcategory(){
        if(computersLaptopsSubcategory == null){
            computersLaptopsSubcategory = new ComputersLaptopsCategory(driver);
        }
        return computersLaptopsSubcategory;
    }
    public MonitorsSubcategory getMonitorsSubcategory(){
        if(monitorsSubcategory == null){
            monitorsSubcategory = new MonitorsSubcategory(driver);
        }
        return monitorsSubcategory;
    }
    public CartPopUp getCartPopUp(){
        if(cartPopUp == null){
            cartPopUp = new CartPopUp(driver);
        }
        return  cartPopUp;
    }
    public CheckoutPage getCheckoutPage(){
        if(checkoutPage == null){
            checkoutPage = new CheckoutPage(driver);
        }
        return checkoutPage;
    }
}