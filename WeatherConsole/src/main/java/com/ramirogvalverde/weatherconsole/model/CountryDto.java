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
public class CountryDto {
    
    @JsonProperty("ID")
    private String id;

    public String getId() {
        return id;
    }

}
