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

public class LoginPageTest {
    public WebDriver driver;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    SearchPage searchPage;
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
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test(priority = 1)
    public void LoginpagetestUI(String phonenumber){
        loginPage.amazonlogo();
        loginPage.mailandphonenumberlabel();
        loginPage.enterphonenumber("7396547606");
        loginPage.clickcontinueButton();
        String Expurl="https://www.amazon.com/?ref_=nav_signin";
        String actualurl=driver.getCurrentUrl();
        Assert.assertEquals(Expurl,actualurl,"Urls do not match as expected");
    }

}
