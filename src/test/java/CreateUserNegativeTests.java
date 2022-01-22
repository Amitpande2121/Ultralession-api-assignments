import Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateUserNegativeTests {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeclass(){
        UsersClient UsersClient = new UsersClient();
    }

    @Test
    public void ShouldNotAllowToCreateUserWithInvalidEmail(){
        String body="{\n" +
                "  \"name\": \"Aditi tai rao\",\n" +
                "  \"gender\": \"Female\",\n" +
                "  \"email\": \"Adatirao202.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";
      UsersClient.CreateUser(body).then().log().all()
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
