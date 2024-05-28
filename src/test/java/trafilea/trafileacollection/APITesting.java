package trafilea.trafileacollection;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.given;

public class APITesting {
	public String APIURL="https://gorest.co.in/public/v1";
	 public String firstUserId ;
	 public String firstUseractiveId;
	 public String updatedName = "New Name";
	 @BeforeSuite
	    public void setup() {
	        RestAssured.baseURI = APIURL;
	 }

	    @Test(priority = 1)
	    public void GetAllUsers() {
	        Response response = given().when().get("/users");
	        AssertJUnit.assertEquals(response.getStatusCode(), 200);
	        
	    }
	    
	    @Test(priority = 2)
	    public void GetTheFirstActiveUser() {
	    	 Response response = given().when().get("/users");
	    	for (int i = 0; i < response.jsonPath().getList("data").size(); i++) {
	            String status = response.jsonPath().getString("data[" + i + "].status");
	            if ("active".equals(status)) {
	                firstUseractiveId = response.jsonPath().getString("data[" + i + "].id");
	                break;
	            }
	        }
	        Response responseactive = given()
	                .pathParam("userId", firstUseractiveId)
	                .when()
	                .get("/users/{userId}");

	        AssertJUnit.assertEquals(responseactive.getStatusCode(), 200);

	        AssertJUnit.assertEquals(responseactive.jsonPath().getString("data.status"), "active");
	    }
	    
	    @Test(priority = 3)
	    public void getthefirstuser(){
	          Response response = given().when().get("/users");
	                firstUserId = response.jsonPath().getString("data[0].id");
	                AssertJUnit.assertEquals(response.getStatusCode(), 200);
	               System.out.println(response.jsonPath().getString("data[0].name"));
	       

	        Response updateUserResponse = given()
	                .header("Authorization", "Bearer 55d6636b25b84832f383665a17f72117ee2b5e655a78ba968912c9a37d1c050f")
	                .pathParam("userId", firstUserId)
	                .body("{\"name\": \"New Name\" , \"email\": \"jana.waters@hotmail.us\", \"status\": \"active\"}")
	                .when()
	                .patch("/users/{userId}");
	        		AssertJUnit.assertEquals(updateUserResponse.getStatusCode(), 200);
	        		//AssertJUnit.assertEquals(updatedName, updateUserResponse.jsonPath().getString("data.name"));
	        }
	    
	        @Test(priority = 4)
	        public void deletafterbatch() {
	        	 Response response = given().when().get("/users");
	        	 firstUserId = response.jsonPath().getString("data[0].id");
	                AssertJUnit.assertEquals(response.getStatusCode(), 200);
	               System.out.println(response.jsonPath().getString("data[0].name"));
	            Response responseFirst = given()
	            .header("Authorization", "Bearer 55d6636b25b84832f383665a17f72117ee2b5e655a78ba968912c9a37d1c050f")
	                .pathParam("userId", firstUserId)
	                .when()
	                .delete("/users/{userId}");
	            System.out.println(response.jsonPath().getString("data[0].name"));
	            AssertJUnit.assertEquals(responseFirst.getStatusCode(), 204);
	            System.out.println(response.jsonPath().getString("data[0].name"));
	        }
	    }