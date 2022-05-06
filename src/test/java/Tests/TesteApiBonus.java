package Tests;

import Dados.MassaDados;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.nullValue;

public class TesteApiBonus extends MassaDados {

    @BeforeClass
    public static void urlBase() {
        RestAssured.baseURI = urlSite;
        RestAssured.basePath = urlPath;
    }
    @Test
    public void consultaListUser(){
        when().get("/users?page=2")
                .then()
                    .statusCode(200)
                    .body(is(conferenciaBody));

    }

    @Test
    public void updateUser() {
        Response response =
                given().body(dadoUpdate).contentType(ContentType.JSON)
                        .when().patch("/users/2");
                            response.then()
                                    .statusCode(200).log().all()
                                    .body(containsString("Michelle Munhoz Schot"));

    }

}


