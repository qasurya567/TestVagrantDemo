package pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebElements {

	final WebDriver driver;	
	WebElement element;
	
	@FindBy(xpath="//ul[li[label[@title='One way']]]/li")
	public List<WebElement> trip_type;
	
	@FindBy(xpath="//div[@id='ORtrip']/section[1]//span")
	public List<WebElement> trip_locator;
	
	@FindBy(id="DepartDate")
	public WebElement Depart_on;
	
	@FindBy(id="ReturnDate")
	public WebElement Return_on;
	
	@FindBy(id="SearchBtn")
	public WebElement searchbtn;
	
	@FindBy(xpath="//div[@id='ResultContainer_1_1']/section[2]/section/div/form/section[2]/div[3]/div[3]/button")
	public List<WebElement> bookbtns;
	
	@FindBy(xpath="//p[contains(text(),'Book in three simple steps')]")
	public WebElement ValidationPage3Element;
	
	@FindBy(id="itineraryBtn")
	public WebElement continuebtn;
	
	@FindBy(id="insurance_confirm")
	public WebElement insuranceConform;
	
	@FindBy(id="username")
	public WebElement userName;
	
	@FindBy(id="LoginContinueBtn_1")
	public WebElement loginContinueBtn;
	
	@FindBy(name="AdultTitle1")
	public WebElement Title;
	
	@FindBy(name="AdultFname1")
	public WebElement Fname;
	
	@FindBy(name="AdultLname1")
	public WebElement Lname;
	
	@FindBy(xpath="//div[@id='travellerOpen']//form/dl[1]//input[1]")
	public WebElement mobilenumber;
	
	@FindBy(id="travellerBtn")
	public WebElement trvellerbtn;
	
	@FindBy(id="paymentTitle")
	public WebElement paymenttext;
	
	public WebElements(WebDriver driver){
		this.driver=driver;
	}
}
