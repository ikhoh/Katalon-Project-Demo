package data

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

public class PagesData {
	public static String Home = config.AppConfig.siteUrl
	public static String AdminConsole = config.AppConfig.siteUrl + "/admin/signin"
	public static String Cart = config.AppConfig.siteUrl + "/Cart"
	public static String SignIn = config.AppConfig.siteUrl + "/MyAccount/SignIn"
}

public class Categories {
	private static String catalog = config.AppConfig.siteUrl + "/Catalog"
	public static String AllProducts = catalog + "/AllProducts"
	public static String BasicCategory = catalog + "/BasicCategory"
}

public class SubCategories {
	public static String BasicSubCategory1 = Categories.BasicCategory + "/BasicSubCategory1"
}

public class Products {
	public static String BasicProduct_100 = SubCategories.BasicSubCategory1 + "/BasicProduct-100"
}