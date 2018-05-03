package businesscomponent;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generics.Constant;
import generics.WebdriverGenerics;
import pagefactory.WebElements;

public class Logics extends WebdriverGenerics{
   
	WebElements elements=PageFactory.initElements(Constant.driver, WebElements.class);
	
	public void SelectTripWithGivenType(String TripType){
		System.out.println("Selecting Trip Type as :"+TripType);
		List<WebElement> all_trips=elements.trip_type;
		for(int i=0;i<all_trips.size();i++){
			String ActualTripType=GetTextFromWebelement(all_trips.get(i));
			if(ActualTripType.equalsIgnoreCase(TripType)){
				ClickOnWebelements(all_trips.get(i));
			}
		}
		WaitImplicitlyForPageToLoad();
	}
	
	public void SelectBookingWithparams(String From,String To) throws InterruptedException{
		System.out.println("Selecting Booking from "+From+" to "+To);
		List<WebElement> trip_locators=elements.trip_locator;
		SendTextToElementUsingAction(trip_locators.get(0), From);
		PressEnterNow(trip_locators.get(0));
		SendTextToElementUsingAction(trip_locators.get(1), To);
		PressEnterNow(trip_locators.get(1));
		WaitImplicitlyForPageToLoad();
	}
	
	public void SelectDepartAndReturn(String Depart , String Return){
		System.out.println("Selecting Depart and Return from "+Depart+" to "+Return);
		if(CheckElementVisibility(elements.Depart_on)){
			SendTextToElementUsingAction(elements.Depart_on,Depart);
			PressEnterNow(elements.Depart_on);
		}
		if(CheckElementVisibility(elements.Return_on)){
			PerformClearTextToInputField(elements.Return_on);
			SendTextToElementUsingAction(elements.Return_on,Return);
			PressEnterNow(elements.Return_on);
		}
		WaitImplicitlyForPageToLoad();
	}
	
	public void ClickOnSearchButtonOnFirstPage(){
		System.out.println("Clciking on Search button on First Page");
		if(CheckElementVisibility(elements.searchbtn)){
			ClickOnWebelements(elements.searchbtn);
		}
		WaitImplicitlyForPageToLoad();
	}
	
	public void ClickOnBookButton(){
		System.out.println("Confoming the Booking from page2");
		ExplicitlyWaitForElement(elements.bookbtns.get(0));
		List<WebElement> list=elements.bookbtns;
		ClickOnWebelements(list.get(0));
		WaitImplicitlyForPageToLoad();
	}
	
	public void PassItenary() throws InterruptedException{
		System.out.println("Pass Itenary by Clicking on Continue at Bottom Of the Page");
		ExplicitlyWaitForElement(elements.continuebtn);
		if(CheckElementVisibility(elements.insuranceConform)){
			ClickOnWebelements(elements.insuranceConform);
		}
		ClickOnWebelements(elements.continuebtn);
		Thread.sleep(5000);
		if(CheckElementVisibility(elements.userName)){
			SendTextToElement(elements.userName, "RANDOMTESTAUTOMATION@mailinator.com");
			ClickOnWebelements(elements.loginContinueBtn);
		}
		WaitImplicitlyForPageToLoad();
	}
	
	public void PassTraveller(String title,String Fname,String Lname,String MobileNumber) throws InterruptedException{
		System.out.println("Filling Traveller Information");
		WaitImplicitlyForPageToLoad();
		Thread.sleep(5000);
		if(CheckElementVisibility(elements.trvellerbtn)){
			SelectFromDropBox(elements.Title, title);
			SendTextToElement(elements.Fname, Fname);
			SendTextToElement(elements.Lname, Lname);
			SendTextToElement(elements.mobilenumber, MobileNumber);
			ClickOnWebelements(elements.trvellerbtn);
		}
		WaitImplicitlyForPageToLoad();
	}
	
	public void PaymentValidation() throws InterruptedException{
		System.out.println("Validating Payment option is Displayed");
		ExplicitlyWaitForElement(elements.paymenttext);
		
		Thread.sleep(5000);
	    Assert.assertTrue(CheckElementVisibility(elements.paymenttext));
	    
	}
}
