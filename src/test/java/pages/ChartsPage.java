package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

import java.awt.*;

public class ChartsPage extends TestBase {

    @FindBy(xpath = "//li/a[contains(text(),'More')]")
    WebElement More;
    @FindBy(xpath = "//li/a[contains(text(),'Charts')]")
    WebElement Charts;
    //ul/li[contains(text(),'video')]/h2
    @FindBy(xpath = "//ul/li[contains(text(),'video')]/h2")
    WebElement video;
    @FindBy(xpath = "//ul/li[contains(text(),'photo')]/h2")
    WebElement photo;
    @FindBy(xpath = "//ul/li[contains(text(),'audio')]/h2")
    WebElement audio;

    public ChartsPage() {
        PageFactory.initElements(driver, this);
    }

    public void ChartsLink() {
        driver.get(prop.getProperty("RegisterURL"));
        More.click();
        Charts.click();
        try{
            System.out.println("Found Google ads");
            driver.switchTo().frame("google_esf");
            driver.findElement(By.xpath("//div[@id='dismiss-button']/div")).click();
            driver.switchTo().parentFrame();
            System.out.println("Closed Google ads");
        }catch (Exception E){
        }
    }

    public void chartdetails(){
        System.out.println(video.getText());
        System.out.println(audio.getText());
        System.out.println(photo.getText());
//li/h3[normalize-space(text())='13.5 M']/../../li[contains(text(),'Shares Traded')]
    }
}
