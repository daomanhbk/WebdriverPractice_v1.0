package SeleniumAPI;

import java.io.BufferedReader;
import java.io.FileReader;

import com.google.gson.Gson;

import ObjectPageJson.JsonData;

public class ReadJson {

	public static void main(String[] args) {
		String userPath = System.getProperty("user.dir");
//		System.out.println(userPath);
		String pathFileJson = userPath.concat("/data/").concat("jSonData.json");
		JsonData commonData = getDataJson(pathFileJson);
		System.out.println("Text = " + commonData.getNewCustomer().getAddress());

	}

	public static String readFile(String filename) {
		String result = "";
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
				System.out.println("value " + line);

			}
			result = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public static JsonData getDataJson(String JsonFile) {
		String json = readFile(JsonFile);
		return new Gson().fromJson(json, JsonData.class);
	}

}