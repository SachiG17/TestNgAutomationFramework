package NewAutomationFramework.Tests;
import NewAutomationFramework.pageobjects.HomePage;
import NewAutomationFramework.pageobjects.ProductPage;
import NewAutomationFramework.pageobjects.TestComponents.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    @Test(dataProvider = "getData")
    public  void AddProductandVerify(String productName){
        HomePage homePage=new HomePage(driver);
        homePage.openProductPage();
        ProductPage productPage = new ProductPage(driver);
        productPage.searchProduct(productName);
        productPage.verifyProduct(productName);
        productPage.Addtocart();
//        productPage.ClickViewCart();
//        CartPage cartPage = new CartPage(driver);
//        cartPage.ProceedToCart();

    }
    @DataProvider
    public Object[] getData(){
        return new Object[][]{{"Blue Top"},{"Men Tshirt"}};

    }
}
