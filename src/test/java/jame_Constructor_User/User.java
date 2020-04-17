package jame_Constructor_User;

import org.junit.Assert;

import jame_Constructor_Browser.Browser;

public class User {

	private String userName;
	private Browser browser;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User(String userName) {
		this.userName=userName;
	}

	public void openBrowser(Browser browser) {
		this.browser=browser;
		browser.openBrowser();
	}

	public void navigateBrowser(String url) {
       
		browser.navigateBrowser(url);
		
	}

	public void doLoginwith(String id, String password) {
		browser.typeText("user_email", id );//passing xpath and id
		browser.typeText("user_password", password );
		browser.clickElement("btnSubmit");
		
	}

	public boolean checkProfileName(String expProfileName) {
	
		return  browser.isElementExist("xpath","//h3[@class='profile_name']//a[contains(text(),'"+expProfileName+"')]");
	}

	public void createAPost(String postMsg) {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		browser.typeText("xpath\",\"//div[@data-placeholder=\\\"Post your message..\\\"]", postMsg );//passing xpath and id and we mention xpath in the beginning bcz in browser page we use if/else condition
		browser.clickElement("xpath","//input[@class='btn primary post_btn']");
	
	}

	public boolean checkPost( String postText) {
		// TODO Auto-generated method stub
		return browser.isElementExist("xpath", "//div[contains(text(),'"+postText+"')]");
	}

	public void navigatePage(String string) {
		// TODO Auto-generated method stub
		browser.clickElement("xpath", "//h3[contains(text(),'Friends')]//a[@class='pull-right'][contains(text(),'More')]");
		
	}

	public boolean getAllFriendsList() {
		// TODO Auto-generated method stub
		return browser.getElementsCounts("//div[@class=\"mediapost display_table wid100per\"]");//Elements bcz we  are looking for whole friends not a single one
	}

	
	

}
