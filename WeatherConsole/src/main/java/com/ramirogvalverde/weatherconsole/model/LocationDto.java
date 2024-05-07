/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirogvalverde.weatherconsole.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Ramiro
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDto {
    
    @JsonProperty("Key")
    private long key;
    @JsonProperty("LocalizedName")
    private String localizedName;
    @JsonProperty("Country")
    private CountryDto country;
    
    
    public long getKey() {
        return key;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public CountryDto getCountry() {
        return country;
    }


    
    
    
    
}
