package stepDefinition;

import io.cucumber.java.en.*;


import org.openqa.selenium.*;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class StepDefinition {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(StepDefinition.class);

    @Given("Open the browser")
    public void open_the_browser() 
    {
      driver=new FirefoxDriver();
  driver.manage().window().maximize();
  logger.info("******* Browser is launched *******");
       
    }
    @When("the user is able to launch the URL {string}")
    public void the_user_is_able_to_launch_the_url(String URL) 
    {
       driver.get(URL);
       logger.info("******* Homepage is launched *******");
       
    }
    @When("Click on my account menu")
    public void click_on_my_account_menu() 
    {
        driver.findElement(By.cssSelector("a[href='https://practice.automationtesting.in/my-account/']")).click();
        logger.info("******* Clicked on Myaccount *******");
    }
    @When("^Enter registered username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void enter_registered_username_and_password(String username, String password) {
        WebElement emailField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        emailField.sendKeys(username);
        passwordField.sendKeys(password);
    }
    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() 
    {
    driver.findElement(By.xpath("//input[@name='login']")).click();
    logger.info("******* clicked on login button *******");
    }
    @Then("the user should be successfully login")
    public void the_user_should_be_successfully_login() 
    {
    	String text=driver.findElement(By.xpath("//strong[normalize-space()='shrayupadhyay']")).getText();
       if(text.contains("shrayupadhyay"))
       {
    	   logger.info("******* Successfully logged in *******");
    System.out.println("Login successfull");
  
       }
       else
       {logger.info("******* login failed *******");
    	   System.out.println("Lgin failed");
       }
       driver.quit();
    
    }

}
