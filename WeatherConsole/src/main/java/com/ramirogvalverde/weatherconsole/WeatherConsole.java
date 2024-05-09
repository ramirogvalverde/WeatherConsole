/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirogvalverde.weatherconsole;

import com.ramirogvalverde.weatherconsole.model.ForecastDto;
import com.ramirogvalverde.weatherconsole.model.LocationDto;
import com.ramirogvalverde.weatherconsole.requests.Forecast;
import static com.ramirogvalverde.weatherconsole.requests.Utils.*;

/**
 *
 * @author Ramiro
 */
public class WeatherConsole {

    public static void main(String[] args) {

        // testing    
        //String[] args2 = {"helpmeplease"};
        //args = args2;
        LocationDto locationDto = null;
        ForecastDto fo = null;
        String localizedName;
        String country;

        Forecast forecast = new Forecast();
        boolean format = true;
        int days = 1;

        if (args.length >= 2) {
            //logic on the second parameter
            if (args[1].contains(",") && !args[0].contains("help")) {

                locationDto = setLocation(args[1]);

                if (locationDto != null) {

                    if (args.length >= 3) {

                        //logic on the third parameter
                        if (args[2].contains("=")) {

                            String[] args3 = splitArgs(args[2], "=");

                            switch (args3[0]) {
                                case "--units":
                                    format = setUnits(args[2]);

                                    break;
                                case "--days":
                                    days = setDays(args[2]);

                                    break;
                                default:
                                    //add log
                                    System.err.println("Invalid option in the third parameter\n");
                                    printHelp();
                            }

                        } else {
                            //add log
                            System.err.println("Invalid option in the third parameter\n");
                            printHelp();
                        }
                    }

                    if (args.length >= 4) {
                        //logic on the fourth parameter
                        if (args[3].contains("=")) {

                            String[] args4 = splitArgs(args[3], "=");

                            switch (args4[0]) {
                                case "--units":
                                    format = setUnits(args[3]);

                                    break;
                                case "--days":
                                    days = setDays(args[3]);

                                    break;
                                default:
                                    //add log
                                    System.err.println("Invalid option in the fourth parameter\n");
                                    printHelp();
                            }

                        } else {
                            //add log
                            System.err.println("Invalid option in the fourth parameter\n");
                            printHelp();
                        }
                    }

                    if (args.length >= 5) {
                        //add log
                        System.err.println("Too many parameters. Check the request\n");
                        printHelp();
                    }
                    // logic on the first parameter
                    switch (args[0]) {
                        case "current":
                            localizedName = locationDto.getLocalizedName();
                            country = locationDto.getCountry().getId();
                            System.out.println(localizedName + ", " + country);
                            fo = forecast.getForecast(locationDto, format);
                            fo.showForecast(1);

                            break;
                        case "forecast":
                            localizedName = locationDto.getLocalizedName();
                            country = locationDto.getCountry().getId();
                            System.out.println(localizedName + ", " + country);
                            fo = forecast.getForecast(locationDto, format);
                            fo.showForecast(days);

                            break;

                        default:
                            //add log
                            System.err.println("Invalid option in the first parameter\n");
                            printHelp();

                    }
                }
            } else {
                //add log
                System.err.println("Invalid option in the second parameter\n");
                printHelp();
            }
        } else {
            if (args[0].contains("help")) {
                printHelp();

            } else {
                //add log
                System.err.println("Invalid option in the first parameter\n");
                printHelp();
            }

        }
    }

}
