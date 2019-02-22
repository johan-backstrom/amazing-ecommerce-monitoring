package se.claremont.ecommerce.monitoring;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

public class AddnatureScenarios {

    private final String url = "https://www.addnature.com";
    private WebDriver driver;

    @Before
    public void setUpDriver() throws MalformedURLException {

        if("remote".equals(System.getProperty("driver"))) {
            URL url = new URL("http://selenium:4444/wd/hub");
            driver = new RemoteWebDriver(url, new ChromeOptions());
            WebDriverRunner.setWebDriver(driver);
        }
    }

    @After
    public void closeDriver(){
        if(driver != null) {
            driver.quit();
        }
    }

    @Test
    public void searchJacketAndPutInBasket() throws InterruptedException {

        open(url);
        screenshot("popup" + System.currentTimeMillis());
        Selenide.actions().moveByOffset(10, 10).click();
        $(By.name("strSearchQuery")).sendKeys("Handske");
        $(By.name("strSearchQuery")).submit();
        $(".gallery_item:nth-child(1)").click();
        screenshot("hanske" + System.currentTimeMillis());

    }
}
