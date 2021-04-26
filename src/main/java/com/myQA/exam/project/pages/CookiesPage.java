package com.myQA.exam.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookiesPage  extends BasePage{

    @FindBy(name = "agree")
    private WebElement AllCookiesButton;

    public CookiesPage (WebDriver driver){
        super(driver);
    }

    public BeginningPage goToHomePage() {
        AllCookiesButton.click();
        return new BeginningPage(driver);
    }
}
