package testng3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLeadWithExcel extends ProjectSpecificMethod {
	
	@BeforeTest
	public void getvalue() {
	datasheet ="Leads";
	}
	@Test(dataProvider="getvalue")
	public  void runCreateLead(String CName,String FName ,String LName, String PhNo) {
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(CName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(FName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(PhNo);
		driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains("Testleaf")) {
			System.out.println("Lead created successfully");
		}
		else {
			System.out.println("Lead is not created");
		}
		


	}

}