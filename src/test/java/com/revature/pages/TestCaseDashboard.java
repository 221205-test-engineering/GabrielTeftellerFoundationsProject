package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCaseDashboard extends Page
{
    public WebDriver driver;

    public TestCaseDashboard(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/form/fieldset/textarea[1]")
    public static WebElement descInput;

    @FindBy(xpath = "//*[@id=\"root\"]/form/fieldset/textarea[2]")
    public static WebElement stepInput;

    @FindBy(xpath = "//*[@id=\"root\"]/form/fieldset/button")
    public static WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"root\"]/table")
    public static WebElement testCaseTable;
}