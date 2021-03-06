
public class JsonBody {

    public static String getAddPlaceBody() {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Rahul Shetty Academy\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://rahulshettyacademy.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";
    }

    public static String getUpdatePlaceBody(String placeId) {
        return "{\n" +
                "\"place_id\":\"" + placeId + "\",\n" +
                "\"address\":\"70 Summer walk, INDIA\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";
    }

    public static String getCourseBody() {
        return "{\n" +
                "\n" +
                "\"dashboard\": {\n" +
                "\n" +
                "\"purchaseAmount\": 135,\n" +
                "\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "\"courses\": [\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\n" +
                "\"price\": 50,\n" +
                "\n" +
                "\"copies\": 6\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Cypress\",\n" +
                "\n" +
                "\"price\": 40,\n" +
                "\n" +
                "\"copies\": 4\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"RPA\",\n" +
                "\n" +
                "\"price\": 45,\n" +
                "\n" +
                "\"copies\": 10\n" +
                "\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}";
    }


    public static String AddBookBody(String name,String isbn,String aisle, String author){
        return "{\n" +
                "\n" +
                "\"name\":\""+name+"\",\n" +
                "\"isbn\":\""+name+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\""+author+"\"\n" +
                "}\n" +
                " ";
    }
}
