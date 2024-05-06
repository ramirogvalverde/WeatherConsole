/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirogvalverde.weatherconsole.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Ramiro
 */
public class TemperatureDto {
    
    @JsonProperty("Maximum")
    private MaximumTempDto maximumTempDto;

    public MaximumTempDto getMaximumTempDto() {
        return maximumTempDto;
    }
    
    
    
}
