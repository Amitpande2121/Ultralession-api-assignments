import Users.UsersClient;
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
                "  \"email\": \"Adatirao@25.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";
       new UsersClient().CreateUser(body)
                .then().log().all().statusCode(201).body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("Adatirao@25.com"));
    }
        @Test
        public void ShouldCreateMaleUser() {

            String body= "{\n" +
                    "  \"name\": \"Amitpande\",\n" +
                    "  \"gender\": \"Male\",\n" +
                    "  \"email\": \"Amitpande@25.com\",\n" +
                    "  \"status\": \"active\"\n" +
                    "}";
          new UsersClient().CreateUser(body)
                    .then().log().all().statusCode(201).body("data.id", Matchers.notNullValue())
                    .body("data.email", Matchers.equalTo("Amitpande@25.com"));
        }
    }

