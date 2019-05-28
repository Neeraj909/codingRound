package TestVagrant.page;

import org.openqa.selenium.WebDriver;




public class Page  {

	WebDriver driver;
        WebDriverWait wait;

	public Page(WebDriver driver) {
		
		this.driver = driver;
		wait =new WebDriverWait(driver, 30);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

}
