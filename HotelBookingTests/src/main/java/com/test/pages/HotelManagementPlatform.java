package com.test.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.test.configutils.LoadProperties;

public class HotelManagementPlatform {
	
private WebDriver driver;
	
	@FindBy(css=".navbar-brand")
    private WebElement pageTitle;
	
	@FindBy(css=".nav.navbar-nav>li>a[data-target='#myModal']")
    private WebElement login;

	@FindBy(id="username")
    private WebElement userNameTextBox;

	@FindBy(id="password")
    private WebElement passwordTextBox;

	@FindBy(id="doLogin")
    private WebElement loginButton;

	@FindBy(id="hotelName")
    private WebElement hotelNameTextBox;
	
	@FindBy(id="address")
    private WebElement addressTextBox;

	@FindBy(id="owner")
    private WebElement ownerTextBox;

	@FindBy(id="phone")
    private WebElement phoneTextBox;

	@FindBy(id="email")
    private WebElement emailTextBox;

	@FindBy(id="createHotel")
    private WebElement createBtn;

	@FindBy(css=".row.detail>div.col-sm-1>span")
    private List<WebElement> deleteRows;

	
	public HotelManagementPlatform(WebDriver driver){
		 ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 30);
	     PageFactory.initElements(finder, this);
		 this.driver = driver;
	}

	
	public void clickLogin(){
		login.click();
	}
	
	
	public String getPageTitle(){
		return pageTitle.getText();
	}
	
	public void gotoHomePage() {
		driver.get(LoadProperties.getWebEndPoint());
	}
	
	public void clickOnDelete(String text){
		driver.findElement(By.xpath(".//*[@class='row detail']/div/div[1]/p[text()='"+text+"']/ancestor::div[@class='hotelRow']/following-sibling::div/span")).click();;
	}
	
	public long getRowCount() {
		//return driver.findElements(By.cssSelector(".row.detail")).size();
		long count = -1;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			count= (Long) js.executeScript("return window.jQuery('.row.detail').size()");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			count =0;
		}
		return count;
	}


	public List<String> getListOfSavedHotelNames() {
		List<String> listofNames=new ArrayList<String>();
		if(getRowCount()==0)
		{
			return listofNames;
		}
		List<WebElement> elements= driver.findElements(By.xpath(".//*[@class='row detail']/div/div[1]/p"));
		for(WebElement e:elements){
			listofNames.add(e.getText());
		}
		return listofNames;
	}


	public void loginUser(String username, String password) {
		clickLogin();
		userNameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		loginButton.click();
	}

	public void fillAllHotelEntries(String hotelName, String address, String owner, String phoneNumber, String email){
		hotelNameTextBox.sendKeys(hotelName);
		addressTextBox.sendKeys(address);
		ownerTextBox.sendKeys(owner);
		phoneTextBox.sendKeys(phoneNumber);
		emailTextBox.sendKeys(email);
	}

	public void clickonCreate() {
		createBtn.click();
	}

	public void deleteAllEntries() {
		int count=deleteRows.size();
		for(int i=0;i<count;i++){
			WebElement e=driver.findElement(By.xpath(".//*[@class='row detail'][1]/div[2]/span"));
			e.click();
		}
	}
}
