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
