package com.revature;

import com.revature.pages.*;
import org.junit.function.ThrowingRunnable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Helper
{
    public static void waitForAlert(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitForPage(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForPage(WebDriver driver, WebElement element1, WebElement element2)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until
        (
            ExpectedConditions.or
            (
                ExpectedConditions.visibilityOf(element1),
                ExpectedConditions.visibilityOf(element2)
            )
        );
    }

    public static void loginAsManager(WebDriver driver)
    {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=14");
        Login.userInput.sendKeys("g8tor");
        Login.passInput.sendKeys("chomp!");
        Login.submit.click();
        waitForPage(driver, ManagerHome.createMatrixButton);
    }

    public static void loginAsTester(WebDriver driver)
    {
        killAlert(driver);
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=14");
        Login.userInput.sendKeys("ryeGuy");
        Login.passInput.sendKeys("coolbeans");
        Login.submit.click();
        waitForPage(driver, TesterHome.testCaseTable);
    }

    public static void checkForAlert(WebDriver driver)
    {
        driver.switchTo().alert().accept();
    }

    public static void killAlert(WebDriver driver)
    {
        try
        {
            driver.switchTo().alert().accept();
        }
        catch(org.openqa.selenium.NoAlertPresentException ignored) { }
    }
}
