package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    public static void untilElementIsVisible(WebDriver driver, WebElement element, Long timeout){
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOf(element));
    }
    public static void untilFrameIsAvailableAndSwitchToIt(WebDriver driver, WebElement element, Long timeout){
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }
    public static void untilElementIsClickable(WebDriver driver, WebElement element, Long timeout){
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
