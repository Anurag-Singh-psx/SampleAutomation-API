import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class ConvertJSON {
    private static JsonPath jsonPath;
    public static void convertJson(String response){
        jsonPath=new JsonPath(response);
    }

    public static String getString(String value){
        return jsonPath.getString(value);
    }

    public static void getComplex(){
        System.out.println(jsonPath.getInt("courses.size()"));
        System.out.println(jsonPath.getInt("dashboard.purchaseAmount"));
        System.out.println(jsonPath.getString("courses.title"));
        int totalPrice=0;
        for (int i=0;i< jsonPath.getInt("courses.size()");i++){
            System.out.println(jsonPath.get("courses["+i+"].price").toString());
            totalPrice=totalPrice+jsonPath.getInt("courses["+i+"].price");
        }

        System.out.println(totalPrice);
        Assert.assertEquals(jsonPath.getInt("dashboard.purchaseAmount"),totalPrice);
    }
}
