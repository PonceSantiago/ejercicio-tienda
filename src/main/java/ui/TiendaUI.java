package ui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ponce Santiago
 */
import com.mycompany.tiendabesysoft.Producto;
import com.mycompany.tiendabesysoft.Tienda;
import com.mycompany.tiendabesysoft.TiendaBesysoft;
import com.mycompany.tiendabesysoft.Vendedor;

import java.io.IOException;
import java.text.AttributedCharacterIterator;
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
                "comisiones", "buscar_categoria", "listar", "ayuda", "salir"
        );

        this.reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .completer(completer)
                .parser(new DefaultParser())
                .build();
    }

    public void iniciar() {
        printTitulo("TIENDA INTERACTIVA - JLINE");
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
            case "listar" -> listarProductos();
            case "ayuda" -> mostrarAyuda();
            default -> printError("Comando no reconocido. Escriba 'ayuda' para ver opciones.");
        }
    }

    private void registrarProducto() {
        printTitulo("Registrar producto");
        String codigo = reader.readLine("Código: ");
        String nombre = reader.readLine("Nombre: ");
        Float precio = Float.valueOf(reader.readLine("Precio: "));
        String categoria = reader.readLine("Categoría: ");

        tienda.almacenarProducto(new Producto(nombre,precio , categoria, codigo));
        printOk("Producto agregado correctamente.");
    }

    private void registrarVendedor() {
        printTitulo("Registrar vendedor");
        String codigo = reader.readLine("Código: ");
        String nombre = reader.readLine("Nombre: ");
        Float sueldo = Float.valueOf(reader.readLine("Sueldo: "));

        tienda.agregarVendedor(new Vendedor(nombre, sueldo,codigo));
        printOk("Vendedor registrado.");
    }

    private void registrarVenta() {
        printTitulo("Registrar venta");
       // String codVend = reader.readLine("Código vendedor: ");
       // String codProd = reader.readLine("Código producto: ");
       // tienda.registrarVenta(producto, vendedor);
        printOk("Venta registrada.");
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
        List<Producto> resultados = tienda.getProductosPorCategoria(categoria);

        if (resultados.isEmpty()) {
            printInfo("No se encontraron productos.");
        } else {
            resultados.forEach(p -> printInfo(p.toString()));
        }
    }

    private void listarProductos() {
        printTitulo("Listado de productos");
        List<Producto> lista = tienda.getProductos();
        if (lista.isEmpty()) {
            printInfo("No hay productos registrados.");
        } else {
            lista.forEach(p -> printInfo(p.toString()));
        }
    }

    private void mostrarAyuda() {
        printTitulo("Comandos disponibles");
        printInfo("registrar_producto   → Registrar nuevo producto");
        printInfo("registrar_vendedor   → Registrar nuevo vendedor");
        printInfo("registrar_venta      → Registrar una venta");
        printInfo("comisiones           → Calcular comisiones por vendedor");
        printInfo("buscar_categoria     → Buscar productos por categoría");
        printInfo("listar               → Mostrar todos los productos");
        printInfo("salir                → Salir del programa");
    }

    // ==== MÉTODOS AUXILIARES CON COLOR ====
    private void printTitulo(String texto) {
        terminal.writer().println(texto);
        terminal.flush();
    }

    private void printOk(String texto) {
    terminal.writer().println(new AttributedString(texto));
        terminal.flush();
    }

    private void printInfo(String texto) {
    terminal.writer().println(new AttributedString(texto));
        terminal.flush();
    }

    private void printError(String texto) {
    terminal.writer().println(new AttributedString(texto));
        terminal.flush();
    }
}

