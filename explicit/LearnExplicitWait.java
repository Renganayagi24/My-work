package explicit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnExplicitWait {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/waits.xhtml");
		driver.findElement(By.xpath("(//span[text()='Click'])[2]")).click();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		Boolean until = w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[text()='I am about to hide'"))));
        System.out.println(until);	
        w.until(ExpectedConditions.numberOfWindowsToBe(3));
	}

}
