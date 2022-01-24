import Users.Create.CreateUserRequestBody;
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
       String name="Aditi tai rao";
       String gender="Female";
       String email="Adatirao202.com";
       String status="active";


        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name(name).gender(gender).email(email).status(status).build();

        UsersClient.CreateUser(requestBody).then().log().all()
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
