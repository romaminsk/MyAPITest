import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APODTest {

    private String URL = "https://api.nasa.gov/planetary/";

    @Test
    public void checkMediaTypeIsImage() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "apod?api_key=YcxLwjGaFVxYegEk963AY1HtiDewWK7poVPllKKp&date=2022-07-04")
                .then().log().all()
                .assertThat().statusCode(200)
                .and().body("media_type", Matchers.is("image"));
    }
}
