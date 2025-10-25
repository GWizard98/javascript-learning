# REST Lab

Goal: show Java exposing JSON and JavaScript consuming it.

Endpoints:
- Java: GET http://localhost:8080/api/hello
- JS Micro (proxy): GET http://localhost:3000/micro/java-hello

Try:
- Open the homepage at http://localhost:3000 and click "Call Java API".
- Or run the snippets below.

JavaScript fetch example:

```js
fetch('http://localhost:3000/micro/java-hello')
  .then(r => r.json())
  .then(console.log)
```

Java HTTP client example (no external deps):

```java
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestClientExample {
  public static void main(String[] args) throws Exception {
    var client = HttpClient.newHttpClient();
    var req = HttpRequest.newBuilder(URI.create("http://localhost:8080/api/hello")).build();
    var res = client.send(req, HttpResponse.BodyHandlers.ofString());
    System.out.println(res.body());
  }
}
```
