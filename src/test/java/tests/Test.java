package tests;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import pageobjects.*;

import java.util.concurrent.TimeUnit;
import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  
  @Before
  public void setUp() throws Exception {
    driver = new HtmlUnitDriver();
    baseUrl = "https://blogs.apache.org/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @org.junit.Test
  public void test() throws Exception {      
    driver.get(baseUrl + "/");    
    PageRoot pageroot = new PageRoot(driver);
    
    
    PageArticle pagearticle = pageroot.clickReadmore();
    
    assertTrue(pagearticle.hasCommentsHead());
    
    
    PageSearch pagesearch = pagearticle.search();
    assertEquals("Showing 1 - 0 of total 0 search results", pagesearch.getResultString());    
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
