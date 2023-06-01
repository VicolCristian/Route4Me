package stepsDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import pageObjects.*;
import utilities.TestContext;
import utilities.Wait;

import static enums.Context.PRODUCT_TITLE;

public class PurchaseProduct {
    TestContext testContext;
    MainPage mainPage;
    ComputersLaptopsCategory computersLaptopsSubcategory;
    MonitorsSubcategory monitorsSubcategory;
    CartPopUp cartPopUp;
    CheckoutPage checkoutPage;

    public PurchaseProduct(TestContext testContext){
        this.testContext = testContext;
        mainPage = testContext.getPageObjectManager().getMainPage();
        computersLaptopsSubcategory = testContext.getPageObjectManager().getComputersLaptopsSubcategory();
        monitorsSubcategory = testContext.getPageObjectManager().getMonitorsSubcategory();
        cartPopUp = testContext.getPageObjectManager().getCartPopUp();
        checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
    }
    @When("user click on a category on the left side of the web page")
    public void user_click_on_a_category_on_the_left_side_of_the_web_page() {
        mainPage.clickComputersAndNotebooksCategory();
    }
    @Then("page with category is displayed")
    public void page_with_category_is_displayed() {
        Wait.untilElementIsVisible(testContext.getDriverManager().getWebDriver(),
                computersLaptopsSubcategory.getSubcategoryHeader(), 30L);
        Assert.assertTrue(computersLaptopsSubcategory.getSubcategoryHeader().isDisplayed());
    }
    @When("user click on a sub-category")
    public void user_click_on_a_sub_category() {
        computersLaptopsSubcategory.clickMonitorsSubcategory();
    }
    @Then("the sub-category is displayed")
    public void the_sub_category_is_displayed() {
        try {
            Wait.untilElementIsVisible(testContext.getDriverManager().getWebDriver(),
                    monitorsSubcategory.getMonitorTitle(), 30L);
            Assert.assertTrue(monitorsSubcategory.getMonitorTitle().isDisplayed());
            Assert.assertTrue(monitorsSubcategory.getAddToCartBtn().isDisplayed());
        }catch (StaleElementReferenceException e){
            Wait.untilElementIsVisible(testContext.getDriverManager().getWebDriver(),
                    monitorsSubcategory.getMonitorTitle(), 30L);
            Assert.assertTrue(monitorsSubcategory.getMonitorTitle().isDisplayed());
            Assert.assertTrue(monitorsSubcategory.getAddToCartBtn().isDisplayed());
        }
    }
    @When("user click on add to cart button on any product from the list")
    public void user_click_on_add_to_cart_button_on_any_product_from_the_list() {
        try {
            testContext.getScenarioContext().setContext(PRODUCT_TITLE, monitorsSubcategory.getMonitorTitle().getText());
            monitorsSubcategory.clickAddToCartBtn();
        }catch (StaleElementReferenceException e){
            testContext.getScenarioContext().setContext(PRODUCT_TITLE, monitorsSubcategory.getMonitorTitle().getText());
            monitorsSubcategory.clickAddToCartBtn();
        }
    }
    @Then("product is added to the cart")
    public void product_is_added_to_the_cart() {
        mainPage.clickAddToCartBtn();
        Wait.untilElementIsVisible(testContext.getDriverManager().getWebDriver(),
                cartPopUp.getProductTitle(), 30L);
        Assert.assertEquals(cartPopUp.getProductTitle().getText(),
                testContext.getScenarioContext().getContext(PRODUCT_TITLE).toString());
    }

    @When("user click on checkout button")
    public void userClickOnCheckoutButton() {
        cartPopUp.clickCheckoutBtn();
    }

    @Then("user is redirected to checkout page")
    public void userIsRedirectedToCheckoutPage() {
        Wait.untilElementIsVisible(testContext.getDriverManager().getWebDriver(),
                checkoutPage.getHeader(), 30L);
        Assert.assertTrue(checkoutPage.getHeader().isDisplayed());
    }
}