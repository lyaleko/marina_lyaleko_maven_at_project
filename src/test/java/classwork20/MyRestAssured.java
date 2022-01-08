package classwork20;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class MyRestAssured {
    public static void main(String[] args) {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.icndb.com")
                //.setPort(8080)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        String result = RestAssured
                .given()
                .spec(requestSpec)
                //.body
                .when()
                .get("jokes/random?firstName=John&lastName=Doe")
                .then()
                .extract().body().asPrettyString();

        System.out.println(result);

    }
}