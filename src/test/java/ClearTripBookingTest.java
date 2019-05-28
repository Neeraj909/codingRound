

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestVagrant .page.ClearTripHomePage;
import TestVagrant .page.ClearTripSearchResultPage;
import TestVagrant .basetest.BaseTest;

public class ClearTripBookingTest extends BaseTest {

	WebDriver driver = null;

	ClearTripHomePage cthp;

	@BeforeClass
	public void init()

	{
		driver = getWebdriver();
		cthp = PageFactory.initElements(driver, ClearTripHomePage.class);

	}

	@Test
	public void searchFlight() {
		String title = cthp.getPageTitle();
		assertTrue(title.contains("#1 Site"));
		
		cthp.typeFrom("BLR");
		cthp.typeTo("DEL");
		cthp.typeDepartDate(20, 4, 2019);
		cthp.typeAdults("2");
		cthp.typeChildrens("1");
		
		ClearTripSearchResultPage searchPage = cthp.clickSearchButton();
		searchPage.clickLowestPriceBookButton();
	}

}
