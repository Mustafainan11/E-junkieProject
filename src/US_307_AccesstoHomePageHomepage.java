import Utilty.BaseDriver;
import Utilty.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_307_AccesstoHomePageHomepage extends BaseDriver {
    @Test
    public void Test1() throws InterruptedException {
        driver.get("https://shopdemo.fatfreeshop.com/?");

        WebElement Ecommerceby= driver.findElement(By.xpath("//a[@class='EJ-ShopLink']"));
        new Actions(driver).scrollToElement(Ecommerceby).click(Ecommerceby).perform();

        WebElement Logo= driver.findElement(By.xpath("//img[@src='/wiki/user/themes/Wiki/images/logo.svg?123']"));
        Logo.click();

        wait.until(ExpectedConditions.urlContains("e-junkie"));
        Assert.assertTrue(driver.getCurrentUrl().contains("e-junkie"));

        TearDown();
    }
}