@Regression
Feature: Hotel Booking - Multiple Entries

  Scenario Outline: verifying create and delete entry
    Given I am a loggedIn user on hotel management platform portal page
    When I fill the hotel details as "<HotelName>", "<Address>","<Owner>","<PhoneNumber>","<Email>"
    And I click on Create button
    Then I should be able to see the hotel details are saved

    Examples: 
      | HotelName | Address | Owner     | PhoneNumber | Email           |
      | Siva2     | London2 | Sirigiri2 |  1234567892 | test2@test2.com |
      | Siva3     | London3 | Sirigiri3 |  1234567893 | test3@test3.com |
      | Siva4     | London3 | Sirigiri3 |  1234567893 | test3@test3.com |
      | Siva5     | London3 | Sirigiri3 |  1234567893 | test3@test3.com |
      | Siva6     | London3 | Sirigiri3 |  1234567893 | test3@test3.com |

      