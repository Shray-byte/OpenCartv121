package testcases;

import testbase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccount;

public class TC002_testcase_Login extends BaseClass
{
	@Test(groups={"Sanity"})
	public void verifylogin()
	{
		try {
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
	    hp.loginmethod();
	    
	    
	    LoginPage lp=new LoginPage(driver);
	    lp.setemailID(p.getProperty("email"));
	    lp.setPassword(p.getProperty("password"));
	    lp.buttonlogin();
	    
	    MyAccount ma=new MyAccount(driver);
	    
	    
	    //Assert.assertEquals(true, ma.isMyAccountDisplayed(), "Login failed");
	    Assert.assertTrue(ma.isMyAccountDisplayed());
	   
		}
		catch (Exception e)
		{
			Assert.fail();
			e.printStackTrace();
		}
	
	}
	

}
