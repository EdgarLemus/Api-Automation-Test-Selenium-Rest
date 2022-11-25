package com.mx.unodostres.certificacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mx.unodostres.certificacion.steps.StepsRest;
import com.mx.unodostres.certificacion.utils.Metodos;

import net.thucydides.core.annotations.Steps;

public class LoginUsuarioUnsuccessfulSteps {

	@Steps
	StepsRest steps = new StepsRest();
	
	@Before
	public void before() {
		steps.requestURL("https://reqres.in/");
		steps.withEndPoint("/api/login");
		steps.withMessageInJson();
		steps.withBodyRequest(String.valueOf(Metodos.leerArchivoJson("LoginUnsuccessful")));
		steps.stepsRequestHTTPWithoutHeaders();
	}
	
	@Test
	public void test() {
		steps.postStepsRequest();
	}
	
	@After
	public void after() {
		steps.verifyStatusSuccess(400);
	}
}
