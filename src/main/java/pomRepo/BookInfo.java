package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookInfo {
	public BookInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//input[@data-testid='first-inputbox-contact-details']")
	private WebElement firstNameTF;
	
	@FindBy(xpath="//input[@data-testid='last-inputbox-contact-details']")
	private WebElement lastNameTF;
	
	@FindBy(xpath="//input[@data-testid='contact-number-input-box']")
	private WebElement phNOTF;
	
	@FindBy(xpath="//input[@data-testid='emailAddress-inputbox-contact-details']")
	private WebElement emailTF;
	
	@FindBy(xpath="//input[@data-testid='city-inputbox-contact-details']")
	private WebElement cityTF;
	
	
	@FindBy(xpath="//div[.='I am flying as the primary passenger']/preceding-sibling::div[@class='css-1dbjc4n r-zso239']")
	private WebElement chkBox;
	
	@FindBy(xpath="//div[.='Continue']")
	private WebElement contBtn;
	
	public WebElement getChkBox() {
		return chkBox;
	}

	public WebElement getContBtn() {
		return contBtn;
	}

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getPhNOTF() {
		return phNOTF;
	}

	public WebElement getEmailTF() {
		return emailTF;
	}

	public WebElement getCityTF() {
		return cityTF;
	}

	public WebElement getFirstNameTF() {
		return firstNameTF;
	}
	
	

}
