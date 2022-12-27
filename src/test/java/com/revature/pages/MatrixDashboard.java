package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MatrixDashboard extends Page
{
    public WebDriver driver;

    public MatrixDashboard(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // PageFactory elements

    @FindBy(css = "button")                                 // get help with this
    public static List<WebElement> matrixButtons;

}
