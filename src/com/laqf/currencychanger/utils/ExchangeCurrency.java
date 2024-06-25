package com.laqf.currencychanger.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeCurrency {

    public static void exchangeCurrency(double amount, String fromCurrency, String toCurrency) {
        try {
            // Hacer la solicitud HTTP GET a la API
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/6ab0381073b2894770d7e2f1/latest/" + fromCurrency);

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            // Parsear el JSON de respuesta
            JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();

            // Extraer la tasa de cambio
            double exchangeRate = jsonObject.getAsJsonObject("conversion_rates").get(toCurrency).getAsDouble();

            // Calcular el monto convertido
            double convertedAmount = amount * exchangeRate;
            System.out.println(amount + " " + fromCurrency + " = " + convertedAmount + " " + toCurrency);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error during HTTP request: " + e.getMessage(), e);
        }
    }

}
