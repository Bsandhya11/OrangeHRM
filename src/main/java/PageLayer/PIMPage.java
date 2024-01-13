package PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.Wait;
import io.cucumber.java.en.When;

public class PIMPage extends BaseClass {

	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement pimLink;

	@FindBy(xpath = "//a[text()='Add Employee']")
	private WebElement addEmployee;

	@FindBy(name = "firstName")
	private WebElement fname;

	@FindBy(name = "middleName")
	private WebElement mname;

	@FindBy(name = "lastName")
	private WebElement lname;

	@FindBy(xpath = "//button[text()=' Save ']")
	private WebElement saveButton;

	@FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
	private WebElement employeeid;

	@FindBy(xpath = "//a[text()='Employee List']")
	private WebElement employeeList;

	@FindBy(xpath = "//button[text()=' Search ']")
	private WebElement searchbutton;

	@FindBy(xpath = "//div[text()='Id']/following::input[1]")
	private WebElement searchCheckbox;

	@FindBy(xpath = "//button[text()=' Delete Selected ']")
	private WebElement deleteButton;

	@FindBy(xpath = "//button[text()=' Yes, Delete ']")
	private WebElement delete;

	@FindBy(xpath = "//span[text()='No Records Found']")
	private WebElement noRecords;

	@FindBy(xpath = "//img[@alt='profile picture']/following-sibling::p")
	private WebElement profile;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;

	public PIMPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnPimLink() {
		Wait.click(pimLink);
	}

	public void clickOnAddEmployeeButton() {
		Wait.click(addEmployee);
	}

	public void addEmployee(String Fname, String MName, String Lname) {
		Wait.sendKeys(fname, Fname);
		Wait.sendKeys(mname, MName);
		Wait.sendKeys(lname, Lname);
		Wait.click(saveButton);
	}

	public String getEmployeeId() {
		return Wait.getAttribute(employeeid, "value");
	}

	public void clickOnEmployeeListButton() {
		Wait.click(employeeList);
	}

	public void searchEmployee(String empId) throws InterruptedException {
		
		Thread.sleep(5000);
		Wait.sendKeys(employeeid, empId);
		Wait.click(searchbutton);
		Thread.sleep(5000);
	}

	public void selectAndClickonDelete() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchCheckbox);
		Wait.click(deleteButton);
		Wait.click(delete);
	}

	public String captureText() {
		return Wait.getText(noRecords);
	}

	public void clickOnProfile() {
		Wait.click(profile);
	}

	public void clickOnlogOut() {
		Wait.click(logout);
	}

}
