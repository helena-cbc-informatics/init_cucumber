package init_cucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;

import static init_cucumber.Driver.*;
import static locators.Google.*;


public class StepDefinitions {

    @Given("I am at website {string}")
    public void iAmAtWebsite(String website) throws Exception {
        startChromeBrowser(website);
    }

    @When("I search for {string}")
    public void iSearchFor(String content) throws Exception {
        getElementByXpath(BTN_ACCEPT_COOKIES).click();
        getElementByXpath(INP_SEARCH).sendKeys(content + Keys.ENTER);
    }

    @Then("I validate Helenas LinkedIn is displayed")
    public void iValidateHelenasLinkedInIsDisplayed() throws Exception {
        getElementByXpath(LBL_HELENA_CARONA_LINKED_IN);
    }

    @After
    public void closeBrowser() {
        closeChromeDriver();
    }

}
