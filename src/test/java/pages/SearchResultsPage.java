package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    @FindBy(xpath = "//a[normalize-space()='Hummingbird printed sweater']")
    private WebElement sweaterProductFound;
    @FindBy(xpath = "//img[@alt='Brown bear printed sweater']")
    private WebElement productImage;

    public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed(){
        return sweaterProductFound.getText().equals("Hummingbird Printed Sweater");
    }

    public void clickYourProduct(){
        productImage.click();
    }
}
