package seleniumPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://login.yahoo.com/account/create?lang=en-IN&src=ym&done=https%3A%2F%2Fin.mail.yahoo.com%2F%3Fguce_referrer%3DaHR0cHM6Ly93d3cuZ29vZ2xlLmNvbS8%26guce_referrer_sig%3DAQAAANoA0fMp4h0zucy-mOPK2Pp5uciwips3rxnFdxgiiRW9XhvbBsbDlt1KOmMXh4vM3RI5Mw1WmoQJcAsLmPaPdGZSmOrq9SKVcdQBCBEf0Tykf5Pq9qp7D9CSK4Q-ImjNhHfODYlCHsyBBToIvXmk9Q7sMXqt9pcgl0k_1JZIE6YF&specId=yidReg");
		// 1st way to handle dropdown :- (Not recommended)
		List<WebElement> bm = driver.findElements(By.xpath("//select[@id='usernamereg-month']/option"));
		bm.get(3).click();
		System.out.println(bm.get(3).isEnabled());

		// 2nd way to handle dropdown :- (Recommended)
		WebElement birthMonth = driver.findElement(By.xpath("//select[@id='usernamereg-month']"));

		Select month = new Select(birthMonth); // Introduced Select class as constructor

		// Select by Visible Text
		month.selectByVisibleText("April"); // April

		// Select by Value
		month.selectByValue("6"); // June

		// Select by Index
		month.selectByIndex(8); // August

		System.out.println(month.getFirstSelectedOption().getText()); // Get the latest selected option from dropdown

		// 3rd way to handle dropdown

		List<WebElement> dropdown = month.getOptions(); // We stored all dropdown values in the list
		for (int i = 0; i < dropdown.size(); i++) {
			String dropdownValues = dropdown.get(i).getText();
			Thread.sleep(2000);
			if (dropdownValues.equalsIgnoreCase("August")) {
				dropdown.get(i).click();
				// or
				month.selectByVisibleText(dropdownValues);
			}
		}

		// 4th way :- Checking if dropdown is supporting multiple selection or not
		System.out.println(month.isMultiple());
		month.selectByIndex(10);
		month.selectByValue("12");
		month.selectByVisibleText("April");

		// 5th way :- (Never recommended)
		birthMonth.sendKeys("March");
	}

}
