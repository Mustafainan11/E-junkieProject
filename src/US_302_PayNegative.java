import Utilty.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_302_PayNegative extends BaseDriver {
    @Test
    public void payNegative() throws InterruptedException {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement addToCartButton = driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));
        addToCartButton.click();

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));

        driver.switchTo().frame(iframe);

        WebElement product = driver.findElement(By.xpath("(//div[@class='Col2 Product-Desc'])[1]/h5"));

        Assert.assertEquals("Demo eBook", product.getText());

        WebElement debitCardButton = driver.findElement(By.xpath("//button[@data-option='CC']"));
        debitCardButton.click();

        WebElement payButton = driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        payButton.click();

        WebElement messageBox = driver.findElement(By.cssSelector("[id='SnackBar']"));
        WebElement messageText = driver.findElement(By.cssSelector("[id='SnackBar']> :nth-child(2)"));

        Assert.assertEquals(messageText.getText(), messageBox.getText());

        TearDown();
    }

}
