package NewAutomationFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductPage {
    WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "search_product")
    WebElement ProductSearchField;

    @FindBy(id="submit_search")
    WebElement SearchBtn;

    @FindBy(className = "add-to-cart")
    WebElement AddtoCartBtn;

    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
    WebElement Productname;

    @FindBy(xpath = "//a[contains(normalize-space(.),'View Cart')]")
    WebElement ViewCartBtn;



    public void searchProduct(String productname){
        ProductSearchField.sendKeys(productname);
        SearchBtn.click();
    }

    public void verifyProduct(String productname){
        String actualproductname = Productname.getText();
        Assert.assertEquals(actualproductname,productname);
    }

    public void Addtocart(){
        AddtoCartBtn.click();
    }
    public  void ClickViewCart(){
        ViewCartBtn.click();
    }

}
