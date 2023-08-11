package apitest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import static io.restassured.RestAssured.given;

public class BookStore {

    String uri = "https://bookstore.toolsqa.com/BookStore/v1/";
    String ct = "application/json";
    Account account = new Account();

    @BeforeMethod
    public void setUP(ITestContext context){
        account.testCreateUser();
        account.testGenerateToken(context);
    }

    @AfterMethod
    public void tearDown(){
        account.testDeleteUser();
    }

    @Test(priority = 1)
    public void testResearchBooks(ITestContext context){
        given()
                .contentType(ct)
                .log().all()
                .header("Authentication", "Bearer " + context.getAttribute("token"))
        .when()
                .get(uri + "Books")
        .then()
                .log().all()
                .statusCode(200)
                ;
    }

}
