package zwift_test_scenarios;

import org.junit.jupiter.api.AfterEach;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SauceLabsHomePageTest {

	 @BeforeEach
	   void setUp() {
	   }

	   @BeforeEach
	   void tearDown() {
	   }

	   //@Test
	   public void site_header_is_on_home_page() {   
	       System.setProperty("webdriver.chrome.driver","chromedriver.exe");   
	       WebDriver browser = new ChromeDriver();
	       browser.get("https://www.zwift.com/");
	       WebElement consent_btn = browser.findElement(By.id("truste-consent-button"));
	       if (consent_btn.isDisplayed() ){
	    	   consent_btn.click();
	       }
	       
	       WebElement sign_in_href = browser.findElement(By.className("Cfgd8NjXNUtPXlfUoSI6Z"));
	       assertTrue((sign_in_href.isDisplayed()));
	       browser.close();
	}
	   
	@Test
	public void events_page_reachable() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");   
	    WebDriver browser = new ChromeDriver();
	    browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    browser.get("https://www.zwift.com/");
	    WebElement consent_btn = browser.findElement(By.id("truste-consent-button"));
	       if (consent_btn.isDisplayed() ){
	    	   consent_btn.click();
	       }
	    WebElement side_navigation_btn = browser.findElement(By.className("_1y_LNCV6bN8pLbpzSLHKCd"));
	    if (side_navigation_btn.isDisplayed() ){
	    	side_navigation_btn.click();
	    }
	    Thread.sleep(1000);
	    WebElement events_href = browser.findElement(By.xpath("//*[@id=\"side-nav\"]/div[2]/div[2]/div/div[1]/ul[2]/li[1]/a"));
	    if (events_href.isDisplayed() ){
	    	events_href.click();
	    }
	    Thread.sleep(1000);
	    WebElement filter_toggle_btn = browser.findElement(By.className("filter-toggle"));
	    if (filter_toggle_btn.isDisplayed() ){
	    	filter_toggle_btn.click();
	    }
	    
	    browser.close();
	    
	}

}
