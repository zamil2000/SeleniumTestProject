package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User_Role {
@FindBy(id="searchSystemUser_userName")
public static WebElement username;
@FindBy(id="searchSystemUser_userType")
public static WebElement userrole;
@FindBy(id="searchSystemUser_status")
public static WebElement userStatus;
@FindBy(id="searchBtn")
public static WebElement searchButton;
@FindBy(xpath = "//tr/td[3]")
public static WebElement userrolevalue;
@FindBy(xpath = "//tr/td[5]")
public static WebElement userStatusvalue;
@FindBy(linkText = "Admin")
public static WebElement adminLink;
@FindBy(id="menu_admin_UserManagement")
public static WebElement userManagementLink;
@FindBy(id="menu_admin_viewSystemUsers")
public static WebElement userLink;


}
