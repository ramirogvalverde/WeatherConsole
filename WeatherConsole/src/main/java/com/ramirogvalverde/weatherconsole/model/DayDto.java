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
class DayDto {
    
    @JsonProperty("IconPhrase")
    private String iconPhrase;

    public String getIconPhrase() {
        return iconPhrase;
    }
    
    
   
    
}
