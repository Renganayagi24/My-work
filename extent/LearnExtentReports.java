package extent;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtentReports {
	public static void main(String[] args) throws IOException {
		ExtentHtmlReporter wb = new ExtentHtmlReporter("./reports/loginreport.html");
		wb.setAppendExisting(true);
		ExtentReports repo = new ExtentReports();
		repo.attachReporter(wb);
		ExtentTest test = repo.createTest("LoginPage", "Login With Valid data for leaftaps application");
		test.assignAuthor("Selenium");
		test.assignCategory("Sanity");
		test.pass("Enter the UserName");
		test.pass("Enter the Password");
		test.pass("LoginButton");
		
		ExtentTest test1 = repo.createTest("LoginPage", "CreateLead Login with Valid Data");
		test1.assignAuthor("SeleniumDemo");
		test1.assignCategory("Smoke");
		test1.pass("Enter the UserName");
		test1.pass("Enter the Password");
		test1.pass("LoginButton");
		test1.pass("Click on crmsfa", MediaEntityBuilder.createScreenCaptureFromPath(".././snap/img.jpg").build());
		repo.flush();
		System.out.println("Done");
		
	}

}
