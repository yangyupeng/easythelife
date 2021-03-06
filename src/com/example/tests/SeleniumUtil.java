package com.example.tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

public class SeleniumUtil {
	public static WebDriver driver;

	public static void clickUtilClickable(By clickedBy, WebDriverWait yourWait) {
		WebDriverWait wait = yourWait;
		wait.until(ExpectedConditions.presenceOfElementLocated(clickedBy));
		wait.until(ExpectedConditions.elementToBeClickable(clickedBy));
		WebElement element = driver.findElement(clickedBy);
		System.out.println("The Class of clicked element is:"
				+ element.getClass());
		System.out.println("The Text of clicked element is:"
				+ element.getText());
		System.out.println("-------------------------------------------------");
		element.click();
	}

	public static void clickUtilClickable(By clickedBy) {
		clickUtilClickable(clickedBy, new WebDriverWait(driver, 30));
	}

	public static void selectByValueUtilSelectable(By selectBy, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(selectBy));
		WebElement element = driver.findElement(selectBy);

		System.out.println("The Class of selected element is:"
				+ element.getClass());
		System.out.println("The Text of selected element is:"
				+ element.getText());
		System.out.println("-------------------------------------------------");
		// wait.until(ExpectedConditions.elementToBeSelected(selectBy));
		new Select(driver.findElement(selectBy)).selectByValue(value);
	}

	public static void waitForInput(WebElement waitInputElement) {
		WebDriverWait longWait = new WebDriverWait(driver, 300);
		waitInputElement.clear();
		String regex = "\\d{4}";
		longWait.until(ExpectedConditions.textToBeMatchInElementValue(
				waitInputElement, regex));
	}

	public static void waitForInput(By waitInputBy) {
		WebElement waitInputElement = driver.findElement(waitInputBy);
		waitForInput(waitInputElement);
	}

	protected static boolean switchWindow(String basicurl) {

		String currentWindow = driver.getWindowHandle();
		Set<String> availableWindows = driver.getWindowHandles();
		if (!availableWindows.isEmpty()) {
			for (String windowId : availableWindows) {
				String currentURL = driver.switchTo().window(windowId)
						.getCurrentUrl();
				System.out.println("Current windowId:" + windowId);
				System.out.println("Current currentURL:" + currentURL);
				if (currentURL.contains(basicurl)) {
					return true;
				} else {
					driver.switchTo().window(currentWindow);
				}
			}
		}
		return false;
	}

	public static void sendkeyUtilPresence(By inputBy, String inputContent) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(inputBy));
		WebElement element = driver.findElement(inputBy);
		element.clear();
		element.sendKeys(inputContent);
		System.out.println("The Class of sendkey element is:"
				+ element.getClass());
		System.out.println("The Text of sendkey element is:"
				+ element.getText());
		System.out.println("-------------------------------------------------");
		element.click();
	}
}
