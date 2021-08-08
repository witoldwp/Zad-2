package zad2;

import cucumber.api.java.en.Then;
import pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class SearchTest {
    private WebDriver driver;
    private HomePage homePage;
    private LogInToYourAccountPage logInToYourAccount;
    private YourAccountPage yourAccountPage;
    private SearchResultsPage searchResultsPage;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;

    @Given("Page (.*) opened in browser")
    public void pageOpenedInBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(url);
        homePage = new HomePage(driver);
        logInToYourAccount = new LogInToYourAccountPage(driver);
        yourAccountPage = new YourAccountPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productPage = new ProductPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @When("Sign in link clicked on home page")
    public void signIn() {
        homePage.clickSignIn();
    }

    @And("email entered in login form email input")
    public void enterEmailToSignIn() {
        String emailValue = "HardingGamgee@teleworm.us";
        logInToYourAccount.fillEmailToSignIn(emailValue);
    }

    @And("password entered in login form password input")
    public void enterPasswordToSignIn() {
        String passwordValue = "Ho0owahd";
        logInToYourAccount.fillPasswordToSignIn(passwordValue);
    }

    @And("SignIn button clicked")
    public void clickSignInButton() {
        logInToYourAccount.clickSignInBtn();
    }

    @Then("find cloths you want")
    public void findClothsYouWant() {
        String searchFor = "Hummingbird Printed Sweater";
        yourAccountPage.setSearchBar(searchFor);
    }

    @And("check if you found your product")
    public void checkIfYouFound() {
        assertTrue(searchResultsPage.isDisplayed());
    }

    @And("click your product")
    public void clickSearchedProduct() {
        searchResultsPage.clickYourProduct();
        assertTrue(productPage.isThereAnyDiscount());
    }

    @And("select size")
    public void selectSize() {
        productPage.selectSizeOfTheSweater();
        productPage.setQuantity();
    }

    @And("add the product to the cart and checkout")
    public void addToCartAndCheckOut() {
        productPage.addToCart();
        productPage.confirm();
    }

    @Then("finalize shopping")
    public void finalizeShoppingProcess() {
        shoppingCartPage.checkOut();
    }

    @And("take screen shot and quit")
    public void takeScreenShot() {
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileHandler.copy(scrFile, new File("c:\\tmp\\screenshot.png"));
    }

    @And("close")
    public void close() {
        driver.quit();
    }
}
