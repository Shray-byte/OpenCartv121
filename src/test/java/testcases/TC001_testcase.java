package testcases;


import org.testng.annotations.*;

import org.testng.Assert;


import pageObject.HomePage;
import testbase.BaseClass;
import pageObject.AccountResgistration;

public class TC001_testcase extends BaseClass
{


@Test(groups={"Regression"})
public void verify_account_registration()
{
	
	logger.info("***********  Test case started  ***********");
	
	try {
	HomePage hp=new HomePage(driver);
	logger.info("***********  Clicking on My account  ***********");
	hp.clickMyAccount();
	hp.Register();
	
	AccountResgistration ar=new AccountResgistration(driver);
	logger.info("***********  Setting up first name  ***********");
	ar.setfirstname(randomString().toUpperCase());
	logger.info("***********  Setting up last name  ***********");
	ar.setLastname(randomString().toUpperCase());
	logger.info("***********  Setting up email ID  ***********");
	ar.setemailID(randomString()+"@gmail.com");
	ar.settelephone(randomNumbers());
	
	 String setpwd=randomAlphnumeric();
	
	ar.setpassword(setpwd);
	ar.setconfirmpassword(setpwd);

	ar.checkprivacypolicy();
	logger.info("***********  Privacy policy checked  ***********");
	ar.buttoncontinue();
	String verificationMessage=ar.messageverification();
	if(verificationMessage.equals("Your Account Has Been Created!"))
			{
		Assert.assertTrue(true);
			}
	else {
		Assert.assertTrue(false);
		
	}
		

}
catch(Exception e)
{
	//logger.error("Test failed..");
	//logger.debug("debug logs..");
	Assert.fail();
	
}
	//logger.info("***********  Test case finished  ***********");
}


}
