import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.navigateToUrl(data.PagesData.Home)

WebUI.waitForAngularLoad(config.AppConfig.waitTime)

WebUI.click(findTestObject('UI/Page_Home/topNav_link_SignIn'))

WebUI.click(findTestObject('UI/Page_SignIn/link_CreateAccount'))

WebUI.setText(findTestObject('UI/Page_CreateAccount/input_EmailAddress'), 'katalonAutomationTest@test.com')

WebUI.setText(findTestObject('UI/Page_CreateAccount/input_UserName'), 'testUser' + UUID.randomUUID())

WebUI.setEncryptedText(findTestObject('UI/Page_CreateAccount/input_Password'), 'p4y+y39Ir5Oy1MY8jPt0uQ==')

WebUI.setEncryptedText(findTestObject('UI/Page_CreateAccount/input_ConfirmPassword'), 'p4y+y39Ir5Oy1MY8jPt0uQ==')

WebUI.click(findTestObject('UI/Page_CreateAccount/button_CreateAccount'))

WebUI.waitForAngularLoad(config.AppConfig.waitTime)

assert(WebUI.getUrl().contains(data.PagesData.Home))
