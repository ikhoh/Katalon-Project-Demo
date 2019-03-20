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
import groovy.json.JsonSlurper as JsonSlurper

response = WS.sendRequest(findTestObject('API/GetToken'))

WS.verifyResponseStatusCode(response, 200)

JsonSlurper slurper = new JsonSlurper()

Map parsedJsonResponse = slurper.parseText(response.responseText)

GlobalVariable.G_accessToken = parsedJsonResponse.access_token

response = WS.sendRequest(findTestObject('API/GetSession', [('accessToken') : GlobalVariable.G_accessToken]))

GlobalVariable.G_cookie = (response.getHeaderFields()['Set-Cookie'])

println('Cookie Set: ' + GlobalVariable.G_cookie)

response = WS.sendRequest(findTestObject('API/GetWishlists', [('cookie') : GlobalVariable.G_cookie]))

parsedJsonResponse = slurper.parseText(response.responseText)

def wishListCollection = parsedJsonResponse.wishListCollection

def found = false

for (def index : (0..wishListCollection.size() - 1)) {
    if (wishListCollection[index].name == 'LeavingFromShareDetail') {
        found = true
    }
}

assert found == true

