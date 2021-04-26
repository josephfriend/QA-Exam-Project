package com.myQA.exam.project.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver getChromeDriver(int wait) {
        ChromeOptions options = new ChromeOptions();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);

        return driver;
    }

    public static WebDriver getFirefoxDriver(int wait) {
        FirefoxOptions options = new FirefoxOptions();

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);

        return driver;
    }


}
