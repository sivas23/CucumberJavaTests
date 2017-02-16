@DeleteEntry
Feature: Hotel Booking - Delete All Entries

  Scenario: verifying delete all entries
    Given I am a loggedIn user on hotel management platform portal page
		When I delete all entries
		Then I should see zero records in the page