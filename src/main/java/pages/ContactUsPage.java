package pages;

import driver.MobileDriverManager;
import enums.WaitStrategy;
import factories.MobileExplicitWaitFactories;
import frameConstatnt.testConstant.Constant;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.MobileTestLog;

public final class ContactUsPage {

    public ContactUsPage() {
        PageFactory.initElements(MobileDriverManager.getDriver(), this);
    }

    @FindBy(xpath = " //android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/itemTextView' and @text='Contact us']")
    private WebElement contactUs;


    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/item_name' and @text='Call']")
    private WebElement callOption;


    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_phone_no']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/item_name' and @text='Write to Us']")
    private WebElement writeToUs;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.zopsmart.stg.scarlet:id/et_name']")
    private WebElement name;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.zopsmart.stg.scarlet:id/et_number']")
    private WebElement phoneNo;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.zopsmart.stg.scarlet:id/btn_submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.zopsmart.stg.scarlet:id/et_description']")
    private WebElement description;

    public ContactUsPage clickOnContactUs(String testname) {
        MobileExplicitWaitFactories.click(contactUs, WaitStrategy.CLICKABLE, "user clicked on contact Us");
        MobileTestLog.logTestStep(testname, "User clicked on contact Us", "user clicked on contact Us");
        return this;

    }

    public ContactUsPage validateCallOption(String text, String testname) {
        MobileExplicitWaitFactories.click(callOption, WaitStrategy.CLICKABLE, "user clicked on call option");
        String phoneNo = MobileExplicitWaitFactories.getText(phoneNumber, text, WaitStrategy.ELEMENT_TO_HAVE_TEXT, "Check mobile number");
        Assert.assertEquals(phoneNo, Constant.PHONE_NO);
        MobileTestLog.logTestStep(testname, "User clicked on call option", "user clicked on call option");
        return this;

    }

    public ContactUsPage validateWriteToUs(String userName, String phoneNumber, String complainDescription, String submitText, String testname) {

        MobileExplicitWaitFactories.click(writeToUs, WaitStrategy.CLICKABLE, "user clicked on write to us");
        MobileExplicitWaitFactories.click(name, WaitStrategy.CLICKABLE, "user click on name section");
        MobileExplicitWaitFactories.sendKeys(name, userName, WaitStrategy.VISIBLE, " their name");
        MobileDriverManager.getDriver().navigate().back();
        MobileExplicitWaitFactories.click(phoneNo, WaitStrategy.CLICKABLE, "user click on  phoneNumber section");
        MobileExplicitWaitFactories.sendKeys(phoneNo, phoneNumber, WaitStrategy.VISIBLE, "user enter their phoneNo.");
        MobileDriverManager.getDriver().navigate().back();
        MobileExplicitWaitFactories.click(description, WaitStrategy.CLICKABLE, "user click on description");
        MobileExplicitWaitFactories.sendKeys(description, complainDescription, WaitStrategy.VISIBLE, " description ");
        MobileDriverManager.getDriver().navigate().back();
        String submit = MobileExplicitWaitFactories.getText(submitButton, submitText, WaitStrategy.ELEMENT_TO_HAVE_TEXT, "Check submit button is enable or not ");
        Assert.assertEquals(submit, Constant.SUBMIT);
        MobileTestLog.logTestStep(testname, "User clicked on write to us", "user clicked on write to us");
        return this;

    }
}
