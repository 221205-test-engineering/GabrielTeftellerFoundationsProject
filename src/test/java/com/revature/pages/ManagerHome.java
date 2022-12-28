package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ManagerHome extends Page
{
    public WebDriver driver;

    public ManagerHome(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(), 'Select')]")
    public static List<WebElement> selectButtons;

    @FindBy(xpath = "//h4")
    public static List<WebElement> boldDescriptions;

    @FindBy(xpath = "//button[contains(text(), 'Assign')]")
    public static List<WebElement> assignButtons;

    @FindBy(xpath = "//input")
    public static List<WebElement> assignmentInputs;

    @FindBy(xpath = "//*[@id=\"root\"]/input")
    public static WebElement matrixTitleInput;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset/table/tbody/tr/td[1]/input")
    public static WebElement userStoryInput;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset/table/tbody/tr/td[2]/select")
    public static WebElement priorityDropdown;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset/table/tbody/tr/td[3]/input")
    public static WebElement noteInput;

    @FindBy(xpath = "//*[@id=\"root\"]/fieldset/button")
    public static WebElement addRequirementButton;

    @FindBy(xpath = "//*[@id=\"root\"]/button")
    public static WebElement createMatrixButton;
}
