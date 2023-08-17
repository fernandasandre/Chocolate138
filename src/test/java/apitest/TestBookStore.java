package apitest;

import com.google.gson.Gson;
import entities.LoanEntity;
import org.testng.annotations.*;
import org.testng.ITestContext;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInRelativeOrder;
import static org.hamcrest.Matchers.is;

public class TestBookStore {

    String uri = "https://bookstore.toolsqa.com/BookStore/v1/";
    String ct = "application/json";
    TestAccount account = new TestAccount();
    LoanEntity isbn = new LoanEntity();
    Gson gson = new Gson();

    @BeforeClass
    public void setUP(ITestContext context){
        account.testCreateUser(context);
        account.testGenerateToken(context);
    }

    @AfterClass
    public void tearDown(){
        account.testDeleteUser();
    }

    @Test(priority = 1)
    public void testResearchBooks(ITestContext context){
        given()
                .contentType(ct)
                .log().all()
                .header("Authorization", "Bearer " + context.getAttribute("token"))
        .when()
                .get(uri + "Books")
        .then()
                .log().all()
                .statusCode(200)
                ;
    }
    @Test(priority = 2)
    public void testLoanBooks(ITestContext context){
        isbn.userId = context.getAttribute("userID").toString();
        isbn.collectionOfIsbns = new LoanEntity.ISBN[]{
                new LoanEntity.ISBN("9781449325862")
        };
        //isbn.isbn = "9781449325862";

        given()
                .log().all()
                .contentType(ct)
                .header("Authorization", "Bearer "+ context.getAttribute("token"))
                .body(gson.toJson(isbn))
        .when()
                .post(uri + "Books")
        .then()
                .log().all()
                .statusCode(201)
                .body("isbn", is(isbn.isbn))
                ;

    }

    @Test(priority = 3)
    public void testUpdateLoan(ITestContext context){
        String isbnOld = "9781449325862";
        String isbnNew = "9781449331818";
        isbn = new LoanEntity();
        isbn.userId = context.getAttribute("userID").toString();
        isbn.isbn = isbnNew;

        given()
                .log().all()
                .contentType(ct)
                .header("Authorization", "Bearer "+ context.getAttribute("token"))
                .body(gson.toJson(isbn))
        .when()
                .put(uri + "Books/" + isbnOld)
        .then()
                .log().all()
                .statusCode(200)
                .body("books[0].isbn", is(isbnNew))
                ;
    }

}
