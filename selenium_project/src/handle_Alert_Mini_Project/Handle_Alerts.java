package handle_Alert_Mini_Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Handle_Alerts {
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Karthick\\selenium_project\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Mouse hover to the switchTo element
		WebElement switch_To =  driver.findElement(By.xpath("//a[text()='SwitchTo']"));
		Actions mousehover = new Actions(driver);
		mousehover.moveToElement(switch_To).build().perform();
		
		//Alerts box
		WebElement element = driver.findElement(By.xpath("//a[text()='Alerts']"));
		element.click();
		Thread.sleep(3000);
		
		System.out.println("Alert with ok handling is started");
        WebElement alertWithOk = driver.findElement(By.xpath("//a[text()='Alert with OK ']"));
        alertWithOk.click();
        Thread.sleep(3000);
        
        WebElement alertBox = driver.findElement(By.xpath("//div[@id='OKTab']/child::button"));
        alertBox.click();
        
        try {  // Handling Exception
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();
        }
        catch (NoAlertPresentException e) {
        	System.out.println("No alert popup is founded");
        }
        System.out.println("You Pressed Ok");
        System.out.println("Alert with Ok handled is successfully");
        
        
        //confirm Box
        System.out.println("Alert with Ok & Cancel handling is started");
        WebElement alertWithOKandCancel = driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']"));
        alertWithOKandCancel.click();
        Thread.sleep(3000);
        
        WebElement confirmBox = driver.findElement(By.xpath("//div[@id='CancelTab']/child::button"));
        confirmBox.click();
        
        try {  // Handling Exception
        Alert confirm = driver.switchTo().alert();
        Thread.sleep(3000);
        confirm.dismiss();
        }
        catch (NoAlertPresentException e) {
        	System.out.println("No alert pop up is founded");
        }
        String str = driver.findElement(By.id("demo")).getText();
        System.out.println(str);
        System.out.println("Alert with Ok & Cancel handled is Successfully");
        
        //Prompt Textbox
        System.out.println("Prompt Textbox handling is started");
        WebElement alertWithTextbox = driver.findElement(By.xpath("//a[text()='Alert with Textbox ']"));
        alertWithTextbox.click();
        Thread.sleep(3000);
        
        WebElement promptBox = driver.findElement(By.xpath("//div[@id='Textbox']/child::button"));
        promptBox.click();
        
        // Handling Exception
        try {
        
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("Karthickraja");
        Thread.sleep(3000);
        prompt.accept();
        }
        
        catch (NoAlertPresentException e) {
        	System.out.println("No alert pop up is founded");
        }
        
        String text = driver.findElement(By.id("demo1")).getText(); 
        System.out.println(text);  // get text is successfully
        System.out.println("Prompt Textbox handled is Successfully");
        
        
        //Close the Browser
        driver.close();

       
	}
	 
}
