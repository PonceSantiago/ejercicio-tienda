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
public class Vendedor {
    private String nombre;
    private Float sueldo;
    private String codigo;
    private ArrayList<Venta> ventas;
    
    public Vendedor(String nombre, Float sueldo, String codigo) throws InvalidDataException {
        if(nombre.isEmpty()||sueldo<0||codigo.isEmpty())
            throw new InvalidDataException();
        
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.codigo = codigo;
        this.ventas = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public Float getSueldo() {
        return sueldo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void registrarVenta(Venta venta){
        this.ventas.add(venta);
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }
    
    
    
}
