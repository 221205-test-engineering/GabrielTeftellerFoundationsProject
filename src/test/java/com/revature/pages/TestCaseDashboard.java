package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(xpath = "/html/body/div[3]/div/div")
    public static WebElement modal;

    @FindBy(xpath = "/html/body/div[3]/div/div/button[1]")
    public static WebElement modalClose;

    @FindBy(xpath = "/html/body/div[3]/div/div/button[2]/a")
    public static WebElement modalEdit;

    @FindBy(xpath = "/html/body/div[3]/div/div/p[6]")
    public static WebElement modalPerformedBy;

    @FindBy(xpath = "//td[3]")
    public static List<WebElement> results;

    @FindBy(xpath = "//button[contains(text(), 'Details')]")
    public static List<WebElement> detailsButtons;

    @FindBy(xpath = "//td[2]")
    public static List<WebElement> descriptions;


}