package com.mx.unodostres.certificacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mx.unodostres.certificacion.steps.StepsRest;

import net.thucydides.core.annotations.Steps;

public class ListaRecursosSteps {

	@Steps
	StepsRest steps = new StepsRest();
	
	@Before
	public void before() {
		steps.requestURL("https://reqres.in/");
		steps.withEndPoint("/api/unknown");
		steps.withMessageInJson();
		steps.stepsRequestHTTPWithoutHeaders();
	}
	
	@Test
	public void test() {
		steps.getStepsRequest();
	}
	
	@After
	public void after() {
		steps.verifyStatusSuccess(200);
	}
}
