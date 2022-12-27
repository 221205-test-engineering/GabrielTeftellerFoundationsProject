package com.revature.runners;

import com.revature.pages.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features =
    {
        "src/test/java/com/revature/features/login/login-negative.feature",
        "src/test/java/com/revature/features/login/login-positive.feature",
        "src/test/java/com/revature/features/navigation/navigation.feature",
        "src/test/java/com/revature/features/defect/report-defect-negative.feature",
        "src/test/java/com/revature/features/defect/report-defect-positive.feature"
    }, glue = "com.revature.steps")
public class Runner
{
    public static WebDriver driver;
    public static Login login;
    public static ManagerHome managerHome;
    public static TesterHome testerHome;
    public static MatrixDashboard matrix;
    public static TestCaseDashboard cases;
    public static DefectReporter defectReports;
    public static DefectOverview overview;
    public static CaseEditor caseEditor;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        login = new Login(driver);
        managerHome = new ManagerHome(driver);
        testerHome = new TesterHome(driver);
        matrix = new MatrixDashboard(driver);
        cases = new TestCaseDashboard(driver);
        defectReports = new DefectReporter(driver);
        overview = new DefectOverview(driver);
        caseEditor = new CaseEditor(driver);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}