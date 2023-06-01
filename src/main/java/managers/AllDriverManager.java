package managers;

import enums.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class AllDriverManager {
    private WebDriver webDriver;
    private static DriverType driverType;

    public AllDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
    }
    private WebDriver createDriver(){
        switch (driverType){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("disable-infobars");
                chromeOptions.addArguments("--disable-extensions");
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                webDriver = new FirefoxDriver(firefoxOptions);
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                webDriver.manage().window().maximize();
                break;
            case SAFARI:
                webDriver = new SafariDriver();
                break;
        }
        long time = FileReaderManager.getInstance().getConfigFileReader().getTime();
        webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        return webDriver;
    }
    public WebDriver getWebDriver(){
        if(webDriver == null) webDriver = createDriver();
        return webDriver;
    }
    public void closeDriver(){
        webDriver.close();
        webDriver.quit();
    }
}
