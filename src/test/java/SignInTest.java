import com.cleartrip.page.web.ClartripSignInPage;
import com.sun.javafx.PlatformUtil;

import TestVagrant.basetest.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest{

	WebDriver driver = null;
	WebDriverWait wait=null;
	ClartripSignInPage signInPage=null;
	@BeforeClass
	public void init()
	{
		driver = getWebdriver();
		wait=getWait();	
		signInPage=PageFactory.initElements(driver, ClartripSignInPage.class);

	}

	 @Test(priority = 0, description = "Invalid Login Scenario with wrong username and password.")
	    public void invalidLoginTest_InvalidUserNameInvalidPassword () {       

	        Assert.assertTrue(signInPage.isYourTripDisplayed(), "Your trip button is display");
	        signInPage.YourTrip();
	        Assert.assertTrue(signInPage.isSignInDisplayed(), "SignIn button in home pasge is display");
	        Assert.assertTrue(signInPage.isComplateSignInDisplayed(), "signin buttan is display");
	        signInPage.clickOnSignIn();
	        // entered wrong mailed message
	        signInPage.setUserName("xyz.@gmail.com");
	        // Enter wrong message
	        signInPage.setPassword("xyz");
	        signInPage.ComplateSignIn();

	        Assert.assertTrue(signInPage.iserrors1Displayed(), "error message is displayed");
	    }
	 @Test(priority = 1, description = "Invalid Login Scenario with empty username and password.")
	    public void shouldThrowAnErrorIfSignInDetailsAreMissing () {

	        Assert.assertTrue(signInPage.isYourTripDisplayed(), "Your trip button is display");
	        signInPage.YourTrip();
	        Assert.assertTrue(signInPage.isSignInDisplayed(), "SignIn button in home pasge is display");
	        Assert.assertTrue(signInPage.isComplateSignInDisplayed(), "signin buttan is display");
	        signInPage.clickOnSignIn();
	        // entered wrong mailed message
	        signInPage.setUserName("");
	        // Enter wrong message
	        signInPage.setPassword("");
	        signInPage.ComplateSignIn();

	        Assert.assertTrue(signInPage.iserrors1Displayed(), "error message is displayed");
	    }

    

   


}