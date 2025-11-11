/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiendabesysoft;

import java.io.IOException;
import ui.TiendaUI;

/**
 *
 * @author zosima
 */
public class TiendaBesysoft {

    public static void main(String[] args) throws IOException {
       Tienda tienda = new Tienda();
        TiendaUI tiendaUI = new TiendaUI(tienda);
        tiendaUI.iniciar();
    }
}
