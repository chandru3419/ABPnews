package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BookingPage {
	
	public BookingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[.='Continue' and @class='css-76zvg2 r-jwli3a r-1i10wst r-1kfrs79'])[2]")
	private WebElement contBtn;
	
	@FindBy(xpath="//img[@style='transform: translate(35px, -5px);']")
	private WebElement popupClose;

	public WebElement getPopupClose() {
		return popupClose;
	}

	public WebElement getContBtn() {
		return contBtn;
	}

}
