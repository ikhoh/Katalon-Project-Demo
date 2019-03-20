package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object G_testrail_testcase_id
     
    /**
     * <p></p>
     */
    public static Object G_testrail_testcase_status
     
    /**
     * <p></p>
     */
    public static Object G_testrail_testrun_id
     
    /**
     * <p></p>
     */
    public static Object G_accessToken
     
    /**
     * <p></p>
     */
    public static Object G_cookie
     
    /**
     * <p></p>
     */
    public static Object G_storefrontUsername
     
    /**
     * <p></p>
     */
    public static Object G_storefrontPassword
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            G_testrail_testcase_id = selectedVariables['G_testrail_testcase_id']
            G_testrail_testcase_status = selectedVariables['G_testrail_testcase_status']
            G_testrail_testrun_id = selectedVariables['G_testrail_testrun_id']
            G_accessToken = selectedVariables['G_accessToken']
            G_cookie = selectedVariables['G_cookie']
            G_storefrontUsername = selectedVariables['G_storefrontUsername']
            G_storefrontPassword = selectedVariables['G_storefrontPassword']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
