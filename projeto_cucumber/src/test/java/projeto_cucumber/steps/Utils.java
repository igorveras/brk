package projeto_cucumber.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	private static int timeout = 15;

	public static void click(WebDriver driver, WebElement element) {

		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao tentar localizar o elemento: " + element);
			driver.quit();
		}

	}
	
	public static void setText(WebDriver driver, WebElement element, String value) {

		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao tentar localizar o elemento: " + element);
			driver.quit();
		}

	}
	
	public static void validateObject(WebDriver driver, WebElement element) {
		
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
			if (element.getSize().getHeight() > 0) {
				System.out.println("Elemento foi exibido em tela: " + element);
			} else {
				System.out.println("Elemento não está sendo exibido " + element);
				driver.quit();
			}
			
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao tentar localizar o elemento: " + element);
			driver.quit();
		}
		
	}
	
}
