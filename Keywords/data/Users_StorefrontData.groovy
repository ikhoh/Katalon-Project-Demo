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

public class Users_StorefrontData {
	trait StoreFrontUserProfileTrait {
		String billingFirstName
		String billingLastName
		String billingCompany
		String billingAddress1
		String billingState
		String billingCity
		String billingPostalCode
		String billingPhone
		String billingEmail

		String shippingCarrier
		String shippingService

		String paymentMethod
		String paymentPoNumber
		String paymentCardType
		String paymentNameOnCard
		String paymentSecurityCode
		String paymentExpMonth
		String paymentExpYear
	}

	public class DummyInfo implements StoreFrontUserProfileTrait {
		public static String billingFirstName = "FirstName"
		public static String billingLastName = "LastName"
		public static String billingCompany = "Company"
		public static String billingAddress1 = "Address1"
		public static String billingState = "Minnesota"
		public static String billingCity = "Minneapolis"
		public static String billingPostalCode = "55408"
		public static String billingPhone = "9521231234"
		public static String billingEmail = "guest@test.com"

		public static String shippingCarrier = "UPS"
		public static String shippingService = "Ground"

		public static String paymentMethod = "Credit Card"
		public static String paymentPoNumber = "123"
		public static String paymentCardType = "Visa"
		public static String paymentNameOnCard = "Dummy Card"
		public static String paymentCardNumber = "4111111111111111"
		public static String paymentSecurityCode = "123"
	}
}
