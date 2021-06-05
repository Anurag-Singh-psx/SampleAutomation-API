import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class JiraApi {
    public static void main(String[] args) {
        String response;
        int commentId;
        SessionFilter sessionFilter=new SessionFilter();

        System.out.println("--------------------------Login-----------------------------------------");
        baseURI="http://localhost:8080";
        given().filter(sessionFilter).log().all().header("Content-Type","application/json")
                .body(JsonBody.jiraLoginBody()).log().all()
                .when().post("rest/auth/1/session")
                .then().log().all().assertThat().statusCode(200);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--------------------------Comment-----------------------------------------");
        response=given().filter(sessionFilter).log().all().pathParam("id","10001").header("Content-Type","application/json")
                .body(JsonBody.jiraAddComment()).log().all()
                .when().post("rest/api/2/issue/{id}/comment")
                .then().log().all().assertThat().statusCode(201).extract().response().asString();

        ConvertJSON.convertJson(response);
        commentId=ConvertJSON.getInt("id");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("---------------------------Attachments----------------------------------------");
        given().filter(sessionFilter).log().all().pathParam("id","10001").header("X-Atlassian-Token","no-check")
                .header("Content-Type","multipart/form-data")
                .multiPart("key",new File("src//main//java//Sample.txt")).log().all()
                .when().log().all().post("rest/api/2/issue/{id}/attachments")
                .then().log().all().assertThat().statusCode(200);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("-----------------------------Get Comment--------------------------------------");
        response= given().filter(sessionFilter).log().all().pathParam("id","10001")
               .queryParam("fields","comment")
                .when().log().all().get("rest/api/2/issue/{id}")
                .then().log().all().statusCode(200).extract().response().asString();
        System.out.println("-------------------------------------------------------------------");
       ConvertJSON.convertJson(response);
       ConvertJSON.compareJira(commentId);
       System.out.println(response);
    }
}
