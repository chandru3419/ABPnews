package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddonsPAge {
	
	public AddonsPAge(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[@data-testid='add-ons-continue-footer-button'])[3]")
	private WebElement AddOnCont;

	public WebElement getAddOnCont() {
		return AddOnCont;
	}
	

}
