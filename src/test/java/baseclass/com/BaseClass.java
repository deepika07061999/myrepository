package baseclass.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;
	 static WebElement element;
	 static File file;
	 static Workbook w;
	public static void browserSetUp(String browser) {
		if (browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			System.out.println("invalid Browser");
		}
	}
	public static void browserLaunch(String url) {
		driver.get(url);
	}
	public static String titleOfWebPage() {
		String title = driver.getTitle();
		return title;
	}
	public static WebElement elementLocator(String locator,String value) {
	
		if (locator.equalsIgnoreCase("id")) {
			WebElement elementById = driver.findElement(By.id(value));
			element=elementById;
		}else if (locator.equalsIgnoreCase("name")) {
			WebElement elementByName = driver.findElement(By.name(value));
			element=elementByName;
		}else if (locator.equalsIgnoreCase("xpath")) {
			WebElement elementByXpath = driver.findElement(By.xpath(value));
			element=elementByXpath;
		}
		return element;	
	}
	public static String readFromFile(String filePath,int rowNumber,int cellNumber) throws IOException {
		 file=new File(filePath);
		FileInputStream fis=new FileInputStream(file);
		w=new XSSFWorkbook(fis);
		String username = w.getSheet("Sheet1").getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		return username;
		
	}
	public static void  windowMaximize() {
		driver.manage().window().maximize();
	}
	public static void writeIntoFile(String filePath,String sheetName,int rowNumber,int cellNumber,String cellValue) throws IOException {
		file=new File(filePath);
		FileOutputStream fos=new FileOutputStream(file);
		w=new XSSFWorkbook();
		w.createSheet(sheetName).createRow(rowNumber).createCell(cellNumber).setCellValue(cellValue);
		w.write(fos);
    }
	public static void dropDown(WebElement dropDown,String dropDownValueToSelect) {
		Select s=new Select(dropDown);
		boolean multiple = s.isMultiple();
		if (multiple) {
			s.selectByVisibleText(dropDownValueToSelect);
			
		}else {
			s.selectByVisibleText(dropDownValueToSelect);
			
		}
	}

}
