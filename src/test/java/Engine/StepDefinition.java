package Engine;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import businesscomponent.Logics;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import generics.Constant;
import generics.WebdriverGenerics;

public class StepDefinition {
	
	@After()
	public void embedScreenshot(Scenario scenario) {
		
		 if (scenario.isFailed()) {
		        try {
		            byte[] screenshot = ((TakesScreenshot) Constant.driver).getScreenshotAs(OutputType.BYTES);
		            scenario.embed(screenshot, "image/png" );
		            scenario.write("URL at failure: " + Constant.driver.getCurrentUrl());
		            scenario.write("Failed Scenario name: " +scenario.getName());
		            scenario.write("Date and Time at failure: " +WebdriverGenerics.getCurrentDate()+"- "+WebdriverGenerics.getCurrentTime());
		            
		        } catch (WebDriverException wde) {
		        	scenario.write("Embed Failed " + wde.getMessage());
		        } catch (ClassCastException cce) {
		            cce.printStackTrace();
		        }
		    }
		
	}

	Logics logics=new Logics();
	
	@Given("^I am navigating to site$")
	public void NavigateToSite(){
	   WebdriverGenerics.GetURL(Constant.URL);
	   WebdriverGenerics.WaitImplicitlyForPageToLoad();
	}
	
	@And("^Select kind of Trip as \"(.*?)\"$")
	public void selectTripKind(String TripType){
		logics.SelectTripWithGivenType(TripType);
	}
	
	@And("^Select Booking From \"(.*?)\" to \"(.*?)\"$")
	public void selectBookingFrom(String From,String To) throws InterruptedException{
		logics.SelectBookingWithparams(From, To);
	}
	
	
	@And("^Select DepartDate as \"(.*?)\" and ReturnDate as \"(.*?)\"$")
	public void selectDapartAndReturn(String Depart,String Return) throws InterruptedException{
		logics.SelectDepartAndReturn(Depart, Return);
	}
	
	@And("^Click on Search button$")
	public void clickOnSearchButton() throws InterruptedException{
		logics.ClickOnSearchButtonOnFirstPage();
	}
	
	
	@And("^Conform Booking from Second Page$")
	public void conformBookingSecondPage() throws InterruptedException{
		logics.ClickOnBookButton();
	}
	
	@And("^Pass Itenerary on Third page$")
	public void PassItenary() throws InterruptedException{
		logics.PassItenary();
	}
	
	@And("^Fill Traveller information as \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" and Continue to payment$")
	public void TravellerInformation(String title,String Fname,String Lname,String Mnumber) throws InterruptedException{
		logics.PassTraveller(title, Fname, Lname, Mnumber);
	}
	
	@Then("^Conform the payment option is Displayed$")
	public void PaymentValidation() throws InterruptedException {
		logics.PaymentValidation();
		
	}
	
}
