@Regression
Feature: Hotel Booking Create & Delete Entry

  Scenario Outline: verifying create and delete entry
    Given I am a loggedIn user on hotel management platform portal page
    When I fill the hotel details as "<HotelName>", "<Address>","<Owner>","<PhoneNumber>","<Email>"
    And I click on Create button
    Then I should be able to see the hotel details are saved
    When I delete the above saved record
    Then I should not see deleted record in the page

    Examples: 
      | HotelName | Address | Owner     | PhoneNumber | Email           |
      | Siva      | London  | Sirigiri  |  1234567890 | test@test.com   |
      | Siva1     | London1 | Sirigiri1 |  1234567891 | test1@test1.com |
