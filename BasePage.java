package framework;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mohammadmuntakim
 */
public class BasePage {

	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementNotFoundException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	public void clickOn(By locator) {
		webAction(locator).click();
	}

	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
	}

	public String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public void selectFromDropdown(By locator, String dropdownText) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by visible text
		selectMonth.selectByVisibleText(dropdownText);
	}

	public void selectFromDropdown(By locator, int index) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by index
		selectMonth.selectByIndex(index);
	}

	public void selectDropDownByText(By locator, String text) {
		Select dropDown = new Select(webAction(locator));
		dropDown.selectByVisibleText(text);
	}
	public void selectDropDownByValue(By locator, String value) {
		Select dropDown = new Select(webAction(locator));
		dropDown.selectByValue(value);
	}
	public void selectDropDownByIndex(By locator, int index) throws StaleElementReferenceException{
		try {
			Select dropdown = new Select(SharedSD.getDriver().findElement(locator));
			dropdown.selectByIndex(index);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
		}
	}

	public void selectRadioButton (By locator, String attribute, String index){
		List<WebElement> listOfLinks = SharedSD.getDriver().findElements(locator);
		for (WebElement element : listOfLinks ){
			String value = element.getAttribute(attribute);
			if(value.equals(index)){
				element.click();
				break;
			}
		}
	}

	public void selectTodayFromCalendar(By locator) {
		SimpleDateFormat sdf = new SimpleDateFormat("d");
		Date date = new Date();
		String todayDate = sdf.format(date);
		List<WebElement> days = SharedSD.getDriver().findElements(locator);
		for (WebElement day : days) {
			String expectedDay = day.getText();
			if (expectedDay.equals(todayDate)) {
				day.click();
				break;
			}
		}
	}

	public void selectDesiredDate(By locator, int dayNumber) {
		SimpleDateFormat sdf = new SimpleDateFormat("d");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, dayNumber);  // 0 for today, 1 for tomorrow and so on....
		String desiredDay = sdf.format(c.getTime());
		List<WebElement> days = SharedSD.getDriver().findElements(locator);
		for (WebElement day : days) {
			String expectedDay = day.getText();
			if (expectedDay.equals(desiredDay)) {
				day.click();
				break;
			}
		}
	}

	public static String desiredDateWithPattern(int day,String datePattern){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		cal.add(Calendar.DATE,day);
		return sdf.format(cal.getTime());
	}

	public void switchToWindow(int index) {
		List<String> listOfWindows = new ArrayList<>(SharedSD.getDriver().getWindowHandles());
		SharedSD.getDriver().switchTo().window(listOfWindows.get(index));
	}

	public void switchToInitialWindowAndCloseCurrentWindow() {
		List<String> listOfWindows = new ArrayList<>(SharedSD.getDriver().getWindowHandles());
		for (int i = 1; i < listOfWindows.size(); i++) {
			SharedSD.getDriver().switchTo().window(listOfWindows.get(i));
			SharedSD.getDriver().close();
		}
		SharedSD.getDriver().switchTo().window(listOfWindows.get(0));
	}

	public void handleMouseOver(By locator) {
		WebElement element = webAction(locator);
		Actions action = new Actions(SharedSD.getDriver());
		action.moveToElement(element).build().perform();
	}

	public void switchToFrame(String string) {
		SharedSD.getDriver().switchTo().frame(string);
	}

	public void acceptAlert() {
		SharedSD.getDriver().switchTo().alert().accept();
	}

	public void dismissAlert() {
		SharedSD.getDriver().switchTo().alert().dismiss();
	}

	public void sendInputToAlert(String string) {
		SharedSD.getDriver().switchTo().alert().sendKeys(string);
	}

	public void clickFromAutoCompleteByText(By locator, String string) {
		try {
			List<WebElement> list = SharedSD.getDriver().findElements(locator);
			for (WebElement e : list) {
				if (e.getText().equals(string)) {
					e.click();
					break;
				}
			}
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public void scrollIntoView(By locator) throws InterruptedException {
		SharedSD.getDriver().manage().window().maximize();
		WebElement element = webAction(locator);
		((JavascriptExecutor)SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(3000);
		element.click();
	}

}
