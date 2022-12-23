package com.revature.steps;

import com.revature.Helper;
import com.revature.pages.*;
import com.revature.runners.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepImplementation
{
    public WebDriver driver = Runner.driver;

    // feature step implementations

    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page()
    {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=0");
    }
    @When("The employee types {string} into username input")
    public void the_employee_types_into_username_input(String string)
    {
        Login.userInput.sendKeys(string);
    }
    @When("The employee types {string} into password input")
    public void the_employee_types_into_password_input(String string)
    {
        Login.passInput.sendKeys(string);
    }
    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button()
    {
        Login.submit.click();
    }
    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_page(String string)
    {
        Helper.waitForPage(driver, ManagerHome.newMatrixButton, TesterHome.defectList);
        String expected = (string + " Home");
        String actual = driver.getTitle();
        assertEquals(expected, actual);
    }
    @Then("The employee should see their name {string} {string} on the home page")
    public void the_employee_should_see_their_name_on_the_home_page(String string, String string2)
    {
        String expected = ("Welcome " + string + " " + string2);
        String actual = Login.welcome.getText();
        assertEquals(expected, actual);
    }
    @When("The employee types in g8tor into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input()
    {
        Login.userInput.sendKeys("g8tor");
    }
    @When("The employee types in chomp!! into the password input")
    public void the_employee_types_in_chomp_into_the_password_input()
    {
        Login.passInput.sendKeys("chomp!!");
    }
    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password()
    {
        Helper.waitForAlert(driver);
        String expected = "Wrong password for User";
        String actual = driver.switchTo().alert().getText();
        assertEquals(expected, actual);
        driver.switchTo().alert().accept();
    }
    @When("The employee types in sicEmDawgs into the username input")
    public void the_employee_types_in_sic_em_dawgs_into_the_username_input()
    {
        Login.userInput.sendKeys("sicEmDawgs");
    }
    @When("The employee types in natchamps into the password input")
    public void the_employee_types_in_natchamps_into_the_password_input()
    {
        Login.passInput.sendKeys("natchamps");
    }
    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found()
    {
        Helper.waitForAlert(driver);
        String expected = "Username not found";
        String actual = driver.switchTo().alert().getText();
        assertEquals(expected, actual);
        driver.switchTo().alert().accept();
    }

    @Given("The manager is logged in as a manager")
    public void theManagerIsLoggedInAsAManager()
    {
        Helper.loginAsManager(driver);
    }

    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void theManagerShouldSeeLinksForMatricesTestCasesDefectReportingAndDefectOverview()
    {
        List<String> expectedLinks = new ArrayList();
        expectedLinks.add("Matrices");
        expectedLinks.add("Test Cases");
        expectedLinks.add("Report a Defect");
        expectedLinks.add("Defect Overview");
        expectedLinks.add("Log Out");
        expectedLinks.add("Home");

        List<String> actualLinks = new ArrayList();
        for (WebElement link : ManagerHome.links)
        {
            actualLinks.add(link.getText());
        }

        assertEquals(expectedLinks, actualLinks);
    }

    @When("The manager clicks on Matrices")
    public void theManagerClicksOnMatrices()
    {
        ManagerHome.links.get(0).click();
    }

    @Then("The title of the page should be Matrix Page")
    public void theTitleOfThePageShouldBeMatrixPage()
    {
        throw new io.cucumber.java.PendingException();
    }

    @When("The manager clicks the browser back button")
    public void theManagerClicksTheBrowserBackButton()
    {
        throw new io.cucumber.java.PendingException();
    }

    @Then("The manager should be on the home page")
    public void theManagerShouldBeOnTheHomePageAndTheTitleOfPageIsHome()
    {
        throw new io.cucumber.java.PendingException();
    }

    @When("The manager clicks on Test Cases")
    public void theManagerClicksOnTestCases()
    {
        throw new io.cucumber.java.PendingException();
    }

    @When("The manager clicks on {string}")
    public void theManagerClicksOn(String arg0)
    {
        throw new io.cucumber.java.PendingException();
    }

    @Then("The title of page should be {string}")
    public void theTitleOfPageShouldBe(String arg0)
    {
        throw new io.cucumber.java.PendingException();
    }
}
