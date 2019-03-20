package helper

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper

public class TestRail {

	@Keyword
	def get_tests(String id) {
		def slurper = new JsonSlurper()
		RequestObject ro = new RequestObject('Get TestRail tests')
		ro.setRestRequestMethod('GET')
		ro.setRestUrl('https://insitesoft.testrail.net/index.php?/api/v2/get_tests/' + id)
		def httpheader = new ArrayList<TestObjectProperty>()
		httpheader.add(new TestObjectProperty('Content-Type', ConditionType.EQUALS, 'application/json'))
		httpheader.add(new TestObjectProperty('Authorization', ConditionType.EQUALS, config.AppConfig.testRailAuthCredentials))

		ro.setHttpHeaderProperties(httpheader)
		ro.setBodyContent(new HttpTextBodyContent('', 'UTF-8', 'application/json'))

		def response = WS.sendRequest(ro)
		return slurper.parseText(response.getResponseText())
	}

	// Update Test Run (which this function will include all test suites that's assigned to that particular test run
	@Keyword
	def update_run(String id, List array) {
		def slurper = new JsonSlurper()
		def ro = new RequestObject('Update TestRail test run')
		ro.setRestRequestMethod('POST')
		ro.setRestUrl('https://insitesoft.testrail.net/index.php?/api/v2/update_run/' + id)

		def httpheader = new ArrayList<TestObjectProperty>()
		httpheader.add(new TestObjectProperty('Content-Type', ConditionType.EQUALS, 'application/json'))
		httpheader.add(new TestObjectProperty('Authorization', ConditionType.EQUALS, config.AppConfig.testRailAuthCredentials))
		ro.setHttpHeaderProperties(httpheader)

		def body ='{"include_all": true}'
		WebUI.comment('body = ' + body)
		ro.setBodyContent(new HttpTextBodyContent(body, 'UTF-8', 'application/json'))
		def response = WS.sendRequest(ro)
		return slurper.parseText(response.getResponseText())
	}

	@Keyword
	def add_results(String id, String request) {
		def slurper = new JsonSlurper()
		RequestObject ro = new RequestObject('Add TestRail results')
		ro.setRestRequestMethod('POST')
		ro.setRestUrl('https://insitesoft.testrail.net/index.php?/api/v2/add_results_for_cases/' + id)

		def httpheader = new ArrayList<TestObjectProperty>()
		httpheader.add(new TestObjectProperty('Content-Type', ConditionType.EQUALS, 'application/json'))
		httpheader.add(new TestObjectProperty('Authorization', ConditionType.EQUALS, config.AppConfig.testRailAuthCredentials))
		ro.setHttpHeaderProperties(httpheader)


		WebUI.comment('body = ' + request)
		ro.setBodyContent(new HttpTextBodyContent(request, 'UTF-8', 'application/json'))

		def response = WS.sendRequest(ro)
		def response_array = slurper.parseText(response.getResponseText())
		return slurper.parseText(response.getResponseText())
	}
}
