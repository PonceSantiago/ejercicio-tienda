/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendabesysoft;

/**
 *
 * @author Santiago Ponce
 */
public class CalculadoraComisionDefault implements CalculadoraDeComision{

    @Override
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
      
      return comision;    }


}
