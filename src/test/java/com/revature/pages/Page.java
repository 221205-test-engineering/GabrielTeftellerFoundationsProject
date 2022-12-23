package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public abstract class Page
{
    WebDriver driver;

    public Page(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*
    @FindBy(xpath = "//*[@id=\"root\"]/nav/a[6]")
    public static WebElement home;

    @FindBy(xpath = "//*[@id=\"root\"]/nav/a[1]")
    public static WebElement matricesLink;

    @FindBy(xpath = "//*[@id=\"root\"]/nav/a[2]")
    public static WebElement testCasesLink;

    @FindBy(xpath = "//*[@id=\"root\"]/nav/a[3]")
    public static WebElement defectReportLink;

    @FindBy(xpath = "//*[@id=\"root\"]/nav/a[4]")
    public static WebElement defectOverviewLink;

    @FindBy(xpath = "//*[@id=\"root\"]/nav/a[5]")
    public static WebElement logOut;

     */

    @FindBy(tagName = "a")
    public static List<WebElement> links;
}
