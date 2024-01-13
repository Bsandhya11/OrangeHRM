package Steps;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BaseLayer.BaseClass;
import PageLayer.LoginPage;
import PageLayer.PIMPage;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRMSteps extends BaseClass {
	PIMPage pIMPage = new PIMPage();;

	static String empid;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		BaseClass.initialization();
	}

	@When("user enter valid credentails")
	public void user_enter_valid_credentails() {
		LoginPage loginPage = new LoginPage();
		loginPage.loginFunctionality("Admin", "admin123");
	}

	@Then("user is on home page and validate home page title")
	public void user_is_on_home_page_and_validate_home_page_title() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Then("user validate Home page URL")
	public void user_validate_home_page_url() {
		boolean actualurl = driver.getCurrentUrl().contains("hrm");
		Assert.assertEquals(actualurl, true);
	}

	@When("user is on pim Page")
	public void user_is_on_pim_page() {

		pIMPage.clickOnPimLink();
	}

	@Then("validate PIM page url")
	public void validate_pim_page_url() {
		boolean actualurl = driver.getCurrentUrl().contains("pim");
		Assert.assertEquals(actualurl, true);
	}

	@When("user click on add Employee")
	public void user_click_on_add_employee() {
		pIMPage.clickOnAddEmployeeButton();
	}

	@When("user enter valid {string},{string}, {string} and click on save button")
	public void user_enter_valid_and_click_on_save_button(String fname, String mname, String lname)
			throws InterruptedException {
		pIMPage.addEmployee(fname, mname, lname);
	}

	@When("user capture the employee id")
	public void user_capture_the_employee_id() throws InterruptedException {
		Thread.sleep(5000);
		empid = pIMPage.getEmployeeId();
	}

	@When("user click on add employee list")
	public void user_click_on_add_employee_list() throws InterruptedException {
		pIMPage.clickOnEmployeeListButton();
		Thread.sleep(2000);
	}

	@When("user enter employee id and click on search button")
	public void user_enter_employee_id_and_click_on_search_button() throws InterruptedException {
		pIMPage.searchEmployee(empid);
	}

	@When("user select searched employee and click on delete")
	public void user_select_searched_employee_and_click_on_delete() throws InterruptedException {

		Thread.sleep(2000);
		pIMPage.selectAndClickonDelete();
	}

	@Then("validate confirm delete window and click on yes deleted")
	public void validate_confirm_delete_window_and_click_on_yes_deleted() throws InterruptedException {

		pIMPage.searchEmployee(empid);
		String actualText = pIMPage.captureText();
		Assert.assertEquals(actualText, "No Records Found");
	}

	@When("user click on profile image")
	public void user_click_on_profile_image() throws InterruptedException {
		pIMPage.clickOnProfile();
	}

	@When("user click on logout button")
	public void user_click_on_logout_button() {
		pIMPage.clickOnlogOut();
	}

}
