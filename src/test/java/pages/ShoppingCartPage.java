package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    public ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='btn btn-primary'][normalize-space()='Proceed to checkout']")
    private WebElement checkoutButton2;
    @FindBy(xpath = "//button[@name='confirm-addresses'][@class='btn btn-primary continue float-xs-right'][normalize-space()='Continue']")
    private WebElement addressContinueBtn;
    @FindBy(xpath = "//button[@name='confirmDeliveryOption'][@class='continue btn btn-primary float-xs-right'][normalize-space()='Continue']")
    private WebElement shippingContinueBtn;
    @FindBy(xpath = "//input[@id='payment-option-1'][@name='payment-option'][@class='ps-shown-by-js ']")
    private WebElement paymentMethod;
    @FindBy(xpath = "//input[@id='conditions_to_approve[terms-and-conditions]'][@name='conditions_to_approve[terms-and-conditions]'][@class='ps-shown-by-js']")
    private WebElement agreeCheckBox;
    @FindBy(xpath = "//button[@class='btn btn-primary center-block'][normalize-space()='Order with an obligation to pay']")
    private WebElement orderWithPayObligation;


    public void checkOut() {
        checkoutButton2.click();
        addressContinueBtn.click();
        shippingContinueBtn.click();
        paymentMethod.click();
        agreeCheckBox.click();
        orderWithPayObligation.click();
    }
}
