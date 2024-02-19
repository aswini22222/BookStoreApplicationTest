package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(xpath = "//i[@aria-label='Amazon']")
    WebElement amazonlogoEl;
    @FindBy(linkText = "Email or mobile phone number")
    WebElement emailandmobilenumberlabel;
    @FindBy(id = "ap_email")
    WebElement textboxfieldel;
    @FindBy(className = "a-button-input")
    WebElement continueEl;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    public void amazonlogo() {
        amazonlogoEl.isDisplayed();
    }
    public void mailandphonenumberlabel(){
        emailandmobilenumberlabel.isDisplayed();
    }
    public void enterphonenumber(String phonenumber){
        enterphonenumber(phonenumber);
    }
    public void clickcontinueButton(){
        continueEl.click();
    }
}
