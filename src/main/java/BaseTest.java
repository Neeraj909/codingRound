

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver webdriver;

	@BeforeSuite
	@Parameters({ "browserName", "url" })
	public void setup(@Optional("chrome") String browserName, @Optional("http://www.cleartrip.com") String url) {

		switch (browserName.trim().toLowerCase()) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			setWebdriver(new FirefoxDriver());
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			setWebdriver(new FirefoxDriver());
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			setWebdriver(new FirefoxDriver());
			break;

		default:
	//		WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			options.setExperimentalOption("prefs", prefs);
			System.setProperty("webdriver.chrome.driver","C:\\Users\\11017\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
 		webdriver = new ChromeDriver();
			//setWebdriver(new ChromeDriver(options));
			break;
		}

		webdriver.get(url);
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
	}

	public WebDriver getWebdriver() {

		return webdriver;
	}

	private void setWebdriver(WebDriver webdriver) {
		this.webdriver = webdriver;
	}

	@AfterSuite
	public void cleanup() {
		if (webdriver != null) {
			webdriver.quit();
		}
	}
}
