package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SmartBearWebOrdersPage extends SmartBearLoginPage {
    public SmartBearWebOrdersPage() {super();};

    @FindBy(css = "ul[id=ctl00_menu]>li")
    public List<WebElement> menuItemList;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement btnCheckAll;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement btnUncheckAll;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement btnDeleteSelected;

    @FindBy(css = "table[class=SampleTable]")
    public WebElement ordersTable;

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement orderProductOptions;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement orderProductQuantity;

    @FindBy(xpath = "((//table)[2]//ol)[2]//input")
    public List<WebElement> orderAddressInfoInputList;

    @FindBy(css = "table[id=ctl00_MainContent_fmwOrder_cardList] label")
    public List<WebElement> orderPmntCardType;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement orderPmntCardNO;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement orderPmntCardExp;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement btnProcessOrder;

    @FindBy(tagName = "h2")
    public WebElement subHeading;

    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement msgEmptyOrder;


    public void clickBtnByVisibleText(String btn) {
        switch (btn) {
            case "Check All":
                btnCheckAll.click();
                break;
            case "Uncheck All":
                btnUncheckAll.click();
                break;
            case "Process":
                btnProcessOrder.click();
                break;
            case "Delete Selected":
                btnDeleteSelected.click();
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

    public void selectCardType(String card) {
        switch (card) {
            case "Visa":
                orderPmntCardType.get(0).click();
                break;
            case "MasterCard":
                orderPmntCardType.get(1).click();
                break;
            case "American Express":
                orderPmntCardType.get(2).click();
                break;
            default:
                throw new NotFoundException(card + " is not available!");
        }
    }
}
