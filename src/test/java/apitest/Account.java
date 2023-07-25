package apitest;


import com.google.gson.Gson;
import entities.AccountEntity;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Account {

    Gson gson = new Gson();
    String userId;

    @Test
    public void testCreateUser(){


        AccountEntity account = new AccountEntity();
        account.userName = "charlie039";
        account.password = "P@ss0rd1";

        String jsonBody = gson.toJson(account);


        Response resp = (Response) given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .post("https://bookstore.toolsqa.com/Account/v1/User")
        .then()
                .log().all()
                .statusCode(201)
                .body("username", is(account.userName))
                .extract()

        ;

        userId = resp.jsonPath().getString("userID");
        System.out.println("UserID extraido: " + userId);
    }

    public void testGenereteToken(){

    }

}
