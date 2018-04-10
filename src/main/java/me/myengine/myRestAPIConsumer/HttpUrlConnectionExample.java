package me.myengine.myRestAPIConsumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpUrlConnectionExample {

  public static void main(String[] args) throws IOException {
    URL url = new URL("http://localhost:8080/users");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Accept", "application/json");

    if (conn.getResponseCode() != 200) {
      throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
    }

    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
    String output;
    StringBuilder sb = new StringBuilder();
    System.out.println("Output from Server .... \n");
    while ((output = br.readLine()) != null) {
      sb.append(output);
    }
    System.out.println(sb);
    conn.disconnect();
  }

}