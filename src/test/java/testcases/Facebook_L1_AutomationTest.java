

package testcases;

import static testutils.TestUtils.businessTestFile;
import static testutils.TestUtils.currentTest;
import static testutils.TestUtils.yakshaAssert;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coreUtilities.testutils.ApiHelper;
import coreUtilities.utils.FileOperations;
import pages.FaceBookPage;
import pages.StartupPage;
import testBase.AppTestBase;

public class Facebook_L1_AutomationTest extends AppTestBase {
	
	Map<String, String> configData;
	Map<String, String> loginCredentials;
	String expectedDataFilePath = testDataFilePath+"expected_data.json";
	String expectedLoginPath = testDataFilePath+"Login.json";
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
		
		initialize(configData);
		startupPage = new StartupPage(driver);
		FaceBookPageInstance = new FaceBookPage(driver);
		yakshaAssert(currentTest(), isValidUrl, businessTestFile);
		Assert.assertTrue(isValidUrl, configData.get("url")+" might be Server down at this moment. Please try after sometime.");
		}catch(Exception ex){
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 1, groups = {"sanity"}, description="Validate the login Page")
	public void validateFacebookLoginPage() throws Exception {
		try{
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "LoginPage_Title");
		String title = FaceBookPageInstance.validateTheLoginPage();
		yakshaAssert(currentTest(),title.equals(expectedData.get("loginpageTitle")), businessTestFile);
		Assert.assertEquals(title, expectedData.get("loginpageTitle"));
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 2, groups = {"sanity"}, description="Validate username field is present in the login Page")
	public void validatePresenceOfOtherFieldsInLoginPage() throws Exception {
		try{
		
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "username_field");
		String field = FaceBookPageInstance.validatePresenceOfAllFieldInTheLoginPage();
		yakshaAssert(currentTest(),field.equals(expectedData.get("username_field_Title")), businessTestFile);
		Assert.assertEquals(field, expectedData.get("username_field_Title"));
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 3, groups = {"sanity"}, description="Validate incorrect username message")
	public void validateIncorrectUsernameDuringLogin() throws Exception {
	try{	
		
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Incorrect_Username");
		String msg = FaceBookPageInstance.Validate_Incorrect_username();
		yakshaAssert(currentTest(),msg.equals(expectedData.get("incorrect_username_meassge")),businessTestFile);
		Assert.assertEquals(msg, expectedData.get("incorrect_username_meassge"));
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 4, groups = {"sanity"}, description="Validate incorrect password message")
	public void Validate_incorrect_password() throws Exception {
		try{
		
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Incorrect_password");
		String msg = FaceBookPageInstance.Validate_Incorrect_Password();
		yakshaAssert(currentTest(),msg.equals(expectedData.get("incorrect_password_meassge")),businessTestFile);
		Assert.assertEquals(msg, expectedData.get("incorrect_password_meassge"));
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	
	
	@Test(priority = 5, groups = {"sanity"}, description="verify Forgot Password? link redirects to the password recovery page")
	public void forgot_password() throws Exception {
		try{
		
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Forgot_Password");
		String title = FaceBookPageInstance.Click_on_forgot_password();
		yakshaAssert(currentTest(),title.equals(expectedData.get("Forgot_Password_title")),businessTestFile);
		Assert.assertEquals(title, expectedData.get("Forgot_Password_title"));
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 6, groups = {"sanity"}, description="Verify that clicking on the Create New Account button")
	public void Create_New_Account() throws Exception {
		try{
		
		FaceBookPage page=FaceBookPageInstance.Click_on_Create_new_account();
		yakshaAssert(currentTest(),page!=null,businessTestFile);
		Assert.assertNotNull(page);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	@Test(priority = 7, groups = {"sanity"}, description="Verify that user navigates to the signup page")
	public void CreateNewAccount() throws Exception {
		try{
		
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Sign_up_page");
		String title = FaceBookPageInstance.navigate_to_the_signUp_page();
		yakshaAssert(currentTest(),title.equals(expectedData.get("")),businessTestFile);
		Assert.assertEquals(title, expectedData.get("Sign_up_page_title"));
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 8, groups = {"sanity"}, description="Enter values in the First name and Surname")
	public void Enter_data_in_First_name_Surname() throws Exception {
		try{	
			Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "userdetails");
		FaceBookPage page=FaceBookPageInstance.enter_firstName_surname(expectedData);
		yakshaAssert(currentTest(),page!=null, businessTestFile);
		Assert.assertNotNull(page);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 9, groups = {"sanity"}, description="Enter values in the Mobile number field")
	public void Enter_data_in_Mobile_number() throws Exception {
			try{
		
		String page=FaceBookPageInstance.enter_MobileNumber();
		yakshaAssert(currentTest(),page!=null,businessTestFile);
		Assert.assertNotNull(page);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 10, groups = {"sanity"}, description="Select different dates from the Date Of Birth fields")
	public void Date_Of_Birth_fields() throws Exception {
			try{
		
		FaceBookPage page=FaceBookPageInstance.select_different_DOB_fields();
		yakshaAssert(currentTest(),page!=null,businessTestFile);
		Assert.assertNotNull(page);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	
	@Test(priority = 11, groups = {"sanity"}, description="Select each radio button option for gender")
	public void Select_each_radio_button() throws Exception {
		try{	
		
		FaceBookPage page=FaceBookPageInstance.select_radio_buttons();
		yakshaAssert(currentTest(),page!=null,businessTestFile);
		Assert.assertNotNull(page);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	
	
	@Test(priority = 12, groups = {"sanity"}, description="Verify that clicking on the Terms link redirects to the Facebook Terms of Service page")
	public void clicking_on_the_Terms() throws Exception {
			try{
		
		//Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Terms_link");
		FaceBookPage page = FaceBookPageInstance.navigate_to_Terms_page();
		yakshaAssert(currentTest(),page!=null,businessTestFile);
		Assert.assertNotNull(page);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 13, groups = {"sanity"}, description="Ensure that clicking on the privacy Policy link redirects to the Facebook Data Policy page")
	public void clicking_on_the_Data_Policy_link() throws Exception {	
		try{
		
		//Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Data_Policy_link");
		FaceBookPage page = FaceBookPageInstance.navigate_to_Data_Policy();
		yakshaAssert(currentTest(),page!=null,businessTestFile);
		Assert.assertNotNull(page);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 14, groups = {"sanity"}, description="Click on the sign up button,leave the new password as empty")
	public void click_on_sign_up() throws Exception {	
		try{
		
		 FaceBookPage page=FaceBookPageInstance.clicking_on_sign_up();
		 yakshaAssert(currentTest(),page!=null,businessTestFile);
		 Assert.assertNotNull(page);
		}catch(Exception ex){
			yakshaAssert(currentTest(), false, businessTestFile);
			Assert.assertTrue(false);
		}

	}
	
	@Test(priority = 15, groups = {"sanity"}, description="Verify that error messages for incomplete field displayed as appropriate")
	public void verify_error_message() throws Exception {	
		try{
		
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "error_message");
		String msg = FaceBookPageInstance.validate_the_error_message();
		yakshaAssert(currentTest(),msg.equals(expectedData.get("verify_error_message")), businessTestFile);
		Assert.assertEquals(msg, expectedData.get("verify_error_message"));
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}

	}
	
	@Test(priority = 16, groups = {"sanity"}, description="Provide valid username and password")
	public void Login() throws Exception {
		try{
			Map<String, String> expectedLoginDetails = new FileOperations().readJson(expectedLoginPath, "credentials");
		String page= FaceBookPageInstance.username_password(expectedLoginDetails);
		yakshaAssert(currentTest(),page!=null,businessTestFile);
		Assert.assertNotNull(page);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	

	@Test(priority = 17, groups = {"sanity"}, description="Validate that the login button is present and clickable")
	public void login_button_is_Clickable() throws Exception {
		try{
		
		//Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "Login_button");
		FaceBookPage page = FaceBookPageInstance.loginbutton_is_present_clickable();
		yakshaAssert(currentTest(), page!=null,businessTestFile);
		Assert.assertNotNull(page);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 18, groups = {"sanity"}, description="Validate title of the login page after successfully loggedin")
	public void Validate_title_of_the_login_page() throws Exception {
		try{
		
		Map<String, String> expectedData = new FileOperations().readJson(expectedDataFilePath, "login_page_title");
		String title = FaceBookPageInstance.titleoftheloginpage();
		yakshaAssert(currentTest(),title.equals(expectedData.get("login_page_title_meassge")),businessTestFile);
		Assert.assertEquals(title, expectedData.get("login_page_title_meassge"));
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}

	


	@Test(priority = 19, groups = {"sanity"}, description="ClickOn Profile Icon and Validate the Profile Name ")
	public void validateProfileName() throws Exception {
		try{
		
		String pages=FaceBookPageInstance.clickOnProfileAndValidateProfileName();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
		Assert.assertNotNull(pages);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 20, groups = {"sanity"}, description="ClickOn Profile Name and upload the profile Picture ")
	public void uploadProfilePicture() throws Exception {
		try{
		
		String pages=FaceBookPageInstance.clickonProfileNameAndUploadProfilePhotos();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
		Assert.assertNotNull(pages);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 21, groups = {"sanity"}, description="clickOn Add Cover Photo and Upload a cover photo")
	public void uploadCoverPhoto() throws Exception {
		try{
		
		FaceBookPage pages=FaceBookPageInstance.uploadCoverPhoto();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
		Assert.assertNotNull(pages);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 22, groups = {"sanity"}, description="click On Edit Profile And fill The Detail In Bio Section")
	public void clickOnEditProfileAddDetailsInBioSections() throws Exception {
		try{
		
		FaceBookPage pages=FaceBookPageInstance.clickOnEditProfileAndfillTheDetailInBioSection();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
		Assert.assertNotNull(pages);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 23, groups = {"sanity"}, description="click On Posts and Go Into and Add Details In Add Bio")
	public void clicOnPostGoToIntoAddDetailsInAddBio() throws Exception {
		try{
		
		FaceBookPage pages=FaceBookPageInstance.clickOnEditProfileAndfillTheDetailInBioSection();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
		Assert.assertNotNull(pages);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 24, groups = {"sanity"}, description="click On Posts and Go Into and Click On Edit Details Add WorkPlace")
	public void clicOnPostGoToIntoClickOnEditDetailsAddWorkPlace() throws Exception {
		try{
		
		FaceBookPage pages=FaceBookPageInstance.clickOnEditDetailsAndAddWorkPlace();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
		Assert.assertNotNull(pages);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	
	
	
	@Test(priority = 25, groups = {"sanity"}, description="go to About and Click On Overview and Add Secondary High School")
	public void gotoAboutClickOnOverviewAddSecondaryHighSchool() throws Exception {
		try{
		
		FaceBookPage pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddSecondaryHighSchool();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
		Assert.assertNotNull(pages);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 26, groups = {"sanity"}, description="go to About and Click On Over view and Add University")
	public void gotoAboutClickOnOverviewAddUniversity() throws Exception {
		try{
		
		FaceBookPage pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddUniversity();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
		Assert.assertNotNull(pages);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 27, groups = {"sanity"}, description="go to About and Click On Overview and Add Current City")
	public void gotoAboutClickOnOverviewAddCurrentCity() throws Exception {
		try{
		
		FaceBookPage pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddCurrentCity();
		yakshaAssert(currentTest(),pages!=null, businessTestFile);
		Assert.assertNotNull(pages);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 28, groups = {"sanity"}, description="go to About and Click On Overview and Add HomeTown")
	public void gotoAboutClickOnOverviewAddHomeTown() throws Exception {
		try{
		
		FaceBookPage pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddHomeTown();
	    yakshaAssert(currentTest(),pages!=null, businessTestFile);
		Assert.assertNotNull(pages);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	@Test(priority = 29, groups = {"sanity"}, description="go to About and Click On Overview and Add RelationShip Status")
	public void gotoAboutClickOnOverviewAddRelationShipStatus() throws Exception {
		try{
		
		FaceBookPage pages=FaceBookPageInstance.gotoAboutClickOnOverviewAddRelationShipStatus();
	    yakshaAssert(currentTest(),pages!=null, businessTestFile);
		Assert.assertNotNull(pages);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	
	
	@Test(priority =30, groups = {"sanity"}, description="after log in Check notifications and mark them as read ")
	public void go_to_notification() throws Exception {	
		try{
		
		FaceBookPage pages=FaceBookPageInstance.Check_notifications();
	    yakshaAssert(currentTest(),pages!=null, businessTestFile);
		Assert.assertNotNull(pages);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}
	

	@Test(priority = 31, groups = {"sanity"}, description="Validate logout")
	public void logout() throws Exception {
		try{
		
		
		FaceBookPage page = FaceBookPageInstance.logout();
		yakshaAssert(currentTest(),page!=null,businessTestFile);
		Assert.assertNotNull(page);
	}catch(Exception ex){
		yakshaAssert(currentTest(), false, businessTestFile);
		Assert.assertTrue(false);
	}
	}

	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		System.out.println("before closing the browser");
		browserTearDown();
	}
	
	


}
