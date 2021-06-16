package zwift_test_scenarios;

import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ZwiftEventsPage;
import pages.ZwiftHomePage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ZwiftTakeHomeTestCases {
	
	WebDriver driver;
	
	ZwiftHomePage testZwiftHomePage;
	
	ZwiftEventsPage testZwiftEventPage;
	
	

	 @BeforeEach
	 void setUp() {
		 System.setProperty("webdriver.chrome.driver","chromedriver.exe");   
	      driver = new ChromeDriver();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.get("https://www.zwift.com/");
	      testZwiftHomePage = new ZwiftHomePage(driver);
	      if (testZwiftHomePage.trusteConsentBtn.isDisplayed() ){
	    	   testZwiftHomePage.trusteConsentBtn.click();
	      }
		 
		 
	 }

	  @AfterEach
	  void tearDown( ) {
		   driver.close();
	   }

	  @Test
	  public void validate_zwift_home_page_elements() {   
	      
		  testZwiftHomePage.moveToPageElement(testZwiftHomePage.signInHref);
	      assertTrue((testZwiftHomePage.signInHref.isDisplayed()));
	      
	      testZwiftHomePage.moveToPageElement(testZwiftHomePage.sideNavigationBtn);
	      assertTrue((testZwiftHomePage.sideNavigationBtn.isDisplayed()));
	      
	      testZwiftHomePage.moveToPageElement(testZwiftHomePage.communityHref);
	      assertTrue(testZwiftHomePage.communityHref.isDisplayed());
	      
	      testZwiftHomePage.moveToPageElement(testZwiftHomePage.careersHref);
	      assertTrue(testZwiftHomePage.careersHref.isDisplayed());
	       
	       
	}
	   
	@Test
	public void test_event_filters() {

		testZwiftHomePage.navigateToEventsPage();
		
		testZwiftEventPage = new ZwiftEventsPage(driver);
		
		testZwiftEventPage.moveToPageElement(testZwiftEventPage.filter_toggle_btn);
		
		testZwiftEventPage.filter_toggle_btn.click();
		
		assertTrue(testZwiftEventPage.cycling_filter_btn.isDisplayed());
		 
		assertFalse((testZwiftEventPage.isClassActive(testZwiftEventPage.cycling_filter_btn)));
		
		testZwiftEventPage.waitForClickThenClick(testZwiftEventPage.cycling_filter_btn);
		
		assertTrue((testZwiftEventPage.isClassActive(testZwiftEventPage.cycling_filter_btn)));
		
		testZwiftEventPage.waitForClickThenClick(testZwiftEventPage.running_filter_btn);
		
		assertTrue((testZwiftEventPage.isClassActive(testZwiftEventPage.running_filter_btn)));
			
		assertFalse((testZwiftEventPage.isClassActive(testZwiftEventPage.cycling_filter_btn)));
		
		testZwiftEventPage.waitForClickThenClick(testZwiftEventPage.night_filter_btn);
		
		assertTrue((testZwiftEventPage.isClassActive(testZwiftEventPage.night_filter_btn)));
		
		testZwiftEventPage.waitForClickThenClick(testZwiftEventPage.evening_filter_btn);
		
		assertTrue((testZwiftEventPage.isClassActive(testZwiftEventPage.evening_filter_btn)));
		
		assertFalse((testZwiftEventPage.isClassActive(testZwiftEventPage.night_filter_btn)));
		
		testZwiftEventPage.waitForClickThenClick(testZwiftEventPage.b_filter_btn);
		
		assertTrue((testZwiftEventPage.isClassActive(testZwiftEventPage.b_filter_btn)));
		
		testZwiftEventPage.waitForClickThenClick(testZwiftEventPage.e_filter_btn);
		
		assertTrue((testZwiftEventPage.isClassActive(testZwiftEventPage.e_filter_btn)));
		
		assertTrue((testZwiftEventPage.isClassActive(testZwiftEventPage.e_filter_btn)));
		
	}
	
	@Test
	public void test_event_filtration()  {
		
		testZwiftHomePage.navigateToEventsPage();
		
		testZwiftEventPage = new ZwiftEventsPage(driver);
		
		testZwiftEventPage.moveToPageElement(testZwiftEventPage.events_column);
		
		testZwiftEventPage.populateEventsList();
		
		testZwiftEventPage.waitForClickThenClick(testZwiftEventPage.filter_toggle_btn);
		
		testZwiftEventPage.waitForClickThenClick(testZwiftEventPage.b_filter_btn);
		
		testZwiftEventPage.waitForClickThenClick(testZwiftEventPage.cycling_filter_btn);
		
		testZwiftEventPage.waitForClickThenClick(testZwiftEventPage.afternoon_filter_btn);
		
		testZwiftEventPage.waitForClickThenClick(testZwiftEventPage.apply_event_filter_btn);
		
		assertTrue(testZwiftEventPage.compareCurrentEventListWithSaved());
		
	}

}
