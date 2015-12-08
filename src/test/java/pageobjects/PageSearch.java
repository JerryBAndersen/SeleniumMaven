package pageobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageSearch extends Page
{
    
    public PageSearch(WebDriver driver) throws Exception{
        this.driver = driver;
    }
    
    public String getResultString() throws Exception{
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (hasResults()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }
        
        String s = driver.findElement(By.cssSelector("h3")).getText();
        return s;
    }
    
    public boolean hasResults(){
        return isElementPresent(By.cssSelector("div.next-previous"));
    }
    
    
}
