package apitest;
import com.google.gson.Gson;
import entities.AccountEntity;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Account {

    Gson gson = new Gson();
    String userId;
    String ct = "application/json";
    String jsonBody;
    String uri = "https://bookstore.toolsqa.com/Account/v1/";
    Response resp;
    static String token;
    AccountEntity account = new AccountEntity();
    @Test(priority = 1)
    public void testCreateUser(){

        account.userName = "charlie0053";
        account.password = "P@ss0rd1";

        jsonBody = gson.toJson(account);

        resp = (Response) given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "User")
        .then()
                .log().all()
                .statusCode(201)
                .body("username", is(account.userName))
                .extract()

        ;

        userId = resp.jsonPath().getString("userID");
        System.out.println("UserID extraido: " + userId);
    }

    @Test(priority = 2)
    public void testGenereteToken(){

        resp = (Response) given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "GenerateToken")
        .then()
                .log().all()
                . statusCode(200)
                .body("status", is("Success"))
                .body("result", is("User authorized successfully."))
        .extract()
        ;

        token = resp.jsonPath().getString("token");
        System.out.println("O token: "+ token);

        Assert.assertTrue(token.length()!= 0);

    }

    @Test(priority = 3)
    public void testAuthorized(){
        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri +"Authorized")
        .then()
                .log().all()
                .statusCode(200)
                ;
    }

    @Test(priority = 4)
    public void testResearchUserNotAuthorized(){
        given()
                .contentType(ct)
                .log().all()
        .when()
                .get(uri + "User/" + userId)
        .then()
                .log().all()
                .statusCode(401)
                .body("code", is("1200"))
                .body("message", is("User not authorized!"))
                ;
    }
    @Test(priority = 5)
    public void testResearchUser(){
        given()
                .contentType(ct)
                .log().all()
                .header("Authorization", "Bearer " + token)
        .when()
                .get(uri + "User/" + userId)
        .then()
                .log().all()
                .statusCode(200)
                .body("username", is(account.userName))
                .body("userId", is(userId))
        ;
    }

    @Test(priority = 6)
    public void testDeleteUser(){
        given()
                .contentType(ct)
                .log().all()
                .header("Authorization", "Bearer " + token)
        .when()
                .delete(uri + "User/" + userId)
        .then()
                .log().all()
                .statusCode(204)
        ;

    }

}
