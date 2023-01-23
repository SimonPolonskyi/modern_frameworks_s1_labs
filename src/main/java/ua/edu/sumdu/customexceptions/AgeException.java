/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ua.edu.sumdu.customexceptions;

/**
 *
 * @author polonskiy
 */
public class AgeException extends Exception{
   
    public AgeException() {
    super ("Age should be greater than 0");
    }
}
