/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirogvalverde.weatherconsole.requests;

import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author Ramiro
 */
public class Utils {
    
    public String getKey(){
    
    Dotenv env = Dotenv.load();
    env.get("API_KEY");
    return env.get("API_KEY");
    
    }
    
    /**
     *
     * @return
     */
    public static String[] splitArgs(String args, String splitRegex) {
        String[] splitedArgs = args.split(splitRegex);
        return splitedArgs;
    }
}