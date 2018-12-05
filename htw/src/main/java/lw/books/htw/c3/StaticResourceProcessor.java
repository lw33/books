package lw.books.htw.c3;

import lw.books.htw.c3.connector.http.HttpRequest;
import lw.books.htw.c3.connector.http.HttpResponse;

import java.io.IOException;

public class StaticResourceProcessor {

  public void process(HttpRequest request, HttpResponse response) {
    try {
      response.sendStaticResource();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}
