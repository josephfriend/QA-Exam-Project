package com.myQA.exam.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainStatsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Statistics')]")
    private WebElement statisticsBtn;

    @FindBy(xpath = "//td[@data-test='DIVIDEND_AND_YIELD-value']")
    private WebElement dividendsVal;

    public String getDividendsValue(){
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(dividendsVal), 4);
        return dividendsVal.getText();
    }

    public MainStatsPage (WebDriver driver) {
        super(driver);
    }

    public StatisticsPage viewStats() {
        statisticsBtn.click();
        return new StatisticsPage(driver);
    }
}



