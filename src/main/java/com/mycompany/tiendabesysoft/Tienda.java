/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendabesysoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Santiago Ponce
 */
public class Tienda {
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Producto> productos;
    private CalculadoraDeComision calculadoraComision;

    public Tienda(ArrayList<Vendedor> vendedores, ArrayList<Producto> productos,CalculadoraDeComision calculadoraComision) {
        this.vendedores = vendedores;
        this.productos = productos;
        this.calculadoraComision = calculadoraComision;
    }

    public Tienda() {
        this.vendedores = new ArrayList<>();
        this.productos = new ArrayList<>();
        this.calculadoraComision = new CalculadoraComisionDefault();
    }
    
    
   

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
  
    public ArrayList<Producto> getProductosPorPrecioMaximo(Float precioMaximo) {
         ArrayList<Producto> productosFiltrados = new ArrayList<>();
         
         this.productos.forEach((producto) -> {
             if(producto.getPrecio()<precioMaximo)
                 productosFiltrados.add(producto);
         });
         
         return productosFiltrados;
    }    
  
   
  
 public  Map<Vendedor, Double>calcularComisiones(){
     Map<Vendedor, Double> comisiones = new HashMap<>();
     for(Vendedor vendedor : this.vendedores){
         comisiones.put(vendedor, this.calculadoraComision.calcularComision(vendedor));
     }
     return comisiones;
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
