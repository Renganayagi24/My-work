package marathon2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteSalesForce {

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
	}

}
