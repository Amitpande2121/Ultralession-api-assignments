import Users.UsersClient;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsers {
    private UsersClient usersClient;
    @BeforeClass
    public void BeforeClass(){
        usersClient=new UsersClient();
    }

    @Test
    public void ShouldGetAllUsers() {

        new UsersClient().GetAllUsers()

                .then().log().all().statusCode(200)
                .body("data", Matchers.hasSize(20))
                .body("data", Matchers.hasItem(Matchers.hasEntry("gender", "male")));
    }

    }
