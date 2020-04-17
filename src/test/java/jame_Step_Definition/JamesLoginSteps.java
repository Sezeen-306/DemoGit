package jame_Step_Definition;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jame_Constructor_Browser.Browser;
import jame_Constructor_User.User;

public class JamesLoginSteps {

	User qa;



	@Given("^james open browser chrome$")
	public void james_open_browser_chrome() {

		User qa=new User("James");
		
		qa.openBrowser(new Browser("Chrome"));
		

	}

	@Given("^james navigate to NMKT\\.com$")
	public void james_navigate_to_NMKT_com() {

		qa.navigateBrowser("https://www.demo.iscripts.com/socialware/demo/");	


	}



	@When("^james complete login with valid credentials$")
	public void james_complete_login_with_valid_credentials() {
		
		
		String id = "user@iscripts.com"; // access account
		String password = "User1234";
		
		qa.doLoginwith(id,password);
	}

	@Then("^james expect James Mathew as a profilename$")
	public void james_expect_James_Mathew_as_a_profilename() {
		
		 String expProfileName="James Mathew ";
		boolean actualExpectedName= qa.checkProfileName(expProfileName);
		 Assert.assertEquals("not getting the expected name",true, actualExpectedName);
	}
	
	
	@Then("^I can create & submit a post$")
	public void i_can_create_submit_a_post() throws Throwable {
		qa.createAPost("This is my first post");//createpost cz it comes with typetext
		boolean actualCreatedPost=qa.checkPost( "This is my first post");
		 Assert.assertEquals("not getting the expected name",true, actualCreatedPost);
	}
	
	
	public void i_expect_at_lease_one_friend_aviable() throws Throwable {
		qa.navigatePage("Friends page");
		int friendlistCount=qa.getAllFriendsList();
	
		Assert.assertEquals("No Friends Available !!", true, friendlistCount);//no more true/false cz we want the number so its an array
	}
	
	
	}


