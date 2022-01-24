package Users;

import Users.Create.CreateUserRequestBody;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {


    public static Response CreateUser(CreateUserRequestBody bodu) {
        return given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 77970b9d769496fe209c6251a9ca0ada2e88866ca6ece14b99b380154a3998d7")
                .body(bodu)

                .when().post("https://gorest.co.in/public/v1/users");
    }

    public Response GetAllUsers() {
        return given()
                .when().get("https://gorest.co.in/public/v1/users");
    }
}


