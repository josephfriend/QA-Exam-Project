package com.myQA.exam.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatisticsPage extends BasePage {

    @FindBy(xpath = "//span[text()='Price/Book']/../following-sibling::td")
    private WebElement priceMrqVal;

    public String getPriceBookValue() {
        return priceMrqVal.getText();
    }

    public StatisticsPage (WebDriver driver) {
        super(driver);
    }
}
