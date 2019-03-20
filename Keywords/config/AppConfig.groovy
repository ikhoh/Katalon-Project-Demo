package config

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

import internal.GlobalVariable

public class AppConfig {
	public static int waitTime = 30;
	public static boolean resetDatabase_everyTestCase = false
	public static boolean resetDatabase_everyTestSuite = false
	public static String siteUrl = "https://trunk.local.com"

	// Test Rail info
	public static String testRailAuthCredentials = "Basic " + helper.General.EncodeCredentials("qatester@insitesoft.com", "insite110")

	// Database info
	public static dbServerName = 'localhost'
	public static dbPort = '1433'
	public static dbName = 'Insite.Commerce.trunk'
	public static dbUsername = 'sa'
	public static dbPassword = 'Password1'

	// Path to Insite.Admin.Automated.dll to run ResetDatabase script from Insite.Commerce, and Nunit3 exe file path (https://nunit.org/download/)
	public static String pathToInsiteAdminAutomatedDll = "C:\\Projects\\Insite.Commerce.Source\\trunk\\Automation\\Insite.Admin.Automated\\bin\\Debug\\Insite.Admin.Automated.dll"
	public static String pathToNunit3ExeFile = "C:\\Program Files (x86)\\NUnit.org\\nunit-console\\nunit3-console.exe"
}
