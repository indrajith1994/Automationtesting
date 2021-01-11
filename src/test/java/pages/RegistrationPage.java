package pages;

import io.cucumber.java.it.Ma;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

public class RegistrationPage extends TestBase {
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement Firstname;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement Lastname;
    @FindBy(xpath = "//input[@type='email']")
    WebElement Email;
    @FindBy(xpath = "//input[@type='tel']")
    WebElement Phone;
    @FindBy(xpath = "//input[@value='Male']")
    WebElement MaleGender;
    @FindBy(xpath = "//input[@value='FeMale']")
    WebElement FemaleGender;



//    String temp = "//select/option[@value='"+ctry+"']";
//    @FindBy(xpath = temp)
//    WebElement country;
//    @FindBy(xpath = "//select/option[@value='1994']")
//    WebElement Year;
//    @FindBy(xpath = "//select/option[@value='March']")
//    WebElement Month;
//    @FindBy(xpath = "//select/option[@value='9']")
//    WebElement Day;


    @FindBy(xpath = "//input[@id='firstpassword']")
    WebElement Password;
    @FindBy(xpath = "//input[@id='secondpassword']")
    WebElement PasswordConfirm;
    @FindBy(xpath = "//button[@id='submitbtn']")
    WebElement SubmitBtn;
    @FindBy(xpath = "//button[@id='Button1']")
    WebElement ResetBtn;

    public RegistrationPage(){
        PageFactory.initElements(driver, this);
    }

    public void RegLink(){
        driver.get(prop.getProperty("RegisterURL"));
    }

    public void enterdetails() {
        Firstname.sendKeys(prop.getProperty("Firstname"));
        Lastname.sendKeys(prop.getProperty("Lastname"));
        Email.sendKeys(prop.getProperty("Email"));
        Phone.sendKeys(prop.getProperty("Phone"));

        if(prop.getProperty("Gender").equals("Male")){
            MaleGender.click();
        }else
            FemaleGender.click();
        String ctry = prop.getProperty("Country");
        String doby = prop.getProperty("DOBYear");
        String dobm = prop.getProperty("DOBMonth");
        String dobd = prop.getProperty("DOBDate");

        driver.findElement(By.xpath("//select/option[@value='"+ctry+"']")).click();
        driver.findElement(By.xpath("//select/option[@value='"+doby+"']")).click();
        driver.findElement(By.xpath("//select/option[@value='"+dobm+"']")).click();
        driver.findElement(By.xpath("//select/option[@value='"+dobd+"']")).click();

        Password.sendKeys(prop.getProperty("Password"));
        PasswordConfirm.sendKeys(prop.getProperty("Password"));

    }

    public void submit(){
        SubmitBtn.click();
    }

    public void Reset(){
        ResetBtn.click();
    }
}
