package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SignInPage {
    public WebDriver driver;

    //Locators
    //SignIn Button
    @FindBy(id = "user-name")
    private WebElement Username;

    @FindBy(id = "password")
    private WebElement Password;

    @FindBy(id = "login-button")
    private WebElement SignInButton;

    //Constructor
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {
        Username.click();
        Username.sendKeys(username);
    }

    public void setUserPassword(String usersPassword) {
        Password.click();
        Password.sendKeys(usersPassword);
    }

    public void clickOnSubmit() {
        SignInButton.click();
    }
    public void signIn(String usersEmail, String password) {
            setUsername(usersEmail);
            setUserPassword(password);
            clickOnSubmit();

    }


}
