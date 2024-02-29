

package testcases;

import java.util.Map;

import static testutils.TestUtils.boundaryTestFile;
import static testutils.TestUtils.businessTestFile;
import static testutils.TestUtils.currentTest;
import static testutils.TestUtils.yakshaAssert;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import coreUtilities.testutils.ApiHelper;
import coreUtilities.utils.FileOperations;
import pages.FaceBookPage;
import pages.StartupPage;
import testBase.AppTestBase;

public class Facebook_L1_AutomationTest extends AppTestBase {
	
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath+"expected_data.json";
	StartupPage startupPage;
	FaceBookPage FaceBookPageInstance;
	
	
	@Parameters({"browser", "environment"})
	@BeforeClass(alwaysRun = true)
	public void initBrowser(String browser, String environment) throws Exception {
		try{
		configData = new FileOperations().readJson(config_filePath, environment);
		configData.put("url", configData.get("url").replaceAll("[\\\\]", ""));
		configData.put("browser", browser);
		
		boolean isValidUrl = new ApiHelper().isValidUrl(configData.get("url"));
		yakshaAssert(currentTest(), isValidUrl, businessTestFile);
		initialize(configData);
		startupPage = new StartupPage(driver);
		}catch(Exception ex){
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}
	
	@Test(priority = 1, groups = {"sanity"}, description="Validate the login Page")
	public void validateFacebookLoginPage() throws Exception {
		try{
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method validateTheLoginPage() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "LoginPage_Title");
		yakshaAssert(currentTest(),FaceBookPageInstance.validateTheLoginPage().equals(expectedData.get("loginpageTitle")), businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 2, groups = {"sanity"}, description="Validate username field is present in the login Page")
	public void validatePresenceOfOtherFieldsInLoginPage() throws Exception {
		try{
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method validatePresenceOfAllFieldInTheLoginPage() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "username_field");
		yakshaAssert(currentTest(),FaceBookPageInstance.validatePresenceOfAllFieldInTheLoginPage().equals(expectedData.get("username_field_Title")), businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 3, groups = {"sanity"}, description="Validate incorrect username message")
	public void validateIncorrectUsernameDuringLogin() throws Exception {
	try{	
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method Validate_Incorrect_username() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Incorrect_Username");
		yakshaAssert(currentTest(),FaceBookPageInstance.Validate_Incorrect_username().equals(expectedData.get("incorrect_username_meassge")),businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 4, groups = {"sanity"}, description="Validate incorrect password message")
	public void Validate_incorrect_password() throws Exception {
		try{
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method Validate_Incorrect_Password() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Incorrect_password");
		yakshaAssert(currentTest(),FaceBookPageInstance.Validate_Incorrect_Password().equals(expectedData.get("incorrect_password_meassge")),businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	
	@Test(priority = 5, groups = {"sanity"}, description="Provide valid username and password")
	public void Login() throws Exception {
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method username_password() has to be implemented by the implementor
		String page= FaceBookPageInstance.username_password();
		yakshaAssert(currentTest(),page!=null,businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	

	@Test(priority = 6, groups = {"sanity"}, description="Validate that the login button is present and clickable")
	public void login_button_is_Clickable() throws Exception {
		try{
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method loginbutton_is_present_clickable() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Login_button");
		yakshaAssert(currentTest(),FaceBookPageInstance.loginbutton_is_present_clickable() !=null,businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 7, groups = {"sanity"}, description="Validate title of the login page after successfully loggedin")
	public void Validate_title_of_the_login_page() throws Exception {
		try{
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method titleoftheloginpage() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "login_page_title");
		yakshaAssert(currentTest(),FaceBookPageInstance.titleoftheloginpage().equals(expectedData.get("login_page_title_meassge")),businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 8, groups = {"sanity"}, description="verify Forgot Password? link redirects to the password recovery page")
	public void forgot_password() throws Exception {
		try{
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method Click_on_forgot_password() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Forgot_Password");
		yakshaAssert(currentTest(),FaceBookPageInstance.Click_on_forgot_password().equals(expectedData.get("Forgot_Password_title")),businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 9, groups = {"sanity"}, description="Verify that clicking on the Create New Account button")
	public void Create_New_Account() throws Exception {
		try{
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method Click_on_Create_new_account() has to be implemented by the implementor
		FaceBookPage page=FaceBookPageInstance.Click_on_Create_new_account();
		yakshaAssert(currentTest(),page!=null,businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	@Test(priority = 10, groups = {"sanity"}, description="Verify that user navigates to the signup page")
	public void CreateNewAccount() throws Exception {
		try{
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method navigate_to_the_signUp_page() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Sign_up_page");
		yakshaAssert(currentTest(),FaceBookPageInstance.navigate_to_the_signUp_page().equals(expectedData.get("Sign_up_page_title")),businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 11, groups = {"sanity"}, description="Enter values in the First name and Surname")
	public void Enter_data_in_First_name_Surname() throws Exception {
		try{	
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method enter_firstName_surname() has to be implemented by the implementor
		String page=FaceBookPageInstance.enter_firstName_surname();
		yakshaAssert(currentTest(),page!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 12, groups = {"sanity"}, description="Enter values in the Mobile number field")
	public void Enter_data_in_Mobile_number_password() throws Exception {
			try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method enter_MobileNumber() has to be implemented by the implementor
		String page=FaceBookPageInstance.enter_MobileNumber();
		yakshaAssert(currentTest(),page!=null,businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 13, groups = {"sanity"}, description="Select different dates from the Date Of Birth fields")
	public void Date_Of_Birth_fields() throws Exception {
			try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method select_different_DOB_fields() has to be implemented by the implementor
		FaceBookPage page=FaceBookPageInstance.select_different_DOB_fields();
		yakshaAssert(currentTest(),page!=null,businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 15, groups = {"sanity"}, description="Verify selected DOB values should be captured accurately")
	public void DOB_values_captured_accurately() throws Exception {
			try{
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method verify_captured_DOB_values() has to be implemented by the implementor
		String page=FaceBookPageInstance.verify_captured_DOB_values();
		yakshaAssert(currentTest(),page!=null,businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}

	}
	@Test(priority = 16, groups = {"sanity"}, description="Select each radio button option for gender")
	public void Select_each_radio_button() throws Exception {
		try{	
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method select_radio_buttons() has to be implemented by the implementor
		FaceBookPage page=FaceBookPageInstance.select_radio_buttons();
		yakshaAssert(currentTest(),page!=null,businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 17, groups = {"sanity"}, description="Validate that male radio button option should be selectable at a time")
	public void select_one_radio_button() throws Exception {
		try{	
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method Validate_only_one_radio_button_should_be_selectable() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "male_radio_button");
		yakshaAssert(currentTest(),FaceBookPageInstance.Validate_only_one_radio_button_should_be_selectable()!=null,businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 18, groups = {"sanity"}, description="Verify that clicking on the Terms link redirects to the Facebook Terms of Service page")
	public void clicking_on_the_Terms() throws Exception {
			try{
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method navigate_to_Terms_page() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Terms_link");
		yakshaAssert(currentTest(),FaceBookPageInstance.navigate_to_Terms_page()!=null,businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 19, groups = {"sanity"}, description="Ensure that clicking on the privacy Policy link redirects to the Facebook Data Policy page")
	public void clicking_on_the_Data_Policy_link() throws Exception {	
		try{
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method navigate_to_Data_Policy() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Data_Policy_link");
		yakshaAssert(currentTest(),FaceBookPageInstance.navigate_to_Data_Policy()!=null,businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 20, groups = {"sanity"}, description="Click on the sign up button,leave the new password as empty")
	public void click_on_sign_up() throws Exception {	
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method clicking_on_sign_up() has to be implemented by the implementor
		 FaceBookPage page=FaceBookPageInstance.clicking_on_sign_up();
		 yakshaAssert(currentTest(),page!=null,businessTestFile);
		}catch(Exception ex){
			yakshaAssert(currentTest(), false, businessTestFile);
		}

	}
	
	@Test(priority = 21, groups = {"sanity"}, description="Verify that error messages for incomplete field displayed as appropriate")
	public void verify_error_message() throws Exception {	
		try{
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method validate_the_error_message() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "error_message");
		yakshaAssert(currentTest(),FaceBookPageInstance.validate_the_error_message().equals(expectedData.get("verify_error_message")), businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 22, groups = {"sanity"}, description="after Logged In, Validate the title of Facebook Home Page ")
	public void validateFacebookHomePage() throws Exception {
		try{
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method validateTheFacebookHomePage() has to be implemented by the implementor
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "HomePage_Title");
		yakshaAssert(currentTest(),FaceBookPageInstance.validateTheFacebookHomePage().equals(expectedData.get("pageTitle")),businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	@Test(priority = 23, groups = {"sanity"}, description="ClickOn Profile Icon and Validate the Profile Name ")
	public void validateProfileName() throws Exception {
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method clickOnProfileAndValidateProfileName() has to be implemented by the implementor
		String pages=FaceBookPageInstance.clickOnProfileAndValidateProfileName();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 24, groups = {"sanity"}, description="ClickOn Profile Name and upload the profile Picture ")
	public void uploadProfilePicture() throws Exception {
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method clickonProfileNameAndUploadProfilePhotos() has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance.clickonProfileNameAndUploadProfilePhotos();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 25, groups = {"sanity"}, description="clickOn Add Cover Photo and Upload a cover photo")
	public void uploadCoverPhoto() throws Exception {
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method uploadCoverPhoto() has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance.uploadCoverPhoto();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 26, groups = {"sanity"}, description="click On Edit Profile And fill The Detail In Bio Section")
	public void clickOnEditProfileAddDetailsInBioSections() throws Exception {
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method clickOnEditProfileAndfillTheDetailInBioSection() has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance.clickOnEditProfileAndfillTheDetailInBioSection();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 27, groups = {"sanity"}, description="click On Posts and Go Into and Add Details In Add Bio")
	public void clicOnPostGoToIntoAddDetailsInAddBio() throws Exception {
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method clicOnPostGoToIntoAddDetailsInAddBio() has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance.clicOnPostGoToIntoAddDetailsInAddBio();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 28, groups = {"sanity"}, description="click On Posts and Go Into and Click On Edit Details Add WorkPlace")
	public void clicOnPostGoToIntoClickOnEditDetailsAddWorkPlace() throws Exception {
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method clicOnPostGoToIntoClickOnEditDetailsAddWorkPlace() has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance.clicOnPostGoToIntoClickOnEditDetailsAddWorkPlace();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 29, groups = {"sanity"}, description="click On Posts and GoTo Click On Edit Featured and Add One Featured Photos")
	public void clicOnPostGoToIntoClickOnEditFeaturedAddOneFeaturedPhotos() throws Exception {
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method clicOnPostGoToIntoClickOnEditFeaturedAddOneFeaturedPhotos() has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance.clicOnPostGoToIntoClickOnEditFeaturedAddOneFeaturedPhotos();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 30, groups = {"sanity"}, description="go to About Click On Overview Add Workplace")
	public void gotoAboutClickOnOverviewAddWorkplace() throws Exception {
		try{
		softAssert = new SoftAssert();		
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method gotoAboutClickOnOverviewAddWorkplace() has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddWorkplace();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 31, groups = {"sanity"}, description="go to About and Click On Overview and Add Secondary High School")
	public void gotoAboutClickOnOverviewAddSecondaryHighSchool() throws Exception {
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method gotoAboutClickOnOverviewAddSecondaryHighSchool() has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddSecondaryHighSchool();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 32, groups = {"sanity"}, description="go to About and Click On Over view and Add University")
	public void gotoAboutClickOnOverviewAddUniversity() throws Exception {
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method gotoAboutClickOnOverviewAddUniversity() has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddUniversity();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 33, groups = {"sanity"}, description="go to About and Click On Overview and Add Current City")
	public void gotoAboutClickOnOverviewAddCurrentCity() throws Exception {
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method gotoAboutClickOnOverviewAddCurrentCity() has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddCurrentCity();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 34, groups = {"sanity"}, description="go to About and Click On Overview and Add HomeTown")
	public void gotoAboutClickOnOverviewAddHomeTown() throws Exception {
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method gotoAboutClickOnOverviewAddHomeTown() has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddHomeTown();
	    yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 35, groups = {"sanity"}, description="go to About and Click On Overview and Add RelationShip Status")
	public void gotoAboutClickOnOverviewAddRelationShipStatus() throws Exception {
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method gotoAboutClickOnOverviewAddRelationShipStatus() has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddRelationShipStatus();
	    yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	
	@Test(priority = 36, groups = {"sanity"}, description="go to About Click On Overview and Edit PhoneNumber")
	public void gotoAboutClickOnOverviewEditPhoneNumber() throws Exception {
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method gotoAboutClickOnOverviewEditPhoneNumber() has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance.gotoAboutClickOnOverviewEditPhoneNumber();
	    yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	@Test(priority =37, groups = {"sanity"}, description="after log in Check notifications and mark them as read ")
	public void go_to_notification() throws Exception {	
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method Check_notifications () has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance. Check_notifications();
	    yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}
	@Test(priority =38, groups = {"sanity"}, description=" Navigate to the marketplace and search for a specific item ")
	public void go_to_marketPlace () throws Exception {	
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method navigate_to_marketplace() has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance.navigate_to_marketplace();
	    yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}
	}

	@Test(priority =39, groups = {"sanity"}, description=" Like a post ")
	public void like_any_post() throws Exception {	
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method like_a_post() has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance.like_a_post();
	    yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}

	}
	@Test(priority =40, groups = {"sanity"}, description="after logged in, click on events and click on classic.")
	public void click_on_events() throws Exception {	
		try{
		FaceBookPageInstance = new FaceBookPage(driver);
		//Note the below todo and method click_on_events_and_click_on_classic() has to be implemented by the implementor
		FaceBookPage pages=FaceBookPageInstance.click_on_events_and_click_on_classic();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
	}

	}
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		System.out.println("before closing the browser");
		browserTearDown();
	}
	
	@AfterMethod
	public void retryIfTestFails() throws Exception {
		startupPage.navigateToUrl(configData.get("url"));
	}


}
