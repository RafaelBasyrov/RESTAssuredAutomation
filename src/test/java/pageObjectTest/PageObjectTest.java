package pageObjectTest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObjectTest {

    WebDriver driver;

    MainPage mainPage;

   @Before
    public void setUp(){
       System.setProperty("webdriver.chrome.driver" ,"/Users/basir/Saved Games/chromedriver.exe");
       driver =new  ChromeDriver();
       driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
       driver.manage().window().maximize();
       driver.get("https://practicetestautomation.com/practice-test-login/");
       mainPage = new MainPage(driver);
   }

   @Test
   public void LogOut(){
         mainPage.register("student","Password123");
   }

    @Test
    public void getError(){
         mainPage.register("studentее","Password123");
        System.out.println(driver.findElement(By.cssSelector("#error")).getText());
    }


}