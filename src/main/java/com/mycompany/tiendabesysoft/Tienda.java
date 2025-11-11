/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendabesysoft;

import java.util.ArrayList;

/**
 *
 * @author Santiago Ponce
 */
public class Tienda {
    private ArrayList<Vendedor> vendedores = new ArrayList();
    private ArrayList<Producto> productos = new ArrayList();

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void setVendedores(ArrayList<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }
    
  public ArrayList<Producto> getProductosPorCategoria(String categoria) {
         ArrayList<Producto> productosFiltrados = new ArrayList<>();
         
         this.productos.forEach((producto) -> {
             if(producto.getCategoria().equals(categoria))
                 productosFiltrados.add(producto);
         });
         
         return productosFiltrados;
    }    
}
