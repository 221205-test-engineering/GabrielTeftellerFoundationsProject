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

    @FindBy(xpath = "//*[@id=\"root\"]/h1")
    public static WebElement titleText;

    @FindBy(xpath = "//button[contains(text(), 'Edit')]")
    public static List<WebElement> editButtons;

    @FindBy(xpath = "//button[contains(text(), 'Save Requirements')]")
    public static List<WebElement> saveRequirementsButtons;

    @FindBy(xpath = "//button[contains(text(), 'Show')]")
    public static List<WebElement> showButtons;

    @FindBy(xpath = "//button[contains(text(), 'Add')]")    // evens are testCaseAdd buttons, odds are defectAdd buttons
    public static List<WebElement> addButtons;

    @FindBy(name = "testlist")
    public static List<WebElement> testCaseInputs;

    @FindBy(name = "defectlist")
    public static List<WebElement> defectInputs;

}
