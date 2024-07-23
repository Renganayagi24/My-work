package marathon2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateSalesforce {

	public static void main(String[] args) throws InterruptedException {
	
		
		ChromeOptions opt =new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		ChromeDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://login.salesforce.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("gokul.sekar@testleaf.com");
        driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 password']")).sendKeys(" Leaf$123");
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        driver.findElement(By.xpath("//button[@class='slds-button slds-context-bar__button slds-icon-waffle_container slds-show']")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        Thread.sleep(2000);
        WebElement opp = driver.findElement(By.xpath("(//a[@class='slds-context-bar__label-action dndItem'])[2]"));
        
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", opp);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='New']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Raju");
        driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys("75,000");
        driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("04/07/2024");
        driver.findElement(By.xpath("//label[text()='Stage']/following::span[text()='--None--']")).click();
        driver.findElement(By.xpath("//label[text()='Stage']/following::span[text()='Needs Analysis']")).click(); 
        driver.findElement(By.xpath("(//button[@class='slds-button slds-button_brand'])[3]")).click();
        String text = driver.findElement(By.xpath("(//span[text()='Needs Analysis'])[2]")).getText();
        if (text.contains("Salesforce Automation by Raju")) {
			System.out.println("Salesforce opportunities are created successfully");
		}
		else {
			System.out.println("Salesforce opportunities are not created successfully");
		}
		driver.close();
       
	}

}
