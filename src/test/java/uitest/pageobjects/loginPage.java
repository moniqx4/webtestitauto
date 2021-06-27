// Sencha WebTestIt Page Object File

package uitest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class loginPage {
    private By BTN_SUBMIT = By.cssSelector("#submit");
    private By TXTBOX_COMPANYALIAS = By.cssSelector("#companyId");
    private By TXTBOX_USERNAME = By.cssSelector("#username");
    private By TXTBOX_PASSWORD = By.cssSelector("#password");

    /*
     * NOTE: Use the Elements Panel to generate element code
     */

    protected WebDriver driver;
    protected WebDriverWait wait;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public loginPage open(String url) {
        this.driver.get(url);

        return this;
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public Boolean isBTN_SUBMIT_Present() {
        Boolean BTN_SUBMIT_IsPresent = driver.findElements(this.BTN_SUBMIT).size() > 0;

        return BTN_SUBMIT_IsPresent;
    }

    /*
     * NOTE: Drag elements from the Elements panel into the code editor to generate
     * methods. Drag elements into existing methods to add steps.
     */
    public loginPage loginToPage(String companyAlias, String username, String password) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.TXTBOX_COMPANYALIAS)).sendKeys(companyAlias);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.TXTBOX_USERNAME)).sendKeys(username);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.TXTBOX_PASSWORD)).sendKeys(password);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.BTN_SUBMIT)).click();

        return this;
    }

    public void ValidateLoggedIn() {
      Assert.assertTrue(this.getTitle() == "Login Page");
    }

}
