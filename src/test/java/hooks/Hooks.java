package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import utilities.TestContext;

public class Hooks {
    private TestContext testContext;
    private WebDriver webDriver;
    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }
    @Before
    public void setUp(){
        webDriver = testContext.getDriverManager().getWebDriver();
        webDriver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
    }

    @After
    public void tearDown(){
        testContext.getDriverManager().getWebDriver().manage().deleteAllCookies();
        testContext.getDriverManager().closeDriver();
    }
}