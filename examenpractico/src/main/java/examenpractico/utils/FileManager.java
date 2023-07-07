package examenpractico.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class FileManager {

	private static FileManager instance;

	private FileManager() {
		super();
	}
	
	public static FileManager getFM(){
		if(instance == null) {
			return new FileManager();
		} else {
			return instance;
		}
	}
	
	
	public String infoFormatter(ArrayList<Map<String, String>> allDigimons) {
		StringBuilder sb = new StringBuilder();
		
		for(Map<String, String> digimon : allDigimons) {
				
				sb.append("\n *");
				sb.append("\n Name:  " + digimon.get("name") +
						"\n Level: " + digimon.get("level"));

		}
		sb.append("\n *\n");


		return sb.toString();
	}
	
	public void writeFile(String digimons){
		
		try {
			//Declarar la ruta y el nombre de archivo con la extension del mismo
			String ruta = ".\\información_final.txt";
			//Inicializo la clase File que me permite crear el archivo.
			File archivo = new File(ruta);
			if(! archivo.exists())
			{
			archivo.createNewFile(); //utilizo el metodo createNewFile() para crear el archivo.
			System.out.println("Se ha generado el archivo.");	
			}
			
			FileWriter fw = new FileWriter(archivo); //El FileWriter es el encargado de habilitar la opción de escritura
			BufferedWriter bw = new BufferedWriter(fw); //BufferedWritter es el encargado de realizar la acción de escritura.
			
			
			bw.write(digimons);
			
			
			bw.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	
}
