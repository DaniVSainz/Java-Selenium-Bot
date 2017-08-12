package botFarm;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
 
public class HttpURLConnectionExample {
 
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36";
 
//    public void post(String url, String params) throws Exception {
//    String result = null;
// 
//    URL obj = new URL(url);
//    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
// 
//    con.setRequestMethod("POST");
//    con.setRequestProperty("User-Agent", USER_AGENT);
// 
//    con.setDoOutput(true);
//    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//    wr.writeBytes(params);
//    wr.flush();
//    wr.close();
// 
//    int responseCode = con.getResponseCode();
//    System.out.println("'POST' request to URL : " + url);
//    System.out.println("Response Code : " + responseCode);
// 
//    System.out.println("Response Body : ");
//    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//    String inputLine;
//    StringBuffer response = new StringBuffer();
// 
//    while ((inputLine = in.readLine()) != null) {
//        response.append(inputLine);
//    }
//    in.close();
// 
//    result = response.toString();
//    System.out.println(result);
// 
//    }
 
    public void get(String url) throws Exception {
    String result = null;
 
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
    con.setRequestMethod("GET");
 
    con.setRequestProperty("User-Agent", USER_AGENT);
 
    int responseCode = con.getResponseCode();
//    System.out.println("'GET' request to URL : " + url);
//    System.out.println("Response Code : " + responseCode);
// 
//    System.out.println("Response Body : ");
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();
 
    while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }
    in.close();
 
    result = response.toString();
    System.out.println(result);


    }
 
    public static void main(String[] args) {
    try {
        HttpURLConnectionExample example = new HttpURLConnectionExample();
        String getUrl = "https://randomuser.me/api/?inc=gender,name,nat,picture";
 
        System.out.println("HttpURLConnection Examples:");
        example.get(getUrl);


 
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}