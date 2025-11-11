package ui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ponce Santiago
 */
import com.mycompany.tiendabesysoft.InvalidDataException;
import com.mycompany.tiendabesysoft.InvalidProductDataException;
import com.mycompany.tiendabesysoft.ProductNotFoundException;
import com.mycompany.tiendabesysoft.Producto;
import com.mycompany.tiendabesysoft.Tienda;
import com.mycompany.tiendabesysoft.Main;
import com.mycompany.tiendabesysoft.Vendedor;
import com.mycompany.tiendabesysoft.VendedorNotFoundException;

import java.io.IOException;
import org.jline.utils.AttributedString;
import java.util.List;
import java.util.Map;
import org.jline.reader.Completer;
import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.reader.impl.DefaultParser;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.AttributedStyle;

public class TiendaUI {
    private final Tienda tienda;
    private final Terminal terminal;
    private final LineReader reader;

    public TiendaUI(Tienda tienda) throws IOException {
        this.tienda = tienda;
        this.terminal = TerminalBuilder.builder().system(true).build();

        Completer completer = new StringsCompleter(
                "registrar_producto", "registrar_vendedor", "registrar_venta",
                "comisiones", "buscar_categoria","buscar_por_precio_maximo", "listar", "ayuda", "salir"
        );

        this.reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .completer(completer)
                .parser(new DefaultParser())
                .build();
    }

    public void iniciar() {
        printTitulo("TIENDA INTERACTIVA");
        mostrarAyuda();

        String prompt = new AttributedString("tienda> ").toAnsi();

        while (true) {
            try {
                String linea = reader.readLine(prompt).trim();

                if (linea.equalsIgnoreCase("salir")) {
                    printInfo("Saliendo del sistema...");
                    break;
                }

                ejecutarComando(linea);

            } catch (UserInterruptException | EndOfFileException e) {
                printInfo("Saliendo...");
                break;
            } catch (Exception e) {
                printError("Error: " + e.getMessage());
            }
        }
    }

    private void ejecutarComando(String comando) throws IOException {
        switch (comando) {
            case "registrar_producto" -> registrarProducto();
            case "registrar_vendedor" -> registrarVendedor();
            case "registrar_venta" -> registrarVenta();
            case "comisiones" -> mostrarComisiones();
            case "buscar_categoria" -> buscarPorCategoria();
            case "precio_max"-> buscarPorPrecioMax();
            case "listar" -> listarProductos();
            case "ayuda" -> mostrarAyuda();
            case "vendedores" -> mostrarVendedores();
            default -> printError("Comando no reconocido. Escriba 'ayuda' para ver opciones.");
        }
    }

    private void registrarProducto() {
        try {
            printTitulo("Registrar producto");
            String codigo = reader.readLine("Código: ");
            String nombre = reader.readLine("Nombre: ");
            Float precio = Float.valueOf(reader.readLine("Precio: "));
            String categoria = reader.readLine("Categoría: ");
            
            tienda.almacenarProducto(new Producto(nombre,precio , categoria, codigo));
            printOk("Producto agregado correctamente.");
        } catch (InvalidProductDataException ex) {
              printError("Error: " + ex.getMessage());
        }
    }

    private void registrarVendedor() {
        try {
            printTitulo("Registrar vendedor");
            String codigo = reader.readLine("Código: ");
            String nombre = reader.readLine("Nombre: ");
            Float sueldo = Float.valueOf(reader.readLine("Sueldo: "));
            
            tienda.agregarVendedor(new Vendedor(nombre, sueldo,codigo));
            printOk("Vendedor registrado.");
        } catch (InvalidDataException ex) {
              printError("Error: " + ex.getMessage());
        }
    }

    private void registrarVenta() {
        try {
            printTitulo("Registrar venta");
            String codVend = reader.readLine("Código vendedor: ");
            String codProd = reader.readLine("Código producto: ");
            
            Producto producto = tienda.buscarProductoPorCodigo(codProd);
            Vendedor vendedor = tienda.buscarVendedorPorCodigo(codVend);
            
            tienda.registrarVenta(producto, vendedor);
            printOk("Venta registrada.");
        } catch (ProductNotFoundException | VendedorNotFoundException | EndOfFileException | UserInterruptException ex) {
              printError("Error: " + ex.getMessage());
        }
    }

    private void mostrarComisiones() {
        printTitulo("Comisiones");
        Map<Vendedor, Double> comisiones = tienda.calcularComisiones();
        if (comisiones.isEmpty()) {
            printInfo("No hay ventas registradas.");
        } else {
            comisiones.forEach((v, c) -> 
                printInfo(String.format("%s → Comisión: $%.2f", v.getNombre(), c))
            );
        }
    }

    private void buscarPorCategoria() {
        printTitulo("Buscar productos por categoría");
        String categoria = reader.readLine("Categoría: ");
        List<Producto> resultados = tienda.buscarProductosPorCategoria(categoria);

        if (resultados.isEmpty()) {
            printInfo("No se encontraron productos.");
        } else {
            resultados.forEach(p -> printInfo(p.getNombre()));
        }
    }

        private void buscarPorPrecioMax() {
        try {
            printTitulo("Buscar productos por precio máximo");
            String precio = reader.readLine("precio: ");
            Float precioValue = Float.valueOf(precio);
            
            
            List<Producto> resultados = tienda.buscarProductosPorPrecioMaximo(precioValue);
            
            if (resultados.isEmpty()) {
                printInfo("No se encontraron productos.");
            } else {
                resultados.forEach(p -> printInfo(String.format("%s|$%.2f|%s",p.getNombre(),p.getPrecio(),p.getCodigo())));
            }
        } catch (InvalidDataException ex) {
              printError("Error: " + ex.getMessage());
        }
    }
        
    private void listarProductos() {
        printTitulo("Listado de productos");
        printTitulo("Nombre - Precio - Código");

        List<Producto> lista = tienda.getProductos();
        if (lista.isEmpty()) {
            printInfo("No hay productos registrados.");
        } else {
             lista.forEach(p -> printInfo(String.format("%s|$%.2f|%s",p.getNombre(),p.getPrecio(),p.getCodigo())));
        }
    }
    
       private void mostrarVendedores() {
        printInfo("Vendedores disponibles");
        printTitulo("Nombre - Código");
        this.tienda.getVendedores().forEach(vendedor -> printInfo(String.format("%s|%s",vendedor.getNombre(),vendedor.getCodigo())));
      
    }

    private void mostrarAyuda() {
        printTitulo("Comandos disponibles");
        printInfo("registrar_producto   → Registrar nuevo producto");
        printInfo("registrar_vendedor   → Registrar nuevo vendedor");
        printInfo("registrar_venta      → Registrar una venta");
        printInfo("comisiones           → Calcular comisiones por vendedor");
        printInfo("buscar_categoria     → Buscar productos por categoría");
        printInfo("listar               → Mostrar todos los productos");
        printInfo("vendedores           → Mostrar todos los vendedores");
        printInfo("precio_max           → Buscar productos de precio inferior");
        printInfo("salir                → Salir del programa");
    }

     private void printTitulo(String texto) {
        terminal.writer().println(new AttributedString(
                "\n=== " + texto.toUpperCase() + " ===",
                AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW | AttributedStyle.BRIGHT)
        ).toAnsi());
        terminal.flush();
    }

    private void printOk(String texto) {
        terminal.writer().println(new AttributedString(
                "✔ " + texto,
                AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN)
        ).toAnsi());
        terminal.flush();
    }

    private void printInfo(String texto) {
        terminal.writer().println(new AttributedString(
                texto,
                AttributedStyle.DEFAULT.foreground(AttributedStyle.CYAN)
        ).toAnsi());
        terminal.flush();
    }

    private void printError(String texto) {
        terminal.writer().println(new AttributedString(
                "✖ " + texto,
                AttributedStyle.DEFAULT.foreground(AttributedStyle.RED)
        ).toAnsi());
        terminal.flush();
    }
}

