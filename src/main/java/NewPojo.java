import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class NewPojo {
    public static void main(String[] args) {
        baseURI="http://216.10.245.166/";
        String response=given().log().all().header("Content-Type","application/json")
                .body(JsonBody.AddBookBody("Love Story","LS1","LS","Anurag Singh"))
                .when().post("Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
        ConvertJSON.convertJson(response);
        String bookID=ConvertJSON.getString("ID");
        Assert.assertEquals(ConvertJSON.getString("Msg"),"successfully added");
    }
}
