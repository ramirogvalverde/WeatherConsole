/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirogvalverde.weatherconsole.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;


/**
 *
 * @author Ramiro
 */
public class DailyForecastDto {
    
    @JsonProperty("Date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM dd,yyyy")
    private Date date;
    @JsonProperty("Day")
    private DayDto day;
    @JsonProperty("Temperature")
    private TemperatureDto temperature;

    public Date getDate() {
        return date;
    }

    public DayDto getDay() {
        return day;
    }

    public TemperatureDto getTemperature() {
        return temperature;
    }
    
    
    
}
