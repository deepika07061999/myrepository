package baseclass.com;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class JUnitSample {
	@BeforeClass
	public  static void launch() {
		System.out.println("testing Started");
	
		
	}	
	@Before
	public void verifyPage() {
		BaseClass.browserSetUp("chrome");
		BaseClass.browserLaunch("https://adactinhotelapp.com/");
		BaseClass.windowMaximize();
		String title = BaseClass.titleOfWebPage();
		System.out.println(title);
		boolean contains = title.contains("Adactin");
		Assert.assertEquals(true,contains);
		System.out.println("title verified");
	}
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
	public void searchHotel() throws IOException, InterruptedException{
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
		//System.out.println("loginpage verified");
		WebElement location= BaseClass.elementLocator("id","location");
		boolean visibilityOfLocation = location.isDisplayed();
		Assert.assertTrue(visibilityOfLocation);
		BaseClass.dropDown(location,"London");
		WebElement hotels = BaseClass.elementLocator("id","hotels");
		boolean visibilityOfhotels = hotels.isDisplayed();
		Assert.assertTrue(visibilityOfhotels);
		BaseClass.dropDown(hotels,"Hotel Sunshine");
		WebElement roomType = BaseClass.elementLocator("id","room_type");
		boolean visibilityOfRoomType = roomType.isDisplayed();
		Assert.assertTrue(visibilityOfRoomType);
		BaseClass.dropDown(roomType,"Standard");
		WebElement numberOfRooms = BaseClass.elementLocator("id","room_nos");
		boolean visibilityOfNoOfRooms = numberOfRooms .isDisplayed();
		Assert.assertTrue(visibilityOfNoOfRooms);
		BaseClass.dropDown(numberOfRooms,"2 - Two");
		WebElement checkinDate = BaseClass.elementLocator("id","datepick_in");
		boolean visibilityOfCheckinDate =checkinDate.isDisplayed();
		Assert.assertTrue(visibilityOfCheckinDate);
		checkinDate.sendKeys("02/09/2022");
		WebElement checkoutDate = BaseClass.elementLocator("id","datepick_out");
		boolean visibilityOfCheckOut = checkoutDate.isDisplayed();
		Assert.assertTrue(visibilityOfCheckOut);
		checkoutDate.sendKeys("03/092022");
		WebElement adultPerRoom= BaseClass.elementLocator("id","adult_room");
		boolean visibilityOfAdultPerRoom=adultPerRoom.isDisplayed();
		Assert.assertTrue(visibilityOfAdultPerRoom);
		BaseClass.dropDown(adultPerRoom, "2 - Two");
		WebElement childPerRoom= BaseClass.elementLocator("id","child_room");
		boolean visibilityOfChildPerRoom = childPerRoom.isDisplayed();
		Assert.assertTrue(visibilityOfChildPerRoom);
		BaseClass.dropDown(childPerRoom,"1 - One");
		WebElement search = BaseClass.elementLocator("id","Submit");
		boolean visibilityOfSearchBtn = search.isDisplayed();
		Assert.assertTrue(visibilityOfSearchBtn);
		search.click();
		System.out.println("search hotel verified ");
		
	}
    @After
    public  void driverClose() throws InterruptedException {
    	Thread.sleep(3000);
    	BaseClass.driver.close();
    	
    }
    @AfterClass
    public static void end() {
    	System.out.println("test Ended");
    }
    
}
