package baseclass.com;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class Sample {
      @Test
      public void login() throws IOException, InterruptedException {
  		WebElement userName = BaseClass.elementLocator("id","username");
  		boolean visibilityOfUserName = userName.isDisplayed();
  		Assert.assertTrue(visibilityOfUserName);
  		userName.sendKeys(BaseClass.readFromFile("C:\\Users\\deepi\\Book2.xlsx", 1, 0));
  		Thread.sleep(3000);
  		String text = userName.getText();
  		System.out.println(text);
  		WebElement passWord = BaseClass.elementLocator("id","password");
  		boolean visibilityOfPassword = passWord.isDisplayed();
  		Assert.assertTrue(visibilityOfPassword);
  		passWord.sendKeys(BaseClass.readFromFile("C:\\Users\\deepi\\Book2.xlsx", 1, 1));
  		System.out.println(passWord.getText());
  		WebElement loginBtn = BaseClass.elementLocator("id","login");
  		boolean loginBtnIsDisplayed = loginBtn.isDisplayed();
  		Assert.assertTrue(loginBtnIsDisplayed);
  		loginBtn.click();
  		System.out.println("loginpage verified");
  		
  	}
      @Test
      public void loginWrongCredential() throws IOException, InterruptedException {
  		WebElement userName = BaseClass.elementLocator("id","username");
  		boolean visibilityOfUserName = userName.isDisplayed();
  		Assert.assertTrue(visibilityOfUserName);
  		userName.sendKeys(BaseClass.readFromFile("C:\\Users\\deepi\\Book2.xlsx", 1, 0));
  		Thread.sleep(3000);
  		String text = userName.getText();
  		System.out.println(text);
  		WebElement passWord = BaseClass.elementLocator("id","password");
  		boolean visibilityOfPassword = passWord.isDisplayed();
  		Assert.assertTrue(visibilityOfPassword);
  		passWord.sendKeys(BaseClass.readFromFile("C:\\Users\\deepi\\Book2.xlsx", 1, 2));
  		System.out.println(passWord.getText());
  		WebElement loginBtn = BaseClass.elementLocator("id","login");
  		boolean loginBtnIsDisplayed = loginBtn.isDisplayed();
  		Assert.assertTrue(loginBtnIsDisplayed);
  		loginBtn.click();
  		System.out.println("loginpage  not verified");
  		
  	}
      @Before
      public  void launch() {
  		BaseClass.browserSetUp("chrome");
  		BaseClass.browserLaunch("https://adactinhotelapp.com/");
  		BaseClass.windowMaximize();
  	}
      @After
      public void driverClose() throws InterruptedException {
      	Thread.sleep(3000);
      	BaseClass.driver.close();
      	
      }

}
