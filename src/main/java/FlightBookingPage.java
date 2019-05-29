package TestVagrant.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

import java.util.List;

public class FlightBookingPage extends Page {
	Select select = null;
	@FindBy(id = "OneWay")
	private WebElement OneWay;
	@FindBy(id = "FromTag")
	private WebElement FromeCity;
	@FindBy(xpath = "//input[@id='DepartDate']/following-sibling::a[@class='calendarIcon']//i")
	private WebElement DateDropDown;
	@FindBy(id = "toTag")
	private WebElement ToCity;
	@FindBy(id = "SearchBtn")
	private WebElement searchBtn;
	@FindBy(className = "searchSummary")
	private WebElement searchSummary;
	@FindBy(id = "ui-id-1")
	private WebElement originDropDown;
	@FindBy(id = "ui-id-2")
	private WebElement DestinationDropDown;
	@FindBy(id = "Adults")
	private WebElement Adults;
	@FindBy(name = "childs")
	private WebElement childs;
	@FindBy(name = "infants")
	private WebElement infants;

	public void Adults(String text) {
		select = new Select(Adults);
		select.selectByValue(text);
	}

	public void childs(String text) {
		select = new Select(childs);
		select.selectByValue(text);
	}

	public void infants(String text) {
		select = new Select(infants);
		select.selectByValue(text);
	}

	public FlightBookingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickOneWay() {
		wait.until(ExpectedConditions.visibilityOf(OneWay));
		OneWay.click();
	}

	public void ClickOnDateDropDown() {
		wait.until(ExpectedConditions.visibilityOf(DateDropDown));
		DateDropDown.click();
	}

	public void clickFromWhere(String city) {
		wait.until(ExpectedConditions.visibilityOf(FromeCity));
		FromeCity.clear();
		FromeCity.sendKeys(city);
		Assert.assertEquals(FromeCity.getAttribute("value"), city);
	}

	public void Tocity(String city) {
		wait.until(ExpectedConditions.visibilityOf(ToCity));
		ToCity.clear();
		ToCity.sendKeys(city);
		Assert.assertEquals(ToCity.getAttribute("value"), city);

	}

	public void searchFlight() {
		wait.until(ExpectedConditions.visibilityOf(searchBtn));
		searchBtn.click();
		wait.until(ExpectedConditions.visibilityOf(searchSummary));
	}

	public boolean isOneWayDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(OneWay));
		return OneWay.isDisplayed() && OneWay.isEnabled();
	}

	public boolean isFromeCityDisplayed() {
		return FromeCity.isDisplayed() && FromeCity.isEnabled();
	}

	public boolean isToCityDisplayed() {
		return ToCity.isDisplayed() && ToCity.isEnabled();
	}

	public boolean isdatepickerDisplayed() {
		return DateDropDown.isDisplayed() && DateDropDown.isEnabled();
	}

	public void typeDepartDate(int date, int month, int year) {

		String s = "//td[contains(@data-handler,'selectDay') and @data-month='" + (month - 1) + "' @data-year='" + year
				+ "' ]/a[contains(text(),'" + date + "')]";
		driver.findElement(By.xpath(s)).click();
	}

	public void originCity(int cityIndex) {

		wait.until(ExpectedConditions.visibilityOf(originDropDown));
		List<WebElement> list = originDropDown.findElements(By.tagName("li"));
		wait.until(ExpectedConditions.visibilityOfAllElements(list));

		list.get(cityIndex).click();

	}

	public void DestinationCity(int cityIndex) {
		wait.until(ExpectedConditions.visibilityOf(DestinationDropDown));
		List<WebElement> list = DestinationDropDown.findElements(By.tagName("li"));
		wait.until(ExpectedConditions.visibilityOfAllElements(list));
		list.get(cityIndex).click();

	}

}
