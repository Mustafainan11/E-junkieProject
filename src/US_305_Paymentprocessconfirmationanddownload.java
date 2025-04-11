import Utilty.BaseDriver;
import Utilty.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class US_305_Paymentprocessconfirmationanddownload extends BaseDriver {
    @Test
    public void Test01() {
        driver.get("https://shopdemo.fatfreeshop.com/");
        MyFunc.Wait(2);

        WebElement AddToButon = driver.findElement(By.xpath("//button[@onclick=\"return EJProductClick('1595015')\"]"));
        AddToButon.click();
        MyFunc.Wait(5);

        WebElement iFrame2 = driver.findElement(By.xpath("//*[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iFrame2);

        WebElement creditCard = driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        creditCard.click();
        MyFunc.Wait(2);

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys("abc@test.com");
        MyFunc.Wait(2);

        WebElement confirmEmail = driver.findElement(By.xpath("//input[@placeholder='Confirm Email']"));
        confirmEmail.sendKeys("abc@test.com");
        MyFunc.Wait(2);

        WebElement NameCard = driver.findElement(By.xpath("//input[@placeholder='Name On Card']"));
        NameCard.sendKeys("Görkem kezer");
        MyFunc.Wait(2);

        WebElement cardNo = driver.findElement(By.xpath("//iframe[starts-with(@name, '__privateStripeFrame')]"));
        driver.switchTo().frame(cardNo);

        WebElement CardNo = driver.findElement(By.xpath("//input[@placeholder='Kart numarası']"));
        CardNo.sendKeys("4242 4242 4242 4242 12/25 000");
        MyFunc.Wait(10);

        driver.switchTo().parentFrame();
        WebElement pay = driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        pay.click();
        MyFunc.Wait(3);

        driver.switchTo().parentFrame();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("https://www.fatfreecartpro.com/ecom/rp.php"));

        WebElement Link = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[@class='download_btn top10']")));
        Link.click();
    }
}