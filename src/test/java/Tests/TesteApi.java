package Tests;

import Dados.MassaDados;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TesteApi extends MassaDados {

    @BeforeClass
    public static void urlBase() {
        RestAssured.baseURI = urlSite;
        RestAssured.basePath = urlPath;
    }

    @Test
    public void cadastroUser() {
            Response response =
            given().body(dadoCadastro).contentType(ContentType.JSON)
            .when().post("/users");
            response.then().statusCode(201);


        }

    @Test
    public void consultaUser(){
            when().get("/users/2")
                .then()
                    .statusCode(200)
                    .body(containsString("Janet"))
                    .body(is(not(nullValue())))
                    .log().all();

    }

}
