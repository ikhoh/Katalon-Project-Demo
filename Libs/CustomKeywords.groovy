
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject

import java.util.List


def static "helper.SqlHelper.connectDB"(
    	String server	
     , 	String port	
     , 	String dbname	
     , 	String username	
     , 	String password	) {
    (new helper.SqlHelper()).connectDB(
        	server
         , 	port
         , 	dbname
         , 	username
         , 	password)
}

def static "helper.SqlHelper.executeQuery"(
    	String queryString	) {
    (new helper.SqlHelper()).executeQuery(
        	queryString)
}

def static "helper.SqlHelper.closeDatabaseConnection"() {
    (new helper.SqlHelper()).closeDatabaseConnection()
}

def static "helper.SqlHelper.execute"(
    	String queryString	) {
    (new helper.SqlHelper()).execute(
        	queryString)
}

def static "helper.Driver.waitForElementThenClick"(
    	TestObject element	) {
    (new helper.Driver()).waitForElementThenClick(
        	element)
}

def static "helper.Cmd.ResetDatabase"() {
    (new helper.Cmd()).ResetDatabase()
}

def static "helper.Cmd.KillAllChromeDrivers"() {
    (new helper.Cmd()).KillAllChromeDrivers()
}

def static "helper.General.EncodeCredentials"(
    	String username	
     , 	String password	) {
    (new helper.General()).EncodeCredentials(
        	username
         , 	password)
}

def static "helper.General.ActivateAccount"(
    	String username	) {
    (new helper.General()).ActivateAccount(
        	username)
}

def static "helper.TestRail.get_tests"(
    	String id	) {
    (new helper.TestRail()).get_tests(
        	id)
}

def static "helper.TestRail.update_run"(
    	String id	
     , 	List array	) {
    (new helper.TestRail()).update_run(
        	id
         , 	array)
}

def static "helper.TestRail.add_results"(
    	String id	
     , 	String request	) {
    (new helper.TestRail()).add_results(
        	id
         , 	request)
}
