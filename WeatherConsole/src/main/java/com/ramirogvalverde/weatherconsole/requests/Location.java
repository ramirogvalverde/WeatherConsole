/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirogvalverde.weatherconsole.requests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ramirogvalverde.weatherconsole.model.LocationDto;
import static com.ramirogvalverde.weatherconsole.requests.Utils.getKey;
import static com.ramirogvalverde.weatherconsole.requests.Utils.getBaseUrl;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.ramirogvalverde.weatherconsole.requests.Utils.getLanguage;
import java.net.URLEncoder;
import java.util.LinkedList;



/**
 *
 * @author Ramiro
 */
public class Location {
    
    
       public List <LocationDto> getlocation(String city,String countryCode){
        try {

         // /locations/v1/cities/autocomplete?apikey=kJUEoJDkbs7ZEor9XD9Xfj3yI6Nq3TGI&q=Santander&language=es
            String encodedCityName = URLEncoder.encode(city, "UTF-8");
            String consulta = getBaseUrl() + "/locations/v1/cities/autocomplete?apikey="+ getKey()+ "&q=" + encodedCityName + "&language=" + getLanguage();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(consulta))
                    .GET()
                    .timeout(Duration.ofSeconds(10))
                    .build();

           HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Convierte el cuerpo de la respuesta en una lista de DTOs utilizando Jackson
            List<LocationDto> locationList = parseJsonToList(response.body());
            
            
            List<LocationDto> filteredList = new LinkedList<>();
            
            for (LocationDto l : locationList) {
                if(l.getCountry().getId().equals(countryCode)){
                    filteredList.add(l);
                }
            }

            return filteredList;
            

           

        } catch (URISyntaxException | IOException | InterruptedException ex) {
            System.err.println(ex.getMessage());
            
            return null;    
        }   
    }

    
     private static List<LocationDto> parseJsonToList(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<LocationDto>> typeReference = new TypeReference<List<LocationDto>>() {};
        return objectMapper.readValue(json, typeReference);
    }
    
}
