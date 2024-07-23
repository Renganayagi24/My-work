package marathon2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditSalesForce {

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
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='slds-button slds-context-bar__button slds-icon-waffle_container slds-show']")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        Thread.sleep(2000);
        WebElement opp = driver.findElement(By.xpath("(//a[@class='slds-context-bar__label-action dndItem'])[2]"));
        
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", opp);
        Thread.sleep(1000);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@class='slds-input'])[1]")).sendKeys("Salesforce Automation by Raju");
        driver.findElement(By.xpath("(//a[@title='Salesforce Automation by Raju'])[1]")).click();
        driver.findElement(By.xpath("(//button[@class='slds-button slds-button_icon-border-filled fix-slds-button_icon-border-filled slds-button_last'])[1]")).click();
        driver.findElement(By.xpath("//span[text()='Edit']")).click();
        driver.findElement(By.xpath("//input[@name='CloseDate']")).clear();
        driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("05/07/2024");
        driver.findElement(By.xpath("(//label[text()='Stage']/following::span[text()='Needs Analysis'])[1]")).click();
        driver.findElement(By.xpath("(//label[text()='Stage']/following::span[text()='Needs Analysis'])[1]")).click();
      
        driver.findElement(By.xpath("//label[text()='Stage']/following::span[text()='Perception Analysis']")).click();
       
        WebElement scroll = driver.findElement(By.xpath("(//label[text()='Delivery/Installation Status']/following::span[text()='--None--'])[1]"));
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
        Thread.sleep(500); 
        scroll.click();
        driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']/following::span[text()='In progress']")).click();
        
        driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow textarea-container']")).sendKeys("SalesForce");
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        String text = driver.findElement(By.xpath("(//span[text()='Perception Analysis'])[3]")).getText();
        if (text.contains("Perception Analysis")) {
			System.out.println("Salesforce opportunities are created successfully");
		}
		else {
			System.out.println("Salesforce opportunities are not created successfully");
		}
		driver.close();
        
        

	}

}
