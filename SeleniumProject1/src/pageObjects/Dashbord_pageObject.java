package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashbord_pageObject {
	
@FindBy(xpath = "//*[@id='task-list-group-panel-container']//following::td[1]")
public static WebElement pendingleave;
}
