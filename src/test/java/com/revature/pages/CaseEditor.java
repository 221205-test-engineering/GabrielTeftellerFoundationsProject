package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaseEditor extends Page
{
    public WebDriver driver;

    public CaseEditor(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[1]/textarea[1]")
    public static WebElement description;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[1]/textarea[2]")
    public static WebElement steps;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[1]/p[1]")
    public static WebElement automated;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[1]/p[2]")
    public static WebElement performedBy;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[2]/p")
    public static WebElement testResult;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[2]/textarea")
    public static WebElement summary;

    @FindBy(xpath = "//button[text()=\"Edit\"]")
    public static WebElement editButton;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[1]/input")
    public static WebElement automatedCheck;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[1]/select")
    public static WebElement performedDrop;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset[2]/select")
    public static WebElement resultDrop;

    @FindBy(xpath = "//button[text()=\"Reset\"]")
    public static WebElement resetButton;

    @FindBy(xpath = "//button[text()=\"Save\"]")
    public static WebElement saveButton;

}