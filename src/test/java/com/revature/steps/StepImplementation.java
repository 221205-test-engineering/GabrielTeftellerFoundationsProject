package com.revature.steps;

import com.revature.Helper;
import com.revature.pages.*;
import com.revature.runners.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.De;
import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class StepImplementation {
    public WebDriver driver = Runner.driver;

    // feature step implementations

    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=14");
    }

    @When("The employee types {string} into username input")
    public void the_employee_types_into_username_input(String string) {
        Login.userInput.sendKeys(string);
    }

    @When("The employee types {string} into password input")
    public void the_employee_types_into_password_input(String string) {
        Login.passInput.sendKeys(string);
    }

    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        Login.submit.click();
    }

    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_page(String string) {
        Helper.waitForPage(driver, ManagerHome.createMatrixButton, TesterHome.defectList);
        String expected = (string + " Home");
        String actual = driver.getTitle();
        assertEquals(expected, actual);
    }

    @Then("The employee should see their name {string} {string} on the home page")
    public void the_employee_should_see_their_name_on_the_home_page(String string, String string2) {
        String expected = ("Welcome " + string + " " + string2);
        String actual = Login.welcome.getText();
        assertEquals(expected, actual);
    }

    @When("The employee types in g8tor into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input() {
        Login.userInput.sendKeys("g8tor");
    }

    @When("The employee types in chomp!! into the password input")
    public void the_employee_types_in_chomp_into_the_password_input() {
        Login.passInput.sendKeys("chomp!!");
    }

    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
        Helper.waitForAlert(driver);
        String expected = "Wrong password for User";
        String actual = driver.switchTo().alert().getText();
        assertEquals(expected, actual);
        driver.switchTo().alert().accept();
    }

    @When("The employee types in sicEmDawgs into the username input")
    public void the_employee_types_in_sic_em_dawgs_into_the_username_input() {
        Login.userInput.sendKeys("sicEmDawgs");
    }

    @When("The employee types in natchamps into the password input")
    public void the_employee_types_in_natchamps_into_the_password_input() {
        Login.passInput.sendKeys("natchamps");
    }

    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() {
        Helper.waitForAlert(driver);
        String expected = "Username not found";
        String actual = driver.switchTo().alert().getText();
        assertEquals(expected, actual);
        driver.switchTo().alert().accept();
    }

    @Given("The manager is logged in as a manager")
    public void theManagerIsLoggedInAsAManager() {
        Helper.loginAsManager(driver);
    }

    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void theManagerShouldSeeLinksForMatricesTestCasesDefectReportingAndDefectOverview() {
        List<String> expectedLinks = new ArrayList();
        expectedLinks.add("Matrices");
        expectedLinks.add("Test Cases");
        expectedLinks.add("Report a Defect");
        expectedLinks.add("Defect Overview");
        expectedLinks.add("Log Out");
        expectedLinks.add("Home");

        List<String> actualLinks = new ArrayList();
        for (WebElement link : ManagerHome.links) {
            actualLinks.add(link.getText());
        }

        assertEquals(expectedLinks, actualLinks);
    }

    @When("The manager clicks on Matrices")
    public void theManagerClicksOnMatrices() {
        ManagerHome.links.get(0).click();
    }

    @Then("The manager should be on the matrices page")
    public void theManagerShouldBeOnTheMatricesPage() {
        assertEquals("Matrix Dashboard", driver.getTitle());
    }

    @When("The manager clicks the browser back button")
    public void theManagerClicksTheBrowserBackButton() {
        driver.navigate().back();
    }

    @Then("The manager should be on the home page")
    public void theManagerShouldBeOnTheHomePage() {
        Helper.waitForPage(driver, ManagerHome.createMatrixButton);
        assertEquals("Manager Home", driver.getTitle());
    }

    @When("The manager clicks on Test Cases")
    public void theManagerClicksOnTestCases() {
        ManagerHome.links.get(1).click();
    }

    @When("The manager clicks on {string}")
    public void theManagerClicksOn(String clickedLink) {
        String checkString;

        for (WebElement link : ManagerHome.links) {
            checkString = link.getText();
            if (checkString.equals(clickedLink)) {
                link.click();
                break;
            }
        }
    }

    @Then("The title of page should be {string}")
    public void theTitleOfPageShouldBe(String title) {
        Helper.waitForPage(driver, Page.links.get(0));
        assertEquals(title, driver.getTitle());
    }

    @Given("The tester is on the test case dashboard")
    public void theTesterIsOnTheTestCaseDashboard() {
        TesterHome.links.get(1).click();
    }

    @When("The tester types Description into input with")
    public void theTesterTypesDescriptionIntoInputWith(String docString) {
        Helper.waitForPage(driver, TestCaseDashboard.descInput);
        TestCaseDashboard.descInput.sendKeys(docString);
    }

    @When("The tester types Steps into input with")
    public void theTesterTypesStepsIntoInputWith(String docString) {
        TestCaseDashboard.stepInput.sendKeys(docString);
    }

    @When("The tester presses the submit button")
    public void theTesterPressesTheSubmitButton() {
        TestCaseDashboard.submitButton.click();
    }

    @Then("The test case should appear at the bottom of the table")
    public void theTestCaseShouldAppearAtTheBottomOfTheTable() throws InterruptedException {
        Thread.sleep(1000);
        int length = TestCaseDashboard.descriptions.size();
        String actualDesc = TestCaseDashboard.descriptions.get(length - 1).getText();
        assertEquals("Verify that usernames cannot have illegal characters", actualDesc);
    }

    @Then("The test case result should say UNEXECUTED")
    public void theTestCaseResultShouldSayUNEXECUTED() {
        int length = TestCaseDashboard.results.size();
        String actualResult = TestCaseDashboard.results.get(length - 1).getText();
        assertEquals("UNEXECUTED", actualResult);
    }

    @When("The tester presses on details")
    public void theTesterPressesOnDetails() {
        int length = TestCaseDashboard.detailsButtons.size();
        System.out.println(length);
        for (int i = 0; i < length; ++i) {
            System.out.println(TestCaseDashboard.detailsButtons.get(i).getText());
        }
        TestCaseDashboard.detailsButtons.get(length - 1).click();
    }

    @Then("A test case modal should appear showing the case ID")
    public void aTestCaseModalShouldAppearShowingTheCaseID() {
        Helper.waitForPage(driver, TestCaseDashboard.modal);
    }

    @Then("The performed by field should say No One")
    public void thePerformedByFieldShouldSayNoOne() {
        assertEquals("No One", TestCaseDashboard.modalPerformedBy.getText());
    }

    @When("The tester presses the modal close button")
    public void theTesterPressesTheCloseButton() {
        TestCaseDashboard.modalClose.click();
    }

    @Then("The Modal Should be closed")
    public void theModalShouldBeClosed() {
        throw new io.cucumber.java.PendingException();
    }

    @When("The Tester clicks on edit within the modal")
    public void theTesterClicksOnEditWithinTheModal() {
        TestCaseDashboard.modalEdit.click();
    }

    @Then("The Tester should be on the case editor for that case")
    public void theTesterShouldBeOnTheCaseEditorForThatCase() {
        assertEquals("Case Editor", driver.getTitle());
    }

    @When("The tester clicks on the edit button")
    public void theTesterClicksOnTheEditButton() {
        CaseEditor.editButton.click();
    }

    @When("The tester types in {string} into the description text area")
    public void theTesterTypesInIntoTheDescriptionTextArea(String string) {
        CaseEditor.description.sendKeys(string);
    }

    @When("The tester types in {string} into the steps text area")
    public void theTesterTypesInIntoTheStepsTextArea(String string) {
        CaseEditor.steps.sendKeys(string);
    }

    @When("The tester clicks on the automated check mark")
    public void theTesterClicksOnTheAutomatedCheckMark() {
        CaseEditor.automatedCheck.click();
    }

    @When("The tester selects {string} for performed from drop down")
    public void theTesterSelectsForPerformedFromDropDown(String string) {
        Select select = new Select(CaseEditor.performedDrop);
        select.selectByVisibleText("string");
    }

    @When("The tester selects {string} for test result from drop down")
    public void theTesterSelectsForTestResultFromDropDown(String string) {
        Select select = new Select(CaseEditor.resultDrop);
        select.selectByVisibleText("string");
    }

    @When("The tester types in {string} into the summary text area")
    public void theTesterTypesInIntoTheSummaryTextArea(String string) {
        CaseEditor.summary.click();
    }

    @When("The tester clicks save on test case page")
    public void theTesterClicksSaveOnTestCasePage() {
        CaseEditor.saveButton.click();
    }

    @Then("A confirmation prompt should appear")
    public void aConfirmationPromptShouldAppear() {
        String actualText = driver.switchTo().alert().getText();
        assertEquals("Are you sure you want to update the test case?", actualText);
    }

    @When("The tester clicks on Ok")
    public void theTesterClicksOnOk() {
        driver.switchTo().alert().accept();
    }

    @Then("An alert says the test case has been saved")
    public void anAlertSaysTheTestCaseHasBeenSaved() {
        String actualText = driver.switchTo().alert().getText();
        assertEquals("Test Case has been Saved", actualText);
        driver.switchTo().alert().accept();
    }

    @When("The tester clicks on the reset button")
    public void theTesterClicksOnTheResetButton() {
        CaseEditor.resetButton.click();
    }

    @Then("The fields should be populated to their old values")
    public void theFieldsShouldBePopulatedToTheirOldValues() {
        throw new io.cucumber.java.PendingException();
    }

    @Given("The tester is logged in as a tester")
    public void theTesterIsLoggedInAsATester() {
        Helper.loginAsTester(driver);
    }

    @Given("The manager is on the home page")
    public void theManagerIsOnTheHomePage() {
        ManagerHome.links.get(5).click();
    }

    @When("The manager chooses to create a new matrix")
    public void theManagerChoosesToCreateANewMatrix() {
        ManagerHome.createMatrixButton.click();
    }

    @When("The manager creates a title for the matrix")
    public void theManagerCreatesATitleForTheMatrix() {
        ManagerHome.matrixTitleInput.sendKeys("This is a test Matrix Title.");
    }

    @When("The manager adds requirements to the matrix")
    public void theManagerAddsRequirementsToTheMatrix()
    {
        ManagerHome.userStoryInput.sendKeys("This is a test User Story.");
        Select select = new Select(ManagerHome.priorityDropdown);
        select.selectByVisibleText("Low");
        ManagerHome.noteInput.sendKeys("This is a test Notes.");
        ManagerHome.addRequirementButton.click();
    }

    @When("The manager saves the matrix")
    public void theManagerSavesTheMatrix()
    {
        ManagerHome.createMatrixButton.click();
    }

    @Then("An alert with a success message should appear")
    public void anAlertWithASuccessMessageShouldAppear() throws InterruptedException
    {
        Thread.sleep(1000);
        String actualText = driver.switchTo().alert().getText();
        assertTrue(actualText.contains("Matrix"));
        driver.switchTo().alert().accept();
    }

    @Given("The manager is on the matrix homepage")
    public void theManagerIsOnTheMatrixHomepage()
    {
        Page.links.get(0).click();
    }

    @Given("The manager has selected the matrix")
    public void theManagerHasSelectedTheMatrix()
    {
        MatrixDashboard.matrixButtons.get(0).click();
    }

    @When("The manager adds a defect")
    public void theManagerAddsADefect()
    {
        throw new io.cucumber.java.PendingException();
    }

    @When("The manager confirms their changes")
    public void theManagerConfirmsTheirChanges()
    {
        throw new io.cucumber.java.PendingException();
    }

    @Then("Then the matrix should saved")
    public void thenTheMatrixShouldSaved()
    {
        throw new io.cucumber.java.PendingException();
    }

    @When("The manager adds a Test Cases")
    public void theManagerAddsATestCases()
    {
        throw new io.cucumber.java.PendingException();
    }

    @Then("The manager should see pending defects")
    public void theManagerShouldSeePendingDefects()
    {
        throw new io.cucumber.java.PendingException();
    }

    @When("The manager clicks on the select button for a defect")
    public void theManagerClicksOnTheSelectButtonForADefect()
    {
        throw new io.cucumber.java.PendingException();
    }

    @Then("The defect description should appear in bold")
    public void theDefectDescriptionShouldAppearInBold()
    {
        throw new io.cucumber.java.PendingException();
    }

    @When("The manager selects a tester from the drop down list")
    public void theManagerSelectsATesterFromTheDropDownList()
    {
        throw new io.cucumber.java.PendingException();
    }

    @When("The manager clicks assign")
    public void theManagerClicksAssign()
    {
        throw new io.cucumber.java.PendingException();
    }

    @Then("The defect should disappear from the list")
    public void theDefectShouldDisappearFromTheList()
    {
        throw new io.cucumber.java.PendingException();
    }

    @Given("The tester is on the Home Page")
    public void theTesterIsOnTheHomePage()
    {
        Page.links.get(5).click();
    }

    @Then("The tester can can see only defects assigned to them")
    public void theTesterCanCanSeeOnlyDefectsAssignedToThem()
    {
        throw new io.cucumber.java.PendingException();
    }

    @When("The tester changes to defect to any status")
    public void theTesterChangesToDefectToAnyStatus()
    {
        throw new io.cucumber.java.PendingException();
    }

    @Then("The tester should see the defect has a different status")
    public void theTesterShouldSeeTheDefectHasADifferentStatus()
    {
        throw new io.cucumber.java.PendingException();
    }

    @Given("The employee is on the Defect Reporter Page")
    public void theEmployeeIsOnTheDefectReporterPage()
    {
        Helper.loginAsTester(driver);
        Page.links.get(2).click();
        Helper.waitForPage(driver, DefectReporter.reportButton);
    }

    @When("The employee selects todays date")
    public void theEmployeeSelectsTodaysDate()
    {
        DefectReporter.dateInput.sendKeys("02242001");
    }

    @When("The employee types in description with")
    public void theEmployeeTypesInDescriptionWith(String description)
    {
        DefectReporter.descInput.sendKeys(description);
    }

    @When("The employee types in steps with")
    public void theEmployeeTypesInStepsWith(String steps)
    {
        DefectReporter.reproductionInput.sendKeys(steps);
    }

    @When("The employee selects high priority")
    public void theEmployeeSelectsHighPriority()
    {
        new Actions(driver)
                .moveToElement(DefectReporter.prioritySlider, 50, 0)
                .click()
                .perform();
    }

    @When("The employee selects low severity")
    public void theEmployeeSelectsLowSeverity()
    {
        new Actions(driver)
                .moveToElement(DefectReporter.severitySlider, -50, 0)
                .click()
                .perform();
    }

    @When("The employee clicks the report button")
    public void theEmployeeClicksTheReportButton()
    {
        DefectReporter.reportButton.click();
    }

    @Then("No confirmation dialog appears")
    public void noConfirmationDialogAppears()
    {
        assertThrows(NoAlertPresentException.class, () -> Helper.checkForAlert(driver));
    }

    @When("The employee selects {string} priority")
    public void theEmployeeSelectsPriority(String priority)
    {
        if (priority.equals("High"))
        {
            new Actions(driver)
                    .moveToElement(DefectReporter.prioritySlider, 50, 0)
                    .click()
                    .perform();
        }
        else if (priority.equals("Medium"))
        {
            new Actions(driver)
                    .moveToElement(DefectReporter.prioritySlider, -10, 0)
                    .click()
                    .perform();
        }
        else
        {
            new Actions(driver)
                .moveToElement(DefectReporter.prioritySlider, -50, 0)
                .click()
                .perform();
        }
    }

    @When("The employee selects {string} severity")
    public void theEmployeeSelectsSeverity(String severity)
    {
        if (severity.equals("High"))
        {
            new Actions(driver)
                    .moveToElement(DefectReporter.prioritySlider, 50, 0)
                    .click()
                    .perform();
        }
        else if (severity.equals("Medium"))
        {
            new Actions(driver)
                    .moveToElement(DefectReporter.prioritySlider, -10, 0)
                    .click()
                    .perform();
        }
        else
        {
            new Actions(driver)
                    .moveToElement(DefectReporter.prioritySlider, -50, 0)
                    .click()
                    .perform();
        }
    }

    @Then("There should be a confirmation box")
    public void thereShouldBeAConfirmationBox()
    {
        assertNotNull(driver.switchTo().alert());
    }

    @When("The employee clicks Ok")
    public void theEmployeeClicksOk()
    {
        driver.switchTo().alert().accept();
    }

    @Then("A modal should appear with a Defect ID")
    public void aModalShouldAppearWithADefectID()
    {
        assertNotNull(DefectReporter.modalText);
    }

    @When("The employee clicks close")
    public void theEmployeeClicksClose() throws InterruptedException {
        Thread.sleep(1000);
        DefectReporter.closeModalButton.click();
    }

    @Then("The modal should disappear")
    public void theModalShouldDisappear()
    {
        assertNull(DefectReporter.modalText);
    }
}

