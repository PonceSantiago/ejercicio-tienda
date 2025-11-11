*Deberá implementarse la funcionalidad básica de una tienda de productos:

- Se podrán **almacenar** _productos_ (código, nombre, precio, categoría)
 vendedor (código,nombre, sueldo).

- Al registrar una venta, se tendrá que relacionar el producto con el vendedor que realizo la
venta.

- Se debe de poder calcular la comisión de ventas por cada vendedor, el cual se obtiene de un
5% de las ventas realizadas en el caso de vender hasta dos productos y un 10% al vender más
de dos productos.

- Debe implementarse distintos tipos de buscadores de productos, por ejemplo el buscar por
categoría.


- La aplicación tendrá que implementar el manejo de excepciones correctamente.
- Deberá diseñarse un Diagrama de Entidad Relación para la solución.
- Deberá ejecutarse por consola y se almacenarán los datos en memoria.




Entidades 
-Tienda
-Producto
-Vendedor

-Venta (Relaciona producto vendido) esta clase surge de mi duda sobre la idea de que 
el vendedor tenga una lista de productos vendidos
Pero aca me surge duda respecto de la doble referencia

El calculo de la comision deberia hacerse mediante una 
estrategia, usar patron

Principios de Diseño

S
O
L
I
D

