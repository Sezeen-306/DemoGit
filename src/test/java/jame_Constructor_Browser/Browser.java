package jame_Constructor_Browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	WebDriver driver;
	private String browserName;

	public Browser(String browserName) {
		this.browserName=browserName;
	}
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sayee\\eclipse-workspace\\james.firstproject\\chromedriver.exe");

		driver=new ChromeDriver();
		System.out.println("browser has opened");
	}
	public void navigateBrowser(String url) {
		// TODO Auto-generated method stub
		driver.get(url);
	}
	public void typeText(String texttobeWrite, String webelementName, String locatorStatagy) {// if else passing cz some times we pass id sometimws name or xpath
		if(locatorStatagy.equals("name")) {
			driver.findElement(By.name(webelementName)).sendKeys(texttobeWrite);
		} else if(locatorStatagy.equals("xpath")) {
			driver.findElement(By.xpath(webelementName)).sendKeys(texttobeWrite);
		} else if(locatorStatagy.equals("id")) {
			driver.findElement(By.id(webelementName)).sendKeys(texttobeWrite);
		}
		
		driver.findElement(By.name(webelementName)).sendKeys(texttobeWrite);

	}
	public void clickElement(String webelementName, String locatorStatagy) {
		// TODO Auto-generated method stub
		if(locatorStatagy.equals("name")) {
			driver.findElement(By.name(webelementName)).click();
		}
		else if(locatorStatagy.equals("xpath"))
		{
			
			driver.findElement(By.xpath(webelementName)).click();
		}
		else if(locatorStatagy.equals("id")) {
			driver.findElement(By.id(webelementName)).click();
		}
	}
	public boolean isElementExist(String locatorStatagy, String webelementName) {
		
		try {
			
			if(locatorStatagy.equals("name")) {
				return driver.findElement(By.name(webelementName)).isDisplayed();
			} else if(locatorStatagy.equals("xpath")) {
				return driver.findElement(By.xpath(webelementName)).isDisplayed();
			} else if(locatorStatagy.equals("id")) {
				return driver.findElement(By.id(webelementName)).isDisplayed();
			} else {
				return false;
			}
						
		} catch(Exception e) {
			
			return false;
		}
		
	}
	public boolean getElementsCounts() {
List<WebElement> allFriendselement =driver.findElements(By.xpath("elementlocator")); //List and right side code will give mwe all friends list
		
		System.out.println("Friends Fount Totoal " + allFriendselement.size());
		
		if(allFriendselement.size()>0) {
			return true;
		}
		return false;
	}

	
	}

}
