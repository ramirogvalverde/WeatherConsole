/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirogvalverde.weatherconsole;

/**
 *
 * @author Ramiro
 */
public class WeatherConsole {

    public static void main(String[] args) {

        String city = "";
        String countryCode = "";
        String format = "";
        int days = 0;

        if (args[1].contains(",")) {
            city = args[1].split(",")[0];
            countryCode = args[1].split(",")[1];

        } else {
            //add log
            System.err.println("Invalid format in the second parameter");
        }
        
        /*
        switch (args[2]) {
            
            case args[2].contains("--units="):

                if (args[2].split("=")[1].equals("imperial")) {
                    format = "imperial";
                } else if (args[2].split("=")[1].equals("metric")) {
                    format = "metric";
                } else {
                    //add log
                    System.err.println("Invalid format in the third parameter. Default value set");
                    format = "metric";
                }
                break;

            case (args[2].contains("--days=")):
                
                try {
                    days = (int(args[2].split("=")[1]));
                } catch (NumberFormatException e) {
                    //add log
                    System.err.println("Invalid format in the third parameter. Set in 1 day");
                    days = 1;
                    break;
                }
                break;

            default:

                throw new AssertionError();
        }
        */
        
        switch (args[0]) {
            case "current":

                //add log
                break;

            case "forecast":

                //add log
                break;
            default:

                //add log
                System.err.println("Invalid option in the first parameter");

        }
    }
}
