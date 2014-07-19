package core;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;
    String baseUrl = "https://www.naturalhr.com";

    public MainPage(WebDriver wd) {
           driver = wd;
    }

    public void logoff() {
           driver.findElement(By.cssSelector("b.caret")).click();
           driver.findElement(By.linkText("Logoff")).click();
//           driver.quit();
//           driver = null;
    }

    public boolean verifyBodyContains(String text) {
           return driver.findElement(By.tagName("body")).getText().contains(text);
    }
}