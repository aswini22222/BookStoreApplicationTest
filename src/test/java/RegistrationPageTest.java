import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationPageTest {
    public WebDriver driver;
    RegistrationPage registrationPage;
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        registrationPage=new RegistrationPage(driver);

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test(priority = 1)
    public void RegistrationPageUI(String mail,String password) {
        registrationPage.clickSignIn();
        String expSigninurl = "https://www.amazon.com/ap/signin";
        String actualurl = "https://www.amazon.com/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fhomepage.html%3F_encoding%3DUTF8%26ref_%3Dnavm_em_signin%26action%3Dsign-out%26path%3D%252Fgp%252Fhomepage.html%253F_encoding%253DUTF8%2526ref_%253Dnavm_em_signin%26signIn%3D1%26useRedirectOnSuccess%3D1%26ref_%3Dnav_em_signout_0_1_1_39&prevRID=EEYXJRMM1X1V67RKSKTK&openid.assoc_handle=usflex&openid.mode=checkid_setup&failedSignInCount=0&pageId=usflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0";
        Assert.assertEquals(expSigninurl, actualurl, "Sign In urls are not as expected");
        registrationPage.entermail("ashwinipitti.1@gmail.com");
        registrationPage.clickcontinueButton();
        String Expsignurl = "https://www.amazon.com/ap/signin";
        String actualsignurl = "https://www.amazon.com/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fhomepage.html%3F_encoding%3DUTF8%26ref_%3Dnavm_em_signin%26action%3Dsign-out%26path%3D%252Fgp%252Fhomepage.html%253F_encoding%253DUTF8%2526ref_%253Dnavm_em_signin%26signIn%3D1%26useRedirectOnSuccess%3D1%26ref_%3Dnav_em_signout_0_1_1_39&prevRID=EEYXJRMM1X1V67RKSKTK&openid.assoc_handle=usflex&openid.mode=checkid_setup&failedSignInCount=0&pageId=usflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0";
        if (Expsignurl.equals(actualsignurl)) {
            System.out.println("signinurls are matched");
        } else {
            System.out.println("urls are not matched as expected");
        }
        registrationPage.enterpassword("Aswini@222");
        registrationPage.enterotp("235212");
        registrationPage.clickSignIn();
        String loginpageurl = "https://www.amazon.com/?_encoding=UTF8&ref_=navm_hdr_signin";
        String actualbackurl = "https://www.amazon.com/ap/mfa?ie=UTF8&arb=4b552821-a10e-49b9-a3ca-a7fbe18a2584&mfa.arb.value=4b552821-a10e-49b9-a3ca-a7fbe18a2584&mfa.arb.key=arb";
        Assert.assertEquals(loginpageurl, actualbackurl, "urls do not matched");
    }

@Test(priority = 2)
    public void registrationpageUI(String Firstname,String mail,String email){
        registrationPage.NewtoAmazonAccountHeadText();
        registrationPage.firstandlastnameLabel();
        registrationPage.enterfirstName("Aswini");
        registrationPage.mobilenumberLabelText();
        registrationPage.entermail("ashwinipitti.1@gmail.com");
        registrationPage.createpasswordlabelText();
        registrationPage.enterpassword("Aswini@222");
        registrationPage.clickcontinueButton();
        String exploginpageurl="https://www.amazon.com/gp/css/homepage.html?ref_=nav_youraccount_btn";
        String actualloginpageurl="https://www.amazon.com/gp/css/homepage.html?ref_=nav_AccountFlyout_ya";
        if(exploginpageurl.equals(actualloginpageurl)){
            System.out.println("ulrs matched");
        }else{
            System.out.println("Urls do not matched");
        }
        registrationPage.errormessageText();
        String experrorMsg="enter valid password and mail";
        String actualerr=registrationPage.errormessageText();
        Assert.assertEquals(experrorMsg,actualerr,"Error messages was not as expected");





}


    }


