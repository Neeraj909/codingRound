package TestVagrant.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import org.testng.Assert;

public class HotalBookingPage extends Page {
   
    @FindBy(id = "hotelApp ")
    private WebElement hotelLink;
    
    @FindBy(id = "Tags")
    private WebElement localityTextBox;
    
    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;
    
    @FindBy(xpath="//input[@title='Check-out date']//following-sibling::i")
    private WebElement CheckoutDropDown;
    
    @FindBy(xpath="//input[@id='CheckInDate']//following-sibling::i")
    private WebElement CheckInDropDown;
    
    public void  CheckoutDropDown() {
		CheckoutDropDown.click();
	}
	public void CheckInDropDown() {
		CheckInDropDown.click();
	}

	
	@FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    public HotalBookingPage (WebDriver driver) {
        super(driver);

    }

    public void clickHotels1Link () {
        wait.until(ExpectedConditions.visibilityOf(hotelLink));
        hotelLink.click();
      
    }

    public void localityTextBox (String hotelLocation) {
        wait.until(ExpectedConditions.visibilityOf(localityTextBox));
        localityTextBox.clear();
        localityTextBox.sendKeys(hotelLocation);
        Assert.assertEquals(localityTextBox.getAttribute("value"), hotelLocation);
    }

    public void searchHotal () {
        
        searchButton.click();

    }


    public boolean isHotelLinkDisplayed () {
        return hotelLink.isDisplayed() && hotelLink.isEnabled();
    }

    public boolean isLocalityTextBoxDisplayed () {
        return localityTextBox.isDisplayed() && localityTextBox.isEnabled();
    }

    public boolean isSearchButtonDisplayed () {
        return searchButton.isDisplayed() && searchButton.isEnabled();
    }

    public boolean isTravelerSelectionDisplayed () {

        return travellerSelection.isDisplayed() && travellerSelection.isEnabled();
    }
}
