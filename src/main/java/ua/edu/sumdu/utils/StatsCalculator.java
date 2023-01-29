/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ua.edu.sumdu.utils;

/**
 *
 * @author polonskiy
 */
public class StatsCalculator {
    private static StatsCalculator instance;

  
    private static double averageAge;    
    private static int maxAge;
    private static int minAge;
    private static String popularMailDomain;
    private static int sumDUMails;
    
    private StatsCalculator(){    
    }
    
    public static StatsCalculator getInstance(){   
        if(instance==null){
            instance= new StatsCalculator();
        }
        return instance;
    }
    
 /*   public static StatsCalculator getInstance() {
        return instance;
    } */

    public static void setInstance(StatsCalculator instance) {
        StatsCalculator.instance = instance;
    }

    public static double getAverageAge() {
        return averageAge;
    }

    public static void setAverageAge(double averageAge) {
        StatsCalculator.averageAge = averageAge;
    }

    public static int getMaxAge() {
        return maxAge;
    }

    public static void setMaxAge(int maxAge) {
        StatsCalculator.maxAge = maxAge;
    }

    public static int getMinAge() {
        return minAge;
    }

    public static void setMinAge(int minAge) {
        StatsCalculator.minAge = minAge;
    }

    public static String getPopularMailDomain() {
        return popularMailDomain;
    }

    public static void setPopularMailDomain (String popularMailDomain) {
        StatsCalculator.popularMailDomain = popularMailDomain;
    }

    public static int getSumDUMails() {
        return sumDUMails;
    }

    public static void setSumDUMails(int sumDUMails) {
        StatsCalculator.sumDUMails = sumDUMails;
    }    

    @Override
    public String toString() {
        return "StatsCalculator{\r\naverageAge: " + averageAge+ "\r\n maxAge: " + maxAge + "\r\n minAge: "+
            minAge + "\r\npopularMailDomain: " + popularMailDomain + "\r\nsumDUMails: "+sumDUMails+" }";
    }
    

    
}
