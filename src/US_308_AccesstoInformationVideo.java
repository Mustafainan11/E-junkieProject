import Utilty.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class US_308_AccesstoInformationVideo extends BaseDriver {
    @Test
    public void bilgiVideosunaErisim() throws InterruptedException {
        driver.get("https://www.e-junkie.com/");
        System.out.println("Sayfa açıldı: " + driver.getCurrentUrl());
        Thread.sleep(2000);

        WebElement howItWorksBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@class='blue_btn']")));
        howItWorksBtn.click();

        String originalWindow = driver.getWindowHandle();
        wait.until(d -> driver.getWindowHandles().size() > 1);

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

        TearDown();
        driver.close();
    }

}
