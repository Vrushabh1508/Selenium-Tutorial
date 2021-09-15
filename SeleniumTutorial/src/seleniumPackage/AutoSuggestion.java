package seleniumPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("how stuff works");

		// Handle Auto Suggestion
		WebElement allSuggestion = driver.findElement(By.xpath("//*[@role='listbox']"));
		List<WebElement> allSearch = allSuggestion.findElements(By.tagName("li"));

		for (int i = 0; i < allSearch.size(); i++) {
			String allSuggestionList = allSearch.get(i).getText();

			String finalResult = "how stuff works videos";
			if (allSuggestionList.equalsIgnoreCase(finalResult)) {
				allSearch.get(i).click();
				System.out.println("You have selected : " + finalResult);
				break;
			}
		}

	}

}
