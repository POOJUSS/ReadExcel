package com.ncs.util;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ncs.model.Candidate;
import com.ncs.model.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
import java.io.OutputStream;
  
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ExcelUtilHelper {
	
	public static String prepareJson(final List<Candidate> candidateList) {

		final JSONArray candidateArray = new JSONArray();

		for (Candidate candidate : candidateList) {
			JSONObject json = new JSONObject();
			json.put("firstName", candidate.getFirstName());
			json.put("lastName", candidate.getLastName());
			json.put("country", candidate.getCountry());
			json.put("contactEmail", candidate.getContactEmail());
			json.put("cellPhone", candidate.getCellPhone());
			candidateArray.put(json);
		}

        JSONObject candidates = new JSONObject();
		
		candidates.put("Candidates", candidateArray);
		
		JsonObject jOb = new JsonParser().parse(candidates.toString()).getAsJsonObject();
		
		return prepareResult("Success","200",jOb);
}
	
private static String prepareResult(String message,String statusCcde,JsonObject candidateList) {
		
		Response response = new Response();
		
		return new Gson().toJson(response);
	}
}
/*	public static void createCandidate(String json) throws MalformedURLException, IOException {
	     
		String input = "{\"firstName\": \"Deepak\",\"lastName\": \"Guta\",\"country\": \"SG\",\"cellPhone\": \"99990001\",\"primaryEmail\":\"deepakg1@gmail.com\"}";
		
        URL myurl = new URL("https://apisalesdemo4.successfactors.com/odata/v2/Candidate");
        HttpURLConnection con = (HttpURLConnection)myurl.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
 
        con.setRequestProperty("Content-Type", "application/json;");
        con.setRequestProperty("Accept", "application/json,text/plain");
        con.setRequestProperty("Method", "POST");
        OutputStream os = con.getOutputStream();
        os.write(input.toString().getBytes("UTF-8"));
        os.close();
        StringBuilder sb = new StringBuilder();  
        int HttpResult =con.getResponseCode();
        if(HttpResult ==HttpURLConnection.HTTP_OK){
        BufferedReader br = new BufferedReader(new   InputStreamReader(con.getInputStream(),"utf-8"));  
 
            String line = null;
            while ((line = br.readLine()) != null) {  
            sb.append(line + "\n");  
            }
             br.close(); 
             System.out.println(""+sb.toString());  
 
        }else{
            System.out.println(con.getResponseCode());
            System.out.println(con.getResponseMessage());  
        }  
 
    }
	
	
	
	
}*/
