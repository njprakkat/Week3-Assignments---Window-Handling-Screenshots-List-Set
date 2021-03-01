package week3.day2;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;

import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.control.Alert;
//import sun.util.calendar.BaseCalendar.Date;

@SuppressWarnings("unused")
public class RedBus {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();

		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);

		//Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
		 WebDriverManager.chromedriver().setup(); 
		 WebDriver driver = new ChromeDriver(options);
	     
		 
		 driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		 driver.get("https://www.redbus.in/");
		 driver.manage().window().maximize();
		 String title = driver.getTitle();
		 System.out.println(title);
		 
		 WebElement src = driver.findElement(By.id("src"));
		 src.sendKeys("Koyambedu, Chennai");
		 src.click();
		 Thread.sleep(2000);
		 
		 		 
		 WebElement dest = driver.findElement(By.id("dest"));
		 dest.sendKeys("Madurai (All Locations)");
		 dest.click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//span[contains(@class,'fl icon-calendar_icon-new')]")).click();
		 driver.findElement(By.xpath("//td[@class='wd day']/following-sibling::td")).click();
         driver.findElement(By.id("search_btn")).click();
         Thread.sleep(4000);
		 System.out.println("SEARCH BUSES BUTTON CLICKED");
		 Thread.sleep(8000);
		 
		
		 String totalbus = driver.findElement(By.xpath("//div[@class='result-sec']//span")).getText();
		 System.out.println("STRING TEXT " +totalbus);
		 String buses = totalbus.substring(0,3);
		 System.out.println(" NUMBER OF BUSES AVAILABLE FROM CHENNAI TO MADURAI : " +buses);
		 
		 List<String> FullList = new ArrayList<String>();
		 List<WebElement> Fullrows = driver.findElements(By.xpath("//div[@class='clearfix bus-item-details']"));
		 System.out.println("TOTAL FULL ROWS: " +Fullrows.size());
		 
		 driver.findElement(By.xpath("//i[@class='icon icon-close c-fs']")).click();
		
		 List<String> Listtrainnames = new ArrayList<String>();
		 List<WebElement> rows = driver.findElements(By.xpath("//ul[@class='bus-items']/div/div"));
		 
		 for(int i=1;i<= Fullrows.size();i++)
		 {
           String trainname = driver.findElement(By.xpath("(//div[@class='clearfix bus-item'])[" +i+ "]//div[@class='travels lh-24 f-bold d-color']")).getText();
		    Listtrainnames.add(trainname);
		 }
		 System.out.println("REACHED HERE");
		 
		 Set<String> setTrainnames = new LinkedHashSet<String>(Listtrainnames);
				
		 for(String eachValue : setTrainnames)
			 System.out.println(" UNIQUE TRAVEL NAMES WITHOUT DUPLICATION :" +eachValue);
		 
		 if(Listtrainnames.size() == setTrainnames.size()) 
					System.out.println(" No Duplicates ");
				else
					System.out.println(" There are Duplicates");
		 
		
         Thread.sleep(8000);
		 driver.findElement(By.xpath("//div[@class='clearfix m-top-16']/div[@class='button view-seats fr']")).click();
		 System.out.println(" VIEW SEATS BUTTON CLICKED");
         // Convert the WebDriver object (driver) to TakeScreenshot
		 Thread.sleep(4000);
		 
		 //Date date = new Date();
		// String strdate = date.toString();
		// strdate.replaceAll(":", "");
		 
		 File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 
		 File target = new File("./snaps/New.png");
		 System.out.println("did u reach here ?");
		 FileUtils.copyFile(source, target);
		 System.out.println("Screenshot Captured of Available Seats");
		 
}
}

