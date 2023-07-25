package apipetstore;

import com.google.gson.Gson;
import entities.CategoryEntity;
import entities.PetEntity;
import entities.TagEntity;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.ArrayList;

import static org.hamcrest.core.IsEqual.equalTo;

public class Pet {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    @Test
    public void testCreatePet() {
        Gson gson = new Gson();

        PetEntity pet = new PetEntity();
        pet.category = new CategoryEntity();
        pet.tags = new ArrayList<>();
        pet.photoUrls = new ArrayList<>();

        pet.id = 0;
        pet.name = "doggie";
        pet.status = "available";
        pet.photoUrls.add("www.photos.com.br");
        pet.category.id = 0;
        pet.category.name = "cachorro";

        TagEntity tag = new TagEntity();
        tag.id = 0;
        tag.name = "auaua";
        pet.tags.add(tag);

        String requestBody = gson.toJson(pet);


        Response resp = (Response) RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody).log().all()
            .when()
                .post(BASE_URL + "/pet")
            .then()
                .statusCode(200)
                .body("name", equalTo("doggie")).log().all()
                .body("status", equalTo("available")).log().all()
                .extract()
                ;

        ;
    }
}
