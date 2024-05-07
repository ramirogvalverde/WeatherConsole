/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirogvalverde.weatherconsole.requests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramirogvalverde.weatherconsole.model.ForecastDto;
import com.ramirogvalverde.weatherconsole.model.LocationDto;
import static com.ramirogvalverde.weatherconsole.requests.Utils.getBaseUrl;
import static com.ramirogvalverde.weatherconsole.requests.Utils.getKey;
import static com.ramirogvalverde.weatherconsole.requests.Utils.getLanguage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

/**
 *
 * @author Ramiro
 */
public class Forecast {
    
    public ForecastDto getForecast(LocationDto locationDto, Boolean isMetric){
        try {

        // "http://dataservice.accuweather.com/forecasts/v1/daily/5day/306949?apikey=kJUEoJDkbs7ZEor9XD9Xfj3yI6Nq3TGI&language=es&details=false&metric=false"
                                             //forecasts/v1/daily/5day/306949?apikey=kJUEoJDkbs7ZEor9XD9Xfj3yI6Nq3TGIlanguage%3Den&details=false&metric=true"
            String consulta = getBaseUrl() + "/forecasts/v1/daily/5day/" + locationDto.getKey() + "?apikey="+ getKey()+ "&language="+ getLanguage() +"&details=false&metric=" + isMetric;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(consulta))
                    .GET()
                    .timeout(Duration.ofSeconds(10))
                    .build();

           HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Convierte el cuerpo de la respuesta en una lista de DTOs utilizando Jackson
            ForecastDto forecastDto = parseJsonToDto(response.body());

            

            return forecastDto;
            

           

        } catch (URISyntaxException | IOException | InterruptedException ex) {
            System.err.println(ex.getMessage());
            
            return null;    
        }   
    }

    
     private static ForecastDto parseJsonToDto(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<ForecastDto> typeReference = new TypeReference<ForecastDto>() {};
        return objectMapper.readValue(json, typeReference);
    }
    
    
    
}
