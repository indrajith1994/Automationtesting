package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebtablePage extends TestBase {
    @FindBy(xpath = "//button[@title='Page forward']")
    WebElement nextpage;

    @FindBy(xpath = "//span[contains(text(),'First Name')]")
    WebElement firstname;

    @FindBy(xpath = "//span[contains(text(),'Last Name')]")
    WebElement lastname;

    @FindBy(xpath = "//span[contains(text(),'Phone')]")
    WebElement phone;

    @FindBy(xpath = "//div[@role='grid']//del-click/button")
    WebElement deleteicon;

    @FindBy(xpath = "//li/button[contains(text(),'Delete')]")
    WebElement deletebutton;

    public WebtablePage(){
        PageFactory.initElements(driver, this);
    }

    public void WebtableLink(){
        driver.get(prop.getProperty("WebtableURL"));
    }

    public void edit(){
        int i;
        String editphone = prop.getProperty("editphone");
        String xpath = "//div[contains(text(),'"+editphone+"')]/../../..//button/i[contains(@class,'fa-pencil')]";

        for(i=0;i<100;i++){
            if(driver.findElements(By.xpath(xpath)).size()>0){
                Actions actions = new Actions(driver);
                WebElement elementLocator = driver.findElement(By.xpath(xpath));
                actions.doubleClick(elementLocator).perform();
                driver.findElement(By.xpath("//input[@value='"+editphone+"']")).clear();
                driver.findElement(By.xpath("//input[@value='"+editphone+"']")).sendKeys(prop.getProperty("Phone"));
                driver.findElement(By.xpath("//div[contains(text(),'"+editphone+"')]/../../..//button[contains(text(),'Save')]"));
                break;
            }
            else{
                nextpage.click();
            }
        }

    }
    public void SortTable(String rowname){
        if(rowname.equalsIgnoreCase("Firstname")){
            firstname.click();
            List<WebElement> Fname = driver.findElements(By.xpath("//div[@role='gridcell']/../../div/div[2]"));
            verifyorder(Fname);
        }
        if(rowname.equalsIgnoreCase("Lastname")){
            lastname.click();
            List<WebElement> Lname = driver.findElements(By.xpath("//div[@role='gridcell']/../../div/div[4]"));
            verifyorder(Lname);
        }
        if(rowname.equalsIgnoreCase("Phone")){
            phone.click();
            List<WebElement> Pnum = driver.findElements(By.xpath("//div[@role='gridcell']/../../div/div[5]"));
            verifyorder(Pnum);
        }
    }

    private void verifyorder(List<WebElement> ordlst) {
        int i;
        ArrayList<String> obtainedList = new ArrayList<>();
        for(i=0;i<10;i++){
            System.out.println(ordlst.get(i).getText());
        }
        for(WebElement we:ordlst){
            obtainedList.add(we.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for(String s:obtainedList){
            sortedList.add(s);
        }
        Collections.sort(sortedList);
        Assert.assertEquals(obtainedList, sortedList);
    }

    public void deletedata(int count){
        try{
            driver.switchTo().frame("google_esf");
            driver.findElement(By.xpath("//div[@id='dismiss-button']/div")).click();
            driver.switchTo().parentFrame();
        }catch (Exception E){
            E.getMessage();
        }
        try{
            for(int i=0;i<count;i++){
                Actions actions = new Actions(driver);
                WebElement elementLocators = deleteicon;
                actions.contextClick(elementLocators).perform();
                Thread.sleep(200);
                deletebutton.click();
                Thread.sleep(200);
                driver.switchTo().alert().accept();
                Thread.sleep(500);
            }
        }catch (Exception E){
            E.getMessage();
        }
    }

}
