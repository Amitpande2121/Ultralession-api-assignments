import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsers {

    @Test
    public void ShouldGetAllUsers() {
        given()
                .when().get("https://gorest.co.in/public/v1/users")

                .then().log().all().statusCode(200)
                .body("data", Matchers.hasSize(20))
                .body("data", Matchers.hasItem(Matchers.hasEntry("gender", "male")));


    }
}