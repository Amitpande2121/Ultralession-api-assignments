import Users.Create.CreateUserRequestBody;
import Users.UsersClient;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateUser {
    private UsersClient UserClient;
    @BeforeClass
    public void BeforeClass(){
        UserClient=new UsersClient();
    }

    @Test
    public void ShouldCreateFemaleUser() {
      String email= String.format("%s@gmail.com", UUID.randomUUID());
      String name="Aditi tai rao";
      String gender="Female";
      String status="active";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);

        UserClient.CreateUser(requestBody)
                .then().log().all().statusCode(201).body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo(email));
    }
        @Test
        public void ShouldCreateMaleUser() {
      String email= String.format("%s@gmail.com", UUID.randomUUID());
      String name="Amitpande";
      String gender="Male";
      String status="active";

            CreateUserRequestBody requestBody = new CreateUserRequestBody(name,gender,email,status);

            UserClient.CreateUser(requestBody)
                    .then().log().all()
                    .statusCode(201).body("data.id", Matchers.notNullValue())
                    .body("data.email", Matchers.equalTo(email));
        }
    }

