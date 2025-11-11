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
  //con estrategia mejor
  public Double calcularComision(Vendedor vendedor) {
      Double comision = Double.valueOf(0);
      Double valorTotalDeVentas = Double.valueOf(0);
      
      if(vendedor.getVentas().isEmpty())
          return comision;
      
      for(Venta venta : vendedor.getVentas()){
          valorTotalDeVentas += venta.getProducto().getPrecio();
      }
     
      if(vendedor.getVentas().size()<=2)
          comision = valorTotalDeVentas*0.05;
      else
          comision = valorTotalDeVentas * 0.1;
      
      return comision;
          
  }
  
  public void almacenarProducto(Producto producto){
      this.productos.add(producto);
  }
  
  public void agregarVendedor(Vendedor vendedor){
      this.vendedores.add(vendedor);
  }
  
  public void registrarVenta(Producto producto, Vendedor vendedor){
      Venta venta = new Venta(producto, vendedor);
      vendedor.registrarVenta(venta);
  }
        
}
