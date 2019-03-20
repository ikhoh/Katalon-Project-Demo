import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import java.text.SimpleDateFormat

// Get all test cases in the given test run ID, and capture them into a list
def response = CustomKeywords.'helper.TestRail.get_tests'(GlobalVariable.G_testrail_testrun_id)
WebUI.comment('response='+response.toString())

def listof_testcases = []
for (def n:(0..response['id'].size - 1)) {
	if (response['case_id'][n].toString()!='null'){
		listof_testcases.add(response['case_id'][n].toString())
	}
}
WebUI.comment(listof_testcases.toString())

// Add variable TestCaseID(s) from Test Case into a list
def total_testcases_to_update=[]
for (def n:(0..GlobalVariable.G_testrail_testcase_id.size - 1)) {
	if (GlobalVariable.G_testrail_testcase_id[n].toString()!='null') {
		total_testcases_to_update.add(GlobalVariable.G_testrail_testcase_id[n].toString())
	}
}

//for (def n:(0..listof_testcases.size - 1)) {
//	if (listof_testcases[n]!='null') {
//		total_testcases_to_update.add(listof_testcases[n].toString())
//	}
//}

// Update test run to 'include all' test cases that's added to that Test Run
response = CustomKeywords.'helper.TestRail.update_run'(GlobalVariable.G_testrail_testrun_id, total_testcases_to_update)
WebUI.comment('response=' + response.toString())

// Create request to update test case results
String request = '{"results": ['
def status_id
for (def n:(0..GlobalVariable.G_testrail_testcase_id.size - 1)) {
	if (GlobalVariable.G_testrail_testcase_id[n]!='null') {
		if (GlobalVariable.G_testrail_testcase_status[n]=='PASSED')
		{
			status_id='1' //passed
		}
		else {
			status_id ='5' //failed
		}
		def date = new Date()
		sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
		request = request.concat('{"case_id":'+GlobalVariable.G_testrail_testcase_id[n]+',"status_id":'+status_id+',"comment":"Automation Updated as of ' + sdf.format(date) + '"},')
	}
}

request = request.substring(0, request.length()-1) //removing last excessive comma from request
request = request.concat("]}")
request = request.replaceAll("null,","")
request = request.replaceAll("null","")
WebUI.comment('request=' + request.toString())

response = CustomKeywords.'helper.TestRail.add_results'(GlobalVariable.G_testrail_testrun_id, request)
WebUI.comment('response=' + response.toString())