Feature: Test ASC Allstate

  @Smoke_Test
  Scenario: Validate User can select Renters Button and Insert a zip
    Given The User Navigates to ASC welcome Page
    Then the user navigates with valid renters flow

  @Smoke_Test
  Scenario: Should not allow user to start a quote with Renter/Home selected
    Given The User Navigates to ASC welcome Page
    When the user selects both renters and home

  @Smoke_Test
  Scenario: Should not allow user to start a quote with Renter/Condo selected
    Given The User Navigates to ASC welcome Page
    Then the user selects both renters and condo

  @Smoke_Test
  Scenario: Should show user an error when ZIP is not entered
    Given The User Navigates to ASC welcome Page
    Then the user tries to continue without entering ZIP

@Smoke_Test
  Scenario: Should show user an error when no product is selected
    Given The User Navigates to ASC welcome Page
    Then the user tries to continue without selecting a product

  @Smoke_Test_1
  Scenario: Expect Save upto 25% when you bundle Message appears when Auto & Home are selected'
    Given The User Navigates to ASC welcome Page
    Then the user should see the bundle message

