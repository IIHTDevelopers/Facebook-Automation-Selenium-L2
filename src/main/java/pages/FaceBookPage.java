package pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;

public class FaceBookPage extends StartupPage {

	// add locators as per need
	
	// DECLARE ANY OBJECTS/VARIABLE TO SHARE DATA/INFORMATION/STATUS AMONG DIFFERENT METHODS 

	public FaceBookPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Expected data will be fetch from config.json file,path of the json file is:FaceBook_Automation_Dummy/src/main/resources/config.json

	// Return the Title of Login page
	public String validateTheLoginPage() {
		// TODO Auto-generated method stub
		return null;
	}

	// return the user name field placeholder value in login page
	public String validatePresenceOfAllFieldInTheLoginPage() {
		// TODO Auto-generated method stub
		return null;
	}

	// provide some invalid user name and return message that displays
	public String Validate_Incorrect_username() {
		// TODO Auto-generated method stub
		return null;
	}

	// provide some invalid password and return message that displays
	public String Validate_Incorrect_Password() {
		// TODO Auto-generated method stub
		return null;
	}

	// click on forgot password and return the title of navigated page
	public String Click_on_forgot_password() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// click on crete new account
	public FaceBookPage Click_on_Create_new_account()
	{
		
		return null;	
	}

	// validate if page navigates to SignUp page. Return page title
	public String navigate_to_the_signUp_page() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Enter firs name , last name by using provided data 
	public FaceBookPage enter_firstName_surname(Map<String, String> userData) {
		// TODO Auto-generated method stub
		return null;
	}

	public String enter_MobileNumber() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// select DOB fields
	public FaceBookPage select_different_DOB_fields() {
		
		return null;	
	}
	
	
	
	// Select Gender Radio button
	public FaceBookPage select_radio_buttons() {
	
		return null;	
	}
	
	
	// navigate to Terms page
	public FaceBookPage navigate_to_Terms_page() {
		
		return null;	
	}

	// Navigate to Data Policy 
	public FaceBookPage navigate_to_Data_Policy() {
	
		return null;	
	}
	

	// Click on sign Up button
	public FaceBookPage clicking_on_sign_up() {
		
		return null;	
	}
	

	// Return the error message shown for incomplete signup data
	public String validate_the_error_message() {
		// TODO Auto-generated method stub
		return null;
	}

	// Navigate to login and provide the login data	
	public String username_password(Map<String, String> loginData) {
		// TODO Auto-generated method stub
		return null;
	}

	// Check if login button is present and click on login
	public FaceBookPage loginbutton_is_present_clickable() {
		
		return null;		
	}

	// After successful login return the title of Loged in Page
	public String titleoftheloginpage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Click on logout option and log out
	public FaceBookPage logout() {
		// TODO Auto-generated method stub
		return null;
	}	

	// Click on profile nad return the profile name
	public String clickOnProfileAndValidateProfileName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// click on profile name and upload photo, return the file name 
	public String  clickonProfileNameAndUploadProfilePhotos() throws Exception {
		
		return null;
	}
	
	// upload cover photo, return the file name 
	public FaceBookPage uploadCoverPhoto() throws Exception {
		
		return null;
	}
	

	// Add Details in Bio section
	public FaceBookPage clickOnEditProfileAndfillTheDetailInBioSection() throws Exception {
		
		return null;
	}
	
	//click add WorkPlace and add workplace details	
	public FaceBookPage clickOnEditDetailsAndAddWorkPlace() throws Exception {
		
		return null;
	}
	

	// add High School Details
	public FaceBookPage gotoAboutClickOnOverviewAddSecondaryHighSchool() throws Exception {
		
		return null;
	}
	
	// add University details
	public FaceBookPage gotoAboutClickOnOverviewAddUniversity() throws Exception {
		
		return null;
	}
	

	//add Current City
	public FaceBookPage gotoAboutClickOnOverviewAddCurrentCity() throws Exception {
		
		return null;
	}
	
	// add Home Town
	public FaceBookPage gotoAboutClickOnOverviewAddHomeTown() throws Exception {
		
		return null;
	}
	
	//add Relationship status
	public FaceBookPage gotoAboutClickOnOverviewAddRelationShipStatus() throws Exception {
		
		return null;
	}
	
	// click on notification icon
	public FaceBookPage Check_notifications() {
		
		return null;		
	}
	
	
	
	

}
