package apipetstore;

import com.google.gson.Gson;
import entities.CategoryEntity;
import entities.PetEntity;
import entities.StoreEntity;
import entities.TagEntity;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.hamcrest.core.IsEqual.equalTo;

public class Store {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    @Test
    public void testCreateStore() {
        Gson gson = new Gson();

        StoreEntity store = new StoreEntity();
        store.id = 0;
        store.petId = 0;
        store.quantity = 1;
        store.shipDate = "2023-07-21T17:54:11.207Z";
        store.status = "placed";
        store.complete = true;


        String requestBody = gson.toJson(store);


        Response resp = (Response) RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody).log().all()
            .when()
                .post(BASE_URL + "/store/order")
            .then()
                .statusCode(200)
                .body("petId", equalTo(0)).log().all()
                .body("quantity", equalTo(1)).log().all()
                .body("shipDate", equalTo("2023-07-21T17:54:11.207+0000")).log().all()
                .body("status", equalTo("placed")).log().all()
                .body("complete", equalTo(true)).log().all()
                .extract()
                ;

        ;
    }
}
