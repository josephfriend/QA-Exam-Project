package com.myQA.exam.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BeginningPage extends BasePage {


    @FindBy(id = "yfin-usr-qry")
    private WebElement searchInput;

    @FindBy(id = "header-desktop-search-button")
    private WebElement searchButton;

    @FindBy(id = "header-signin-link")
    private WebElement signInBtn;

    public BeginningPage(WebDriver driver){
        super(driver);
    }

    public MainStatsPage searchCompany(String searchField){
        searchInput.sendKeys(searchField);
        searchButton.click();
        return new MainStatsPage(driver);
    }



    public SignInPage clickSignInButton(){
        signInBtn.click();
        return new SignInPage(driver);
    }
}
