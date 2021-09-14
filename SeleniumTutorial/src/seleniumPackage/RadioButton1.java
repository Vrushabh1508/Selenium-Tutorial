package seleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://materializecss.com/radio-buttons.html");

		// It is not a good approach
		System.out.println(
				driver.findElement(By.xpath("//body/main[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]/label[1]/span[1]"))
						.isEnabled());
		driver.findElement(By.xpath("//body/main[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]/label[1]/span[1]"))
				.click();
	}

}
