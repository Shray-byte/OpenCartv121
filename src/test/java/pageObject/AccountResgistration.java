package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;

public class AccountResgistration extends BasePage
{


public AccountResgistration(WebDriver driver) {
		super(driver);
		
	}



//locators
@FindBy (xpath="//input[@id='input-firstname']")
WebElement txtFirstname;

@FindBy (xpath="//input[@id='input-lastname']")
WebElement txtLastname;

@FindBy (xpath="//input[@id='input-email']")
WebElement txtemailID;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txttelephone;

@FindBy (xpath="//input[@id='input-password']")
WebElement txtpassword;

@FindBy (xpath="//input[@id='input-confirm']")
WebElement cnf_password;



@FindBy (xpath="//input[@name='agree']")
WebElement chkprivacypolicy;

@FindBy (xpath="//input[@value='Continue']")
WebElement btncontinue;

@FindBy (xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgconfirmation;


//Actions
public void setfirstname(String fname)
{
	txtFirstname.sendKeys(fname);
}
public void setLastname(String lname)
{
	txtLastname.sendKeys(lname);
}
public void setemailID(String email)
{
	txtemailID.sendKeys(email);
}
public void settelephone(String tele)
{
	txttelephone.sendKeys(tele);
}


public void setpassword(String pwd)
{
	txtpassword.sendKeys(pwd);
}
public void setconfirmpassword(String setpwd) 
{
	cnf_password.sendKeys(setpwd);
}



public void checkprivacypolicy()
{
	chkprivacypolicy.click();
}
public void buttoncontinue()
{
	btncontinue.click();
}
public String messageverification()
{
	try {
		return(msgconfirmation.getText());
	}

	catch(Exception e)
	{
		return(e.getMessage());
	}

}}
