package stepdefinition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DarkSkyHomePage;
import org.testng.Assert;

public class DarkSkySD {
    private DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();



    @Given("^I am on DarkSky Homepage$")
    public void iAmOnHomepageOfDarkSky() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - 260 Broadway, New York City, NY","Invalid Homepage");

    }

    @When("^I expand today's timeline$")
    public void clickOnTodaysBar() throws InterruptedException {
        darkSkyHomePage.clickOnTodaysBar();
        }


    @Then("^I verify (timeline|lowest and highest temp) is displayed correctly$")
    public void verifyCorrectDisplay(String textField) {
    switch (textField) {
        case "forecast hours incrementation":
            darkSkyHomePage.verifyTimeline();
            break;
                case "low and high temp":
                    Assert.assertEquals(darkSkyHomePage.lowTemperature(), darkSkyHomePage.lowestTemperatureDisplayed());
                    Assert.assertEquals(darkSkyHomePage.highTemperature(), darkSkyHomePage.highestTemperatureDisplayed());
                    break;

        }

    }
    @Then("^I verify current temp is not greater and less then temps from daily timeline$")
    public void verifyTemp () {
        Assert.assertTrue(darkSkyHomePage.compareTimeLineTemp(),"Error: current temp is greater than max temp or less than min temp of daily timeline");

    }
}
