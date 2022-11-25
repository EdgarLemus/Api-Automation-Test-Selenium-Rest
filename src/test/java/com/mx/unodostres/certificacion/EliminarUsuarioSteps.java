package com.mx.unodostres.certificacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mx.unodostres.certificacion.steps.StepsRest;

import net.thucydides.core.annotations.Steps;

public class EliminarUsuarioSteps {

	@Steps
	StepsRest steps = new StepsRest();
	
	@Before
	public void before() {
		steps.requestURL("https://reqres.in/");
		steps.withEndPoint("/api/users/2");
		steps.withMessageInJson();
		steps.stepsRequestHTTPWithoutHeaders();
	}
	
	@Test
	public void test() {
		steps.deleteStepsRequest();
	}
	
	@After
	public void after() {
		steps.verifyStatusSuccess(204);
	}
}
