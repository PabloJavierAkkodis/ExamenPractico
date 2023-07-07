package examenpractico;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import examenpractico.repositories.RepoApi;

public class PruebasBorde {

	
	@Test
	public void estadoConexionEndpoint1() {
		//assertEquals para validar que el tiempo de respuesta sea 200.
		assertTrue(RepoApi.connectApi("https://digimon-api.vercel.app/api/digimon") > 99);
	}

	@Test
	public void estadoConexionEndpoint2() {
		//assertEquals para validar que el tiempo de respuesta sea 200.
		assertTrue(RepoApi.connectApi("https://digimon-api.vercel.app/api/digimon/level/rookie") > 99);
	}
	
	@Test
	public void estadoConexionEndpoint3() {
		//assertEquals para validar que el tiempo de respuesta sea 200.
		assertTrue(RepoApi.connectApi("https://digimon-api.vercel.app/api/digimon/name/agumon") > 99);
	}
	
}
