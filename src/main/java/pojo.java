import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class pojo {

    public static void main(String[] args) {
        //Three Principle Given, When, Then

        System.out.println("---------------ADD PLACE-----------------------");
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String addPlaceResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").
                body(JsonBody.getAddPlaceBody()).
                when().post("maps/api/place/add/json").
                then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).
                header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
        ConvertJSON.convertJson(addPlaceResponse);
        String placeId = ConvertJSON.getString("place_id");

        System.out.println("---------------UPDATE PLACE-----------------------");
        String updatePlaceResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").
                body(JsonBody.getUpdatePlaceBody(placeId)).
                when().put("maps/api/place/update/json").
                then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated")).
                header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
        ConvertJSON.convertJson(updatePlaceResponse);
        Assert.assertEquals("Address successfully updated", ConvertJSON.getString("msg"));

        System.out.println("---------------VERIFY UPDATE PLACE-----------------------");
        String getPlaceResponse = given().queryParam("key", "qaclick123").queryParam("place_id", placeId).
                when().get("maps/api/place/get/json").
                then().log().all().assertThat().statusCode(200).body("address", equalTo("70 Summer walk, INDIA")).
                extract().response().asString();
        ConvertJSON.convertJson(getPlaceResponse);
        Assert.assertEquals("70 Summer walk, INDIA", ConvertJSON.getString("address"));

        System.out.println("---------------COMPLEX JSON-----------------------");
        ConvertJSON.convertJson(JsonBody.getCourseBody());
        ConvertJSON.getComplex();


    }
}
