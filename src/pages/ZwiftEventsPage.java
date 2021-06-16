/**
 * 
 */
package pages;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author alegarpa
 *
 */

public class ZwiftEventsPage {
	
	
	/**
	 * Constructors
	 */
	WebDriver driver;
	Actions actions;
	WebDriverWait wait;
	HashMap<String, WebElement> orignal_events_list;
	
	
	
	/**
	 * "Test-ids"
	 */
	@FindBy(className="filter-toggle")
	public WebElement filter_toggle_btn;
	
	@FindBy(xpath="//*[text()='All']")
	public WebElement all_filter_btn;
	
	@FindBy(xpath="//*[text()='Cycling']")
	public WebElement cycling_filter_btn;
	
	@FindBy(xpath="//*[text()='Running']")
	public WebElement running_filter_btn;
	
	@FindBy(xpath="//*[text()='Morning']")
	public WebElement morning_filter_btn;
	
	@FindBy(xpath="//*[text()='Evening']")
	public WebElement afternoon_filter_btn;
	
	@FindBy(xpath="//*[text()='Evening']")
	public WebElement evening_filter_btn;
	
	@FindBy(xpath="//*[text()='Night']")
	public WebElement night_filter_btn;
	
	@FindBy(xpath="//*[text()='A']")
	public WebElement a_filter_btn;
	
	@FindBy(xpath="//*[text()='B']")
	public WebElement b_filter_btn;
	
	@FindBy(xpath="//*[text()='C']")
	public WebElement c_filter_btn;
	
	@FindBy(xpath="//*[text()='D']")
	public WebElement d_filter_btn;
	
	@FindBy(xpath="//*[text()='E (Open)']")
	public WebElement e_filter_btn;
	
	@FindBy(xpath="//*[@id=\"zwift-events\"]/div[1]/div/div/div/div[3]/button[2]")
	public WebElement apply_event_filter_btn;
	
	@FindBy(className="events-column")
	public WebElement events_column;
	
	/**
	 * @param driver The Selenium webDriver we'll attach our webElements too. 
	 */
	public ZwiftEventsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actions = new Actions(this.driver);
		this.wait = new WebDriverWait(this.driver, 10);
		this.orignal_events_list = new HashMap<String, WebElement>();
		
		
	}
	
	public void moveToPageElement(WebElement element) {
		
		this.actions.moveToElement(element);
		this.actions.perform();
	}
	
	
	public boolean isClassActive(WebElement webelement) {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(webelement));
		return webelement.getAttribute("class").contains("active");
		
	}
	
	public void waitForClickThenClick(WebElement webelement) {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(webelement));
		this.moveToPageElement(webelement);
		webelement.click();
		
	}
		
	
	/**
	 * 
	 * Populates this.orignal_events_list to keep track of all the events generated in the EventsPage.
	 * 
	 */
	public void populateEventsList () {
		
		this.wait.until(ExpectedConditions.visibilityOf(events_column));
		
		List<WebElement> tab_list_elements = this.driver.findElements(By.className("header-title"));
		
		if (tab_list_elements.size() > 0) {
		
			for(int i=0; i < tab_list_elements.size(); i++) {
				
				this.orignal_events_list.put(tab_list_elements.get(i).getText(), tab_list_elements.get(i));
				
			}
		}
		
	}
	
	
	
	/**
	 * 
	 * Compares the list with the HashMap generated when called:
	 * 
	 * this.populateEventsList()
	 * 
	 * @return If the event list matches the one saved. 
	 */
	public boolean compareCurrentEventListWithSaved() {
		
		List<WebElement> tab_list_elements = this.driver.findElements(By.className("header-title"));
		
		if(tab_list_elements.size() != this.orignal_events_list.size()) {
			return true;
		}
		
		for(int i=0; i < tab_list_elements.size(); i++) {
			
			if (!this.orignal_events_list.containsKey(tab_list_elements.get(i).getText())) {
				return true;
			}
		}
		return false;
			
		}
	
}
