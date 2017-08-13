package botFarm;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionExample {
	static String url ;
 
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36";
 
    public String get(String url) throws Exception {
    String result = null;
 
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
    con.setRequestMethod("GET");
 
    con.setRequestProperty("User-Agent", USER_AGENT);
 
//    int responseCode = con.getResponseCode();
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
    return result = response.toString();

    }
 
//    public static void main(String[] args) {
//    try {
//        HttpURLConnectionExample example = new HttpURLConnectionExample();
//        String getUrl = url;
// 
//        System.out.println("HttpURLConnection Examples:");
//        System.out.println(example.get(getUrl));
//
//
// 
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//    }
}