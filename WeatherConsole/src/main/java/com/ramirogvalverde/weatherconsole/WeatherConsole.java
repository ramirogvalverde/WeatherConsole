/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirogvalverde.weatherconsole;

import static com.ramirogvalverde.weatherconsole.requests.Utils.splitArgs;

/**
 *
 * @author Ramiro
 */
public class WeatherConsole {

    public static void main(String[] args) {

        String city = "";
        String countryCode = "";
        String format = "metric";
        int days = 0;

        if (args[1].contains(",")) {
            city = args[1].split(",")[0];
            countryCode = args[1].split(",")[1];

        } else {
            //add log
            System.err.println("Invalid format in the second parameter");
        }

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
    }

    
}
