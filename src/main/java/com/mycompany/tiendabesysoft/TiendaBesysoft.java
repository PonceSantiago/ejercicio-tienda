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
public class TiendaBesysoft {

    public static void main(String[] args) throws IOException {
        
        
       Tienda tienda = new Tienda();
       tienda.agregarVendedor(new Vendedor("Alexei Karamazov", Float.valueOf("80000"), "001"));
       tienda.agregarVendedor(new Vendedor("Lucila Perez", Float.valueOf("80000"), "002"));
       tienda.agregarVendedor(new Vendedor("Maria Iribarne", Float.valueOf("80000"), "003"));

       tienda.almacenarProducto(new Producto("Calculadora",Float.valueOf("800"),"Bazar","a11"));
        TiendaUI tiendaUI = new TiendaUI(tienda);
        tiendaUI.iniciar();
    }
}
