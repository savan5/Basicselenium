package com.basic.operations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class FileAttachEmail {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws MalformedURLException {
        driver = new FirefoxDriver();;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.gmail.com/");
    }

    @Test
    public void fileUpload() throws AWTException, InterruptedException {
        driver.findElement(By.id("identifierId")).sendKeys("aryaavjewels@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
         driver.findElement(By.name("password")).sendKeys("suratindia0987654321");
        driver.findElement(By.id("passwordNext")).click();

        driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
        driver.findElement(By.xpath("//div[@class='wO nr l1']//textarea")).sendKeys("nareshkhunt@yahoo.co.in");
        driver.findElement(By.name("subjectbox")).sendKeys("Test File Upload");
        WebElement fileInput = driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));
        fileInput.click();

       StringSelection ss = new StringSelection("C:\\Users\\nares\\Desktop\\testfile.txt");
       // StringSelection ss = new StringSelection("C:\\Users\\nares\\Desktop\\EggPlant.docx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        // Ctrl + v
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_ENTER);

        driver.findElement(By.xpath("//div[text()='Send']")).click();
        //logout
        driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div/div[2]/div/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"gb_71\"]")).click();
    }

   @After
    public void tearDown() {
        driver.quit();
    }

}
