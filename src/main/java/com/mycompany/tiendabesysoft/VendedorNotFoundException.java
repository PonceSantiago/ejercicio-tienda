/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendabesysoft;

/**
 *
 * @author Ponce Santiago
 */
public class VendedorNotFoundException extends Exception {

    public VendedorNotFoundException() {
    }

    @Override
    public String getMessage() {
        return "Vendedor no encontrado";
    }
    
    
}
