package examenpractico;

import examenpractico.repositories.RepoApi;
import examenpractico.utils.FileManager;

public class Main {
	private static FileManager fm = FileManager.getFM();

	public static void main(String[] args) {
		
		init();
	}

	private static void init() {
		StringBuilder sb = new StringBuilder();
		
		String endPoint1 = "---------  MOSTRANDO TODOS LOS DIGIMON (ENDPOINT 1)  --------- \n"  + fm.infoFormatter(RepoApi.readAll());
		String endPoint2 = "---------  MOSTRANDO TODOS LOS DIGIMON NIVEL ROOKIE (ENDPOINT 2)  --------- \n " + fm.infoFormatter(RepoApi.readLevel("rookie"));
		String endPoint3 = "---------  MOSTRANDO DIGIMON CON NOMBRE AGUMON (ENDPOINT 3)  --------- \n" + fm.infoFormatter(RepoApi.readName("agumon"));

		
		
		System.out.println(endPoint1);
		sb.append(endPoint1);
		
		System.out.println(endPoint2);
		sb.append(endPoint2);
		
		System.out.println(endPoint3);
		sb.append(endPoint3);
		
		fm.writeFile(sb.toString());

	}

	

}
