package pages;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SmartBearWebOrdersPage extends SmartBearLoginPage {
    public SmartBearWebOrdersPage() {super();};

    @FindBy(css = "ul[id=ctl00_menu]>li")
    public List<WebElement> menuItemList;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement btnCheckAll;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement btnUncheckAll;

    @FindBy(css = "table[class=SampleTable]")
    public WebElement ordersTable;

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productOptions;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement productQuantity;

    public void clickBtnByVisibleText(String btn) {
        switch (btn) {
            case "Check All":
                btnCheckAll.click();
                break;
            case "Uncheck All":
                btnUncheckAll.click();
                break;
            default:
                throw new NotFoundException(btn + " is not found!");
        }
    }

    public void selectMenuItemByText(String option) {
        for(WebElement item : menuItemList) {
            if(item.getText().equals(option)) {
                item.click();
                break;
            }
        }
    }
}
