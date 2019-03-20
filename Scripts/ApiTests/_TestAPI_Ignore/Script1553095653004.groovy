//import com.kms.katalon.core.testobject.RequestObject
//import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
//import com.kms.katalon.core.testobject.TestObjectProperty
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
//import com.kms.katalon.core.testobject.ConditionType
//
//String endpoint = "https://trunk.local.com/api/v1/sessions"
//String requestMethod = "POST"
//TestObjectProperty auth = new TestObjectProperty("Authorization", ConditionType.EQUALS, "Bearer " + "aXNjOjAwOUFDNDc2LUIyOEUtNEUzMy04QkFFLUI1RjEwM0ExNDJCQw==")
//TestObjectProperty contentType = new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/x-www-form-urlencoded")
//ArrayList defaultHeaders = Arrays.asList(auth, contentType)
//
//
//RequestObject reqObj = new RequestObject()
//reqObj.setHttpHeaderProperties(defaultHeaders)
//reqObj.setRestRequestMethod(requestMethod)
//reqObj.setRestUrl(endpoint)
//reqObj.setBodyContent(null)("grant_type=password&username=buyer3&password=Password1&scope=iscapi offline_access")
//
//def getResponse = WS.sendRequest(reqObj)
//println getResponse.responseText


// ===== ANOTHER METHOD ===== //


//import com.kms.katalon.core.testobject.ConditionType as ConditionType
//import com.kms.katalon.core.testobject.RestRequestObjectBuilder
//import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
//import com.kms.katalon.core.testobject.UrlEncodedBodyParameter
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
//	 
//def builder = new RestRequestObjectBuilder()
//	  
//'Create a new POST object using builder'
//def requestObject = builder
//	.withRestRequestMethod("POST")
//	.withRestUrl("https://trunk.local.com/identity/connect/token")
//	.withHttpHeaders([
//		new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/x-www-form-urlencoded"),
//		new TestObjectProperty("Authorization", ConditionType.EQUALS, "Bearer " + "aXNjOjAwOUFDNDc2LUIyOEUtNEUzMy04QkFFLUI1RjEwM0ExNDJCQw==")
//	])
//	.withUrlEncodedBodyContent([
//		new UrlEncodedBodyParameter("grant_type", "password"),
//		new UrlEncodedBodyParameter("username", "buyer3"),
//		new UrlEncodedBodyParameter("password", "Password1"),
//		new UrlEncodedBodyParameter("scope", "iscapi offline_access")
//	])
//	.build()
//		 
//def response = WS.sendRequest(requestObject)
//	  
//assert response.getStatusCode() == 200