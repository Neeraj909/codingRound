package TestVagrant.page;

import org.openqa.selenium.WebDriver;




public class Page  {

	WebDriver driver;

	public Page(WebDriver driver) {
		
		this.driver = driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

}
