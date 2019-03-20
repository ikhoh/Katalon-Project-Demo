import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.context.TestCaseContext
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

class AfterAllTestCase {
	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		
		// Get test case number from tc variable
		if(!GlobalVariable.G_testrail_testcase_id.isEmpty())
		{
			GlobalVariable.G_testrail_testcase_id.clear()
		}
		if(!GlobalVariable.G_testrail_testcase_status.isEmpty())
		{
			GlobalVariable.G_testrail_testcase_status.clear()
		}
		def testcase_ids = testCaseContext.getTestCaseVariables()['TestRail_TestCaseID'].split(",")
		for (def n : (0 .. testcase_ids.length - 1)) {
			GlobalVariable.G_testrail_testcase_id.add(testcase_ids[n])
			GlobalVariable.G_testrail_testcase_status.add(testCaseContext.getTestCaseStatus())
		}
		
		// push results to TestRail
		WebUI.callTestCase(findTestCase('Test Cases/Utilities/_UpdateTestRailResults'), [:], FailureHandling.CONTINUE_ON_FAILURE)
		
		WebUI.closeBrowser()
		CustomKeywords.'helper.Cmd.KillAllChromeDrivers'()
	}
}