package me.myengine.myRestAPIConsumer;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class RestTemplateAuthorConsumer {

  public static void getAllAuthors() {
    String URI = "http://localhost:8080/authors";

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

    ResponseEntity<String> response = restTemplate.exchange(URI, HttpMethod.GET, httpEntity, String.class);


    System.out.println("\n******************************\n");
    System.out.println("status code is " + response.getStatusCode());
    System.out.println("body is " + response.getBody());
    System.out.println("headers are " + response.getHeaders());
    System.out.println("StatusCodeValue is " + response.getStatusCodeValue());


    System.out.println("\n******************************\n");
  }

  public static void createAuthor() {
    String URI = "http://localhost:8080/authors";
    String jsonData = "{\"firstName\": \"AdminPritam\",\"lastName\": \"Bohra\"}";

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();

    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    HttpEntity<String> httpEntity = new HttpEntity<>(jsonData, httpHeaders);
    ResponseEntity<String> response = restTemplate.exchange(URI, HttpMethod.POST, httpEntity, String.class);

    System.out.println("**************************POST*******************************");
    System.out.println(response.getBody());
  }

  public static void updateAuthor(long id) {
    String URI = "http://localhost:8080/authors/" + id;
    String jsonData = "{\"firstName\": \"AdminSachin\",\"lastName\": \"Tendulkar\"}";

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML));

    HttpEntity<String> httpEntity = new HttpEntity<>(jsonData, httpHeaders);
    ResponseEntity<String> response = restTemplate.exchange(URI, HttpMethod.PUT, httpEntity, String.class);

    System.out.println("*****************************PUT*******************************");
    System.out.println(response.getBody());
  }

  public static void deleteAuthor(long id) {
    String URI = "http://localhost:8080/authors/" + id;
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    HttpEntity<String> httpEntity = new HttpEntity<>("parameters", httpHeaders);
    ResponseEntity<String> response = restTemplate.exchange(URI, HttpMethod.DELETE, httpEntity, String.class);

    System.out.println("*****************************DELETE*******************************");
    System.out.println(response.getBody());

  }

  public static void main(String[] args) {
//    getAllAuthors();
//    createAuthor();
//    updateAuthor(17L);
    deleteAuthor(15L);
  }
}
