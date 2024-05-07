/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirogvalverde.weatherconsole;

import com.ramirogvalverde.weatherconsole.model.ForecastDto;
import com.ramirogvalverde.weatherconsole.model.LocationDto;
import com.ramirogvalverde.weatherconsole.requests.Forecast;
import com.ramirogvalverde.weatherconsole.requests.Location;
import static com.ramirogvalverde.weatherconsole.requests.Utils.splitArgs;
import static com.ramirogvalverde.weatherconsole.requests.Utils.getKey;
import java.util.List;

/**
 *
 * @author Ramiro
 */
public class WeatherConsole {

    public static void main(String[] args) {

        LocationDto locationDto = null;
        ForecastDto fo = null;
        
        String format = "metric";
        int days = 1;
        
        String [] args2 = {"", "Cabezón,ES" , "" };
        args = args2;
        
        
        
        if (args[1].contains(",")) {
            
           locationDto = setLocation(args[1]);
           Forecast forecast = new Forecast();
           
           fo = forecast.getForecast(locationDto, Boolean.TRUE);
           fo.showForecast(days);
          
           
        } else {
            //add log
            System.err.println("Invalid format in the second parameter");
        }
/*
        if (args[2].contains("=")) {

            String[] args2 = splitArgs(args[2], "=");

            switch (args2[0]) {
                case "--units":
                    if (args2[1].equals("imperial")) {
                        format = "imperial";
                        break;
                    } else if (args2[1].equals("metric")) {
                        format = "metric";
                        break;
                    } else {
                        //add log
                        System.err.println("Invalid format in the third parameter. Default value metric.");
                        format = "metric";
                    }
                    break;
                case "--days":
                try {
                    days = Integer.parseInt(args2[1]);

                    if (days >= 6 || days <= 0) {
                        //add log
                        System.err.println("Invalid option. Days should be between 1 and 5. Days set in 1");
                        days = 1;
                    }

                } catch (NumberFormatException e) {

                    //add log
                    System.err.println("Invalid option in the third parameter. Days set in 1");
                    days = 1;
                }
                break;

                default:

                    //add log
                    System.err.println("Invalid option in the third parameter");

            }
        } else {
            //add log
            System.err.println("Invalid option in the third parameter");
        }

        if (args[3].contains("=")) {
            String[] args3 = splitArgs(args[3], "=");
            try {
                days = Integer.parseInt(args3[1]);

                if (days >= 6 || days <= 0) {
                    //add log
                    System.err.println("Invalid option. Days should be between 1 and 5. Days set in 1");
                    days = 1;
                }

            } catch (NumberFormatException e) {

                //add log
                System.err.println("Invalid option in the third parameter. Days set in 1");
                days = 1;
            }

        }

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
     */
        
    }

    private static LocationDto setLocation(String args) {
        
        LocationDto locationDto=null;       
        String city = args.split(",")[0];
        String countryCode = args.split(",")[1];
        
        Location location= new Location();
        
        List<LocationDto> list = location.getlocation(city, countryCode);
        
        if (list.isEmpty()) {
            System.out.println("The requested city was not found");
        }else if(list==null){
            System.out.println("Something went wrong with the request. Repeat it");
        }else if(list.size()>1){
            System.out.println("You have to be more pesize with the name. Pick one from the list");
            for (LocationDto l : list) {
                System.out.println(l.getLocalizedName()+ " "+ l.getCountry().getId());
            }
        }else{
            locationDto=list.get(0);
        }

        return locationDto;
    }

    
}
