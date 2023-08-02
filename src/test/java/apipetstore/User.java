package apipetstore;

import com.google.gson.Gson;
import entities.UserEntity;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class User {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/user/";

    @Test(priority = 0)
    public void testCreateUser() {
        Gson gson = new Gson();
        
        //UserEntity user = new UserEntity();
        //user.id = 0;
        //user.username = "charlie036";
        //user.firstName = "Charlie";
        //user.lastName = "Brown";
        //user.email = "charlie@brown.com.br";
        //user.password = "123456";
        //user.phone = "1122223333";
        //user.userStatus = 0;

        //String requestBody = gson.toJson(user);

        String requestBody = "[\n" +
                "  {\n" +
                "    \"id\": 0,\n" +
                "    \"username\": \"Fernanda00124\",\n" +
                "    \"firstName\": \"Fernanda\",\n" +
                "    \"lastName\": \"teste\",\n" +
                "    \"email\": \"fernanda@teste.com\",\n" +
                "    \"password\": \"123456@\",\n" +
                "    \"phone\": \"2222-2222\",\n" +
                "    \"userStatus\": 0\n" +
                "  }\n" +
                "]";

        Response resp = (Response) given()
                .contentType(ContentType.JSON)
                .body(requestBody).log().all()
                .when()
                .post(BASE_URL + "createWithArray")
                .then()
                .statusCode(200).log().all()
                .body("code", equalTo(200)).log().all()
                .body("type", equalTo("unknown")).log().all()
                .body("message", equalTo("ok")).log().all()
                .extract()
                ;

    }
    @Test(priority = 1)
    public void getUser(){
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(BASE_URL + "Fernanda00124")
        .then()
                .log().all()
                .statusCode(200)
                .body("username", is("Fernanda00124"))
                .body("firstName", is("Fernanda"))
                .body("lastName", is("teste"))
                .body("email", is("fernanda@teste.com"))
                .body("password", is("123456@"))
                .body("phone", is("2222-2222"))
                ;

    }
}
