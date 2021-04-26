package com.myQA.exam.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(id = "createacc")
    private WebElement createAcc;

    public SignInPage (WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage clickSignUpButton(){
        createAcc.click();
        return new CreateAccountPage(driver);
    }
}
