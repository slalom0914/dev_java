package dev_java.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TomcatServer {
	public static void main(String[] args) {
		String url = "http://192.168.10.47:9000/index.html";
		try {
			// 예외가 발생할 가능성이 있는 코드
			URL myURL = new URL(url);
			HttpURLConnection con = (HttpURLConnection) myURL.openConnection();
			int responseCode = con.getResponseCode();// 200 204 404 500
			//System.out.println(responseCode);
			//System.out.println(5 / 0);
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			StringBuilder sb = new StringBuilder();
			String line="";
			while((line =br.readLine())!=null){
				sb.append(line);
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
