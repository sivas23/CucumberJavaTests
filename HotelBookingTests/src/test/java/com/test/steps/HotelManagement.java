package com.test.steps;

import static org.junit.Assert.*;

import java.util.List;

import com.test.pages.HotelManagementPlatform;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HotelManagement extends Common {

	public HotelManagementPlatform hotelManagementPlatformPage;
	public static long currentRowCount;
	public static String SavedHotelName;
	
	public HotelManagement(){
		hotelManagementPlatformPage = new HotelManagementPlatform(driver);
	}
	
	@Given("^I am a loggedIn user on hotel management platform portal page$")
	public void i_am_a_loggedIn_user_on_hotel_management_platform_portal_page() throws Throwable {
		hotelManagementPlatformPage.gotoHomePage();
		assertEquals("Hotel Management Platform", hotelManagementPlatformPage.getPageTitle());
		hotelManagementPlatformPage.loginUser("admin","password");
		
	}

	@When("^I fill the hotel details as \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void i_fill_the_hotel_details_as(String hotelName, String address, String owner, String phoneNumber, String email) throws Throwable {
		SavedHotelName=hotelName;
		hotelManagementPlatformPage.fillAllHotelEntries(hotelName, address, owner, phoneNumber, email);
	}

	@When("^I click on Create button$")
	public void i_click_on_Create_button() throws Throwable {
		currentRowCount=hotelManagementPlatformPage.getRowCount();
		hotelManagementPlatformPage.clickonCreate();
		
	}

	@Then("^I should be able to see the hotel details are saved$")
	public void i_should_be_able_to_see_the_hotel_details_are_saved() throws Throwable {
		assertEquals(currentRowCount+1, hotelManagementPlatformPage.getRowCount());
	}

	@When("^I delete the above saved record$")
	public void i_delete_the_above_saved_record() throws Throwable {
		hotelManagementPlatformPage.clickOnDelete(SavedHotelName);
	}

	@Then("^I should not see deleted record in the page$")
	public void i_should_not_see_deleted_record_in_the_page() throws Throwable {
		List<String> firstNames= hotelManagementPlatformPage.getListOfSavedHotelNames();
		assertFalse(firstNames.contains(SavedHotelName));
	}

	@When("^I delete all entries$")
	public void i_delete_all_entries() throws Throwable {
		hotelManagementPlatformPage.deleteAllEntries();
	}

	@Then("^I should see zero records in the page$")
	public void i_should_see_zero_records_in_the_page() throws Throwable {
		assertEquals(0, hotelManagementPlatformPage.getRowCount());
	}
	
}
