package apipetstore;

import com.google.gson.Gson;
import entities.StoreEntity;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Store {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/store/order";
    StoreEntity store = new StoreEntity();
    int orderId;
    @Test(priority = 0)
    public void testCreateStore() {
        Gson gson = new Gson();

        store.id = 3;
        store.petId = 9;
        store.quantity = 1;
        store.shipDate = "2023-07-21T17:54:11.207Z";
        store.status = "placed";
        store.complete = true;

        String requestBody = gson.toJson(store);

        Response resp = (Response) given()
                .contentType(ContentType.JSON)
                .body(requestBody).log().all()
            .when()
                .post(BASE_URL )
            .then()
                .log().all()
                .statusCode(200)
                .body("petId", equalTo(9))
                .body("quantity", equalTo(1))
                .body("status", equalTo("placed"))
                .body("complete", equalTo(true))
                .body("id", equalTo(3))
                .extract();
        orderId = resp.jsonPath().getInt("id");
        System.out.println("id extraido: " + orderId);


        }
    @Test(priority = 1)
    public void getStoreOrder(){
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(BASE_URL + "/" + orderId)
        .then()
                .log().all()
                .statusCode(200)
                .body("petId", equalTo(9))
                .body("status", equalTo("placed"))
                .body("complete", equalTo(true))

                ;


    }

    @Test(priority = 2)
    public void deleteStoreOrder(){
        given()
                .contentType("Application/json")
                .log().all()
        .when()
                .delete(BASE_URL + "/" + orderId)
        .then()
                .log().all()
                .statusCode(200)
                ;

    }
}
