package examenpractico;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import examenpractico.repositories.RepoApi;



public class PruebasUnitarias {
	
	/* Test para validar el estado de conexion de los 3 endpoints*/
	@Test
	public void estadoConexionEndpoint1() {
		//assertEquals para validar que el tiempo de respuesta sea 200.
		assertEquals(200, RepoApi.connectApi("https://digimon-api.vercel.app/api/digimon"));
	}
	
	@Test
	public void estadoConexionEndpoint2() {
		//assertEquals para validar que el tiempo de respuesta sea 200.
		assertEquals(200, RepoApi.connectApi("https://digimon-api.vercel.app/api/digimon/level/rookie"));
	}
	
	@Test
	public void estadoConexionEndpoint3() {
		//assertEquals para validar que el tiempo de respuesta sea 200.
		assertEquals(200, RepoApi.connectApi("https://digimon-api.vercel.app/api/digimon/name/agumon"));
	}
	
	
	//Este test valida que el nombre que le pases al endpoint 3 es el que devuelve, en este caso Agumon
	@Test
	public void endpoint3response() {
		String digimon = "Agumon";
		
		assertEquals(digimon, RepoApi.readName(digimon).get(0).get("name"));
	}
	
}
