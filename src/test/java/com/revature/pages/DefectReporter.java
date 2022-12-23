package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefectReporter extends Page
{
    public WebDriver driver;

    public DefectReporter(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "dateReported")
    public static WebElement dateInput;

    @FindBy(name = "desc")
    public static WebElement descInput;

    @FindBy(name = "stepsToReproduce")
    public static WebElement reproductionInput;

    @FindBy(name = "severity")
    public static WebElement severitySlider;

    @FindBy(name = "priority")
    public static WebElement prioritySlider;

    @FindBy(xpath = "//*[@id=\"defectReport\"]/button")
    public static WebElement reportButton;

    @FindBy(xpath = "/html/body/div[3]/div/div/button")
    public static WebElement confirmButton;
}
