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



public class FlightBookingTest extends BaseTest {

	WebDriver driver = null;
	WebDriverWait wait=null;
	FlightBookingPage Flight=null;
	Page page=null;

	@BeforeClass
	public void init()
	{
		driver = getWebdriver();
		wait=getWait();	
		Flight = PageFactory.initElements(driver, FlightBookingPage.class);
		page=    PageFactory.initElements(driver, Page.class);
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
	        Flight.clickFromWhere("Bangalore");
	        Flight.originCity(0);
	        Flight.Tocity("delhi");
	        Flight.DestinationCity(0);
	        Flight.ClickOnDateDropDown();
	        Flight.typeDepartDate(29, 5, 2019);
	        Flight.Adults("1");
	        Flight.childs("0");
	        Flight.infants("0");
	        Flight.searchFlight();
	  
	}





	


}
