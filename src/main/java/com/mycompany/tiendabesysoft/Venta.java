/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendabesysoft;

/**
 *
 * @author zosima
 */
public class Venta {
    private Producto producto;
    private Vendedor vendedor;

    public Venta(Producto producto, Vendedor vendedor) {
        this.producto = producto;
        this.vendedor = vendedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }
    
    
}
