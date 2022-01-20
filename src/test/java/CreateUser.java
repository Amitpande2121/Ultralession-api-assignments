import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {

    @Test
    public void ShouldCreateFemaleUser() {

        String body = "{\n" +
                "  \"name\": \"Aditi tai rao\",\n" +
                "  \"gender\": \"Female\",\n" +
                "  \"email\": \"Adatirao@22.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";
        CreateUser(body)
                .then().log().all().statusCode(201).body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("Adatirao@22.com"));
    }
        @Test
        public void ShouldCreateMaleUser() {

            String body= "{\n" +
                    "  \"name\": \"Amitpande\",\n" +
                    "  \"gender\": \"Male\",\n" +
                    "  \"email\": \"Amitpande@22.com\",\n" +
                    "  \"status\": \"active\"\n" +
                    "}";
            CreateUser(body)
                    .then().log().all().statusCode(201).body("data.id", Matchers.notNullValue())
                    .body("data.email", Matchers.equalTo("Amitpande@22.com"));
        }




    private static Response CreateUser(String bodu) {
        return given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 77970b9d769496fe209c6251a9ca0ada2e88866ca6ece14b99b380154a3998d7")
                .body(bodu)

                .when().post("https://gorest.co.in/public/v1/users");
    }


}
