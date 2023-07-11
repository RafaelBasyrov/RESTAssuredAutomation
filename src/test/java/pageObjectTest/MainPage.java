package pageObjectTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    By usernameField  = By.xpath("//input[@id='username']");
    By passwordField  = By.xpath("//input[@id='password']");
    By button = By.xpath("//button[@id='submit']");


    public MainPage typeUsername (String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public MainPage typePassword (String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public void clickSubmit(){
        driver.findElement(button).click();

    }

    public MainPage register(String username , String password){
        this.typeUsername(username);
        this.typePassword(password);
        this.clickSubmit();
        return this;
    }

}
