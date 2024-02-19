package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegistrationPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(linkText = "Account & Lists")
    WebElement signInlinkElement;
    @FindBy(id ="ap-eamil")
    WebElement entermailEl;
    @FindBy(id = "ap_password")
    WebElement passwordEl;
    @FindBy(id = "auth-mfa-otpcode")
    WebElement otpel;
    @FindBy(linkText = "Sign in")
    WebElement signInButtonEl;
    @FindBy(id = "createAccountSubmit")
    WebElement createamazonaccountbuttonEl;
    @FindBy(linkText = "New to Amazon?")
    WebElement NewtoAmazonHeadingText;

    @FindBy(className = "a-form-label")
    WebElement firstandlastnameLabelEl;
    @FindBy(id = "ap_customer_name")
    WebElement firstnameandlastnameEl;
    @FindBy(linkText = "Mobile number or email")
    WebElement mobilenumberlabelEl;
    @FindBy(id = "ap_email")
    WebElement Mobilenumberorphonenumberel;
    @FindBy(linkText = "Create a password")
    WebElement CreatepasswordlabelEl;
    @FindBy(id = "ap_password")
    WebElement passwordDEl;

    @FindBy(id = "continue")
    WebElement continueButtonel;
    @FindBy(className = "a-alert-content")
    WebElement ErrorMessageEl;

    public RegistrationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void clickSignIn(){
        signInlinkElement.click();
    }
    public void entermail(String mail){
        entermail(mail);
    }
    public void enterpassword(String password){
        enterpassword(password);
    }
    public void enterotp(String otp){
        enterotp(otp);
    }
    public void clickSignINbutton(){
        signInButtonEl.click();
    }
    public void clickCreateyourAmazonAccountButton(){
        createamazonaccountbuttonEl.click();
    }

    public String NewtoAmazonAccountHeadText(){
        return NewtoAmazonHeadingText.getText();
    }
    public String firstandlastnameLabel(){
        return firstandlastnameLabelEl.getText();
    }
    public void enterfirstName(String FirstName){
        firstnameandlastnameEl.sendKeys(FirstName);
    }
    public String mobilenumberLabelText(){
        return mobilenumberlabelEl.getText();
    }

    public void enterMobilenumberorEmail(String email){
        Mobilenumberorphonenumberel.sendKeys(email);
    }
    public String createpasswordlabelText(){
        return CreatepasswordlabelEl.getText();
    }
    public void enterpasswordText(String password){
        passwordEl.sendKeys(password);
    }


    public void clickcontinueButton(){
        continueButtonel.click();
    }

    public String errormessageText(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-alert-content")));
        return ErrorMessageEl.getText();
    }



}



