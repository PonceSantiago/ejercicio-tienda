/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiendabesysoft;

import java.io.IOException;
import java.util.ArrayList;
import ui.TiendaUI;

/**
 *
 * @author Santiago ponce
 */
public class Main {

    public static void main(String[] args) throws IOException, InvalidDataException, InvalidProductDataException, VendedorDuplicadoException, ProductoDuplicadoException {
        
        
       Tienda tienda = new Tienda();
       tienda.agregarVendedor(new Vendedor("Alexei Karamazov", Float.valueOf("80000"), "V01"));
       tienda.agregarVendedor(new Vendedor("Roderick Usher", Float.valueOf("80000"), "V02"));
       tienda.agregarVendedor(new Vendedor("Maria Iribarne", Float.valueOf("80000"), "V03"));
       

       tienda.almacenarProducto(new Producto("Zapatillas",Float.valueOf("80000"),"Indumentaria","A001"));
       tienda.almacenarProducto(new Producto("Auriculares",Float.valueOf("25000"),"Audio","A002"));
       tienda.almacenarProducto(new Producto("Mouse",Float.valueOf("15000"),"Electronica","A003"));
       tienda.almacenarProducto(new Producto("Lampara Led",Float.valueOf("80000"),"Electronica","A004"));
       tienda.almacenarProducto(new Producto("Pendrive 64GB",Float.valueOf("10000"),"Electronica","A005"));
       
 
       
        
        TiendaUI tiendaUI = new TiendaUI(tienda);
        tiendaUI.iniciar();
    }
}
