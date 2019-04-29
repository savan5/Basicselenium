package com.basic.operations;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ScreenShots {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.expedia.com/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testScreenshots() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("tab-flight-tab-hp")).click();

        // Find Elements
        WebElement flight_origin = driver.findElement(By.id("flight-origin-hp-flight"));
        WebElement flight_destination = driver.findElement(By.id("flight-destination-hp-flight"));
        WebElement departure_date = driver.findElement(By.id("flight-departing-hp-flight"));
        WebElement return_date = driver.findElement(By.id("flight-returning-hp-flight"));
        WebElement search = driver.findElement(By.xpath("//form[@id='gcw-flights-form-hp-flight']//button[contains(@type,'submit')]"));

        // Send data to elements
        flight_origin.sendKeys("New York");
        departure_date.sendKeys("09/04/2019");
        return_date.clear();
        return_date.sendKeys("09/10/2019");
        flight_destination.sendKeys("New York");
        search.click();
    }

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    @After
    public void tearDown() throws Exception {
        String fileName = getRandomString(10) + ".png";
        String directory = "//c://Desktop//";

        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
        driver.quit();
    }
}
