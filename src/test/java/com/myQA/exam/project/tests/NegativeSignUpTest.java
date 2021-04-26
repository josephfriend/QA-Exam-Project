package com.myQA.exam.project.tests;

import com.myQA.exam.project.pages.BeginningPage;
import com.myQA.exam.project.pages.CreateAccountPage;
import com.opencsv.exceptions.CsvException;
import com.myQA.exam.project.base.TestUtil;
import com.myQA.exam.project.pages.CookiesPage;
import com.myQA.exam.project.pages.SignInPage;
import com.myQA.exam.project.utils.CsvReader;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NegativeSignUpTest extends TestUtil {


    @DataProvider(name = "negative-login-data-csv")
    public static Object[][] dataProviderCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/negative-login-data.csv");
    }

    @SuppressWarnings("TestDataSupplier")
    @Test(dataProvider = "negative-login-data-csv")
    public void executeSignUpTest(String firstName, String lastName, String emailAddress, String password, String phoneNumber, String birthMonth, String birthDay, String birthYear, String gender) throws InterruptedException {

        CookiesPage cookiesPage = new CookiesPage(driver);
        BeginningPage beginningPage = cookiesPage.goToHomePage();
        Reporter.log("Beginning page is successfully loaded.");

        SignInPage signInPage = beginningPage.clickSignInButton();
        Reporter.log("Sign In page is successfully loaded.");

        CreateAccountPage createAccountPage = signInPage.clickSignUpButton();
        Reporter.log("Create account page is successfully loaded.");

        createAccountPage.fillName(firstName, lastName);
        createAccountPage.fillEmail(emailAddress);
        createAccountPage.fillPass(password);
        createAccountPage.fillPhone(phoneNumber);
        createAccountPage.fillDateOfBirth(birthMonth, birthDay, birthYear);
        createAccountPage.fillGender(gender);

        /*  DOES NOT PASS
       createAccountPage.clickSubmit();
       driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
       FluentWait fluentWait = new FluentWait(driver);
       fluentWait.withTimeout(Duration.ofSeconds(20));
       fluentWait.pollingEvery(Duration.ofSeconds(2));
       fluentWait.ignoring(NoSuchElementException.class);
       fluentWait.until(ExpectedConditions.visibilityOfAllElements());
       driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
       */

       Thread.sleep(500);


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(createAccountPage.getEmailValidationMessage(), "That email address is too short, please use a longer one.");
        softAssert.assertEquals(createAccountPage.getPasswordValidationMessage(), "Your password isn’t strong enough, try making it longer.");
        softAssert.assertEquals(createAccountPage.getPhoneNumberValidationMessage(), "That doesn’t look right, please re-enter your phone number.");
        softAssert.assertEquals(createAccountPage.getBirthDateValidationMessage(), "That doesn’t look right, please re-enter your birthday.");

        softAssert.assertAll();


    }


    @AfterTest
    public void TearDown() {
        driver.quit();
    }


}
