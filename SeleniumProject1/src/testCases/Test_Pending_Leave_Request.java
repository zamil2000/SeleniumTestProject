package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.Dashbord_pageObject;
import pageObjects.Login_Page_Object;




public class Test_Pending_Leave_Request extends CommonFunctions  {
	String actualrecord=null;
	static Logger logger=Logger.getLogger(Test_Pending_Leave_Request.class);
	//login home page
	public void login() {
		logger.info("Login to application");
		PageFactory.initElements(driver,Login_Page_Object.class );
		Login_Page_Object.userName.sendKeys(property.getProperty("username"));
		Login_Page_Object.passWord.sendKeys(property.getProperty("password"));
		Login_Page_Object.submitButton.click();
	}
	
	//Dashbord checking
	public void getPendingdasbord()
	{
		PageFactory.initElements(driver,Dashbord_pageObject.class );
		 actualrecord=Dashbord_pageObject.pendingleave.getText();
		
	}
@Test
public void verify_Test_pending()
{
	
	login();
	logger.info("Getting the Test_Pending_Leave_Request ");
	getPendingdasbord();
	logger.info("verification ");
	Assert.assertEquals(actualrecord, "No Records are Available");
	logger.info("End of  Test_Pending_Leave_Request Test case ");
}
}
