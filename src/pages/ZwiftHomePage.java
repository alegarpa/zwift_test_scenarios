/**
 * 
 */
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author alegarpa
 *
 */
public class ZwiftHomePage {
	
	/**
	 * Constructors
	 */
	WebDriver driver;
	Actions actions;
	WebDriverWait wait;
	
	
	/**
	 * "Test-ids"
	 */
	@FindBy(id="truste-consent-button")
	public WebElement trusteConsentBtn;
	
	@FindBy(className="Cfgd8NjXNUtPXlfUoSI6Z")
	public WebElement signInHref;
	
	@FindBy(className="_1y_LNCV6bN8pLbpzSLHKCd")
	public WebElement sideNavigationBtn;
	
	@FindBy(className="solvvy-chat-icon solvvy-support-flow-link")
	public WebElement supportBtn;
	
	// I'm not a huge fan of the below but I don't have access your test-ids obviously
	@FindBy(xpath="//*[@id=\"__next\"]/div/div[1]/div[2]/header/div/nav/ul[1]/li[3]/div/a/span")
	public WebElement communityHref;
	
	@FindBy(xpath="//*[@id=\"side-nav\"]/div[2]/div[2]/div/div[1]/ul[2]/li[1]/a")
	public WebElement eventsHref;
	
	@FindBy(xpath="//*[@id=\"__next\"]/div/div[1]/div[4]/div/div/footer/div[1]/div[5]/dl/dd[1]/a")
	public WebElement careersHref;
	
	@FindBy(xpath="//*[@id=\"__next\"]/div/div[1]/div[3]/div[5]/div/div/div[1]/div[2]/div/div/div/div[2]/span/button")
	public WebElement learn_more_community_btn;
	
	
	
	/**
	 * @param driver The Selenium webDriver we'll attach our webElements too. 
	 */
	public ZwiftHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actions = new Actions(this.driver);
		this.wait = new WebDriverWait(this.driver, 10);
	}
	
	public void clickOnSideNavigation() {
		
		sideNavigationBtn.click();
	}
	
	//If I had more time I'd make a base class but I want to respect the 72 hour window.
	public void moveToPageElement(WebElement element) {
		
		this.actions.moveToElement(element);
		this.actions.perform();
	}
	
	 
	public void navigateToEventsPage() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(sideNavigationBtn));
		sideNavigationBtn.click();
		this.wait.until(ExpectedConditions.elementToBeClickable(eventsHref));
		eventsHref.click();
	}
	
	

}
