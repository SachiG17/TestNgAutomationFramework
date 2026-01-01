package NewAutomationFramework.Tests;

import NewAutomationFramework.pageobjects.CartPage;
import NewAutomationFramework.pageobjects.HomePage;
import NewAutomationFramework.pageobjects.ProductPage;
import NewAutomationFramework.pageobjects.TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    @Test
    public  void AddProductandVerify(){
        HomePage homePage=new HomePage(driver);
        homePage.openProductPage();
        ProductPage productPage = new ProductPage(driver);
        productPage.searchProduct("Men Tshirt");
        productPage.verifyProduct("Men Tshirt");
        productPage.Addtocart();
        productPage.ClickViewCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.ProceedToCart();

    }
}
