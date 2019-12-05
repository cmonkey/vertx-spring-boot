package org.excavator.boot.vertxspringboot;

import com.alibaba.fastjson.JSON;
import org.synchronoss.cloud.nio.multipart.util.IOUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class BPI{
    public static void main (String [] args) throws IOException, InterruptedException {
        var request = HttpRequest
            .newBuilder()
            .uri(URI.create("https://api.coindesk.com/v1/bpi/currentprice.json"))
            .GET()
            .build();

        var response = HttpClient
            .newHttpClient()
            .send(request, HttpResponse.BodyHandlers.ofInputStream());

        var responseBody = response.body();
        String r = IOUtils.inputStreamAsString(responseBody, StandardCharsets.UTF_8.name());
        var json = JSON.parseObject(r);
        var bpi = json.getJSONObject("bpi");
        var usd = bpi.getJSONObject("USD");
        var price = usd.getFloatValue("rate_float");
        System.out.printf("Current Bitcoin USD Price: $%s ", price);
    }
}
