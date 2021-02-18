package com.academy.telesens.lesson20;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class RestSamples {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost/rest/json";
        RestAssured.port = 8081;
//        RestAssured.config().set().

//        getOneSubscriberDemo();
//        getAllSubscribersDemo();
//        addSubscriberDemo();
//        updateSubscriberDemo();
        deleteSubscriberDemo();
    }

    private static void deleteSubscriberDemo() {
        System.out.println("***deleteSubscriberDemo***");
        Response response = given()
                .delete("/subscribers/6668");
        int code = response.getStatusCode();
        System.out.println(code);
    }

    private static void updateSubscriberDemo() {
        System.out.println("***updateSubscriberDemo***");
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", 10);
        jsonObj.put("firstName", "Ivan_upd"); // Cast
        jsonObj.put("lastName", "Ivanov_upd");
        jsonObj.put("age", 68);
        jsonObj.put("gender", "m");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(jsonObj.toJSONString())
                .put("/subscribers/10");

        int code = response.getStatusCode();

        System.out.println(code);
    }

    private static void addSubscriberDemo() {
        System.out.println("***addSubscriberDemo***");
        String json = generateSubscriberJson();

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json)
                .post("subscribers");

        int code = response.getStatusCode();
        String location = response.getHeader("Location");

        System.out.println(code);
        System.out.println(location);
    }

    private static void getAllSubscribersDemo() {
        System.out.println("***getAllSubscribersDemo***");
        Response response = RestAssured.given()
                .get("subscribers");

        int code = response.getStatusCode();
        ResponseBody body = response.getBody();
        String json = body.print();
        int size = body.path("size()");
        int id = body.path("[%s].id", "0");
        String firstName = body.path("[%s].firstName", "0");

        System.out.println("code: " + code);
        System.out.println("json: " + json);
        System.out.println("size: " + size);
        System.out.println("id: " + id);
        System.out.println("firstName: " + firstName);
    }

    private static void getOneSubscriberDemo() {
        System.out.println("***getOneSubscriberDemo***");
        Response response = RestAssured.given()
                .get("subscribers/1");

        int code = response.getStatusCode();
        ResponseBody body = response.getBody();
        String json = body.print();
        System.out.println(code);
        System.out.println(json);

        int id = body.path("id");
        String firstName = body.path("firstName");

        System.out.println(id);
        System.out.println(firstName);
    }

    private static String generateSubscriberJson() {
        JSONObject json = new JSONObject();
//        json.put("id", 10);
        json.put("firstName", "test2");
        json.put("lastName", "test2");
        json.put("age", 27);
        json.put("gender", "m");

        return json.toJSONString();
    }
}
