import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.SearchPage;
import pages.ShoppingcartPage;

public class ShoppingcartpageTest {
    WebDriver driver;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    SearchPage searchPage;
    ShoppingcartPage shoppingcartpage;
    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"ashwinipitti.1@gmail.com", "Ashwini@222"}
        };
    }

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.vikrambooks.com/account/login");
        loginPage=new LoginPage(driver);
        registrationPage=new RegistrationPage(driver);
        searchPage=new SearchPage(driver);
        shoppingcartpage=new ShoppingcartPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test(priority = 1)
    public void shoppingcarttest() {
        searchPage.addtoCart();
        String expcarturl = "https://www.amazon.com/gp/aw/c?ref_=navm_hdr_cart";
        String actualurl = "https://www.amazon.com/gp/aw/c";
        Assert.assertEquals(expcarturl, actualurl, "Cart page was not displayed as expected");
        shoppingcartpage.proceedtocheckbuttonEl();
        String expproceedpageurl="https://www.amazon.com/gp/buy/kyc/xborder/handlers/display.html?_from=cheetah";
        String actualproccedpageurl="https://www.amazon.com/gp/cart/view.html?ref_=nav_cart";
        Assert.assertEquals(expproceedpageurl,actualproccedpageurl,"Expected proceeding urls are not displayed");
        shoppingcartpage.checkboxselect();
        shoppingcartpage.setQuantityel();
        String expquantitycount="2";
        int count=Integer.parseInt(expquantitycount);
        Assert.assertEquals(expquantitycount,count,"count as not expected");

        shoppingcartpage.clickskipforNowEl();
        shoppingcartpage.clickcontinueButton();
        String ExpContiunepageurl="https://www.amazon.com/gp/buy/payselect/handlers/display.html?_from=cheetah";
        String actualcontinuepageurl="https://www.amazon.com/gp/cart/view.html?ref_=nav_cart";
        Assert.assertEquals(ExpContiunepageurl,actualcontinuepageurl,"Urls are not as expected");
        shoppingcartpage.ordersuccessmessage();

    }}

