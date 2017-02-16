package com.test.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Shared extends Common{

	
	@After  
    public void embedScreenshot(Scenario scenario) {  
        if (scenario.isFailed()) {  
        	System.out.println(("Scenario Failed"));
            try {  
            	byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            	scenario.embed(bytes, "image/png");
            } catch (WebDriverException wde) {  
                System.err.println(wde.getMessage());  
            } catch (ClassCastException cce) {  
                cce.printStackTrace();  
            } catch (Exception e){
            	e.printStackTrace();
            }
        }  else{
        	System.out.println("Scenario Passed");
        }
        //driver.close();
        //driver=null;
    }
	
	
	@Before
	public void deleteCookies() { 
		try
		{
			driver.manage().deleteAllCookies();
		}
		catch(WebDriverException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
