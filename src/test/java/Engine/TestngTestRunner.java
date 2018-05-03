package Engine;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.TestNGCucumberRunner;
import generics.Constant;
import generics.WebdriverGenerics;



@CucumberOptions(features="src/test/java/EngineFeatures/",
format= {"pretty","html:target/Destination"},
tags={"@CaseSetup"}
)

public class TestngTestRunner {

	@Parameters({"browserType","URL"})
	@BeforeMethod
	public void beforeMethod(String browserType,String URL){
		
		
		Constant.setDriverPath();
		Constant.URL=URL;
		WebdriverGenerics.OpenBrowser(browserType);
		
	}
	
	@Test(groups = "cucumber", description = "Runs Cucumber Features")
	public void run_cukes() throws IOException {
	  new TestNGCucumberRunner(getClass()).runCukes();
	}
	
	@AfterMethod
	public void afterMethod(){
		WebdriverGenerics.QuitBrowser();
		System.out.println("All browsers are Finally Closed and Execution is completed");
	}
}
