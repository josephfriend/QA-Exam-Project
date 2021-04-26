package com.myQA.exam.project.tests;

import com.myQA.exam.project.pages.BeginningPage;
import com.myQA.exam.project.pages.StatisticsPage;
import com.opencsv.exceptions.CsvException;
import com.myQA.exam.project.base.TestUtil;
import com.myQA.exam.project.pages.CookiesPage;
import com.myQA.exam.project.pages.MainStatsPage;
import com.myQA.exam.project.utils.CsvReader;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class StatsTest extends TestUtil {

    @DataProvider(name = "companies-data-csv")
    public static Object[][] dataProviderCsv() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/companies-data.csv");
    }

    @SuppressWarnings("TestDataSupplier")
    @Test(dataProvider = "companies-data-csv")
    public void executeStatsTest(String searchField, String dividendsVal, String priceMrqVal) {
        CookiesPage cookiesPage = new CookiesPage(driver);
        BeginningPage beginningPage = cookiesPage.goToHomePage();
        Reporter.log("Successful entry to the home page");

        MainStatsPage mainStatsPage = beginningPage.searchCompany(searchField);
        Reporter.log("Successful entry to the main statistics page");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mainStatsPage.getDividendsValue(), dividendsVal);

        StatisticsPage statisticsPage = mainStatsPage.viewStats();
        Reporter.log("Successful entry to the statistics page");

        SoftAssert softAssert1 = new SoftAssert();
        softAssert1.assertEquals(statisticsPage.getPriceBookValue(), priceMrqVal);


    }
}
