package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.*;


public class DarkSkyHomePage extends BasePage {


    private By timelineHours = By.xpath("//div[@class='hours']//span//span");
    private By timelineTemp = By.xpath("//div[@class='temps']//span//span");
    private By currentTempDisplayed = By.xpath("//span[@class='currently']/span[2]/span[1]");
    private By todayBar = By.xpath("//a[1]//span[2]//span[2]");
    private By lowTempBar = By.xpath("//*[@data-day=\"0\"]/span[2]/span[@class=\"minTemp\"]");
    private By highTempBar = By.xpath("//*[@data-day=\"0\"]/span[2]/span[@class=\"maxTemp\"]");
    private By lowestTempDisplayed = By.xpath("//*[@class='dayDetails revealed']//span[@class='highTemp swip']//span[@class='temp']");
    private By highestTempDisplayed = By.xpath("//*[@class='dayDetails revealed']//span[@class='lowTemp swap']//span[@class='temp']");


    //method for first Scenario
    public void verifyTimeline() {
        //get list of hours from the web
        List<WebElement> list = SharedSD.getDriver().findElements(timelineHours);
        ArrayList<String> forecasthours = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            forecasthours.add(list.get(i).getText());
        }
        //get list of hours in (am/pm) format
        SimpleDateFormat sdf = new SimpleDateFormat("ha");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 2);
        ArrayList<String> expectedForecastHours = new ArrayList<>();
        expectedForecastHours.add(0, "Now"); // index [0] = current hour
        for (int i = 0; i < 11; i++) {
            expectedForecastHours.add(sdf.format(calendar.getTime()).toLowerCase());
        }

    }

    //for second Scenario
    public void clickOnTodaysBar() throws InterruptedException {
        scrollIntoView(todayBar);
        Thread.sleep(2000);
    }

    public String lowTemperature() {
        return getTextFromElement(lowTempBar);
    }

    public String highTemperature() {
        return getTextFromElement(highTempBar);
    }

    public String lowestTemperatureDisplayed() {
        return getTextFromElement(lowestTempDisplayed);
    }

    public String highestTemperatureDisplayed() {
        return getTextFromElement(highestTempDisplayed);
    }


    // final scenario

    public boolean compareTimeLineTemp() {
        //Putting timeline visible hours into a list and converting that list into a String ArrayList
        List<WebElement> timelineTemperature = SharedSD.getDriver().findElements(timelineTemp);
        ArrayList<String> stringTimeLineTemperature = new ArrayList<>();
        for (WebElement element : timelineTemperature) {
            stringTimeLineTemperature.add(element.getText());

        }
        //Converting String ArrayList to Integer ArrayList
        ArrayList<Integer> intTimeLineTemperature = new ArrayList<>();
        for (String strElement : stringTimeLineTemperature) {
            intTimeLineTemperature.add(Integer.valueOf(strElement.substring(0, strElement.length() - 1)));
            Collections.sort(intTimeLineTemperature);
        }

        int maxTemp = Collections.max(intTimeLineTemperature);
        int minTemp = Collections.min(intTimeLineTemperature);

        //Extracting current temperature from the display and converting into Integer
        String currentTemp = SharedSD.getDriver().findElement(currentTempDisplayed).getText();
        String [] currentTempArray = currentTemp.split("˚");
        String splitCurrentTemp = currentTempArray [0];
        int intCurrentTemp = Integer.valueOf(splitCurrentTemp);


        //Comparing Temperatures
        boolean currentTempisNotGreater = false;
        if (intCurrentTemp>=minTemp && intCurrentTemp<=maxTemp) {
            currentTempisNotGreater = true;

        } return currentTempisNotGreater;


    }
}








