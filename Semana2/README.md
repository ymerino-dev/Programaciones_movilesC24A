# Laboratorio 02 - Carrito de Compras (Con IA) 🛒

Este proyecto es una aplicación de consola en **Java** que simula un sistema de ventas. Fue reestructurado utilizando estrictamente los pilares de la Programación Orientada a Objetos (POO), con el apoyo de Inteligencia Artificial para el diseño de la arquitectura.

## 🚀 Conceptos Aplicados

* **Clases y Objetos:** Estructuración del código separando la lógica del negocio de la interacción con el usuario.
* **Encapsulamiento:** Protección de datos usando modificadores de acceso `private` y métodos `getters`/`setters`.
* **Herencia:** Creación de una clase padre abstracta `Producto` y derivación de clases hijas (`ProductoElectronico`, `ProductoAccesorio`).
* **Polimorfismo:** Sobrescritura del método `calcularSubtotalItem()` usando `@Override` para que cada tipo de producto calcule su precio final con reglas de negocio distintas (ej. recargos por garantía).

## 🛠️ Tecnologías Usadas
* **Lenguaje:** Java
* **Entorno:** Android Studio / Consola
* **Entrada de datos:** Clase `Scanner` interactiva.

## 📋 Reglas de Negocio
1. El sistema calcula el Subtotal general y aplica el 18% de IGV.
2. Si la compra supera los S/ 3000, aplica 5% de descuento.
3. Si la compra supera los S/ 5000, aplica 10% de descuento.
4. Identifica automáticamente cuál fue el producto más caro de la lista.

## Prompt utilizado
Actúa como un desarrollador de software experto en Java. Necesito que programes desde cero una aplicación de consola para un "Carrito de Compras", aplicando estrictamente los pilares de la Programación Orientada a Objetos (POO).

1. Arquitectura y Requerimientos Técnicos (POO):

Herencia: Crea una clase padre abstracta llamada Producto que contenga los atributos básicos: nombre (String), precio (double) y cantidad (int). Luego, crea al menos dos clases hijas (por ejemplo, ProductoElectronico y ProductoAccesorio) que hereden de ella.

Polimorfismo: Define un método en la clase padre llamado calcularSubtotalItem() y haz que cada clase hija lo sobrescriba (Override) aplicando alguna regla particular (por ejemplo, que los electrónicos tengan un recargo por garantía o simplemente devuelvan el precio por la cantidad).

Encapsulamiento: Todos los atributos deben ser privados y accederse mediante métodos getters y setters.

2. Interacción con el Usuario:

Utiliza la clase Scanner para la entrada de datos por teclado.

El programa debe pedir primero el nombre del cliente.

Debe usar un bucle while que le pregunte al usuario los datos del producto (nombre, precio, cantidad y tipo de producto) y le permita agregar tantos productos como desee a una lista (por ejemplo, un ArrayList<Producto>) hasta que decida detenerse (ej. ingresando "N").

3. Reglas de Negocio y Cálculos Finales:
   Una vez que el usuario termina de agregar productos, el programa debe recorrer la lista y calcular lo siguiente:

Subtotal general: La suma de los subtotales de todos los productos.

IGV: Calcular el 18% del subtotal general.

Total a Pagar: La suma del subtotal general + IGV.

Descuento Global: Si el Total a Pagar supera los S/ 5000, aplicar un 10% de descuento. Si supera los S/ 3000, aplicar un 5%. De lo contrario, 0.

Producto más caro: Buscar y guardar cuál fue el producto con el precio unitario más alto.

4. Salida esperada (Consola):
   Imprime un "ticket" o recibo ordenado que muestre:

El nombre del cliente.

El detalle de cada producto agregado con su respectivo importe.

El Subtotal, IGV, Total, Descuento aplicado y el Total Final a pagar.

El nombre y precio del producto más caro.

Por favor, incluye comentarios en el código explicando brevemente dónde y cómo se aplicó la herencia y el polimorfismo.