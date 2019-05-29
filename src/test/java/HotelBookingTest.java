package TestVagrant.autotest;


import TestVagrant.basetest.BaseTest;
import TestVagrant.page.FlightBookingPage;
import TestVagrant.page.HotalBookingPage;
import TestVagrant.page.Page;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HotelBookingTest extends BaseTest {

	WebDriver driver = null;
	WebDriverWait wait = null;
	HotalBookingPage Hotel = null;
	Page page = null;
	FlightBookingPage Flight = null;
	Properties prop=null;
	

	@BeforeClass
	public void init() {
		driver = getWebdriver();
		wait = getWait();
		Hotel = PageFactory.initElements(driver, HotalBookingPage.class);
		page = PageFactory.initElements(driver, Page.class);
		Flight = PageFactory.initElements(driver, FlightBookingPage.class);
		prop=getProp();
	}

	@Test
	public void testThatResultsAppearForAOneWayJourney() throws InterruptedException {
		String title = page.getPageTitle();
		assertTrue(title.contains("#1 Site"));
		
		Hotel.clickHotels1Link();
		Hotel.localityTextBox(prop.getProperty("HotelCity"));
		Hotel.CheckInDropDown();
		Flight.typeDepartDate(Integer.parseInt(prop.getProperty("CheckInDate")), Integer.parseInt(prop.getProperty("CheckInMomth")), Integer.parseInt(prop.getProperty("CheckInYear")));
		Thread.sleep(5000);
		Flight.typeDepartDate(Integer.parseInt(prop.getProperty("CheckOutDate")), Integer.parseInt(prop.getProperty("CheckOutMomth")), Integer.parseInt(prop.getProperty("CheckOutYear")));
        Hotel.isTravelerSelectionDisplayed();
        Hotel.searchHotal();
	}
   
}
