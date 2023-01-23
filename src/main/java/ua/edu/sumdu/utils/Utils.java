/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ua.edu.sumdu.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import ua.edu.sumdu.customexceptions.AgeException;
import ua.edu.sumdu.customexceptions.EmailException;

/**
 *
 * @author polonskiy
 */
public class Utils {
    
    public static String calculatePopularDomain(LinkedList<Student> studs) throws EmailException{
        Map<String,Integer> mails=new HashMap<String,Integer>();
        String tempDomain="";
        String popularDomain="";
        int count=0;
        for (Student st:studs) {
            if (Utils.patternMatches (st.getEmail())) {
                tempDomain = Utils.getEmailDomain(st.getEmail());
                if (mails.containsKey (tempDomain)) {
                    count = mails.get(tempDomain) +1;
                }
                else {
                    count=1;
                }
                mails.put(tempDomain, count);
            }            
            else {
                throw new EmailException();
            }
        }
        
        Set<String> keys= mails.keySet ();
        int max=0;
        for (String current:keys) {
            if (max <= mails.get(current)) {
                max = mails.get (current);
            
                if (popularDomain.length()==0){
                    popularDomain = current;
                }else{
                    popularDomain=popularDomain+"; "+current;
                }
            }
        }
    return popularDomain;
    }
    
    
    public static double calculateAverageAge(LinkedList<Student> studs) throws AgeException {
        double tempAge=0;
        int count=0;
        for(Student st: studs){
            int age=age=Integer.parseInt(st.getAge());
            if (age>0) {
                tempAge+=age;
                count++;
            }else{
               throw new AgeException();
            }
        }
        if(count==0) {return -1;}
        return tempAge/count;
    }
    
    public static int calculateMaxAge(LinkedList<Student> studs) {
        List<Integer> age = new ArrayList<Integer>();
        for(Student st: studs){
            age.add(Integer.parseInt(st.getAge()));
            }
        return Collections.max(age);
    }
    
    public static int calculateMinAge(LinkedList<Student> studs) {
        List<Integer> age = new ArrayList<Integer>();
        for(Student st: studs){
            age.add(Integer.parseInt(st.getAge()));
            }
        return Collections.min(age);
    }
    
    
    public static boolean patternMatches (String emailAddress) {
        String regexPattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$";
        return Pattern.compile(regexPattern).matcher(emailAddress).matches();
    }
    
     public static boolean sumduPatternMatches (String emailAddress) {
        String regexPattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9_.+-]*sumdu.edu.ua";
        return Pattern.compile(regexPattern).matcher(emailAddress).matches();
    }
       
    
    public static String getEmailDomain(String someEmail) {
        return someEmail.substring(someEmail.indexOf("@") + 1);
    }
    public static int calculateSumduDomain(LinkedList<Student> studs) throws EmailException{
        int count=0;
    
        for (Student st:studs) {
            if (Utils.sumduPatternMatches(st.getEmail())) 
                count++;            
        }
    return count;
    }
    
    
     public static void  printStudentsList(LinkedList<Student> studs) {
        System.out.println("Students:");
        for (Student st:studs) {
            System.out.println();
            System.out.println("Name: " + st.getName());
            System.out.println("Surname: " + st.getSurname());
            System.out.println("Age: " + st.getAge());
            System.out.println("Email: " + st.getEmail());
            System.out.println("Group: " + st.getGroup());
            System.out.println("Faculty: " + st.getFaculty());
        }     
     }
     
    
}