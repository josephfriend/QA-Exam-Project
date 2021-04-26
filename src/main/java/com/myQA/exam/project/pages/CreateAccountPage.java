package com.myQA.exam.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {

    @FindBy(id = "usernamereg-firstName")
    private WebElement firstNameInput;

    @FindBy(id = "usernamereg-lastName")
    private WebElement lastNameInput;

    @FindBy(id = "usernamereg-yid")
    private WebElement emailInput;

    @FindBy(id = "reg-error-yid")
    private WebElement emailVal;

    @FindBy(id = "usernamereg-password")
    private WebElement passwordInput;

    @FindBy(id = "reg-error-password")
    private WebElement passwordVal;

    @FindBy(id = "usernamereg-phone")
    private WebElement phoneNumberInput;

    @FindBy(id = "reg-error-phone")
    private WebElement phoneNumberVal;

    @FindBy(id = "usernamereg-month")
    private WebElement monthOfBirthInput;

    @FindBy(id = "usernamereg-day")
    private WebElement dayOfBirthInput;

    @FindBy(id = "usernamereg-year")
    private WebElement yearOfBirthInput;

    @FindBy(id = "reg-error-birthDate")
    private WebElement birthdateVal;

    @FindBy(id = "reg-submit-button")
    private WebElement submitButton;

    @FindBy(id = "usernamereg-freeformGender")
    private WebElement genderInput;


    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getEmailValidationMessage() {
        return emailVal.getText();
    }

    public String getPasswordValidationMessage() {
        return passwordVal.getText();
    }

    public String getPhoneNumberValidationMessage() {
        return phoneNumberVal.getText();
    }

    public String getBirthDateValidationMessage() {
        return birthdateVal.getText();
    }

    public CreateAccountPage fillName(String firstName, String lastName) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        return new CreateAccountPage(driver);
    }

    public CreateAccountPage fillEmail(String emailAddress) {
        emailInput.sendKeys(emailAddress);
        return new CreateAccountPage(driver);
    }

    public CreateAccountPage fillPass(String password) {
        passwordInput.sendKeys(password);
        return new CreateAccountPage(driver);
    }

    public CreateAccountPage fillPhone(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);
        return new CreateAccountPage(driver);
    }

    public CreateAccountPage fillDateOfBirth(String birthMonth, String birthDay, String birthYear) {
        monthOfBirthInput.sendKeys(birthMonth);
        dayOfBirthInput.sendKeys(birthDay);
        yearOfBirthInput.sendKeys(birthYear);
        return new CreateAccountPage(driver);
    }
    public CreateAccountPage fillGender(String gender){
        genderInput.sendKeys(gender);
        return  new CreateAccountPage(driver);
    }

    // public CreateAccountPage clickSubmit() {
    // submitButton.click();
    //return new CreateAccountPage(driver);}


}
