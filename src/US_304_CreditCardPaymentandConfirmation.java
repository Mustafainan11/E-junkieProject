import Utilty.BaseDriver;
import Utilty.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class US_304_CreditCardPaymentandConfirmation extends BaseDriver {
    @Test
    public void Test1() throws InterruptedException {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement Book = driver.findElement(By.xpath("(//*[@class='ion-ios-cart cart_icon']) [2]"));
        Book.click();
        MyFunc.Wait(2);

        WebElement frame = driver.findElement(By.xpath("//*[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(frame);
        WebElement paybutton =driver.findElement(By.xpath("//*[@class='Payment-Button CC']"));
        paybutton.click();

        WebElement Email =driver.findElement(By.xpath("(//*[@type='email']) [1]"));
        Email.sendKeys("abc@test.com");

        WebElement confirmemail=driver.findElement(By.xpath("//*[@placeholder='Confirm Email']"));
        confirmemail.sendKeys("abc@test.com");

        WebElement nameoncard=driver.findElement(By.xpath("//*[@placeholder='Name On Card']"));
        nameoncard.sendKeys("john Doe");

        WebElement phone=driver.findElement(By.xpath("//*[@placeholder='Optional'] [1]"));
        phone.sendKeys("44070000000");

        WebElement frame2= driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]"));
        driver.switchTo().frame(frame2);

        WebElement cardnumber=driver.findElement(By.xpath("//*[@class='InputElement is-empty Input Input--empty'] [1]"));
        cardnumber.sendKeys("4242 4242 4242 4242");

        WebElement MMYY=driver.findElement(By.xpath("//*[@name='exp-date']"));
        MMYY.sendKeys("12/25");

        WebElement CVV=driver.findElement(By.xpath("//*[@name='cvc']"));
        CVV.sendKeys("000");
        driver.switchTo().parentFrame();
        MyFunc.Wait(5);

        WebElement pay=driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        pay.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("https://www.fatfreecartpro.com/"));
        MyFunc.Wait(3);

        TearDown();
    }

}
