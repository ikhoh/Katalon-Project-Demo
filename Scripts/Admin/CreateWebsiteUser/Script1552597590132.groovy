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

// This can either be here or in the 'Variables'
def userName = 'automation_WebsiteUserTests_' + UUID.randomUUID()
def password = 'Password1'

WebUI.navigateToUrl(data.PagesData.AdminConsole)

WebUI.setText(findTestObject('AdminConsole/AC_SignIn/input_Username'), data.Users_AdminConsoleData.SystemAdmin.username)

WebUI.setText(findTestObject('AdminConsole/AC_SignIn/input_Password'), data.Users_AdminConsoleData.SystemAdmin.password)

WebUI.click(findTestObject('AdminConsole/AC_SignIn/button_SignIn'))

WebUI.waitForAngularLoad(config.AppConfig.waitTime)

WebUI.click(findTestObject('AdminConsole/AC_SideBarNav/sideBar_administration'))

WebUI.click(findTestObject('AdminConsole/AC_SideBarNav/Administration/link_WebsiteUsers'))

WebUI.click(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/button_AddWebsiteUser'))

WebUI.setText(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Details/input_Username'), 
    userName)

WebUI.setText(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Details/input_Email'), 
    userName + '@test.com')

WebUI.setText(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Details/input_FirstName'), 
    userName)

WebUI.setText(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Details/input_LastName'), 
    'Test')

WebUI.click(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Details/radioBtn_Buyer3'))

WebUI.click(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Details/button_Save'))

CustomKeywords.'helper.Driver.waitForElementThenClick'(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/tab_Customers'))

WebUI.click(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Customers/button_AssignCustomers'))

WebUI.waitForElementVisible(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Customers/Modal_AssignCustomers/input_Filter'), 
    config.AppConfig.waitTime)

WebUI.setText(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Customers/Modal_AssignCustomers/input_Filter'), 
    data.CustomersData.BasicUsers.customerNumber)

CustomKeywords.'helper.Driver.waitForElementThenClick'(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Customers/Modal_AssignCustomers/radioBtn_CustomerRow_First'))

WebUI.click(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Customers/Modal_AssignCustomers/button_Assign'))

WebUI.click(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Customers/Modal_AssignCustomers/button_Done'))

Thread.sleep(500)

WebUI.click(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/tab_Websites'))

WebUI.click(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Websites/button_AssignWebsites'))

WebUI.setText(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Websites/Modal_AssignWebsites/input_Filter'), 
    'MainWebsite')

CustomKeywords.'helper.Driver.waitForElementThenClick'(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Websites/Modal_AssignWebsites/radioBtn_WebsitesRow_First'))

WebUI.click(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Websites/Modal_AssignWebsites/button_Assign'))

WebUI.click(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/Websites/Modal_AssignWebsites/button_Done'))

Thread.sleep(500)

WebUI.click(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/button_SendActivationEmail'))

WebUI.waitForElementVisible(findTestObject('AdminConsole/AC_SideBarNav/Administration/WebsiteUsers/UserProfile/banner_NotificationSuccess'), config.AppConfig.waitTime)

Thread.sleep(1000) // wait for activation email to be sent to database

def resetPasswordlink = CustomKeywords.'helper.General.ActivateAccount'(userName)

WebUI.navigateToUrl(resetPasswordlink)

WebUI.setText(findTestObject('UI/Page_AccountActivation/input_NewPassword'), password)

WebUI.setText(findTestObject('UI/Page_AccountActivation/input_ConfirmNewPassword'), password)

WebUI.click(findTestObject('UI/Page_AccountActivation/button_ActivateAccount'))

WebUI.navigateToUrl(data.PagesData.SignIn)

WebUI.setText(findTestObject('UI/Page_SignIn/input_Username'), userName)

WebUI.setText(findTestObject('UI/Page_SignIn/input_Password'), password)

WebUI.click(findTestObject('UI/Page_SignIn/button_SignIn'))

WebUI.waitForAngularLoad(config.AppConfig.waitTime)

assert WebUI.getText(findTestObject('UI/Page_Home/topNav_label_UserName')).contains(userName)

assert WebUI.getUrl().contains(data.PagesData.Home)

