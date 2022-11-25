package com.mx.unodostres.certificacion.steps;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;

public class StepsRest {

	private String endPointOrWSDL = "";
	private String contenType = "";
    private String accept = "";
    private String requestConsume = "{}";
    public RequestSpecification requestSpec;
    public Response res = null;
    public Map<String,String> headers = new HashMap<String, String>();
	
    @Step
    public void stepsRequestHTTPWithoutHeaders (){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBasePath(endPointOrWSDL);
        builder.setContentType(contenType);
        builder.setAccept(accept);
        builder.setBody(requestConsume);
        builder.addHeaders(headers);
        requestSpec = builder.build();
        requestSpec = RestAssured.given().spec(requestSpec);
        requestSpec.log().all();
    }
    
	@Step
	public void requestURL(String url) {
		RestAssured.baseURI = url;
	}
	
	@Step
    public void withEndPoint(String endPoint)
    {
        this.endPointOrWSDL = endPoint;
    }
	
	@Step
    public void withHeaders(String key, String value)
    {
        this.headers.put(key, value);
    }
	
	@Step
    public void withMessageInJson() {
        this.contenType = "application/json";
        this.accept = "*/*";
    }
	
	@Step
    public void withHeaderAccept() {
        this.accept = "*/*";
    }
	
	@Step
    public void withHeaderJson() {
        this.contenType = "application/json";        
    }
	
	@Step
    public void withBodyRequest(String requestConsume)
    {
        this.requestConsume = requestConsume;
    }
	
	@Step
    public void postStepsRequest()  {
        res = requestSpec.when().post();
    }

    @Step
    public void getStepsRequest()  {
        res = requestSpec.when().get();
    }

    @Step
    public void deleteStepsRequest()
    {
        res = requestSpec.when().delete();
    }

    @Step
    public void putStepsRequest()
    {
        res = requestSpec.when().put();
    }
    
    @Step
    public void patchStepsRequest()
    {
        res = requestSpec.when().patch();
    }
    
    @Step
    public void verifyStatusSuccess(int status) {
        Assert.assertEquals("The Status Responses Is Not Equal!",status,res.getStatusCode());
    }
 }
