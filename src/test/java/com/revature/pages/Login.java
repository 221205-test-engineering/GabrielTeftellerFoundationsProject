package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login
{
    public WebDriver driver;

    public Login(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

// PageFactory elements
    @FindBy(name = "username")
    public static WebElement userInput;

    @FindBy(name = "pass")
    public static WebElement passInput;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset/button")
    public static WebElement submit;

    @FindBy(xpath = "//*[@id=\"root\"]/nav/p")
    public static WebElement welcome;
}