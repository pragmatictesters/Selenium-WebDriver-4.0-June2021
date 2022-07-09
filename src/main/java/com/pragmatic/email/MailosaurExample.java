package com.pragmatic.email;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Link;
import com.mailosaur.models.Message;
import com.mailosaur.models.SearchCriteria;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MailosaurExample {


    @Test
    public void testEmailWithSelenium() throws IOException, MailosaurException{
        // Available in the API tab of a server
        String apiKey = "YOUR_API_KEY";
        String serverId = "SERVER_ID";
        String serverDomain = "SERVER_DOMAIN";

        String testEmail = String.format("selenium@%s", serverDomain);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.mailosaur.com/password-reset");
        driver.findElement(By.id("email")).sendKeys(testEmail);
        driver.findElement(By.xpath("//button")).click();
        driver.close();

        MailosaurClient mailosaur = new MailosaurClient(apiKey);
        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo(testEmail);

        Message message = mailosaur.messages().get(serverId, criteria);
        Assert.assertNotNull(message);
        Assert.assertEquals(message.subject(), "Set your new password for ACME Product");
    }
}
