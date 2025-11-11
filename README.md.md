## Requerimientos

Deberá implementarse la funcionalidad básica de una tienda de productos:

Se podrán almacenar productos (código, nombre, precio, categoría) y vendedores (código, nombre, sueldo).

Al registrar una venta, se deberá relacionar el producto con el vendedor que realizó la venta.

Se debe poder calcular la comisión de ventas por cada vendedor, la cual se obtiene de un 5% del total vendido en el caso de haber realizado hasta dos ventas, y de un 10% si ha vendido más de dos productos.

Deben implementarse distintos tipos de buscadores de productos, por ejemplo, por categoría.

La aplicación deberá implementar correctamente el manejo de excepciones.

Se deberá diseñar un Diagrama de Entidad-Relación (DER) para la solución.

La aplicación se ejecutará por consola y los datos se almacenarán en memoria.

### Notas de desarrollo

Para el cálculo de la comisión de los vendedores, se utilizó el patrón Strategy, con el fin de desacoplar la lógica del cálculo de comisiones de la clase Tienda.

Con respecto a los buscadores de productos, se implementó el solicitado en la consigna (filtrado por categoría) y se agregó un método adicional de filtrado por tope de precio.

En cuanto a la interfaz, se utilizó la librería JLine para agilizar el desarrollo y mejorar la interacción por consola.


### Resultado de ejecucion
Se marca en negrita la ejecucion de comandos

=== TIENDA INTERACTIVA ===

=== COMANDOS DISPONIBLES ===
registrar_producto   → Registrar nuevo producto
registrar_vendedor   → Registrar nuevo vendedor
registrar_venta      → Registrar una venta
comisiones           → Calcular comisiones por vendedor
buscar_categoria     → Buscar productos por categoría
listar               → Mostrar todos los productos
vendedores           → Mostrar todos los vendedores
precio_max           → Buscar productos con tope de precio
salir                → Salir del programa
tienda> **listar**

=== LISTADO DE PRODUCTOS ===

=== NOMBRE - PRECIO - CÓDIGO ===
Zapatillas|$80000,00|A001
Auriculares|$25000,00|A002
Mouse|$15000,00|A003
Lampara Led|$80000,00|A004
Pendrive 64GB|$10000,00|A005
tienda> **ayuda**

=== COMANDOS DISPONIBLES ===
registrar_producto   → Registrar nuevo producto
registrar_vendedor   → Registrar nuevo vendedor
registrar_venta      → Registrar una venta
comisiones           → Calcular comisiones por vendedor
buscar_categoria     → Buscar productos por categoría
listar               → Mostrar todos los productos
vendedores           → Mostrar todos los vendedores
precio_max           → Buscar productos con tope de precio
salir                → Salir del programa
tienda> **comisiones**

=== COMISIONES ===
Roderick Usher → Comisión: $0,00
Alexei Karamazov → Comisión: $0,00
Maria Iribarne → Comisión: $0,00
tienda> **listar**

=== LISTADO DE PRODUCTOS ===

=== NOMBRE - PRECIO - CÓDIGO ===
Zapatillas|$80000,00|A001
Auriculares|$25000,00|A002
Mouse|$15000,00|A003
Lampara Led|$80000,00|A004
Pendrive 64GB|$10000,00|A005
tienda> **vendedores**
Vendedores disponibles

=== NOMBRE - CÓDIGO ===
Alexei Karamazov|V01
Roderick Usher|V02
Maria Iribarne|V03
tienda> **registrar_venta**

=== REGISTRAR VENTA ===
Código vendedor: v03
Código producto: a001
✔ Venta registrada.
tienda> **comisiones**

=== COMISIONES ===
Roderick Usher → Comisión: $0,00
Alexei Karamazov → Comisión: $0,00
Maria Iribarne → Comisión: $4000,00  _comision del 5%_
tienda> registrar_venta

=== REGISTRAR VENTA ===
Código vendedor: v03
Código producto: a004
✔ Venta registrada.
tienda> registrar_venta

=== REGISTRAR VENTA ===
Código vendedor: v03
Código producto: a001
✔ Venta registrada.
tienda> comisiones

=== COMISIONES ===
Roderick Usher → Comisión: $0,00
Alexei Karamazov → Comisión: $0,00
Maria Iribarne → Comisión: $24000,00
tienda> ayuda

=== COMANDOS DISPONIBLES ===
registrar_producto   → Registrar nuevo producto
registrar_vendedor   → Registrar nuevo vendedor
registrar_venta      → Registrar una venta
comisiones           → Calcular comisiones por vendedor
buscar_categoria     → Buscar productos por categoría
listar               → Mostrar todos los productos
vendedores           → Mostrar todos los vendedores
precio_max           → Buscar productos con tope de precio
salir                → Salir del programa
tienda> registrar_producto

=== REGISTRAR PRODUCTO ===
Código: a001
Nombre: crema
Precio: 100
Categoría: belleza
✖ Error: Producto con código duplicado
tienda> ayuda
