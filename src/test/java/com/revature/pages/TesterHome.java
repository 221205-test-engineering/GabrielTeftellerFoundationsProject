package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TesterHome extends Page
{
    public WebDriver driver;

    public TesterHome(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/ul")
    public static WebElement defectList;

    @FindBy(xpath = "//*[@id=\"root\"]/h1")
    public static WebElement titleText;

    @FindBy(xpath = "//*[@id=\"root\"]/table")
    public static WebElement testCaseTable;

    @FindBy(xpath = "//button[contains(text(), 'Accepted')]")
    public static List<WebElement> acceptedButtons;

    @FindBy(xpath = "//b[not(contains(text(), 'ID'))]")
    public static List<WebElement> statuses;

    @FindBy(xpath = "//b[contains(text(), 'ID')]")
    public static List<WebElement> defects;

    @FindBy(xpath = "//button[contains(text(), 'Details')]")
    public static List<WebElement> detailsButtons;

    @FindBy(xpath = "//td[3]")
    public static List<WebElement> results;

    @FindBy(xpath = "//button[contains(text(), 'Change Status')]")
    public static List<WebElement> changeStatusButtons;

    @FindBy(xpath = "//button[contains(text(), 'Steps')]")
    public static List<WebElement> stepsButtons;
}