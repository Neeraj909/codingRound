package TestVagrant.autotest;

import TestVagrant.basetest.BaseTest;
import TestVagrant.page.FlightBookingPage;
import TestVagrant.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

public class FlightBookingTest extends BaseTest {

	WebDriver driver = null;
	WebDriverWait wait = null;
	FlightBookingPage Flight = null;
	Page page = null;
	Properties prop=null;

	@BeforeClass
	public void init() {
		driver = getWebdriver();
		wait = getWait();
		prop=getProp();
		Flight = PageFactory.initElements(driver, FlightBookingPage.class);
		page = PageFactory.initElements(driver, Page.class);
	}

	@Test
	public void testThatResultsAppearForAOneWayJourney() {
		String title = page.getPageTitle();
		assertTrue(title.contains("#1 Site"));
		Assert.assertTrue(Flight.isOneWayDisplayed(), "One way flight booking option is display");
		Assert.assertTrue(Flight.isToCityDisplayed(), "To city flight option is display");
		Assert.assertTrue(Flight.isFromeCityDisplayed(), "from city flight option is display");
		Assert.assertTrue(Flight.isdatepickerDisplayed(), "For booking a flight date option is display");
		Flight.clickOneWay();
		Flight.clickFromWhere(prop.getProperty("FromCity"));
		Flight.originCity(0);
		Flight.Tocity(prop.getProperty("ToCity"));
		Flight.DestinationCity(0);
		Flight.ClickOnDateDropDown();
		Flight.typeDepartDate(Integer.parseInt(prop.getProperty("Date")), Integer.parseInt(prop.getProperty("Month")), Integer.parseInt(prop.getProperty("Year")));
		Flight.Adults(prop.getProperty("Adults"));
		Flight.childs(prop.getProperty("childs"));
		Flight.infants(prop.getProperty("infants"));
		Flight.searchFlight();

	}

}