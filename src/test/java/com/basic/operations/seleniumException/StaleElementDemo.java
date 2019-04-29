package com.basic.operations.seleniumException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class StaleElementDemo {
    @Test
    public void testMethod() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://learn.letskodeit.com/p/practice");

       // driver.get(driver.getCurrentUrl());
        WebElement checkboxElement = driver.findElement(By.id("bmwcheck"));
        driver.get(driver.getCurrentUrl());//if u try find element
        //while page loading,selenium cant find element
        checkboxElement.click();
    }
}

