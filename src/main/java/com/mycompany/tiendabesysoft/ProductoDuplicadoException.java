/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendabesysoft;

/**
 *
 * @author Ponce Santiago
 */
public class ProductoDuplicadoException extends Exception {

    public ProductoDuplicadoException() {
    }

    @Override
    public String getMessage() {
        return "Producto con código duplicado";
    }
    
    
    
}
