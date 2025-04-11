import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.util.Set;

import static Utilty.BaseDriver.driver;

public class US_308_AccesstoInformationVideo {

    @Test
    public void bilgiVideosunaErisim() throws InterruptedException {

        Assert.assertEquals("https://www.e-junkie.com/", driver.getCurrentUrl());

        WebElement howItWorksBtn = driver.findElement(By.xpath("//a[contains(text(),'See How it works')]"));
        howItWorksBtn.click();

        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
                .sendKeys(Keys.SPACE).perform();

        Thread.sleep(10000);

        driver.close();

        driver.switchTo().window(originalWindow);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
