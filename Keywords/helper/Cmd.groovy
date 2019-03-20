package helper
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import java.io.File

public class Cmd {

	@Keyword
	public void ResetDatabase() {
		String resetDatabaseProjectDll = "C:\\Projects\\Insite.Commerce.Source\\trunk\\Automation\\Insite.Admin.Automated\\bin\\Debug\\Insite.Admin.Automated.dll";
		String nunit3ExeFilePath = "C:\\Program Files (x86)\\NUnit.org\\nunit-console\\nunit3-console.exe";

		try {
			// Execute command
			String command = String.format("%s %s --test=Insite.Admin.Automated.Tests.DatabaseReset", nunit3ExeFilePath, resetDatabaseProjectDll);
			Process process = Runtime.getRuntime().exec(command);
			this.ReadCommandLineExecution(process);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Keyword
	public void KillAllChromeDrivers() {
		try {
			// Execute command
			String command = "taskkill /im chromedriver.exe /f";
			Process process = Runtime.getRuntime().exec(command);
			this.ReadCommandLineExecution(process);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void ReadCommandLineExecution(Process process) {
		BufferedReader stdInput = new BufferedReader(new
				InputStreamReader(process.getInputStream()));

		BufferedReader stdError = new BufferedReader(new
				InputStreamReader(process.getErrorStream()));

		// read the output from the command
		System.out.println("Here is the standard output of the command:\n");
		String s = null;
		while ((s = stdInput.readLine()) != null) {
			System.out.println(s);
		}

		// read any errors from the attempted command
		System.out.println("Here is the standard error of the command (if any):\n");
		while ((s = stdError.readLine()) != null) {
			System.out.println(s);
		}
	}
}