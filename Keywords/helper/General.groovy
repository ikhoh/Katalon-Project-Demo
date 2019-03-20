package helper

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import internal.GlobalVariable

public class General {
	@Keyword
	public static String EncodeCredentials(String username, String password) {
		def credentials = username + ":" + password
		return credentials.bytes.encodeBase64().toString()
	}

	@Keyword
	public String ActivateAccount(String username){
		def sqlHelper = new SqlHelper()
		sqlHelper.connectDB(config.AppConfig.dbServerName, config.AppConfig.dbPort, config.AppConfig.dbName, config.AppConfig.dbUsername, config.AppConfig.dbPassword)

		def queryResult = sqlHelper.executeQuery("SELECT TOP 1 Body FROM EmailMessage WHERE Subject = 'Insite Commerce Account Activation' ORDER BY SentDate DESC ")

		def resetPasswordlink
		def regexPattern = config.AppConfig.siteUrl.replace("https", "http") + '/.+.ResetPasswordPage.+' + username + '.+?"'
		while (queryResult.next()) {
			Object body = queryResult.getObject("Body")
			resetPasswordlink = (body =~ regexPattern)[0]
		}

		sqlHelper.closeDatabaseConnection()

		println(resetPasswordlink)
		return resetPasswordlink
	}
}
