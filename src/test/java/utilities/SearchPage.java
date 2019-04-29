package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    public static void navigateToFlightsTab(WebDriver driver) {
       WebElement element = driver.findElement(By.id("tab-flight-tab-hp"));
        element.click();
    }
}
