package src.main.java.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONParser {

	public static void main(String[] args) {

		
		JSONParser jParser = new JSONParser();
		
		jParser.parser();
	}
	
	private void parser(){
		
		
		String value = "{\'level1\':{\'volumes\': {\'status\': \'available\',\'managed\': true,\'name\': \'va_85621143-1133-412f-83b4-57a01a552638_\',\'support\': {\'status\': \'supported\'},\'mapped_wwpns\': [\'2101001B32BD4280\',\'2100001B329D4280\',\'2101001B32BD637E\', \'2100001B329D637E\'],\'storage_pool\': \'pfm9253_pfm9254_new\', \'id\': \'afb8e294-6188-4907-9f6f-963c7623cecb\',\'size\': 9  }}}";
		JsonParser parser = new JsonParser();
		JsonObject json = (JsonObject)parser.parse(value);
		
		JsonObject volumne = json.getAsJsonObject().getAsJsonObject("level1").getAsJsonObject("volumes");
        //JsonArray volumes = json.getAsJsonObject().getAsJsonArray("volumes");
       // System.out.println("volumes-->"+ voulumes);
        JsonElement status = volumne.getAsJsonObject().get("status");//JSONObject(0);
       // JsonObject geometry = result1.getAsJsonObject().getJSONObject("geometry");
   //     JsonObject locat = geometry.getJSONObject('location');
        System.out.println("status-->"+ status);
        
        JsonArray support = volumne.getAsJsonObject().getAsJsonArray("mapped_wwpns");
       // JsonElement innerStatus = support.get(0).getAsJsonObject().get("status");
        System.out.println("mapped_wwpns-->" +support);
        
        //----------------------parse string value 1----------------------
        String value1 ="{\'level1\':{ \'volumes\': [{\'status\': \'available\', \'managed\': true,\'name\': \'va_85621143-1133-412f-83b4-57a01a552638_\', \'support\': { \'status\': \'supported\' }, \'mapped_wwpns\': [\'12345\',\'777777\',\'99999\', \'888888888888888888\'],\'storage_pool\': \'pfm9253_pfm9254_new\', \'id\': \'afb8e294-6188-4907-9f6f-963c7623cecb\', \'size\': 9 },{\'status\': \'not-available\', \'managed\': false,\'name\': \'bt_newd20\', \'support\': { \'status\': \'not-supported\' },\'mapped_wwpns\': [\'2222222222\',\'33333333333\',\'4444444444\', \'5555555555\'], \'storage_pool\': \'kvm\', \'id\': \'afb8e294-6188-4907-9f6f-963c7623cecb\', \'size\': 15 } ]}}";
		
        json = (JsonObject)parser.parse(value1);
		
		//JsonObject volumne1 = json.getAsJsonObject().getAsJsonObject("level1").getAsJsonObject("volumes");
        JsonArray volumes1 = json.getAsJsonObject().getAsJsonObject("level1").getAsJsonArray("volumes");
       // System.out.println("volumes-->"+ voulumes);
        JsonElement status1 = volumes1.get(0).getAsJsonObject().get("status");//JSONObject(0);
        JsonElement status2 = volumes1.get(1).getAsJsonObject().get("status");//JSONObject(0);
       // JsonObject geometry = result1.getAsJsonObject().getJSONObject("geometry");
   //     JsonObject locat = geometry.getJSONObject('location');
        System.out.println("status1-->"+ status1);
        System.out.println("status2-->"+ status2);
        
        JsonArray mapped_wwpns = volumes1.get(0).getAsJsonObject().getAsJsonArray("mapped_wwpns");
       // JsonElement innerStatus = support.get(0).getAsJsonObject().get("status");
        System.out.println("mapped_wwpns1-->" +mapped_wwpns);
        
	}

}
