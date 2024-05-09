/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirogvalverde.weatherconsole.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author Ramiro
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDto {
    
    @JsonProperty("DailyForecasts")
    private List <DailyForecastDto> dailyForecast;

    public List <DailyForecastDto> getDailyForecast() {
        return dailyForecast;
    }
    
    public void showForecast(int numDays){
        for (int i = 0; i < numDays; i++) {
            DailyForecastDto df = dailyForecast.get(i);
            System.out.println(
            df.getDate() + "\n" +
            "> Weather: " + df.getDay().getIconPhrase() + "\n" +
            "> Temperature: " + df.getTemperature().getMaximumTempDto().getValue() + " º" + df.getTemperature().getMaximumTempDto().getUnit()            
            );
        }
    }
}
