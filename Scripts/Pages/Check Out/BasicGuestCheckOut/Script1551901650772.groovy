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

WebUI.navigateToUrl(data.Products.BasicProduct_100)

WebUI.waitForAngularLoad(config.AppConfig.waitTime)

CustomKeywords.'helper.Driver.waitForElementThenClick'(findTestObject('UI/Page_Catalog/Product_Details/button_AddToCart'))

WebUI.navigateToUrl(data.PagesData.Cart)

CustomKeywords.'helper.Driver.waitForElementThenClick'(findTestObject('UI/Page_Cart/link_CheckOut'))

CustomKeywords.'helper.Driver.waitForElementThenClick'(findTestObject('UI/Page_SignIn/link_CheckoutAsGuest'))

WebUI.waitForElementVisible(findTestObject('UI/Page_CheckOut_BillingAndShippingInfo/section_AddressForm'), config.AppConfig.waitTime)

WebUI.setText(findTestObject('UI/Page_CheckOut_BillingAndShippingInfo/input_BillingFirstName'), data.Users_StorefrontData.DummyInfo.billingFirstName)

WebUI.setText(findTestObject('UI/Page_CheckOut_BillingAndShippingInfo/input_BillingLastName'), data.Users_StorefrontData.DummyInfo.billingLastName)

WebUI.setText(findTestObject('UI/Page_CheckOut_BillingAndShippingInfo/input_BillingCompany'), data.Users_StorefrontData.DummyInfo.billingCompany)

WebUI.setText(findTestObject('UI/Page_CheckOut_BillingAndShippingInfo/input_BillingAddress1'), data.Users_StorefrontData.DummyInfo.billingAddress1)

WebUI.selectOptionByLabel(findTestObject('UI/Page_CheckOut_BillingAndShippingInfo/dropdown_BillingState'), data.Users_StorefrontData.DummyInfo.billingState, false)

WebUI.setText(findTestObject('UI/Page_CheckOut_BillingAndShippingInfo/input_BillingCity'), data.Users_StorefrontData.DummyInfo.billingCity)

WebUI.setText(findTestObject('UI/Page_CheckOut_BillingAndShippingInfo/input_BillingPostalCode'), data.Users_StorefrontData.DummyInfo.billingPostalCode)

WebUI.setText(findTestObject('UI/Page_CheckOut_BillingAndShippingInfo/input_BillingPhone'), data.Users_StorefrontData.DummyInfo.billingPhone)

WebUI.setText(findTestObject('UI/Page_CheckOut_BillingAndShippingInfo/input_BillingEmail'), data.Users_StorefrontData.DummyInfo.billingEmail)

WebUI.click(findTestObject('UI/Page_CheckOut_BillingAndShippingInfo/button_Continue'))

WebUI.waitForAngularLoad(config.AppConfig.waitTime)

WebUI.selectOptionByLabel(findTestObject('UI/Page_CheckOut_Payment/dropdown_ShippingCarrier'), data.Users_StorefrontData.DummyInfo.shippingCarrier, false)

WebUI.selectOptionByLabel(findTestObject('UI/Page_CheckOut_Payment/dropdown_ShippingService'), data.Users_StorefrontData.DummyInfo.shippingService, false)

WebUI.selectOptionByLabel(findTestObject('UI/Page_CheckOut_Payment/dropdown_PaymentMethod'), data.Users_StorefrontData.DummyInfo.paymentMethod, false)

WebUI.setText(findTestObject('UI/Page_CheckOut_Payment/input_PoNumber'), data.Users_StorefrontData.DummyInfo.paymentPoNumber)

WebUI.selectOptionByLabel(findTestObject('UI/Page_CheckOut_Payment/dropdown_CardType'), data.Users_StorefrontData.DummyInfo.paymentCardType, false)

WebUI.setText(findTestObject('UI/Page_CheckOut_Payment/input_NameOnCard'), data.Users_StorefrontData.DummyInfo.paymentNameOnCard)

WebUI.setText(findTestObject('UI/Page_CheckOut_Payment/input_CardNumber'), data.Users_StorefrontData.DummyInfo.paymentCardNumber)

WebUI.setText(findTestObject('UI/Page_CheckOut_Payment/input_SecurityCode'), data.Users_StorefrontData.DummyInfo.paymentSecurityCode)

WebUI.selectOptionByValue(findTestObject('UI/Page_CheckOut_Payment/dropdown_ExpirationMonth'), '5', true)

WebUI.selectOptionByValue(findTestObject('UI/Page_CheckOut_Payment/dropdown_ExpirationYear'), '6', true)

WebUI.click(findTestObject('UI/Page_CheckOut_Payment/link_PlaceOrder'))

WebUI.waitForElementPresent(findTestObject('UI/Page_CheckOut_Confirmation/label_Status'), config.AppConfig.waitTime)

