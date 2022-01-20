import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTests {

    @Test
    public void ShouldGetAllUsers() {
        given()
                .when().get("https://gorest.co.in/public/v1/users")

                .then().log().all().statusCode(200);


    }


    @Test
    public void ShouldCreateUser() {

        given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer 77970b9d769496fe209c6251a9ca0ada2e88866ca6ece14b99b380154a3998d7")
                .body("{\"name\":\"Tenali Ramakrishna\", \"gender\":\"male\", \"email\":\"tenali.ramakrishna@206.com\", \"status\":\"active\"}")

                .when().post("https://gorest.co.in/public/v1/users")
                .then().log().all().statusCode(201).body("data.id", Matchers.notNullValue())
                .body("data.email",Matchers.equalTo("tenali.ramakrishna@206.com"));


    }
}
