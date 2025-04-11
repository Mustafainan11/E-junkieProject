import org.junit.Assert;
import org.junit.Test;

import static Utilty.BaseDriver.driver;

public class US_305_Paymentprocessconfirmationanddownload {

    @Test
    public void testNavigationToMainSite() throws InterruptedException {

        WebElement footerLink = driver.findElement(By.xpath("//a[contains(text(),'E-Commerce By E-Junkie')]"));
        footerLink.click();


        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        WebElement logo = driver.findElement(By.xpath("//a[contains(@href,'https://www.e-junkie.com/')]//img"));
        logo.click();

        // 4. Yönlendirilen URL'yi doğrula
        Thread.sleep(2000); // Gerekirse kısa bir bekleme
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.e-junkie.com/", currentUrl);
    }


    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
