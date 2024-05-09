/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramirogvalverde.weatherconsole.requests;

import com.ramirogvalverde.weatherconsole.model.LocationDto;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.List;

/**
 *
 * @author Ramiro
 */
public class Utils {

    public static String getKey() {

        Dotenv env = Dotenv.load();
        env.get("API_KEY");
        return env.get("API_KEY");

    }

    public static String getBaseUrl() {

        Dotenv env = Dotenv.load();
        env.get("BASE_URL");
        return env.get("BASE_URL");

    }

    public static String getLanguage() {

        Dotenv env = Dotenv.load();
        return env.get("LANGUAGE");

    }

    /**
     *
     * @return
     */
    public static String[] splitArgs(String args, String splitRegex) {
        String[] splitedArgs = args.split(splitRegex);
        return splitedArgs;
    }

    public static LocationDto setLocation(String args) {

        LocationDto locationDto = null;
        String city = args.split(",")[0];

        if (city.contains("_")) {
            city = city.replace('_', ' ');
        }

        String countryCode = args.split(",")[1];
        Location location = new Location();

        List<LocationDto> list = location.getlocation(city, countryCode);

        if (list.isEmpty()) {
            System.out.println("The requested city was not found");
        } else if (list == null) {
            System.out.println("Something went wrong with the request. Repeat it");
        } else if (list.size() > 1) {
            System.out.println("You have to be more precise with the name. Pick one from the list and remember the formatting");
            for (LocationDto l : list) {
                System.out.println(l.getLocalizedName() + " " + l.getCountry().getId());
            }
        } else {
            locationDto = list.get(0);
        }

        return locationDto;
    }

    public static boolean setUnits(String args) {

        String[] args2 = splitArgs(args, "=");

        if (args2[1].equals("imperial")) {

            return false;

        } else if (args2[1].equals("metric")) {

            return true;
        } else {
            //add log
            System.err.println("Invalid format in the third parameter. Default value metric.");
        }
        return true;
    }

    public static int setDays(String args) {
        int days = 1;
        String[] args2 = splitArgs(args, "=");

        try {
            days = Integer.parseInt(args2[1]);

            if (days >= 6 || days <= 0) {
                //add log
                System.err.println("Invalid option. Days should be between 1 and 5. Days set in 1");
                days = 1;
            }
            return days;

        } catch (NumberFormatException e) {
            //add log
            System.err.println("Invalid option in the third parameter. Days set in 1");
            days = 1;
        }
        return days;
    }

    public static void printHelp() {
        System.out.println("Welcome to WeatherConsole\n");
        System.out.println("First parameter options:");
        System.out.println("\thelp: Shows the help menu");
        System.out.println("\tcurrent: Shows weather for the current day");
        System.out.println("\tforecast: Shows weather for a number of days\n");
        System.out.println("Second parameter options:");
        System.out.println("\tcityname,countryCode  ex. Santander,ES\n");
        System.out.println("Third parameter options: (OPTIONAL)");
        System.out.println("\t--days=numberOfDays (between 1 and 5) ex. --days=3 ");
        System.out.println("\t--units=desiredFormat (imperial or metric) ex. --units=imperial\n");
        System.out.println("Fourth parameter options: (OPTIONAL)");
        System.out.println("\t--days=numberOfDays (between 1 and 5) ex. --days=3 ");
        System.out.println("\t--units=desiredFormat (imperial or metric) ex. --units=imperial");
    }
}
