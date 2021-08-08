package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

    @FindBy(xpath = "//*[@class='discount discount-percentage']")
    private WebElement productDiscount;
    @FindBy(id = "group_1")
    private WebElement sizeDropDown;
    @FindBy(xpath = "//i[@class='material-icons touchspin-up']")
    private WebElement quantityIncreaseButton;
    int productAmount = 4;
    @FindBy(xpath = "//i[@class='material-icons shopping-cart'][normalize-space()='\uE547']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[@class='btn btn-primary'][normalize-space()='\uE876Proceed to checkout']")
    private WebElement checkoutButton;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isThereAnyDiscount() {
        return productDiscount.isDisplayed();
    }

    public void selectSizeOfTheSweater() {
        Select size = new Select(sizeDropDown);
        size.selectByVisibleText("M");
    }

    public void setQuantity() {
        for (int i = 0; i < productAmount; i++) {
            quantityIncreaseButton.click();
        }
    }

    public void addToCart(){
        addToCartButton.click();
    }

    public void confirm(){
        checkoutButton.click();
    }
}
