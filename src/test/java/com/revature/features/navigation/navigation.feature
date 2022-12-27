Feature: Navigation

# Depending on how the associates code this one, all or most of the scenarios should fail. Naming conventions
# Naming conventions in this feature file do not match the actual web pages

    Background: Logged in as a Manager
        Given The manager is logged in as a manager
    
    Scenario: Home Page Links Visible
        Then The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview 

    Scenario: Back Navigation
        When The manager clicks on Matrices 
        Then The manager should be on the matrices page
        When The manager clicks the browser back button 
        Then The manager should be on the home page
        When The manager clicks on Test Cases
        When The manager clicks the browser back button 
        Then The manager should be on the home page
    
    Scenario Outline: All Links Viable 
        When The manager clicks on "<link>"
        Then The title of page should be "<title>"
    
    Examples:
        | link           | title               |
        | Matrices       | Matrix Dashboard    |
        | Test Cases     | Test Cases          |
        | Report a Defect| Case Reporter       |
        | Defect Overview| Case Overview       |



