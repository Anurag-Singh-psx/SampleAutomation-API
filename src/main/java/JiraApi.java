import getcomment.GetComments;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import pojo.AddComment;
import pojo.AddComment.Visibility;

public class JiraApi {
    public static void main(String[] args) {
        String response;
        int commentId;
        SessionFilter sessionFilter = new SessionFilter();

        System.out.println("--------------------------Login-----------------------------------------");
        baseURI = "http://localhost:8080";
        given().filter(sessionFilter).log().all().relaxedHTTPSValidation().header("Content-Type", "application/json")
                .body(JsonBody.jiraLoginBody()).log().all()
                .when().post("rest/auth/1/session")
                .then().log().all().assertThat().statusCode(200);
        System.out.println("-------------------------------------------------------------------");

        System.out.println("--------------------------Comment-----------------------------------------");
        response = given().filter(sessionFilter).log().all().pathParam("id", "10001").header("Content-Type", "application/json")
                .body(JsonBody.jiraAddComment()).log().all()
                .when().post("rest/api/2/issue/{id}/comment")
                .then().log().all().assertThat().statusCode(201).extract().response().asString();

        ConvertJSON.convertJson(response);
        commentId = ConvertJSON.getInt("id");
        System.out.println("-------------------------------------------------------------------");

        System.out.println("---------------------------Attachments----------------------------------------");
        given().filter(sessionFilter).log().all().pathParam("id", "10001").header("X-Atlassian-Token", "no-check")
                .header("Content-Type", "multipart/form-data")
                .multiPart("key", new File("src//main//java//Sample.txt")).log().all()
                .when().log().all().post("rest/api/2/issue/{id}/attachments")
                .then().log().all().assertThat().statusCode(200);
        System.out.println("-------------------------------------------------------------------");

        System.out.println("-----------------------------Get Comment--------------------------------------");
        response = given().filter(sessionFilter).log().all().pathParam("id", "10001")
                .queryParam("fields", "comment")
                .when().log().all().get("rest/api/2/issue/{id}")
                .then().log().all().statusCode(200).extract().response().asString();
        ConvertJSON.convertJson(response);
        ConvertJSON.compareJira(commentId);
        System.out.println(response);
        System.out.println("-------------------------------------------------------------------");

        System.out.println("-----------------------------Deserialization--------------------------------------");
        GetComments comments=given().filter(sessionFilter).pathParam("id", "10001")
                .queryParam("fields", "comment").expect().defaultParser(Parser.JSON)
                .when().get("rest/api/2/issue/{id}")
                .then().statusCode(200).extract().response().as(GetComments.class);
        System.out.println(comments.getKey());
        System.out.println("----------------------------------------------------------------------------------");

        System.out.println("-----------------------------serialization--------------------------------------");
        AddComment addComment=new AddComment();
        addComment.setBody("Serialization Comment..");
        AddComment.Visibility visibility=addComment.new Visibility();
        visibility.setType("role");
        visibility.setValue("Administrators");

        response = given().filter(sessionFilter).log().all().pathParam("id", "10001").header("Content-Type", "application/json")
                .body(addComment).log().all()
                .when().post("rest/api/2/issue/{id}/comment")
                .then().log().all().assertThat().statusCode(201).extract().response().asString();
        System.out.println(response);
        System.out.println("----------------------------------------------------------------------------------");

    }
}
