/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendabesysoft;

/**
 *
 * @author zosima
 */
public class InvalidProductDataException extends Exception{

    public InvalidProductDataException() {
    }

    @Override
    public String getMessage() {
        return "Error:Datos de producto invalido";
    }
    
    
    
}
