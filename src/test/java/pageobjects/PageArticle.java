package pageobjects;

import static org.junit.Assert.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageArticle extends Page
{    
    public PageArticle(WebDriver driver) throws Exception{
        this.driver = driver;
    }
    
    public boolean hasCommentsHead() throws Exception{
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.cssSelector("div.comments-head"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }
        return isElementPresent(By.cssSelector("div.comments-head"));        
    }
    
    public PageSearch search()throws Exception{
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("q"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.id("q")).clear();
        driver.findElement(By.id("q")).sendKeys("qwer");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("searchbutton"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }
        driver.findElement(By.id("searchbutton")).click();
        return new PageSearch(driver);        
    }
}
