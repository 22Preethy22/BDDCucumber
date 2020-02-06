package in.com.hcl.stepdefinition;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigFileReader;
import utilities.ScreenShot;
import utilities.WebDriver_Generic;

public class APIandUITest {

	utilities.ConfigFileReader configFileReader;
	RequestSpecification request1;
	String ROOT_URI;
	Response response;
	Response response1;
	// *****************************************API
	// methods************************************************************

	@Given("^I get employee service api endpoint$")
	public void set_Post_Endpoint() {
		ROOT_URI = "http://dummy.restapiexample.com/api/v1";
		System.out.println("get URL:" + ROOT_URI);
	}

	

	@Then("^I validated the response$")
	public void valid_response() throws Throwable {
		JsonPath jsonPath = new JsonPath(response1.asString());
//		System.out.println(jsonPath.get("data[2]"));
		System.out.println("Get Employees " + response.asString());
		Assert.assertEquals(200, response.getStatusCode());
	}

	@Then("^I recieve valid response$")
	public void i_recieve_valid_response() throws Throwable {
		JsonPath jsonPath = new JsonPath(response.asString());
		System.out.println(" ID " + jsonPath.get("data[2].id"));
		System.out.println(" employee_name " + jsonPath.get("data[2].employee_name"));
		System.out.println("Get Employees " + response.asString());
		Assert.assertEquals(200, response.getStatusCode());
	}

	// **************************************************************post******************
	@Given("^I get employee api endpoint$")
	public void Post_customer_Endpoint() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		request1 = RestAssured.given();
		System.out.println("get URL:" + RestAssured.baseURI);
	}

	// RequestSpecification request;
	@SuppressWarnings("unchecked")
	@When("^Post the request with following data$")
	public void post_the_request_with_following_data() throws Throwable {
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		double nameId = Math.random();
		String emp_name = "zozo_" + nameId;
		// HashMap requestParams =new HashMap();
		requestParams.put("id", "100");
		requestParams.put("emp_name", emp_name);
		requestParams.put("employee_salary", Math.random());
		requestParams.put("employee_age", 45);
		requestParams.put("profile_image", "");

		request.header("Content-Type", "application/json");
		//// Add the Json to the body of the request
		request.body(requestParams.toJSONString());
		//// Post the request and check the response
		response = request.post("/create");
	}

	@Then("^validate the response$")
	public void validate_response() throws Throwable {
		int statusCode = response.getStatusCode();
		Assert.assertEquals("the post was unsuccessful", statusCode, 200);
		// System.out.println("The status code recieved: " + statusCode);
		System.out.println("Response body: " + response.body().asString());

	}

	@SuppressWarnings("unchecked")
	@When("^I update Request$")
	public void update_the_request_with_following_data() throws Throwable {
		int empid = 234;
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		double nameId = Math.random();
		String emp_name = "zozo_" + nameId;
		// HashMap requestParams =new HashMap();
		// requestParams.put("id", "100");
		requestParams.put("emp_name", emp_name);
		requestParams.put("employee_salary", Math.random());
		requestParams.put("employee_age", 45);
		// requestParams.put("profile_image", "");

		request.header("Content-Type", "application/json");
		//// Add the Json to the body of the request
		request.body(requestParams.toJSONString());
		//// Post the request and check the response
		response = request.put("/update/" + empid);
	}

	// **********************************************2/6
	// methods****************************************************************************

	@SuppressWarnings("unchecked")
	@When("^Post the request with following$")
	public void post_with_following(DataTable field) throws Throwable {

		Map<String, String> testData = field.asMap(String.class, String.class);
		
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name", testData.get("emp_name"));
		requestParams.put("salary", testData.get("employee_salary"));
		requestParams.put("age", testData.get("employee_age"));
		// requestParams.put("profile_image", "");

		

		request.header("Content-Type", "application/json");
		//// Add the Json to the body of the request
		request.body(requestParams.toJSONString());
		response = request.post("/create");
		
		
		//// Post the request and check the response
		//response = request.put("/update/" + empid);

		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)

	}
	@When("^I get Request$")
	public void sendGetRequest() {
		
		System.out.println("Response body in GET Request: " + response.body().asString());
		String id1=response.jsonPath().getString("data.id");
		System.out.println(id1);

		
		response = given()./* config(config) */contentType(ContentType.JSON).accept(ContentType.JSON).when()
				.get(ROOT_URI + "/employee/"+id1);
	//JsonPath jsonPath = new JsonPath(response.asString());
	//	System.out.println(jsonPath.get("data[].id"));
		
		//System.out.println(response.jsonPath().getString("id"));
		
	}
}

/*
 * 
 * @Given("^username and password present$") public void setPostEndpoint() {
 * 
 * 
 * WebDriver driver = new ChromeDriver(); driver.manage().window().maximize();
 * System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe"); //
 * C:\\Users\\suryakanthnag.pujar\\Desktop\\softwares\\Chrome\\chromedriver.exe
 * // driver.get("http://www.google.com");
 * driver.get(ConfigFileReader.getApplicationUrl());
 * 
 * System.out.println("Successfully opened the chrome browser");
 * 
 * }
 * 
 * @When("^enter username and password click on sumbit$") public void
 * enter_username_and_password_click_on_sumbit() { // Write code here that turns
 * the phrase above into concrete actions
 * 
 * System.out.println("When_sucess"); Assert.fail(); }
 * 
 * //
 * *****************************************************************************
 * **************************
 * 
 * @Given("^launch makemytrip browser$") public void launch_the_browser() throws
 * Throwable {
 * 
 * configFileReader = new ConfigFileReader();
 * System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
 * WebDriver driver = new ChromeDriver();
 * WebDriver_Generic.Window_Maximize(driver);
 * driver.get(ConfigFileReader.getApplicationUrl());
 * WebDriver_Generic.Driver_wait(driver,10); System.out.println(
 * "Successfully opened the browser"); ScreenShot.GetScreenShot(driver,
 * "MakeMyTrip"); }
 * 
 * @Then("^login with valid userName as 'name' and password as 'pass'$") public
 * void login_with_valid_userName_as_name_and_password_as_pass() throws
 * Throwable {
 * 
 * }
 * 
 * @When("^I see the 'Name' field$") public void i_see_the_Name_field() throws
 * Throwable {
 * 
 * }
 * 
 * @Then("^user have see the home pa$") public void user_have_see_the_home_pa()
 * throws Throwable {
 * 
 * }
 * 
 * 
 * 
 * }
 * 
 * 
 */