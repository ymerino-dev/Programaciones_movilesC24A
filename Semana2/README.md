# Laboratorio N 02 - Carrito de compras en Kotlin

**Nombre del estudiante:** Ana Yanira Merino Ramos

## Descripción
Programa desarrollado en Kotlin que simula la lógica de un carrito de compras. El proyecto incluye el uso de variables, tipos de datos, funciones, colecciones (`MutableList`) y estructuras de decisión. Se implementó una `data class` para los productos y funciones para calcular el subtotal, el IGV (18%) y el total a pagar. Además, se incluyó la lógica para encontrar el producto más caro y aplicar descuentos usando la estructura `when`.

## Análisis de Variables (val vs var)
**¿Por qué nombre y precio son val pero cantidad es var?**
En Kotlin, `val` declara un valor que NO cambia (es inmutable), mientras que `var` declara una variable que SÍ puede cambiar. En el contexto del carrito, el nombre y el precio unitario del producto son fijos una vez creados, por lo que usan `val`. Sin embargo, la cantidad de un mismo producto en el carrito puede aumentar o disminuir, por lo que obligatoriamente requiere `var` para ser modificada posteriormente. Si intentaramos cambiar un valor `val`, el programa daría un error de compilación.

## Captura de Ejecución
<img width="576" height="857" alt="detalle semana2 sinia" src="https://github.com/user-attachments/assets/e4b6f954-71f1-4f55-b429-1bc8195bd01c" />

