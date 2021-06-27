// Sencha WebTestIt Test File

package uitest.tests;

import uitest.TestNgTestBase;
import uitest.pageobjects.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

class LoginTest extends TestNgTestBase {
    @Test
    public void SimpleLoginTestCase() {
        WebDriver driver = getDriver();

        // 1. Arrange
        // Create a new Page Object instance by right-clicking into the code editor and
        // selecting "Instantiate Page Object" at the bottom of the context menu

        loginPage loginPageInstance = new loginPage(driver);
        loginPageInstance.open("https://www.sencha.com");

        // 2. Act
        // Call an existing action from your Page Object instance
        loginPageInstance.loginToPage("100496", "dannyemployee", "Password1");

        // 3. Assert
        // Use TestNG assertions to verify results.
        // e.g.:
        // Assert.assertEquals(title, "Test Automation for GUI Testing | Sencha");
        loginPageInstance.validateLoggedIn();
    }
}
