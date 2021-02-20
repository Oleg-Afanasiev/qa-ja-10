package com.academy.api.rest;

import com.academy.telesens.lesson06.inheritance.Subscriber;
import com.academy.telesens.lesson07.enumeration.Gender;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class SubscriberRestApiTests {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://localhost/rest/json";
        RestAssured.port = 8081;
    }

    @Test
    public void testGetOneSubscriber() {
        Response response = given()
                .get("/subscribers/{id}", 1);

        String body = response.getBody().print();
        int code = response.getStatusCode();
        int id = response.getBody().path("id" );
        String firstName = response.getBody().path("firstName");
        String lastName = response.getBody().path("lastName");

        System.out.println("Body: " + body);

        System.out.println(String.format("code: %s, id: %d, firstName: %s, lastName: %s",
                code, id, firstName, lastName));
    }

    @Test
    public void testGetSubscribers() {
        Response response = given()
                .log().all()
                .get("/subscribers");

        int code = response.getStatusCode();
        String body = response.getBody().print();
        int size = response.getBody().path("size()");
        int id = response.getBody().path("[%s].id", "0");
        String fName = response.getBody().path("[%s].firstName", "0");
        String lastName = response.getBody().path("[%s].lastName", "0");

        System.out.println(code);
        System.out.println(body);
    }

    @Test
    public void testGetAllSubscribers() {
        given()
                .log().all()
                .when()
                .get("/subscribers")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("size()", greaterThanOrEqualTo(1))
                .and()
                .body("[0].id", equalTo(1))
                .and()
                .body("[0].firstName", equalTo("Peter"));


    }

    @Test(dataProvider = "subscriberProvider")
    public void testAddSubscriber(Subscriber subscriber) {
        //  1 шаг - получить тестового абонента (dataProvider)
        // if exists => delete
        if (getSubscriberById(subscriber.getId()) != null) {
            deleteSubscriber(subscriber.getId());
        }

        List<Subscriber> before = getAllSubscribers();

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", subscriber.getId());
        jsonObj.put("firstName", subscriber.getFirstName());
        jsonObj.put("lastName", subscriber.getLastName());
        jsonObj.put("age", subscriber.getAge());
        jsonObj.put("gender", subscriber.getGender().toValue());

        given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(jsonObj.toJSONString())
                .post("/subscribers")
                .then()
                .assertThat()
                .header("Location", containsString("http://localhost:8081/rest/json/subscribers"))
                .statusCode(201);

//        List<Subscriber> after = getAllSubscribers();
//        after.equals(before + 1);
        // отсортировать списки по id
        // assert (переопределить метод equals для Subscriber
    }

    @Test
    public void testUpdateSubscriber() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", 6667);
        jsonObj.put("firstName", "Ivan_upd"); // Cast
        jsonObj.put("lastName", "Ivanov_upd");
        jsonObj.put("age", 68);
        jsonObj.put("gender", "m");

        given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(jsonObj.toJSONString())
                .put("/subscribers/6667")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testDeleteSubscriber() {
        given()
                .log().all()
                .delete("/subscribers/6667")
                .then()
                .assertThat()
                .statusCode(200);
    }

    private List<Subscriber> getAllSubscribers() {
        return new ArrayList<>();
    }

    private Subscriber getSubscriberById(int id) {
        Response response = given().get("/subscribers/{id}", id);
        if (response.getStatusCode() != 200) {
            return null;
        }

        Subscriber subscriber = new Subscriber();
        subscriber.setFirstName("");
        subscriber.setGender(Gender.parse("f"));
        return subscriber;
    }

    private int deleteSubscriber(int id) {
        int code = 200;
        return code;
    }

    @DataProvider(name="subscriberProvider")
    public Object[][] subscriberProvider() {
        Subscriber subscriber = new Subscriber();
        subscriber.setId(10);
        subscriber.setFirstName("Петр");
        subscriber.setLastName("Петров");
        subscriber.setGender(Gender.MALE);
        subscriber.setAge(25);

        return new Object[][] {
                {subscriber}
        };
    }
}
