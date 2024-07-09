package practice.datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		//step1:parse Json Physical file into Java Object using JsonParse class
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("D:\\TEKPYRAMID\\OTHER FILES(was there in DESKTOP)\\data\\appCommonData.json"));

		//step2:Convert java object into JsonObject using down casting
		JSONObject map=(JSONObject) obj;

		//step3:get the value from Json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeout"));

		
	}
}