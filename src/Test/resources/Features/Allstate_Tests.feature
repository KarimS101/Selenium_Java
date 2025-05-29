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

