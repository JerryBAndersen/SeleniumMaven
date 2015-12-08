package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageRoot extends Page
{    
    public PageRoot(WebDriver driver){
        this.driver = driver;
    }
    
    public PageArticle clickReadmore() throws Exception{
        driver.findElement(By.linkText("Read more...")).click();
        return new PageArticle(this.driver);
    }
}
