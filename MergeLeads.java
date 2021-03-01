package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLeads {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		 driver.get("http://leaftaps.com/opentaps/control/main");
		 driver.manage().window().maximize();
		 String title = driver.getTitle();
		 System.out.println(title);
		 
		 driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		 driver.findElement(By.id("password")).sendKeys("crmsfa");
		 driver.findElement(By.className("decorativeSubmit")).click();
		 
		 driver.findElement(By.linkText("CRM/SFA")).click();
		 driver.findElement(By.xpath("//a[@href='/crmsfa/control/leadsMain']")).click();	
		 driver.findElement(By.linkText("Merge Leads")).click();
		 driver.findElement(By.xpath("//table[@class='twoColumnForm']//a")).click();
		 System.out.println("From Image clicked");
		 Thread.sleep(4000);
		 Set<String> allwindowHandles = driver.getWindowHandles();
	     List<String> listHandles = new ArrayList<String>(allwindowHandles);
	     driver.switchTo().window(listHandles.get(2));
	     System.out.println(" Window Switched to FIND LEADS");
	     driver.findElement(By.xpath("//input[@name='id']")).sendKeys("10072");
	     driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	     System.out.println("Find Leads Button Clicked");
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a")).click();
	     System.out.println("REACHED HERE");
	     driver.switchTo().window(listHandles.get(0));
	     System.out.println("SWITCHED BACK TO MERGE LEADS WINDOW");
	     driver.findElement(By.xpath("(//table[@class='twoColumnForm']//a)[" +2+ "]")).click();
		 System.out.println("To Image clicked");
		 Thread.sleep(3000);
		 
		 Set<String> allwindowHandles2 = driver.getWindowHandles();
	     List<String> listHandles2 = new ArrayList<String>(allwindowHandles2);
		 driver.switchTo().window(listHandles2.get(2));
		 System.out.println(" SWITCH BACK TO FIND LEADS");
		 driver.findElement(By.xpath("//input[@name='id']")).sendKeys("10073");
	     driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a")).click();
	     driver.switchTo().window(listHandles.get(0));
	     driver.findElement(By.linkText("Merge")).click();
	     driver.switchTo().alert().accept();
	     
	     
	     driver.findElement(By.linkText("Find Leads")).click();
	     driver.findElement(By.name("id")).sendKeys("10072");
	     Thread.sleep(4000);
	     driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	     System.out.println(" Find Leads button clicked");
	     Thread.sleep(4000);
	     String noRecordsTo = driver.findElement(By.xpath("//div[@class='x-toolbar x-small-editor']/div")).getText();
	     System.out.println(noRecordsTo);
	     if(noRecordsTo.contains("No records"))
	     System.out.println("This confirms the Successful Merge of Leads");
	     else
	     System.out.println("Merge not successful"); 
	     
	     
	     
	     
	}

}
