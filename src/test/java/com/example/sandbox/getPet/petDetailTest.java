package com.example.sandbox.getPet;

import java.util.Map;
import java.util.TreeMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.sandbox.Common;
import static com.example.sandbox.util.constans.Tags.SMOKE;

import io.restassured.response.Response;

public class petDetailTest extends Common {

    /*@Test(enabled = true,groups = {SMOKE},description ="description")
    public void Test1(){
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status","sold");

        Response  response = getUrl(findByStatus, queryParams);
        Assert.assertEquals(response.getStatusCode(),200,"0Invalid response code");

        String id = response.jsonPath().get("[0].id").toString();

        Response  response2 = getUrl(petById+id);
        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code");
    }*/

    @Test(enabled = true,groups = {SMOKE},description ="For a user the logout is successful.")
    public void TestLoginInValidUserUnSuccessful(){
        Response  response = getUrl(logout);
        Integer statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        System.err.println("StatusCode:" + statusCode.toString());


//        String id = response.jsonPath().get("[0].id").toString();

        /*Response  response2 = getUrl(petById+id);
        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code");*/
    }
    
    @Test(enabled = true,groups = {SMOKE},description ="For a valid user the given password is not correct.")
    public void TestLoginValidUserUnSuccessful(){
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("username","epteers");
        queryParams.put("password", "epteers0");

        Response  response = getUrl(login,queryParams);
        Integer statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,401);
        System.err.println("StatusCode:" + statusCode.toString());


//        String id = response.jsonPath().get("[0].id").toString();

        /*Response  response2 = getUrl(petById+id);
        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code");*/
    }
}
