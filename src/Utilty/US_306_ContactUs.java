package Utilty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_306_ContactUs extends BaseDriver{
    @Test
    public void Test() throws InterruptedException {

        driver.get("https://shopdemo.fatfreeshop.com/?");
        Actions actions=new Actions(driver);

        WebElement contact=driver.findElement(By.cssSelector("[href='/contact']"));
        actions.scrollToElement(contact).perform();
        wait.until(ExpectedConditions.visibilityOf(contact));
        actions.click(contact).perform();

        driver.findElement(By.cssSelector("[id='sender_name']")).sendKeys("Telman");
        driver.findElement(By.cssSelector("[id='sender_email']")).sendKeys("telman@gmail.com");
        driver.findElement(By.cssSelector("[id='sender_subject']")).sendKeys("Apply for tester position");
        driver.findElement(By.cssSelector("[id='sender_message']")).sendKeys("Salam Aleykum ladies and gentlemen");
        driver.findElement(By.cssSelector("[id='send_message_button']")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        String alertText=driver.switchTo().alert().getText();
        System.out.println(alertText);

        Assert.assertTrue(alertText.equals("Recaptcha didn't match"));

        TearDown();
    }

}
