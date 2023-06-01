package stepsDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.openqa.selenium.StaleElementReferenceException;
import pageObjects.LogInPopUp;
import pageObjects.MainPage;
import utilities.TestContext;
import utilities.Wait;

import java.util.List;

public class CommonSteps {
    TestContext testContext;
    MainPage mainPage;
    LogInPopUp logInPopUp;
    public CommonSteps(TestContext testContext){
        this.testContext = testContext;
        mainPage = testContext.getPageObjectManager().getMainPage();
        logInPopUp = testContext.getPageObjectManager().getLogInPopUp();
    }
    @Given("user is logged in")
    public void user_is_logged_in(DataTable dataTable) throws InterruptedException {
        List<String> dataRow = dataTable.row(1);
        String email = dataRow.get(0);
        String password = dataRow.get(1);
        try {
            mainPage.clickLogInButton();
        }catch (StaleElementReferenceException e){
            mainPage.clickLogInButton();
        }
        Wait.untilElementIsVisible(testContext.getDriverManager().getWebDriver(),
                logInPopUp.getEmailTextField(), 20L);
        logInPopUp.getEmailTextField().sendKeys(email);
        logInPopUp.getPasswordTextField().sendKeys(password);
        logInPopUp.getSubmitBtn().click();
        Thread.sleep(20000); //this line is written because I had to pass reCaptcha manually
        logInPopUp.getSubmitBtn().click();
    }
}