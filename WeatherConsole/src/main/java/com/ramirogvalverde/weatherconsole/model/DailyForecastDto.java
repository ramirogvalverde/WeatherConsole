/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirogvalverde.weatherconsole.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 *
 * @author Ramiro
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecastDto {
    
    @JsonProperty("Date")
    private Date date;
    @JsonProperty("Day")
    private DayDto day;
    @JsonProperty("Temperature")
    private TemperatureDto temperature;

    public String getDate() {
        // Especifica el formato deseado
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy",Locale.US);
        // Formatea el Date y devuelve el resultado como un String
        return sdf.format(date);

    }

    public DayDto getDay() {
        
        return day;
    }

    public TemperatureDto getTemperature() {
        return temperature;
    }
    
    
    
}
