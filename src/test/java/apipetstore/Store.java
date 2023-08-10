package apipetstore;

import com.google.gson.Gson;
import entities.StoreEntity;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Store {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/store/order";
    StoreEntity store = new StoreEntity();
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
                .body("shipDate", equalTo("2023-07-21T17:54:11.207+0000"))
                .body("status", equalTo("placed"))
                .body("complete", equalTo(true))
                .extract()
                ;

        }
    @Test(priority = 1)
    public void getStoreOrder(){
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(BASE_URL +"/" + store.petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("petId", equalTo(3))
                .body("status", equalTo("placed"))
                .body("complete", equalTo(false))
                ;

    }
}
