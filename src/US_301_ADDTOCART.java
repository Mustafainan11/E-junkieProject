import Utilty.BaseDriver;
import Utilty.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_301_ADDTOCART extends BaseDriver {

    @Test
    public void Test(){
        driver.get("https://shopdemo.fatfreeshop.com/?");
        WebElement element=driver.findElement(By.cssSelector("[href='/product/1595015/Demo-eBook']>div>div+div"));

        WebElement header = element.findElement(By.cssSelector("[href='/product/1595015/Demo-eBook']>div>div+div>h4"));
        String bookName = header.getText();
        System.out.println(bookName);
        WebElement addToCart=element.findElement(By.cssSelector("[href='/product/1595015/Demo-eBook']>div>div+div>button"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        addToCart.click();
        MyFunc.Wait(3);

        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.EJOverlayV3")));
        driver.switchTo().frame(iframe);
        WebElement bookInTheCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Col2.Product-Desc h5")));

        Assert.assertTrue(bookName.equals(bookInTheCart.getText()));

        WebElement close = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-label='close']")));
        close.click();
        driver.switchTo().defaultContent();

        WebElement cart=driver.findElement(By.cssSelector("[class='navbar-item cart']"));
        cart.click();

        driver.switchTo().frame(iframe);
        bookInTheCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Col2.Product-Desc h5")));

        Assert.assertTrue(bookName.equals(bookInTheCart.getText()));

    }

}
