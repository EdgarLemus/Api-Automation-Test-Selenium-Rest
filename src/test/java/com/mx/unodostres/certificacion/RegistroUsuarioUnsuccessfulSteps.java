package com.mx.unodostres.certificacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mx.unodostres.certificacion.steps.StepsRest;
import com.mx.unodostres.certificacion.utils.Metodos;

import net.thucydides.core.annotations.Steps;

public class RegistroUsuarioUnsuccessfulSteps {

	@Steps
	StepsRest steps = new StepsRest();
	
	@Before
	public void before() {
		steps.requestURL("https://reqres.in/");
		steps.withEndPoint("/api/register");
		steps.withMessageInJson();
		steps.withBodyRequest(String.valueOf(Metodos.leerArchivoJson("RegistroUnsuccessful")));
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
