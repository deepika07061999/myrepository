package baseclass.com;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Tester extends BaseClass{

	public static void main(String[] args) throws IOException {
		browserSetUp("chrome");
		browserLaunch("https://adactinhotelapp.com/");
		String titleOfWebPage = titleOfWebPage();
		System.out.println(titleOfWebPage);
		WebElement userName = elementLocator("id","username");
		String userNameValue = readFromFile("C:\\Users\\deepi\\Book2.xlsx",1,0);
		userName.sendKeys(userNameValue);
		WebElement password = elementLocator("name","password");
		String passwordValue = readFromFile("C:\\Users\\deepi\\Book2.xlsx",1,1);
		password.sendKeys(passwordValue);
		WebElement loginBtn = elementLocator("id","login");
		loginBtn.click();
		WebElement location= elementLocator("id","location");
		dropDown(location,"London");
	}

}
