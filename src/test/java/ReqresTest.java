import org.example.RegisterUserData;
import org.example.Specifications;
import org.example.SuccessUserRegistrationData;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqresTest {

    private String URL = "https://reqres.in/";

    @Test
    public void isUserRegistered() {

        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());

        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        RegisterUserData userData = new RegisterUserData("eve.holt@reqres.in", "pistol");
        SuccessUserRegistrationData successUser =
                given()
                        .body(userData)
                        .when()
                        .post("/api/register")
                        .then().log().all()
                        .extract().as(SuccessUserRegistrationData.class);

        Assert.assertEquals(id, successUser.getId());
        Assert.assertEquals(token, successUser.getToken());
    }
}
