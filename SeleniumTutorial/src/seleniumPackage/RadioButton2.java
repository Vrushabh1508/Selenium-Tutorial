package seleniumPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		// Creating the list of all radio button
		List<WebElement> radios = driver.findElements(By.xpath("//input[@name='sex']"));
		System.out.println("Total Radio Buttons : " + radios.size()); // size() method is used to get total number of
																		// web elements stored in a list.

		System.out.println(radios.get(3).isDisplayed()); // Check if radio button is displayed or not
		radios.get(1).click(); // Click on radio button
		System.out.println(radios.get(0).isDisplayed());
		System.out.println(radios.get(0).isEnabled()); // Check if radio button is enabled or not
		System.out.println(radios.get(0).isSelected()); // Check if radio button is selected or not
		radios.get(2).click();
		System.out.println(radios.get(1).isEnabled());
		System.out.println(radios.get(1).isSelected());

	}

}
