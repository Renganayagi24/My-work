package testng2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends ProjectSpecificMethod {
	@DataProvider(name="getvalue")
	public String[][] fetchdata() {
		String[][] value = new String[3][4];
		value[0][0] ="Testleaf";
		value[0][1] ="Aravind";
		value[0][2] ="R";
		value[0][3] ="9878";
		
		value[1][0] ="Testleaf";
		value[1][1] ="Ragu";
		value[1][2] ="M";
		value[1][3] ="9876";
		
		value[2][0] ="Testleaf";
		value[2][1] ="Vinoth";
		value[2][2] ="P";
		value[2][3] ="9874";
		
		return value;
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