package com.mx.unodostres.certificacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mx.unodostres.certificacion.steps.StepsRest;
import com.mx.unodostres.certificacion.utils.Metodos;

import net.thucydides.core.annotations.Steps;

public class ActualizarUsuarioSteps {

	@Steps
	StepsRest steps = new StepsRest();
	
	@Before
	public void before() {
		steps.requestURL("https://reqres.in/");
		steps.withEndPoint("/api/users/2");
		steps.withMessageInJson();
		steps.withBodyRequest(String.valueOf(Metodos.leerArchivoJson("ActualizacionUsuario")));
		steps.stepsRequestHTTPWithoutHeaders();
	}
	
	@Test
	public void test() {
		steps.putStepsRequest();
	}
	
	@After
	public void after() {
		steps.verifyStatusSuccess(200);
	}
	
}
