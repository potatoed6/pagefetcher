package ParkingReserver;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PageFetcher {
    public String fetchPage(String page)
    {
        try {
            HttpClient client = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).build();
            String url = page.startsWith("http") ? page : "https://" + page;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200)
            {
                System.out.println("StatusCode: " + response.statusCode());
                return response.body();
            }
            else
            {
                System.out.println("ERROR: StatusCode = " + response.statusCode());
                return null;
            }
        } catch (IOException e) {

            System.out.println("Couldnt conenct to " + page + ": " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
            Thread.currentThread().interrupt();
            }
        return null;
    }
}
