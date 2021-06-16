/**
 * 
 */
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author hyuge_weeb
 *
 */
public class ZwiftHomePage {
	WebDriver driver;
	
	@FindBy(id="truste-consent-button")
	public WebElement trusteConsentBtn;
	
	@FindBy(className="Cfgd8NjXNUtPXlfUoSI6Z")
	public WebElement signInHref;
	
	@FindBy(className="_1y_LNCV6bN8pLbpzSLHKCd")
	WebElement sideNavigationBtn;
	
	@FindBy(xpath="//*[@id=\"side-nav\"]/div[2]/div[2]/div/div[1]/ul[2]/li[1]/a")
	WebElement eventsHref;
	// I'm not a huge fan of this but I don't have access to your test-ids obviously
	
	
	public ZwiftHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSideNavigation() {
		
		sideNavigationBtn.click();
	}
	
	public void navigateToEventsPage() {
		
		sideNavigationBtn.click();
		eventsHref.click();
	}
	
	

}
