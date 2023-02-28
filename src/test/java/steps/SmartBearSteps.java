package steps;

import co.boorse.seleniumtable.SeleniumTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.SmartBearLoginPage;
import pages.SmartBearWebOrdersPage;
import utilities.Driver;
import utilities.TableHandler;

public class SmartBearSteps {
    // TODO: create hooks class before running

    WebDriver driver;
    Select select;
    SmartBearLoginPage smartBearLoginPage;
    SmartBearWebOrdersPage smartBearWebOrdersPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        smartBearLoginPage = new SmartBearLoginPage();
        smartBearWebOrdersPage = new SmartBearWebOrdersPage();
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user enters username as {string}")
    public void userEntersUsernameAs(String username) {
        smartBearLoginPage.usernameInput.clear();
        smartBearLoginPage.usernameInput.sendKeys(username);
    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String password) {
        smartBearLoginPage.passwordInput.clear();
        smartBearLoginPage.passwordInput.sendKeys(password);
    }


    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        smartBearLoginPage.loginBtn.click();
    }

    @Then("user should see {string} message")
    public void userShouldSeeMessage(String errorMsg) {
        Assert.assertEquals(errorMsg, smartBearLoginPage.loginFailureMsg.getText());
    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @And("validate below menu items are displayed")
    public void validateBelowMenuItemsAreDisplayed(DataTable data) {
        for(int i = 0; i < data.asList().size(); i++) {
            Assert.assertEquals(data.asList().get(i), smartBearWebOrdersPage.menuItemList.get(i).getText());
        }
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String btn) {
        smartBearWebOrdersPage.clickBtnByVisibleText(btn);
    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        for(int i = 1; i < TableHandler.getRows(smartBearWebOrdersPage.ordersTable).size(); i++) {
            Assert.assertTrue(TableHandler.getCheckbox(smartBearWebOrdersPage.ordersTable, i, 0).isSelected());
        }
    }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        for(int i = 1; i < TableHandler.getRows(smartBearWebOrdersPage.ordersTable).size(); i++) {
            Assert.assertFalse(TableHandler.getCheckbox(smartBearWebOrdersPage.ordersTable, i, 0).isSelected());
        }
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String menuOption) {
        smartBearWebOrdersPage.selectMenuItemByText(menuOption);
    }

    @And("user selects {string} as product")
    public void userSelectsAsProduct(String option) {
        select = new Select(smartBearWebOrdersPage.productOptions);
        select.selectByVisibleText(option);
    }


    @And("user enters {int} as quantity")
    public void userEntersAsQuantity(int quantity) {
        smartBearWebOrdersPage.productQuantity.sendKeys(String.valueOf(quantity));
    }
}
