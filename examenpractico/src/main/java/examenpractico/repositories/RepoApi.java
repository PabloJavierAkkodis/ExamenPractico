package examenpractico.repositories;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;

public class RepoApi {

	static URL url;

	public static int connectApi(String endpoint) {
		int httpResponseCode = 0;

		try {
			url = new URL(endpoint);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			httpResponseCode = conn.getResponseCode();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return httpResponseCode;

	}

	public static ArrayList<Map<String, String>> readAll() {
		ArrayList<Map<String, String>> allDigimons = new ArrayList<>();

		// hacemos la consulta a la api
		int reponse = connectApi("https://digimon-api.vercel.app/api/digimon");

		if (reponse != 200) {
			throw new RuntimeException("HTTPSResponseCode: " + reponse);
		} else {
			StringBuilder informacion = new StringBuilder();
			Scanner sc;
			try {
				sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					informacion.append(sc.nextLine());
				}

				JSONArray jsonArray = new JSONArray(informacion.toString());
				String name, level;

				// Insertamos un registro en el ArrayList por cada registro obenido
				for (int i = 0; i < jsonArray.length(); i++) {

					allDigimons.add(new HashMap<String, String>());

					name = jsonArray.getJSONObject(i).getString("name");
					level = jsonArray.getJSONObject(i).getString("level");

					allDigimons.get(i).put("name", name);
					allDigimons.get(i).put("level", level);
					
				}
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return allDigimons;

	}
	
	
	
	public static ArrayList<Map<String, String>> readLevel( String levelD ) {
		ArrayList<Map<String, String>> allDigimons = new ArrayList<>();

		// hacemos la consulta a la api
		int reponse = connectApi("https://digimon-api.vercel.app/api/digimon/level/" + levelD);

		if (reponse != 200) {
			throw new RuntimeException("HTTPSResponseCode: " + reponse);
		} else {
			StringBuilder informacion = new StringBuilder();
			Scanner sc;
			try {
				sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					informacion.append(sc.nextLine());
				}

				JSONArray jsonArray = new JSONArray(informacion.toString());
				String name, level;

				// Insertamos un registro en el ArrayList por cada registro obenido
				for (int i = 0; i < jsonArray.length(); i++) {

					allDigimons.add(new HashMap<String, String>());

					name = jsonArray.getJSONObject(i).getString("name");
					level = jsonArray.getJSONObject(i).getString("level");

					allDigimons.get(i).put("name", name);
					allDigimons.get(i).put("level", level);

				}
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return allDigimons;

	}
	
	
	
	public static ArrayList<Map<String, String>> readName(String nameD) {
		ArrayList<Map<String, String>> allDigimons = new ArrayList<>();

		// hacemos la consulta a la api
		int reponse = connectApi("https://digimon-api.vercel.app/api/digimon/name/" + nameD);

		if (reponse != 200) {
			throw new RuntimeException("HTTPSResponseCode: " + reponse);
		} else {
			StringBuilder informacion = new StringBuilder();
			Scanner sc;
			try {
				sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					informacion.append(sc.nextLine());
				}

				JSONArray jsonArray = new JSONArray(informacion.toString());
				String name, level;

				// Insertamos un registro en el ArrayList por cada registro obenido
				for (int i = 0; i < jsonArray.length(); i++) {

					allDigimons.add(new HashMap<String, String>());

					name = jsonArray.getJSONObject(i).getString("name");
					level = jsonArray.getJSONObject(i).getString("level");

					allDigimons.get(i).put("name", name);
					allDigimons.get(i).put("level", level);
					
				}
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return allDigimons;

	}
}
