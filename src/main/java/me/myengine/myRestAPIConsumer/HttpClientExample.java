package me.myengine.myRestAPIConsumer;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientExample {

  public static void performGet() throws ClientProtocolException, IOException {
    CloseableHttpClient client = HttpClientBuilder.create().build();
    HttpGet get = new HttpGet("http://localhost:8080/users");
    HttpResponse response = client.execute(get);
    HttpEntity entity = response.getEntity();
    String responseJSON = EntityUtils.toString(entity);
    System.out.println(responseJSON);
    client.close();
  }

  public static void performPost() throws ClientProtocolException, IOException {
    CloseableHttpClient client = HttpClientBuilder.create().build();
    HttpPost post = new HttpPost("http://localhost:8080/users");
    post.addHeader("content-type", ContentType.APPLICATION_JSON.getMimeType());
    String json = "{\"fName\":\"Annne\",\"lName\":\"Bhimavarapu\"}";
    StringEntity se = new StringEntity(json);
    post.setEntity(se);
    HttpResponse response = client.execute(post);
    HttpEntity entity = response.getEntity();
    String responseJSON = EntityUtils.toString(entity);
    System.out.println(responseJSON);
    client.close();
  }


  public static void performPut() throws ClientProtocolException, IOException {
    CloseableHttpClient client = HttpClientBuilder.create().build();
    HttpPut put = new HttpPut("http://localhost:8080/users");
    put.addHeader("content-type", ContentType.APPLICATION_JSON.getMimeType());
    String json = "{\"id\":7,\"fName\":\"Annne\", \"lName\":null, \"city\":\"Argyle\" }";
    StringEntity se = new StringEntity(json);
    put.setEntity(se);
    HttpResponse response = client.execute(put);
    HttpEntity entity = response.getEntity();
    String responseJSON = EntityUtils.toString(entity);
    System.out.println(responseJSON);
    client.close();
  }


  public static void performDelete() throws ClientProtocolException, IOException {
    CloseableHttpClient client = HttpClientBuilder.create().build();
    HttpDelete delete = new HttpDelete("http://localhost:8080/users/6");
    HttpResponse response = client.execute(delete);
    HttpEntity entity = response.getEntity();
    String responseJSON = EntityUtils.toString(entity);
    System.out.println(responseJSON);
    client.close();
  }

  public static void main(String[] args) throws ClientProtocolException, IOException {
    //performPost();
    //performDelete();
    //performPut();
    performGet();
  }

}