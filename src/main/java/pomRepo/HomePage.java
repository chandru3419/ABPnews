package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[text()='From']")
	private WebElement fromTxtfld;
	
	@FindBy(xpath="//div[text()='Search Flight']")
	private WebElement searchBtn;
	

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getFromTxtfld() {
		return fromTxtfld;
	}

	
	
	
	

}
