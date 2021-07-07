package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.User_Role;

public class Test_User_Role extends CommonFunctions {
	
	static Logger logger = Logger.getLogger(Test_User_Role.class);
	public void movetoUser()
	{
		
		Actions actions = new Actions(driver);
		actions.moveToElement(User_Role.adminLink);
		actions.moveToElement(User_Role.userManagementLink);
		actions.moveToElement(User_Role.userLink);
		actions.click().build().perform();
	}
	public void selectUserRole()
	{
		Select selectrole= new Select(User_Role.userrole);
		selectrole.selectByIndex(1);
	}
	public void selectUserstatus()
	{
		Select selectstatus= new Select(User_Role.userStatus);
		selectstatus.selectByIndex(1);
	}
	
	@Test
	public void checkUserRole() {
		PageFactory.initElements(driver,User_Role.class );
		logger.info("Navigating to user Page");
		movetoUser();
		logger.info("Selecting the user Role");
	    selectUserRole();
	    logger.info("Selecting the user status");
		selectUserstatus();
		User_Role.searchButton.click();
		
		String actualrole=User_Role.userrolevalue.getText();
		String actualstatus=User_Role.userStatusvalue.getText();
		logger.info("Verification the result");
		Assert.assertEquals(actualrole, "Admin");
		Assert.assertEquals(actualstatus, "Enabled");
		logger.info("End of the result Test_User_Role");
	}

}
