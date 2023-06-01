package utilities;

import managers.AllDriverManager;
import managers.PageObjectManager;

public class TestContext {
    private final AllDriverManager driverManager;
    private final PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;
    public TestContext(){
        driverManager = new AllDriverManager();
        pageObjectManager = new PageObjectManager(driverManager.getWebDriver());
        scenarioContext = new ScenarioContext();
    }
    public AllDriverManager getDriverManager(){
        return driverManager;
    }
    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }
    public ScenarioContext getScenarioContext(){
        return scenarioContext;
    }
}
